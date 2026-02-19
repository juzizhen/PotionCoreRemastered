package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class EffectSustainedSaturation extends StatusEffect {
    public EffectSustainedSaturation() {
        super(StatusEffectCategory.BENEFICIAL, 0xF82423);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 20 == 0;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            int foodAmount = 2 * (amplifier + 1);
            float saturationAmount = 2.0F * (amplifier + 1);
            player.getHungerManager().add(foodAmount, saturationAmount);
        }
    }
}