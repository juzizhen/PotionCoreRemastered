package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectDrown extends StatusEffect {
    public EffectDrown() {
        super(StatusEffectCategory.HARMFUL, 65535);
    }

    private int tickCounter = 0;

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        int maxAir = entity.getMaxAir();
        int currentAir = entity.getAir();

        boolean inWater = entity.isSubmergedInWater();

        if (inWater) {
            entity.setAir(Math.min(maxAir, currentAir + 2));
            tickCounter = 0;
        } else {
            entity.setAir(Math.max(0, currentAir - 1));

            if (entity.getAir() <= 0) {
                tickCounter++;
                if (tickCounter >= 20) {
                    entity.damage(entity.getDamageSources().drown(), 2.0F);
                    tickCounter = 0;
                }
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}