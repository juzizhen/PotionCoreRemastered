package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EffectMagicInhibition extends StatusEffect {
    private final Map<LivingEntity, Map<StatusEffect, StatusEffectInstance>> originalAmplifiers = new HashMap<>();

    public EffectMagicInhibition() {
        super(StatusEffectCategory.HARMFUL, 10845875);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, attributes, amplifier);

        Map<StatusEffect, StatusEffectInstance> cache = new HashMap<>();
        StatusEffectInstance inhibitor = entity.getStatusEffect(ModEffects.MAGIC_INHIBITION);
        if (inhibitor == null) return;

        int inhibitorLevel = inhibitor.getAmplifier() + 1;
        double reductionFactor = inhibitorLevel * 0.3;

        List<StatusEffectInstance> effects = new ArrayList<>(entity.getStatusEffects());
        for (StatusEffectInstance inst : effects) {
            StatusEffect effect = inst.getEffectType();
            if (effect == ModEffects.MAGIC_INHIBITION) continue;
            if (effect.getCategory() == StatusEffectCategory.BENEFICIAL) {
                cache.put(effect, inst);

                int reducedAmp = (int) Math.round(inst.getAmplifier() - reductionFactor);
                if (reducedAmp < 0) reducedAmp = 0;

                entity.addCommandTag("potioncoreremastered:internal_weaken");
                entity.addStatusEffect(new StatusEffectInstance(
                        effect,
                        inst.getDuration(),
                        reducedAmp,
                        inst.isAmbient(),
                        inst.shouldShowParticles(),
                        inst.shouldShowIcon()
                ));
            }
        }
        originalAmplifiers.put(entity, cache);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);

        Map<StatusEffect, StatusEffectInstance> cache = originalAmplifiers.remove(entity);
        if (cache == null || cache.isEmpty()) return;

        if (entity.getStatusEffects().isEmpty()) {
            return;
        }

        for (Map.Entry<StatusEffect, StatusEffectInstance> entry : cache.entrySet()) {
            StatusEffect effect = entry.getKey();
            StatusEffectInstance original = entry.getValue();

            if (effect == ModEffects.MAGIC_INHIBITION) continue;

            StatusEffectInstance current = entity.getStatusEffect(effect);
            if (current != null) {
                entity.removeStatusEffect(effect);
                entity.addStatusEffect(new StatusEffectInstance(
                        effect,
                        current.getDuration(),
                        original.getAmplifier(),
                        current.isAmbient(),
                        current.shouldShowParticles(),
                        current.shouldShowIcon()
                ));
                entity.removeScoreboardTag("potioncoreremastered:internal_weaken");
            }
        }
    }
}