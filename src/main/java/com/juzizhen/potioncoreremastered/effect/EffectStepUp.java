package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import com.juzizhen.potioncoreremastered.network.StepHeightUpdate;
import net.minecraft.server.network.ServerPlayerEntity;


public class EffectStepUp extends StatusEffect {
    private static final float BASE_STEP_HEIGHT = 0.6f;

    public EffectStepUp() {
        super(StatusEffectCategory.BENEFICIAL, 3394611);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!(entity instanceof ServerPlayerEntity player)) return;

        float stepHeight = entity.hasStatusEffect(ModEffects.STEP_UP)
                ? BASE_STEP_HEIGHT + (amplifier + 1) * 0.5f
                : BASE_STEP_HEIGHT;

        entity.setStepHeight(stepHeight);
        StepHeightUpdate.sendStepHeightUpdate(player, stepHeight);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (!(entity instanceof ServerPlayerEntity player)) return;

        entity.setStepHeight(BASE_STEP_HEIGHT);
        StepHeightUpdate.sendStepHeightUpdate(player, BASE_STEP_HEIGHT);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}