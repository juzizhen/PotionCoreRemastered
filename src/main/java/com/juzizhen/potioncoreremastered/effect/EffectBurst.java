package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.world.World;

public class EffectBurst extends StatusEffect {
    public static final float BASE_EXPLOSION_SIZE = 2.0F;

    public EffectBurst() {
        super(StatusEffectCategory.BENEFICIAL, 6710886);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        if (!world.isClient) {
            float strength = (amplifier + 1) * BASE_EXPLOSION_SIZE;
            world.createExplosion(
                    entity,
                    entity.getX(),
                    entity.getY(),
                    entity.getZ(),
                    strength,
                    World.ExplosionSourceType.NONE
            );
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
