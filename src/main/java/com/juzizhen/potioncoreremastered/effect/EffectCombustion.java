package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectCombustion extends StatusEffect {
    public EffectCombustion() {
        super(StatusEffectCategory.HARMFUL, 16733440);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        int seconds = (amplifier + 1) * 10;
        entity.setOnFireFor(seconds);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}