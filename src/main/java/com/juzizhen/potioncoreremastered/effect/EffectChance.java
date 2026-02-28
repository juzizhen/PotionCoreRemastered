package com.juzizhen.potioncoreremastered.effect;

import com.juzizhen.potioncoreremastered.util.EffectClassifier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.*;

public class EffectChance extends StatusEffect {
    public EffectChance() {
        super(StatusEffectCategory.NEUTRAL, 255);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        Set<StatusEffect> allEffect = new HashSet<>();
        allEffect.addAll(EffectClassifier.GOOD_EFFECTS);
        allEffect.addAll(EffectClassifier.BAD_EFFECTS);
        allEffect.remove(ModEffects.CHANCE);
        allEffect.remove(ModEffects.BLESS);
        allEffect.remove(ModEffects.CURSE);

        if (allEffect.isEmpty()) return;

        int count = amplifier + 1;

        List<StatusEffect> effectList = new ArrayList<>(allEffect);
        count = Math.min(count, effectList.size());

        Collections.shuffle(effectList);

        for (int i = 0; i < count; i++) {
            StatusEffect effect = effectList.get(i);
            entity.addStatusEffect(new StatusEffectInstance(effect, 1200, 0));
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}