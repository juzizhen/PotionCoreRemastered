package com.juzizhen.potioncoreremastered.potion;

import com.juzizhen.potioncoreremastered.PotionCoreRemastered;
import com.juzizhen.potioncoreremastered.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    /*
     * 正面效果
     */
    public static final Potion ANTIDOTE_POTION = new Potion(
            new StatusEffectInstance(ModEffects.ANTIDOTE, 3600, 0)
    );
    public static final Potion LONG_ANTIDOTE_POTION = new Potion(
            new StatusEffectInstance(ModEffects.ANTIDOTE, 9600, 0)
    );

    public static final Potion IMPROVE_ACCURACY_POTION = new Potion(
            new StatusEffectInstance(ModEffects.IMPROVE_ACCURACY, 3600, 0)
    );
    public static final Potion LONG_IMPROVE_ACCURACY_POTION = new Potion(
            new StatusEffectInstance(ModEffects.IMPROVE_ACCURACY, 9600, 0)
    );
    public static final Potion STRONG_IMPROVE_ACCURACY_POTION = new Potion(
            "improve_accuracy",
            new StatusEffectInstance(ModEffects.IMPROVE_ACCURACY, 1800, 1)
    );

    public static final Potion BLESS_POTION = new Potion(
            new StatusEffectInstance(ModEffects.BLESS, 3600, 0)
    );
    public static final Potion LONG_BLESS_POTION = new Potion(
            new StatusEffectInstance(ModEffects.BLESS, 9600, 0)
    );

    public static final Potion BURST_POTION = new Potion(
            new StatusEffectInstance(ModEffects.BURST, 3600, 0)
    );
    public static final Potion LONG_BURST_POTION = new Potion(
            new StatusEffectInstance(ModEffects.BURST, 9600, 0)
    );
    public static final Potion STRONG_BURST_POTION = new Potion(
            "burst",
            new StatusEffectInstance(ModEffects.BURST, 1800, 1)
    );

    public static final Potion CLIMB_POTION = new Potion(
            new StatusEffectInstance(ModEffects.CLIMB, 3600, 0)
    );
    public static final Potion LONG_CLIMB_POTION = new Potion(
            new StatusEffectInstance(ModEffects.CLIMB, 9600, 0)
    );

    public static final Potion CURE_POTION = new Potion(
            new StatusEffectInstance(ModEffects.CURE, 3600, 0)
    );
    public static final Potion LONG_CURE_POTION = new Potion(
            new StatusEffectInstance(ModEffects.CURE, 9600, 0)
    );

    public static final Potion DIAMOND_SKIN_POTION = new Potion(
            new StatusEffectInstance(ModEffects.DIAMOND_SKIN, 3600, 0)
    );
    public static final Potion LONG_DIAMOND_SKIN_POTION = new Potion(
            new StatusEffectInstance(ModEffects.DIAMOND_SKIN, 9600, 0)
    );
    public static final Potion STRONG_DIAMOND_SKIN_POTION = new Potion(
            "diamond_skin",
            new StatusEffectInstance(ModEffects.DIAMOND_SKIN, 1800, 1)
    );

    public static final Potion EXTENSION_POTION = new Potion(
            new StatusEffectInstance(ModEffects.EXTENSION, 3600, 0)
    );
    public static final Potion LONG_EXTENSION_POTION = new Potion(
            new StatusEffectInstance(ModEffects.EXTENSION, 9600, 0)
    );
    public static final Potion STRONG_EXTENSION_POTION = new Potion(
            "extension",
            new StatusEffectInstance(ModEffects.EXTENSION, 1800, 1)
    );

    public static final Potion REPAIR_POTION = new Potion(
            new StatusEffectInstance(ModEffects.REPAIR, 3600, 0)
    );
    public static final Potion LONG_REPAIR_POTION = new Potion(
            new StatusEffectInstance(ModEffects.REPAIR, 9600, 0)
    );
    public static final Potion STRONG_REPAIR_POTION = new Potion(
            "repair",
            new StatusEffectInstance(ModEffects.REPAIR, 1800, 1)
    );

    public static final Potion REVIVAL_POTION = new Potion(
            new StatusEffectInstance(ModEffects.REVIVAL, 3600, 0)
    );
    public static final Potion LONG_REVIVAL_POTION = new Potion(
            new StatusEffectInstance(ModEffects.REVIVAL, 9600, 0)
    );
    public static final Potion STRONG_REVIVAL_POTION = new Potion(
            "revival",
            new StatusEffectInstance(ModEffects.REVIVAL, 1800, 1)
    );

    public static final Potion STEP_UP_POTION = new Potion(
            new StatusEffectInstance(ModEffects.STEP_UP, 3600, 0)
    );
    public static final Potion LONG_STEP_UP_POTION = new Potion(
            new StatusEffectInstance(ModEffects.STEP_UP, 9600, 0)
    );
    public static final Potion STRONG_STEP_UP_POTION = new Potion(
            "step_up",
            new StatusEffectInstance(ModEffects.STEP_UP, 1800, 1)
    );

    public static final Potion TELEPORT_SPAWN_POTION = new Potion(
            new StatusEffectInstance(ModEffects.TELEPORT_SPAWN, 3600, 0)
    );
    public static final Potion LONG_TELEPORT_SPAWN_POTION = new Potion(
            new StatusEffectInstance(ModEffects.TELEPORT_SPAWN, 9600, 0)
    );

    public static final Potion PURITY_POTION = new Potion(
            new StatusEffectInstance(ModEffects.PURITY, 3600, 0)
    );
    public static final Potion LONG_PURITY_POTION = new Potion(
            new StatusEffectInstance(ModEffects.PURITY, 9600, 0)
    );

    public static final Potion SOLID_CORE_POTION = new Potion(
            new StatusEffectInstance(ModEffects.SOLID_CORE, 3600, 0)
    );
    public static final Potion LONG_SOLID_CORE_POTION = new Potion(
            new StatusEffectInstance(ModEffects.SOLID_CORE, 9600, 0)
    );
    public static final Potion STRONG_SOLID_CORE_POTION = new Potion(
            "solid_core",
            new StatusEffectInstance(ModEffects.SOLID_CORE, 1800, 1)
    );

    public static final Potion FLIGHT_POTION = new Potion(
            new StatusEffectInstance(ModEffects.FLIGHT, 3600, 0)
    );
    public static final Potion LONG_FLIGHT_POTION = new Potion(
            new StatusEffectInstance(ModEffects.FLIGHT, 9600, 0)
    );

    public static final Potion LOVE_POTION = new Potion(
            new StatusEffectInstance(ModEffects.LOVE, 1, 0)
    );

    public static final Potion TELEPORT_SURFACE_POTION = new Potion(
            new StatusEffectInstance(ModEffects.TELEPORT_SURFACE, 1, 0)
    );

    public static final Potion REACH_POTION = new Potion(
            new StatusEffectInstance(ModEffects.REACH, 3600, 0)
    );
    public static final Potion LONG_REACH_POTION = new Potion(
            new StatusEffectInstance(ModEffects.REACH, 9600, 0)
    );
    public static final Potion STRONG_REACH_POTION = new Potion(
            "reach",
            new StatusEffectInstance(ModEffects.REACH, 1800, 1)
    );

    public static final Potion IRON_SKIN_POTION = new Potion(
            new StatusEffectInstance(ModEffects.IRON_SKIN, 3600, 0)
    );
    public static final Potion LONG_IRON_SKIN_POTION = new Potion(
            new StatusEffectInstance(ModEffects.IRON_SKIN, 9600, 0)
    );
    public static final Potion STRONG_IRON_SKIN_POTION = new Potion(
            "iron_skin",
            new StatusEffectInstance(ModEffects.IRON_SKIN, 1800, 1)
    );

    public static final Potion COUNTERATTACK_POTION = new Potion(
            new StatusEffectInstance(ModEffects.COUNTERATTACK, 3600, 0)
    );
    public static final Potion LONG_COUNTERATTACK_POTION = new Potion(
            new StatusEffectInstance(ModEffects.COUNTERATTACK, 9600, 0)
    );
    public static final Potion STRONG_COUNTERATTACK_POTION = new Potion(
            "counterattack",
            new StatusEffectInstance(ModEffects.COUNTERATTACK, 1800, 1)
    );

    public static final Potion MAGIC_SHIELD_POTION = new Potion(
            new StatusEffectInstance(ModEffects.MAGIC_SHIELD, 3600, 0)
    );
    public static final Potion LONG_MAGIC_SHIELD_POTION = new Potion(
            new StatusEffectInstance(ModEffects.MAGIC_SHIELD, 9600, 0)
    );
    public static final Potion STRONG_MAGIC_SHIELD_POTION = new Potion(
            "magic_shield",
            new StatusEffectInstance(ModEffects.MAGIC_SHIELD, 1800, 1)
    );

    public static final Potion MAGIC_FOCUS_POTION = new Potion(
            new StatusEffectInstance(ModEffects.MAGIC_FOCUS, 3600, 0)
    );
    public static final Potion LONG_MAGIC_FOCUS_POTION = new Potion(
            new StatusEffectInstance(ModEffects.MAGIC_FOCUS, 9600, 0)
    );
    public static final Potion STRONG_MAGIC_FOCUS_POTION = new Potion(
            "magic_focus",
            new StatusEffectInstance(ModEffects.MAGIC_FOCUS, 1800, 1)
    );

    public static final Potion ORDERLINESS_POTION = new Potion(
            new StatusEffectInstance(ModEffects.ORDERLINESS, 3600, 0)
    );
    public static final Potion LONG_ORDERLINESS_POTION = new Potion(
            new StatusEffectInstance(ModEffects.ORDERLINESS, 9600, 0)
    );

    /*
     * 负面效果
     */
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
    public static final Potion LONG_CURSE_POTION = new Potion(
            new StatusEffectInstance(ModEffects.CURSE, 9600, 0)
    );

    public static final Potion DISORGANIZATION_POTION = new Potion(
            new StatusEffectInstance(ModEffects.DISORGANIZATION, 3600, 0)
    );
    public static final Potion LONG_DISORGANIZATION_POTION = new Potion(
            new StatusEffectInstance(ModEffects.DISORGANIZATION, 9600, 0)
    );

    public static final Potion DISPEL_POTION = new Potion(
            new StatusEffectInstance(ModEffects.DISPEL, 3600, 0)
    );
    public static final Potion LONG_DISPEL_POTION = new Potion(
            new StatusEffectInstance(ModEffects.DISPEL, 9600, 0)
    );

    public static final Potion DROWN_POTION = new Potion(
            new StatusEffectInstance(ModEffects.DROWN, 3600, 0)
    );
    public static final Potion LONG_DROWN_POTION = new Potion(
            new StatusEffectInstance(ModEffects.DROWN, 9600, 0)
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
    public static final Potion LONG_MIRROR_POTION = new Potion(
            new StatusEffectInstance(ModEffects.MIRROR, 9600, 0)
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
    public static final Potion LONG_RANDOM_TELEPORT_POTION = new Potion(
            new StatusEffectInstance(ModEffects.RANDOM_TELEPORT, 9600, 0)
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
    public static final Potion LONG_NO_FLIGHT_POTION = new Potion(
            new StatusEffectInstance(ModEffects.NO_FLIGHT, 9600, 0)
    );

    public static final Potion BROKEN_MAGIC_POTION = new Potion(
            new StatusEffectInstance(ModEffects.BROKEN_MAGIC, 3600, 0)
    );
    public static final Potion LONG_BROKEN_MAGIC_POTION = new Potion(
            new StatusEffectInstance(ModEffects.BROKEN_MAGIC, 9600, 0)
    );
    public static final Potion STRONG_BROKEN_MAGIC_POTION = new Potion(
            "broken_magic",
            new StatusEffectInstance(ModEffects.BROKEN_MAGIC, 1800, 1)
    );

    /*
     * 中立效果
     */
    public static final Potion CHANCE_POTION = new Potion(
            new StatusEffectInstance(ModEffects.CHANCE, 3600, 0)
    );
    public static final Potion LONG_CHANCE_POTION = new Potion(
            new StatusEffectInstance(ModEffects.CHANCE, 9600, 0)
    );

    public static final Potion INVERT_POTION = new Potion(
            new StatusEffectInstance(ModEffects.INVERT, 1, 0)
    );

    public static void registerPotions() {
        // 正面效果
        registerAntidote(); // 解毒 Antidote
        registerImproveAccuracy(); // 提高精度 Improve Accuracy
        registerBless(); // 祝福 Bless
        registerBurst(); // 炸裂 Burst
        registerClimb(); // 攀爬 Climb
        registerCure(); // 净化 Cure
        registerDiamondSkin(); // 镶钻 Diamond Skin
        registerExtension(); //延长 Extension
        registerRepair(); // 修复 Repair
        registerRevival(); // 复活 Revival
        registerStepUp(); // 高踏 Step Up
        registerTeleportSpawn(); // 回家 Teleport Spawn
        registerPurity(); // 凋零抗性 Purity
        registerSolidCore(); // 稳固 Solid Core
        registerFlight(); // 飞行 Flight
        registerLove(); // 爱情 Love
        registerTeleportSurface(); // 地面传送 Teleport Surface
        registerReach(); // 延伸 Reach
        registerIronSkin(); // 铁皮 Iron Skin
        registerCounterattack(); // 反伤 Counterattack
        registerBrokenMagic(); // 破魔 Broken Magic
        registerMagicFocus(); // 魔力聚焦 Magic Focus
        registerOrderliness(); // 有序 Orderliness

        // 负面效果
        registerBrokenArmor(); // 护甲减效 Broken Armor
        registerCurse(); // 诅咒 Curse
        registerDisorganization(); // 乱序 Disorganization
        registerDispel(); // 驱散 Dispel
        registerDrown(); // 鱼鳃 Drown
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
        registerMagicShield(); // 魔抗 magic_shield

        // 中立效果
        registerChance(); // 运气 Chance
        registerInvert(); // 颠倒 Invert
    }

    /*
     * 正面效果
     */
    private static void registerAntidote() {
        // 解毒 Antidote
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "antidote"), ANTIDOTE_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_antidote"), LONG_ANTIDOTE_POTION);
    }

    private static void registerImproveAccuracy() {
        // 提高精度 Improve Accuracy
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "improve_accuracy"), IMPROVE_ACCURACY_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_improve_accuracy"), LONG_IMPROVE_ACCURACY_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_improve_accuracy"), STRONG_IMPROVE_ACCURACY_POTION);
    }

    private static void registerBless() {
        // 祝福 Bless
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "bless"), BLESS_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_bless"), LONG_BLESS_POTION);
    }

    private static void registerBurst() {
        // 炸裂 Burst
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "burst"), BURST_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_burst"), LONG_BURST_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_burst"), STRONG_BURST_POTION);
    }

    private static void registerClimb() {
        // 攀爬 Climb
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "climb"), CLIMB_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_climb"), LONG_CLIMB_POTION);
    }

    private static void registerCure() {
        // 净化 Cure
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "cure"), CURE_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_cure"), LONG_CURE_POTION);
    }

    private static void registerDiamondSkin() {
        // 镶钻 Diamond Skin
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "diamond_skin"), DIAMOND_SKIN_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_diamond_skin"), LONG_DIAMOND_SKIN_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_diamond_skin"), STRONG_DIAMOND_SKIN_POTION);
    }

    private static void registerExtension() {
        // 延长 Extension
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "extension"), EXTENSION_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_extension"), LONG_EXTENSION_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_extension"), STRONG_EXTENSION_POTION);
    }

    private static void registerRepair() {
        // 修复 Repair
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "repair"), REPAIR_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_repair"), LONG_REPAIR_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_repair"), STRONG_REPAIR_POTION);
    }

    private static void registerRevival() {
        // 复活 Revival
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "revival"), REVIVAL_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_revival"), LONG_REVIVAL_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_revival"), STRONG_REVIVAL_POTION);
    }

    private static void registerStepUp() {
        // 高踏 Step Up
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "step_up"), STEP_UP_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_step_up"), LONG_STEP_UP_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_step_up"), STRONG_STEP_UP_POTION);
    }

    private static void registerTeleportSpawn() {
        // 回家 Teleport Spawn
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "teleport_spawn"), TELEPORT_SPAWN_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_teleport_spawn"), LONG_TELEPORT_SPAWN_POTION);
    }

    private static void registerPurity() {
        // 凋零抗性 Purity
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "purity"), PURITY_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_purity"), LONG_PURITY_POTION);
    }

    private static void registerSolidCore() {
        // 稳固 Solid Core
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "solid_core"), SOLID_CORE_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_solid_core"), LONG_SOLID_CORE_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_solid_core"), STRONG_SOLID_CORE_POTION);
    }

    private static void registerFlight() {
        // 飞行 Flight
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "flight"), FLIGHT_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_flight"), LONG_FLIGHT_POTION);
    }

    private static void registerLove() {
        // 爱情 Love
        // 注册 Love I
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "love"), LOVE_POTION);
    }

    private static void registerTeleportSurface() {
        // 地面传送 Teleport Surface
        // 注册 Teleport Surface I
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "teleport_surface"), TELEPORT_SURFACE_POTION);
    }

    private static void registerReach() {
        // 延伸 Reach
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "reach"), REACH_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_reach"), LONG_REACH_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_reach"), STRONG_REACH_POTION);
    }

    private static void registerIronSkin() {
        // 铁皮 Iron Skin
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "iron_skin"), IRON_SKIN_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_iron_skin"), LONG_IRON_SKIN_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_iron_skin"), STRONG_IRON_SKIN_POTION);
    }

    private static void registerCounterattack() {
        // 反伤 Counterattack
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "counterattack"), COUNTERATTACK_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_counterattack"), LONG_COUNTERATTACK_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_counterattack"), STRONG_COUNTERATTACK_POTION);
    }

    private static void registerMagicShield() {
        // 魔抗 magic_shield
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "magic_shield"), MAGIC_SHIELD_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_magic_shield"), LONG_MAGIC_SHIELD_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_magic_shield"), STRONG_MAGIC_SHIELD_POTION);
    }

    private static void registerMagicFocus() {
        // 魔力聚焦 Magic Focus
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "magic_focus"), MAGIC_FOCUS_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_magic_focus"), LONG_MAGIC_FOCUS_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_magic_focus"), STRONG_MAGIC_FOCUS_POTION);
    }

    private static void registerOrderliness() {
        // 有序 Orderliness
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "orderliness"), ORDERLINESS_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_orderliness"), LONG_ORDERLINESS_POTION);
    }

    /*
     * 负面效果
     */
    private static void registerBrokenArmor() {
        // 护甲减效 Broken Armor
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "broken_armor"), BROKEN_ARMOR_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_broken_armor"), LONG_BROKEN_ARMOR_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_broken_armor"), STRONG_BROKEN_ARMOR_POTION);
    }

    private static void registerCurse() {
        // 诅咒 Curse
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "curse"), CURSE_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_curse"), LONG_CURSE_POTION);
    }

    private static void registerDisorganization() {
        // 乱序 Disorganization
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "disorganization"), DISORGANIZATION_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_disorganization"), LONG_DISORGANIZATION_POTION);
    }

    private static void registerDispel() {
        // 驱散 Dispel
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "dispel"), DISPEL_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_dispel"), LONG_DISPEL_POTION);
    }

    private static void registerDrown() {
        // 鱼鳃 Drown
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "drown"), DROWN_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_drown"), LONG_DROWN_POTION);
    }

    private static void registerExplode() {
        // 爆破 Explode
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "explode"), EXPLODE_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_explode"), LONG_EXPLODE_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_explode"), STRONG_EXPLODE_POTION);
    }

    private static void registerCombustion() {
        // 燃烧 Combustion
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "combustion"), COMBUSTION_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_combustion"), LONG_COMBUSTION_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_combustion"), STRONG_COMBUSTION_POTION);
    }

    private static void registerLossAccuracy() {
        // 降低精度 Loss Accuracy
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "loss_accuracy"), LOSS_ACCURACY_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_loss_accuracy"), LONG_LOSS_ACCURACY_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_loss_accuracy"), STRONG_LOSS_ACCURACY_POTION);
    }

    private static void registerVulnerable() {
        // 脆弱 Vulnerable
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "vulnerable"), VULNERABLE_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_vulnerable"), LONG_VULNERABLE_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_vulnerable"), STRONG_VULNERABLE_POTION);
    }

    private static void registerRust() {
        // 腐蚀 Rust
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "rust"), RUST_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_rust"), LONG_RUST_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_rust"), STRONG_RUST_POTION);
    }

    private static void registerMirror() {
        // 镜像 Mirror
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "mirror"), MIRROR_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_mirror"), LONG_MIRROR_POTION);
    }

    private static void registerMagicInhibition() {
        // 魔力抑制 Magic Inhibition
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "magic_inhibition"), MAGIC_INHIBITION_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_magic_inhibition"), LONG_MAGIC_INHIBITION_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_magic_inhibition"), STRONG_MAGIC_INHIBITION_POTION);
    }

    private static void registerSpin() {
        // 头晕 Spin
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "spin"), SPIN_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_spin"), LONG_SPIN_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_spin"), STRONG_SPIN_POTION);
    }

    private static void registerWeight() {
        // 沉重 Weight
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "weight"), WEIGHT_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_weight"), LONG_WEIGHT_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_weight"), STRONG_WEIGHT_POTION);
    }

    private static void registerRandomTeleport() {
        // 随机传送 Random Teleport
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "random_teleport"), RANDOM_TELEPORT_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_random_teleport"), LONG_RANDOM_TELEPORT_POTION);
    }

    private static void registerLightning() {
        // 闪电 Lightning
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "lightning"), LIGHTNING_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_lightning"), LONG_LIGHTNING_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_lightning"), STRONG_LIGHTNING_POTION);
    }

    private static void registerLaunch() {
        // 发射 Launch
        // 注册 Launch I
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "launch"), LAUNCH_POTION);
        // 注册 Launch II
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_launch"), STRONG_LAUNCH_POTION);
        // 注册 Launch III
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "super_strong_launch"), SUPER_STRONG_LAUNCH_POTION);
        // 注册 Launch IV
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "plus_super_strong_launch"), PLUS_SUPER_STRONG_LAUNCH_POTION);
        // 注册 Launch V
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "ultra_plus_super_strong_launch"), ULTRA_PLUS_SUPER_STRONG_LAUNCH_POTION);
    }

    private static void registerNoFlight() {
        // 禁空 No Flight
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "no_flight"), NO_FLIGHT_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_no_flight"), LONG_NO_FLIGHT_POTION);
    }

    private static void registerBrokenMagic() {
        // 破魔 Broken Magic
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "broken_magic"), BROKEN_MAGIC_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_broken_magic"), LONG_BROKEN_MAGIC_POTION);
        // 注册增强版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "strong_broken_magic"), STRONG_BROKEN_MAGIC_POTION);
    }

    /*
     * 中立效果
     */
    private static void registerChance() {
        // 运气 Chance
        // 注册普通版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "chance"), CHANCE_POTION);
        // 注册延长版
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "long_chance"), LONG_CHANCE_POTION);
    }

    private static void registerInvert() {
        // 颠倒 Invert
        // 注册 Invert
        Registry.register(Registries.POTION,
                new Identifier(PotionCoreRemastered.MOD_ID, "invert"), INVERT_POTION);}
}