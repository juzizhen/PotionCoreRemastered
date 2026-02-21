package com.juzizhen.potioncoreremastered.effect;

import com.juzizhen.potioncoreremastered.util.EffectClassifier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EffectCure extends StatusEffect {
    public EffectCure() {
        super(StatusEffectCategory.BENEFICIAL, 16733695);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        Map<StatusEffect, StatusEffectInstance> activeEffects = entity.getActiveStatusEffects();
        List<StatusEffect> toRemove = new ArrayList<>();

        for (Map.Entry<StatusEffect, StatusEffectInstance> entry : activeEffects.entrySet()) {
            if (EffectClassifier.isHarmful(entry.getKey())) {
                toRemove.add(entry.getKey());
            }
        }

        for (StatusEffect effect : toRemove) {
            entity.removeStatusEffect(effect);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}