package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;

public class EffectClimb extends StatusEffect {
    public EffectClimb() {
        super(StatusEffectCategory.BENEFICIAL, 13391104);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        StatusEffectInstance buff = entity.getStatusEffect(ModEffects.CLIMB);
        if (buff != null && entity.getStatusEffect(ModEffects.CLIMB) != null) {
            if (entity.horizontalCollision) {
                if (entity instanceof PlayerEntity player) {
                    if (!player.isSneaking() && player.forwardSpeed > 0.0F) {
                        if (player.getVelocity().y < 0.2D) {
                            player.setVelocity(player.getVelocity().x, 0.2D, player.getVelocity().z);
                        }
                    } else if (player.isSneaking()) {
                        player.setVelocity(player.getVelocity().x, 0.0D, player.getVelocity().z);
                    }
                } else {
                    if (!entity.isSneaky() && entity.forwardSpeed > 0.0F) {
                        if (entity.getVelocity().y < 0.2D) {
                            entity.setVelocity(entity.getVelocity().x, 0.2D, entity.getVelocity().z);
                        }
                    } else if (entity.isSneaky()) {
                        entity.setVelocity(entity.getVelocity().x, 0.0D, entity.getVelocity().z);
                    }
                }
                entity.fallDistance = 0.0F;
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
