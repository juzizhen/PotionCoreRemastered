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
        LivingEntity attacker;
        if (source.getAttacker() instanceof PotionEntity potion) {
            attacker = (LivingEntity) potion.getOwner();
        } else if (source.getAttacker() instanceof AreaEffectCloudEntity cloud) {
            attacker = cloud.getOwner();
        } else {
            attacker = source.getAttacker() instanceof LivingEntity living ? living : null;
        }
        return attacker;
    }
}