package com.juzizhen.potioncoreremastered.effect;

import com.juzizhen.potioncoreremastered.PotionCoreRemastered;
import com.juzizhen.potioncoreremastered.util.EffectClassifier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.random.Random;

public class EffectPotionSickness extends StatusEffect {
    public EffectPotionSickness() {
        super(StatusEffectCategory.NEUTRAL, 16711935);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;
        if (!(entity instanceof PlayerEntity player)) return;

        var config = PotionCoreRemastered.CONFIG;
        if (!config.PotionSicknessEnabled) return;

        int sicknessLevel = amplifier + 1;
        double chance = sicknessLevel / (double) EffectClassifier.safeParseInt(config.PotionSicknessBadEffectChance, 1000);
        if (chance <= 0) return;

        Random random = player.getRandom();
        if (random.nextDouble() >= chance) return;

        StatusEffect selected = selectRandomBadEffect(random);
        if (selected == null) return;

        player.addStatusEffect(new StatusEffectInstance(selected, 1200, 0));
    }

    private StatusEffect selectRandomBadEffect(Random random) {
        var set = EffectClassifier.BAD_EFFECTS;
        if (set.isEmpty()) return null;

        int index = random.nextInt(set.size());
        int i = 0;
        for (StatusEffect effect : set) {
            if (i == index && !effect.isInstant() && effect != ModEffects.POTION_SICKNESS) {
                return effect;
            }
            i++;
        }
        return null;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}