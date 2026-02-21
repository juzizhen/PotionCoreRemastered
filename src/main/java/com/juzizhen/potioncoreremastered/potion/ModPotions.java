package com.juzizhen.potioncoreremastered.potion;

import com.juzizhen.potioncoreremastered.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    // 正面效果
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

    // 负面效果
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

    public static final Potion CURSE_POTION = new Potion(
            new StatusEffectInstance(ModEffects.CURSE, 3600, 0)
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

    public static final Potion COMBUSTION_POTION = new Potion(
            new StatusEffectInstance(ModEffects.COMBUSTION, 3600, 0)
    );
    public static final Potion LONG_COMBUSTION_POTION = new Potion(
            new StatusEffectInstance(ModEffects.COMBUSTION, 9600, 0)
    );
    public static final Potion STRONG_COMBUSTION_POTION = new Potion(
            "combustion",
            new StatusEffectInstance(ModEffects.COMBUSTION, 1800, 1)
    );

    public static final Potion LOSS_ACCURACY_POTION = new Potion(
            new StatusEffectInstance(ModEffects.LOSS_ACCURACY, 3600, 0)
    );
    public static final Potion LONG_LOSS_ACCURACY_POTION = new Potion(
            new StatusEffectInstance(ModEffects.LOSS_ACCURACY, 9600, 0)
    );
    public static final Potion STRONG_LOSS_ACCURACY_POTION = new Potion(
            "loss_accuracy",
            new StatusEffectInstance(ModEffects.LOSS_ACCURACY, 1800, 1)
    );

    public static final Potion VULNERABLE_POTION = new Potion(
            new StatusEffectInstance(ModEffects.VULNERABLE, 3600, 0)
    );
    public static final Potion LONG_VULNERABLE_POTION = new Potion(
            new StatusEffectInstance(ModEffects.VULNERABLE, 9600, 0)
    );
    public static final Potion STRONG_VULNERABLE_POTION = new Potion(
            "vulnerable",
            new StatusEffectInstance(ModEffects.VULNERABLE, 1800, 1)
    );

    public static final Potion RUST_POTION = new Potion(
            new StatusEffectInstance(ModEffects.RUST, 3600, 0)
    );
    public static final Potion LONG_RUST_POTION = new Potion(
            new StatusEffectInstance(ModEffects.RUST, 9600, 0)
    );
    public static final Potion STRONG_RUST_POTION = new Potion(
            "rust",
            new StatusEffectInstance(ModEffects.RUST, 1800, 1)
    );

    public static final Potion MIRROR_POTION = new Potion(
            new StatusEffectInstance(ModEffects.MIRROR, 3600, 0)
    );

    public static final Potion MAGIC_INHIBITION_POTION = new Potion(
            new StatusEffectInstance(ModEffects.MAGIC_INHIBITION, 3600, 0)
    );
    public static final Potion LONG_MAGIC_INHIBITION_POTION = new Potion(
            new StatusEffectInstance(ModEffects.MAGIC_INHIBITION, 9600, 0)
    );
    public static final Potion STRONG_MAGIC_INHIBITION_POTION = new Potion(
            "magic_inhibition",
            new StatusEffectInstance(ModEffects.MAGIC_INHIBITION, 1800, 1)
    );

    public static final Potion SPIN_POTION = new Potion(
            new StatusEffectInstance(ModEffects.SPIN, 3600, 0)
    );
    public static final Potion LONG_SPIN_POTION = new Potion(
            new StatusEffectInstance(ModEffects.SPIN, 9600, 0)
    );
    public static final Potion STRONG_SPIN_POTION = new Potion(
            "spin",
            new StatusEffectInstance(ModEffects.SPIN, 1800, 1)
    );

    public static final Potion WEIGHT_POTION = new Potion(
            new StatusEffectInstance(ModEffects.WEIGHT, 3600, 0)
    );
    public static final Potion LONG_WEIGHT_POTION = new Potion(
            new StatusEffectInstance(ModEffects.WEIGHT, 9600, 0)
    );
    public static final Potion STRONG_WEIGHT_POTION = new Potion(
            "weight",
            new StatusEffectInstance(ModEffects.WEIGHT, 1800, 1)
    );

    public static final Potion RANDOM_TELEPORT_POTION = new Potion(
            new StatusEffectInstance(ModEffects.RANDOM_TELEPORT, 3600, 0)
    );

    public static final Potion LIGHTNING_POTION = new Potion(
            new StatusEffectInstance(ModEffects.LIGHTNING, 3600, 0)
    );
    public static final Potion LONG_LIGHTNING_POTION = new Potion(
            new StatusEffectInstance(ModEffects.LIGHTNING, 9600, 0)
    );
    public static final Potion STRONG_LIGHTNING_POTION = new Potion(
            "lightning",
            new StatusEffectInstance(ModEffects.LIGHTNING, 1800, 1)
    );

    public static final Potion LAUNCH_POTION = new Potion(
            new StatusEffectInstance(ModEffects.LAUNCH, 1, 0)
    );
    public static final Potion STRONG_LAUNCH_POTION = new Potion(
            new StatusEffectInstance(ModEffects.LAUNCH, 1, 1)
    );
    public static final Potion SUPER_STRONG_LAUNCH_POTION = new Potion(
            new StatusEffectInstance(ModEffects.LAUNCH, 1, 2)
    );
    public static final Potion PLUS_SUPER_STRONG_LAUNCH_POTION = new Potion(
            new StatusEffectInstance(ModEffects.LAUNCH, 1, 3)
    );
    public static final Potion ULTRA_PLUS_SUPER_STRONG_LAUNCH_POTION = new Potion(
            new StatusEffectInstance(ModEffects.LAUNCH, 1, 4)
    );

    public static final Potion NO_FLIGHT_POTION = new Potion(
            new StatusEffectInstance(ModEffects.NO_FLIGHT, 3600, 0)
    );

    public static void registerPotions() {
        // 正面效果
        registerSustainedSaturation(); // 持续饱和 Sustained Saturation

        // 负面效果
        registerBrokenArmor(); // 护甲减效 Broken Armor
        registerCurse(); // 诅咒 Curse
        registerDisorganization(); // 乱序 Disorganization
        registerDispel(); // 驱散 Dispel
        registerDrown(); // 溺水 Drown
        registerExplode(); // 爆破 Explode
        registerCombustion(); // 燃烧 Combustion
        registerLossAccuracy(); // 降低精度 Loss Accuracy
        registerVulnerable();// 脆弱 Vulnerable
        registerRust(); // 腐蚀 Rust
        registerMirror(); // 镜像 Mirror
        registerMagicInhibition(); // 魔力抑制 Magic Inhibition
        registerSpin(); // 头晕 Spin
        registerWeight(); // 沉重 Weight
        registerRandomTeleport(); // 随机传送 Random Teleport
        registerLightning(); // 闪电 Lightning
        registerLaunch(); // 发射 Launch
        registerNoFlight(); // 禁空 No Flight
    }

    // 正面效果
    private static void registerSustainedSaturation() {
        // 持续饱和 Sustained Saturation
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

    // 负面效果
    private static void registerBrokenArmor() {
        // 护甲减效 Broken Armor
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

    private static void registerCurse() {
        // 诅咒 Curse
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "curse"), CURSE_POTION);
    }

    private static void registerDisorganization() {
        // 乱序 Disorganization
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "disorganization"), DISORGANIZATION_POTION);
    }

    private static void registerDispel() {
        // 驱散 Dispel
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "dispel"), DISPEL_POTION);
    }

    private static void registerDrown() {
        // 溺水 Drown
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "drown"), DROWN_POTION);
    }

    private static void registerExplode() {
        // 爆破 Explode
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

    private static void registerCombustion() {
        // 燃烧 Combustion
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "combustion"), COMBUSTION_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "long_combustion"), LONG_COMBUSTION_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "strong_combustion"), STRONG_COMBUSTION_POTION);
    }

    private static void registerLossAccuracy() {
        // 降低精度 Loss Accuracy
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "loss_accuracy"), LOSS_ACCURACY_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "long_loss_accuracy"), LONG_LOSS_ACCURACY_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "strong_loss_accuracy"), STRONG_LOSS_ACCURACY_POTION);
    }

    private static void registerVulnerable() {
        // 脆弱 Vulnerable
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "vulnerable"), VULNERABLE_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "long_vulnerable"), LONG_VULNERABLE_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "strong_vulnerable"), STRONG_VULNERABLE_POTION);
    }

    private static void registerRust() {
        // 腐蚀 Rust
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "rust"), RUST_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "long_rust"), LONG_RUST_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "strong_rust"), STRONG_RUST_POTION);
    }

    private static void registerMirror() {
        // 镜像 Mirror
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "mirror"), MIRROR_POTION);
    }

    private static void registerMagicInhibition() {
        // 魔力抑制 Magic Inhibition
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "magic_inhibition"), MAGIC_INHIBITION_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "long_magic_inhibition"), LONG_MAGIC_INHIBITION_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "strong_magic_inhibition"), STRONG_MAGIC_INHIBITION_POTION);
    }

    private static void registerSpin() {
        // 头晕 Spin
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "spin"), SPIN_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "long_spin"), LONG_SPIN_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "strong_spin"), STRONG_SPIN_POTION);
    }

    private static void registerWeight() {
        // 沉重 Weight
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "weight"), WEIGHT_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "long_weight"), LONG_WEIGHT_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "strong_weight"), STRONG_WEIGHT_POTION);
    }

    private static void registerRandomTeleport() {
        // 随机传送 Random Teleport
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "random_teleport"), RANDOM_TELEPORT_POTION);
    }

    private static void registerLightning() {
        // 闪电 Lightning
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "lightning"), LIGHTNING_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "long_lightning"), LONG_LIGHTNING_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "strong_lightning"), STRONG_LIGHTNING_POTION);
    }

    private static void registerLaunch() {
        // 发射 Launch
        // 注册 Launch I
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "launch"), LAUNCH_POTION);
        // 注册 Launch II
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "strong_launch"), STRONG_LAUNCH_POTION);
        // 注册 Launch III
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "super_strong_launch"), SUPER_STRONG_LAUNCH_POTION);
        // 注册 Launch IV
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "plus_super_strong_launch"), PLUS_SUPER_STRONG_LAUNCH_POTION);
        // 注册 Launch V
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "ultra_plus_super_strong_launch"), ULTRA_PLUS_SUPER_STRONG_LAUNCH_POTION);
    }

    private static void registerNoFlight() {
        // 禁空 No Flight
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier("potioncoreremastered", "no_flight"), NO_FLIGHT_POTION);
    }
}