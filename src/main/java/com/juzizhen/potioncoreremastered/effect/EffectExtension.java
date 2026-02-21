package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EffectExtension extends StatusEffect {
    public EffectExtension() {
        super(StatusEffectCategory.BENEFICIAL, 10027161);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        Map<StatusEffect, StatusEffectInstance> activeEffects = entity.getActiveStatusEffects();
        List<StatusEffectInstance> otherEffects = new ArrayList<>();
        for (Map.Entry<StatusEffect, StatusEffectInstance> entry : activeEffects.entrySet()) {
            if (entry.getKey() != this) {
                otherEffects.add(entry.getValue());
            }
        }

        int otherCount = otherEffects.size();
        if (otherCount == 0) return;

        int protectionCount = amplifier + 1;

        if (protectionCount >= otherCount) {
            for (StatusEffectInstance effect : otherEffects) {
                entity.addStatusEffect(cloneEffect(effect, effect.getDuration() + 1));
            }
        } else {
            long time = entity.getWorld().getTime();
            int startIndex = (int) (time % otherCount);

            for (int i = 0; i < otherCount; i++) {
                StatusEffectInstance effect = otherEffects.get(i);
                if (i >= startIndex && i < startIndex + protectionCount) {
                    entity.addStatusEffect(cloneEffect(effect, effect.getDuration() + 1));
                }
            }
        }
    }

    private StatusEffectInstance cloneEffect(StatusEffectInstance effect, int newDuration) {
        return new StatusEffectInstance(
                effect.getEffectType(),
                Math.max(newDuration, 0),
                effect.getAmplifier(),
                effect.isAmbient(),
                effect.shouldShowParticles(),
                effect.shouldShowIcon()
        );
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}