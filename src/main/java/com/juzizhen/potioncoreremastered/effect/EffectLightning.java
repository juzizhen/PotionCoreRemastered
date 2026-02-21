package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.world.ServerWorld;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EffectLightning extends StatusEffect {
    private final Map<UUID, Long> lastSummonTick = new HashMap<>();

    public EffectLightning() {
        super(StatusEffectCategory.HARMFUL, 16776960);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        ServerWorld world = (ServerWorld) entity.getWorld();
        long currentTick = world.getTime();

        int interval = Math.max(1, 100 - amplifier * 20);

        UUID uuid = entity.getUuid();
        Long lastTick = lastSummonTick.get(uuid);

        if (lastTick == null || currentTick - lastTick >= interval) {
            summonLightning(world, entity);
            lastSummonTick.put(uuid, currentTick);
        }

        StatusEffectInstance effectInstance = entity.getStatusEffect(ModEffects.LIGHTNING);
        if (effectInstance == null) {
            lastSummonTick.remove(uuid);
        }
    }

    private void summonLightning(ServerWorld world, LivingEntity entity) {
        LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
        lightning.setPos(entity.getX(), entity.getY(), entity.getZ());
        lightning.setCosmetic(false);
        world.spawnEntity(lightning);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}