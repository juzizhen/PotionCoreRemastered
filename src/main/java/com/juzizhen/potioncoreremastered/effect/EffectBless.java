package com.juzizhen.potioncoreremastered.effect;

import com.juzizhen.potioncoreremastered.util.EffectClassifier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class EffectBless extends StatusEffect {
    public EffectBless() {
        super(StatusEffectCategory.BENEFICIAL, 6737151);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        Set<StatusEffect> goodEffects = EffectClassifier.GOOD_EFFECTS;
        if (goodEffects.isEmpty()) return;

        int count = amplifier + 1;

        List<StatusEffect> effectList = new ArrayList<>(goodEffects);
        effectList.remove(this);
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