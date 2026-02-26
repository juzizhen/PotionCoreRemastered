package com.juzizhen.potioncoreremastered.util;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.juzizhen.potioncoreremastered.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;

import java.util.HashSet;
import java.util.Set;

public class EffectClassifier {
    public static final Set<StatusEffect> GOOD_EFFECTS = new HashSet<>();
    public static final Set<StatusEffect> BAD_EFFECTS = new HashSet<>();
    public static final BiMap<StatusEffect, StatusEffect> OPPOSITE_EFFECTS = HashBiMap.create();

    public static void initialize() {
        GOOD_EFFECTS.clear();
        BAD_EFFECTS.clear();
        OPPOSITE_EFFECTS.clear();

        effectClassification();
        oppositeClassification();
    }

    private static void effectClassification() {
        for (StatusEffect effect : Registries.STATUS_EFFECT) {
            if (effect.getCategory() == StatusEffectCategory.BENEFICIAL) {
                GOOD_EFFECTS.add(effect);
            } else if (effect.getCategory() == StatusEffectCategory.HARMFUL) {
                BAD_EFFECTS.add(effect);
            }
        }
    }

    private static void oppositeClassification() {
        OPPOSITE_EFFECTS.put(ModEffects.ANTIDOTE, StatusEffects.POISON);
        OPPOSITE_EFFECTS.put(ModEffects.IMPROVE_ACCURACY, ModEffects.LOSS_ACCURACY);
        OPPOSITE_EFFECTS.put(ModEffects.BLESS, ModEffects.CURSE);
        OPPOSITE_EFFECTS.put(ModEffects.IRON_SKIN, ModEffects.BROKEN_ARMOR);
        OPPOSITE_EFFECTS.put(ModEffects.MAGIC_SHIELD, ModEffects.BROKEN_MAGIC);
        OPPOSITE_EFFECTS.put(ModEffects.CURE, ModEffects.DISPEL);
        OPPOSITE_EFFECTS.put(StatusEffects.WATER_BREATHING, ModEffects.DROWN);
        OPPOSITE_EFFECTS.put(StatusEffects.FIRE_RESISTANCE, ModEffects.COMBUSTION);
        OPPOSITE_EFFECTS.put(ModEffects.MAGIC_FOCUS, ModEffects.MAGIC_INHIBITION);
        OPPOSITE_EFFECTS.put(ModEffects.REPAIR, ModEffects.RUST);
        OPPOSITE_EFFECTS.put(StatusEffects.SLOW_FALLING, StatusEffects.LEVITATION);
        OPPOSITE_EFFECTS.put(StatusEffects.RESISTANCE, ModEffects.VULNERABLE);
        OPPOSITE_EFFECTS.put(StatusEffects.JUMP_BOOST, ModEffects.WEIGHT);
        OPPOSITE_EFFECTS.put(StatusEffects.NIGHT_VISION, StatusEffects.BLINDNESS);
        OPPOSITE_EFFECTS.put(StatusEffects.HASTE, StatusEffects.MINING_FATIGUE);
        OPPOSITE_EFFECTS.put(StatusEffects.SATURATION, StatusEffects.HUNGER);
        OPPOSITE_EFFECTS.put(StatusEffects.INSTANT_HEALTH, StatusEffects.INSTANT_DAMAGE);
        OPPOSITE_EFFECTS.put(StatusEffects.REGENERATION, StatusEffects.WITHER);
        OPPOSITE_EFFECTS.put(StatusEffects.SPEED, StatusEffects.SLOWNESS);
        OPPOSITE_EFFECTS.put(StatusEffects.STRENGTH, StatusEffects.WEAKNESS);
        OPPOSITE_EFFECTS.put(StatusEffects.LUCK, StatusEffects.UNLUCK);
        OPPOSITE_EFFECTS.put(ModEffects.ORDERLINESS, ModEffects.DISORGANIZATION);
        OPPOSITE_EFFECTS.put(StatusEffects.HEALTH_BOOST, ModEffects.DEPLETION);
        OPPOSITE_EFFECTS.put(ModEffects.FLIGHT, ModEffects.NO_FLIGHT);
    }

    public static boolean isBeneficial(StatusEffect effect) {
        return GOOD_EFFECTS.contains(effect);
    }

    public static boolean isHarmful(StatusEffect effect) {
        return BAD_EFFECTS.contains(effect);
    }

    public static int safeParseInt(String value, int defaultValue) {
        if (value == null) return defaultValue;
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}