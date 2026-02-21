package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    // 正面效果
    public static StatusEffect SUSTAINED_SATURATION = new EffectSustainedSaturation();

    // 负面效果
    public static final StatusEffect BROKEN_ARMOR = new EffectBrokenArmor();
    public static final StatusEffect CURSE = new EffectCurse();
    public static final StatusEffect DISORGANIZATION = new EffectDisorganization();
    public static final StatusEffect DISPEL = new EffectDispel();
    public static final StatusEffect DROWN = new EffectDrown();
    public static final StatusEffect EXPLODE = new EffectExplode();
    public static final StatusEffect COMBUSTION = new EffectCombustion();
    public static final StatusEffect LOSS_ACCURACY = new EffectLossAccuracy();
    public static final StatusEffect VULNERABLE = new EffectVulnerable();
    public static final StatusEffect RUST = new EffectRust();
    public static final StatusEffect MIRROR = new EffectMirror();
    public static final StatusEffect MAGIC_INHIBITION = new EffectMagicInhibition();
    public static final StatusEffect SPIN = new EffectSpin();
    public static final StatusEffect WEIGHT = new EffectWeight();
    public static final StatusEffect RANDOM_TELEPORT = new EffectRandomTeleport();
    public static final StatusEffect LIGHTNING = new EffectLightning();
    public static final StatusEffect LAUNCH = new EffectLaunch();
    public static final StatusEffect POTION_SICKNESS = new EffectPotionSickness();
    public static final StatusEffect NO_FLIGHT = new EffectNoFlight();


    public static void registerEffects() {
        // 正面效果
        Registry.register( Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "sustained_saturation"), SUSTAINED_SATURATION);

        // 负面效果
        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "broken_armor"), BROKEN_ARMOR);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "disorganization"), DISORGANIZATION);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "dispel"), DISPEL);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "drown"), DROWN);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "explode"), EXPLODE);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "curse"), CURSE);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "combustion"), COMBUSTION);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "loss_accuracy"), LOSS_ACCURACY);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "vulnerable"), VULNERABLE);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "rust"), RUST);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "mirror"), MIRROR);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "magic_inhibition"), MAGIC_INHIBITION);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "spin"), SPIN);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "weight"), WEIGHT);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "random_teleport"), RANDOM_TELEPORT);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "lightning"), LIGHTNING);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "launch"), LAUNCH);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "potion_sickness"), POTION_SICKNESS);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "no_flight"), NO_FLIGHT);
    }
}
