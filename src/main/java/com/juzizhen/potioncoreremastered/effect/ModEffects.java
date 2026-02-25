package com.juzizhen.potioncoreremastered.effect;

import com.juzizhen.potioncoreremastered.PotionCoreRemastered;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    // 正面效果
    public static final StatusEffect ANTIDOTE = new EffectAntidote();
    public static final StatusEffect IMPROVE_ACCURACY = new EffectImproveAccuracy();
    public static final StatusEffect BLESS = new EffectBless();
    public static final StatusEffect CLIMB = new EffectClimb();
    public static final StatusEffect CURE = new EffectCure();
    public static final StatusEffect DIAMOND_SKIN = new EffectDiamondSkin();
    public static final StatusEffect EXTENSION = new EffectExtension();
    public static final StatusEffect REPAIR = new EffectRepair();
    public static final StatusEffect REVIVAL = new EffectRevival();
    public static final StatusEffect STEP_UP = new EffectStepUp();
    public static final StatusEffect TELEPORT_SPAWN = new EffectTeleportSpawn();
    public static final StatusEffect PURITY = new EffectPurity();
    public static final StatusEffect SOLID_CORE = new EffectSolidCore();
    public static final StatusEffect FLIGHT = new EffectFlight();
    public static final StatusEffect LOVE = new EffectLove();
    public static final StatusEffect TELEPORT_SURFACE = new EffectTeleportSurface();
    public static final StatusEffect REACH = new EffectReach();
    public static final StatusEffect IRON_SKIN = new EffectIronSkin();
    public static final StatusEffect COUNTERATTACK = new EffectCounterattack();
    public static final StatusEffect MAGIC_SHIELD = new EffectMagicShield();
    public static final StatusEffect MAGIC_FOCUS = new EffectMagicFocus();
    public static final StatusEffect ORDERLINESS = new EffectOrderliness();

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
    public static final StatusEffect BURST = new EffectBurst();
    public static final StatusEffect BROKEN_MAGIC = new EffectBrokenMagic();

    //中立效果
    public static final StatusEffect CHANCE = new EffectChance();
    public static final StatusEffect INVERT = new EffectInvert();

    public static void registerEffects() {
        /*
         * 正面效果
         */
        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "antidote"), ANTIDOTE);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "improve_accuracy"), IMPROVE_ACCURACY);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "bless"), BLESS);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "burst"), BURST);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "climb"), CLIMB);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "cure"), CURE);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "diamond_skin"), DIAMOND_SKIN);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "extension"), EXTENSION);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "repair"), REPAIR);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "revival"), REVIVAL);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "step_up"), STEP_UP);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "teleport_spawn"), TELEPORT_SPAWN);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "purity"), PURITY);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "solid_core"), SOLID_CORE);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "flight"), FLIGHT);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "love"), LOVE);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "teleport_surface"), TELEPORT_SURFACE);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "reach"), REACH);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "iron_skin"), IRON_SKIN);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "counterattack"), COUNTERATTACK);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "magic_shield"), MAGIC_SHIELD);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "magic_focus"), MAGIC_FOCUS);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "orderliness"), ORDERLINESS);

        /*
         * 负面效果
         */
        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "broken_armor"), BROKEN_ARMOR);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "disorganization"), DISORGANIZATION);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "dispel"), DISPEL);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "drown"), DROWN);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "explode"), EXPLODE);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "curse"), CURSE);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "combustion"), COMBUSTION);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "loss_accuracy"), LOSS_ACCURACY);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "vulnerable"), VULNERABLE);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "rust"), RUST);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "mirror"), MIRROR);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "magic_inhibition"), MAGIC_INHIBITION);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "spin"), SPIN);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "weight"), WEIGHT);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "random_teleport"), RANDOM_TELEPORT);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "lightning"), LIGHTNING);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "launch"), LAUNCH);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "potion_sickness"), POTION_SICKNESS);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "no_flight"), NO_FLIGHT);

        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "broken_magic"), BROKEN_MAGIC);

        /*
         * 中立效果
         */
        Registry.register( Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "chance"), CHANCE);


        Registry.register(Registries.STATUS_EFFECT,
                new Identifier(PotionCoreRemastered.MOD_ID, "invert"), INVERT);
    }
}
