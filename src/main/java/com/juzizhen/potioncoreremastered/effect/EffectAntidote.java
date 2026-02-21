package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;

public class EffectAntidote extends StatusEffect {
    public EffectAntidote() {
        super(StatusEffectCategory.BENEFICIAL, 52377);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, attributes, amplifier);
        if (entity.getWorld().isClient) return;

        if (entity.hasStatusEffect(StatusEffects.POISON)) {
            entity.removeStatusEffect(StatusEffects.POISON);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return false;
    }
}