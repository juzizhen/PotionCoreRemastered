package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    // 增益
    public static StatusEffect SUSTAINED_SATURATION = new EffectSustainedSaturation();

    // 减益
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


    public static void registerEffects() {
        Registry.register( Registries.STATUS_EFFECT,
                new Identifier("potioncoreremastered", "sustained_saturation"), SUSTAINED_SATURATION);

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
    }
}
