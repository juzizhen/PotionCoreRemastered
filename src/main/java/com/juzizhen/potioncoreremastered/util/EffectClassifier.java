package com.juzizhen.potioncoreremastered.util;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EffectClassifier {
    public static final Set<StatusEffect> GOOD_EFFECTS = new HashSet<>();
    public static final Set<StatusEffect> BAD_EFFECTS = new HashSet<>();
    public static final Map<StatusEffect, StatusEffect> OPPOSITE_EFFECTS = new HashMap<>();

    public static void initialize() {
        GOOD_EFFECTS.clear();
        BAD_EFFECTS.clear();
        OPPOSITE_EFFECTS.clear();

        for (StatusEffect effect : Registries.STATUS_EFFECT) {
            if (effect.getCategory() == StatusEffectCategory.BENEFICIAL) {
                GOOD_EFFECTS.add(effect);
            } else if (effect.getCategory() == StatusEffectCategory.HARMFUL) {
                BAD_EFFECTS.add(effect);
            }
        }
    }

    public static boolean isBeneficial(StatusEffect effect) {
        return GOOD_EFFECTS.contains(effect);
    }

    public static boolean isHarmful(StatusEffect effect) {
        return BAD_EFFECTS.contains(effect);
    }
}