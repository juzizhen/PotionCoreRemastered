package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectStepUp extends StatusEffect {
    private static final float BASE_STEP_HEIGHT = 0.6f;

    public EffectStepUp() {
        super(StatusEffectCategory.BENEFICIAL, 3394611);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, attributes, amplifier);
        updateStepHeight(entity, amplifier);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        updateStepHeight(entity, amplifier);
    }

    private void updateStepHeight(LivingEntity entity, int amplifier) {
        entity.setStepHeight(BASE_STEP_HEIGHT + (amplifier + 1) * 0.5f);
    }


    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        entity.setStepHeight(BASE_STEP_HEIGHT);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}