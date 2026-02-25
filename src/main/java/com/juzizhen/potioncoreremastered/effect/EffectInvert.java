package com.juzizhen.potioncoreremastered.effect;

import com.google.common.collect.BiMap;
import com.juzizhen.potioncoreremastered.util.EffectClassifier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EffectInvert extends StatusEffect {
    public EffectInvert() {
        super(StatusEffectCategory.NEUTRAL, 0xFFA500);
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker,
                                   LivingEntity target, int amplifier, double proximity) {
        Collection<StatusEffectInstance> effectList = target.getStatusEffects();
        BiMap<StatusEffect, StatusEffect> OPPOSITE_EFFECTS = EffectClassifier.OPPOSITE_EFFECTS;

        List<StatusEffectInstance> effectsCopy = new ArrayList<>(effectList);

        List<StatusEffect> effectsToRemove = new ArrayList<>();
        List<StatusEffectInstance> effectsToAdd = new ArrayList<>();

        for (StatusEffectInstance instance : effectsCopy) {
            StatusEffect currentEffect = instance.getEffectType();

            StatusEffect oppositeEffect = OPPOSITE_EFFECTS.get(currentEffect);
            if (oppositeEffect == null) {
                oppositeEffect = OPPOSITE_EFFECTS.inverse().get(currentEffect);
            }

            if (oppositeEffect != null && oppositeEffect != currentEffect) {
                effectsToRemove.add(currentEffect);

                int newAmplifier = instance.getAmplifier() + amplifier;
                int duration = instance.getDuration();
                if (duration <= 1) {
                    duration = 1;
                }

                effectsToAdd.add(new StatusEffectInstance(
                        oppositeEffect,
                        duration,
                        Math.max(0, newAmplifier),
                        instance.isAmbient(),
                        instance.shouldShowParticles(),
                        instance.shouldShowIcon()
                ));
            }
        }
        for (StatusEffect toRemove : effectsToRemove) {
            target.removeStatusEffect(toRemove);
        }

        for (StatusEffectInstance toAdd : effectsToAdd) {
            target.addStatusEffect(toAdd);
        }
    }

    @Override
    public boolean isInstant() {
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return false;
    }
}