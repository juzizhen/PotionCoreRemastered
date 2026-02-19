package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static StatusEffect SUSTAINED_SATURATION = new EffectSustainedSaturation();
    public static StatusEffect BROKEN_ARMOR = new EffectBrokenArmor();
    public static StatusEffect DISORGANIZATION = new EffectDisorganization();
    public static StatusEffect DISPEL = new EffectDispel();
    public static StatusEffect DROWN = new EffectDrown();
    public static StatusEffect EXPLODE = new EffectExplode();


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
    }
}
