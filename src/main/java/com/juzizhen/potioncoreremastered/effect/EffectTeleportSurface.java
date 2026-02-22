package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class EffectTeleportSurface extends StatusEffect {
    public EffectTeleportSurface() {
        super(StatusEffectCategory.BENEFICIAL, 65433);
    }

    @Override
    public boolean isInstant() {
        return true;
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        World world = target.getWorld();
        if (world.isClient) return;

        BlockPos entityPos = target.getBlockPos();
        int surfaceY = world.getTopY(Heightmap.Type.MOTION_BLOCKING, entityPos.getX(), entityPos.getZ());
        BlockPos surfacePos = new BlockPos(entityPos.getX(), surfaceY, entityPos.getZ());

        if (world.getBlockState(entityPos.down()).isSolid()) {
            return;
        }

        double targetX = surfacePos.getX() + 0.5;
        double targetY = surfacePos.getY() + 1.1;
        double targetZ = surfacePos.getZ() + 0.5;

        teleportTo(target, targetX, targetY, targetZ);
    }

    private void teleportTo(LivingEntity entity, double x, double y, double z) {
        World world = entity.getWorld();
        double oldX = entity.getX();
        double oldY = entity.getY();
        double oldZ = entity.getZ();

        entity.teleport(x, y, z);

        Box newBoundingBox = entity.getBoundingBox();
        if (!world.isSpaceEmpty(entity, newBoundingBox)) {
            entity.teleport(oldX, oldY, oldZ);
            return;
        }

        if (world instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(ParticleTypes.PORTAL,
                    oldX, oldY + entity.getHeight() / 2, oldZ,
                    32, 0.5, 0.5, 0.5, 0.0);
            serverWorld.spawnParticles(ParticleTypes.PORTAL,
                    x, y + entity.getHeight() / 2, z,
                    32, 0.5, 0.5, 0.5, 0.0);
            serverWorld.playSound(null, oldX, oldY, oldZ,
                    SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);
            serverWorld.playSound(null, x, y, z,
                    SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return false;
    }
}