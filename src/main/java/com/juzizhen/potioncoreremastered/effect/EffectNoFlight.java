package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.boss.WitherEntity;

public class EffectNoFlight extends StatusEffect {
    public EffectNoFlight() {
        super(StatusEffectCategory.HARMFUL, 0x87CEEB);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        // 玩家逻辑
        if (entity instanceof PlayerEntity player) {
            if (player.getAbilities().allowFlying) {
                player.getAbilities().allowFlying = false;
            }
            if (player.getAbilities().flying) {
                player.getAbilities().flying = false;
                player.fallDistance = 0.0f;
            }
            if (player.isFallFlying()) {
                player.stopFallFlying();
            }
            if (player.hasStatusEffect(StatusEffects.LEVITATION)) {
                player.removeStatusEffect(StatusEffects.LEVITATION);
            }
            player.sendAbilitiesUpdate();
            return;
        }

        // 统一处理飞行生物
        if (entity instanceof PhantomEntity
                || entity instanceof BatEntity
                || entity instanceof ParrotEntity
                || entity instanceof BeeEntity
                || entity instanceof WitherEntity
                || entity instanceof AllayEntity
                || entity instanceof GhastEntity
                || entity instanceof ChickenEntity
                || entity instanceof BlazeEntity
                || entity instanceof VexEntity
        ) {
            forceFall(entity);
        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        if (entity.getWorld().isClient) return;

        if (entity instanceof PlayerEntity player) {
            player.getAbilities().allowFlying = player.isCreative() || player.isSpectator();
            player.getAbilities().flying = false;
            player.sendAbilitiesUpdate();
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    private void forceFall(LivingEntity entity) {
        entity.setNoGravity(false);
        entity.setVelocity(entity.getVelocity().x, -0.5, entity.getVelocity().z);
    }
}