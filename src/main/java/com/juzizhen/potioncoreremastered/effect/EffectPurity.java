package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;

public class EffectPurity extends StatusEffect {
    public EffectPurity() {
        super(StatusEffectCategory.BENEFICIAL, 16777215);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, attributes, amplifier);
        if (entity.getWorld().isClient) return;

        if (entity.hasStatusEffect(StatusEffects.WITHER)) {
            entity.removeStatusEffect(StatusEffects.WITHER);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return false;
    }
}