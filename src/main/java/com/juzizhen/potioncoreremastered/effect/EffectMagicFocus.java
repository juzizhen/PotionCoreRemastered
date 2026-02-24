package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import org.jetbrains.annotations.Nullable;

public class EffectMagicFocus extends StatusEffect {
    public EffectMagicFocus() {
        super(StatusEffectCategory.BENEFICIAL, 15114239);
    }

    public static @Nullable LivingEntity getLivingEntity(DamageSource source) {
        LivingEntity attacker = null;
        if (source.getAttacker() instanceof PotionEntity potion) {
            if (potion.getOwner() instanceof LivingEntity owner) {
                attacker = owner;
            }
        } else if (source.getAttacker() instanceof AreaEffectCloudEntity cloud) {
            if (cloud.getOwner() instanceof LivingEntity owner) {
                attacker = owner;
            }
        } else {
            attacker = source.getAttacker() instanceof LivingEntity living ? living : null;
        }
        return attacker;
    }
}