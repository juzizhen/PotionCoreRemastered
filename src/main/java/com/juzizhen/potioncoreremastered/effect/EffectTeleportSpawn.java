package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class EffectTeleportSpawn extends StatusEffect {
    private static final Map<UUID, PlayerState> PLAYER_STATES = new ConcurrentHashMap<>();
    private static final int REQUIRED_TICKS = 200;

    public EffectTeleportSpawn() {
        super(StatusEffectCategory.BENEFICIAL, 10049023);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;
        if (!(entity instanceof ServerPlayerEntity player)) return;

        UUID uuid = player.getUuid();
        PlayerState state = PLAYER_STATES.computeIfAbsent(uuid, k -> new PlayerState());

        World currentWorld = player.getWorld();
        BlockPos currentPos = player.getBlockPos();

        if (!currentWorld.equals(state.lastWorld) || !currentPos.equals(state.lastPos)) {
            state.stillTicks = 0;
            state.lastWorld = currentWorld;
            state.lastPos = currentPos;
            return;
        }

        state.stillTicks++;

        int particleCount = Math.min(state.stillTicks / 10, 40);
        ServerWorld serverWorld = (ServerWorld) player.getWorld();
        for (int i = 0; i < particleCount; i++) {
            double dx = (player.getRandom().nextDouble() - 0.5) * 2.0;
            double dy = player.getRandom().nextDouble() * 2.0;
            double dz = (player.getRandom().nextDouble() - 0.5) * 2.0;
            serverWorld.spawnParticles(
                    ParticleTypes.PORTAL,
                    player.getX(), player.getY() + 1, player.getZ(),
                    1, dx, dy, dz, 0.1
            );
        }

        if (state.stillTicks >= REQUIRED_TICKS) {
            ServerWorld spawnWorld = Objects.requireNonNull(player.getServer()).getOverworld();
            BlockPos spawnPos = spawnWorld.getSpawnPos();

            for (int i = 0; i < 100; i++) {
                double dx = (player.getRandom().nextDouble() - 0.5) * 2.0;
                double dy = player.getRandom().nextDouble() * 2.0;
                double dz = (player.getRandom().nextDouble() - 0.5) * 2.0;
                serverWorld.spawnParticles(
                        ParticleTypes.PORTAL,
                        player.getX(), player.getY() + 1, player.getZ(),
                        1, dx, dy, dz, 0.1
                );
            }

            player.teleport(spawnWorld,
                    spawnPos.getX() + 0.5,
                    spawnPos.getY(),
                    spawnPos.getZ() + 0.5,
                    player.getYaw(),
                    player.getPitch()
            );

            state.stillTicks = 0;
            state.lastWorld = spawnWorld;
            state.lastPos = player.getBlockPos();
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (!entity.getWorld().isClient) {
            PLAYER_STATES.remove(entity.getUuid());
        }
    }

    private static class PlayerState {
        World lastWorld;
        BlockPos lastPos;
        int stillTicks = 0;
    }
}