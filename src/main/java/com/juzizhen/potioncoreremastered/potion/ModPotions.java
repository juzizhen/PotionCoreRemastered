package com.juzizhen.potioncoreremastered.potion;

import com.juzizhen.potioncoreremastered.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final Potion BROKEN_ARMOR_POTION = new Potion(
            new StatusEffectInstance(ModEffects.BROKEN_ARMOR, 3600, 0)
    );
    public static final Potion LONG_BROKEN_ARMOR_POTION = new Potion(
            new StatusEffectInstance(ModEffects.BROKEN_ARMOR, 9600, 0)
    );
    public static final Potion STRONG_BROKEN_ARMOR_POTION = new Potion(
            "broken_armor",
            new StatusEffectInstance(ModEffects.BROKEN_ARMOR, 1800, 1)
    );

    public static final Potion SUSTAINED_SATURATION_POTION = new Potion(
            new StatusEffectInstance(ModEffects.SUSTAINED_SATURATION, 3600, 0)
    );
    public static final Potion LONG_SUSTAINED_SATURATION_POTION = new Potion(
            new StatusEffectInstance(ModEffects.SUSTAINED_SATURATION, 9600, 0)
    );
    public static final Potion STRONG_SUSTAINED_SATURATION_POTION = new Potion(
            "sustained_saturation",
            new StatusEffectInstance(ModEffects.SUSTAINED_SATURATION, 1800, 1)
    );

    public static final Potion DISORGANIZATION_POTION = new Potion(
            new StatusEffectInstance(ModEffects.DISORGANIZATION, 3600, 0)
    );

    public static final Potion DISPEL_POTION = new Potion(
            new StatusEffectInstance(ModEffects.DISPEL, 3600, 0)
    );

    public static final Potion DROWN_POTION = new Potion(
            new StatusEffectInstance(ModEffects.DROWN, 3600, 0)
    );

    public static final Potion EXPLODE_POTION = new Potion(
            new StatusEffectInstance(ModEffects.EXPLODE, 3600, 0)
    );
    public static final Potion LONG_EXPLODE_POTION = new Potion(
            new StatusEffectInstance(ModEffects.EXPLODE, 9600, 0)
    );
    public static final Potion STRONG_EXPLODE_POTION = new Potion(
            "explode",
            new StatusEffectInstance(ModEffects.EXPLODE, 1800, 1)
    );

    public static void registerPotions() {
        registerBrokenArmor(); //护甲减效 Broken Armor
        registerSustainedSaturation(); //持续饱和 Sustained Saturation
        registerDisorganization(); //乱序 Disorganization
        registerDispel(); //驱散 Dispel
        registerDrown(); //溺水 Drown
        registerExplode(); //爆破 Explode
    }

    private static void registerBrokenArmor() {
        //护甲减效 Broken Armor
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "broken_armor"), BROKEN_ARMOR_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "long_broken_armor"), LONG_BROKEN_ARMOR_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "strong_broken_armor"), STRONG_BROKEN_ARMOR_POTION);
    }

    private static void registerSustainedSaturation() {
        //持续饱和 Sustained Saturation
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "sustained_saturation"), SUSTAINED_SATURATION_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "long_sustained_saturation"), LONG_SUSTAINED_SATURATION_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "strong_sustained_saturation"), STRONG_SUSTAINED_SATURATION_POTION);
    }

    private static void registerDisorganization() {
        //乱序 Disorganization
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "disorganization"), DISORGANIZATION_POTION);
    }

    private static void registerDispel() {
        //驱散 Dispel
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "dispel"), DISPEL_POTION);
    }

    private static void registerDrown() {
        //溺水 Drown
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "drown"), DROWN_POTION);
    }

    private static void registerExplode() {
        //爆破 Explode
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "explode"), EXPLODE_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "long_explode"), LONG_EXPLODE_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "strong_explode"), STRONG_EXPLODE_POTION);
    }
}