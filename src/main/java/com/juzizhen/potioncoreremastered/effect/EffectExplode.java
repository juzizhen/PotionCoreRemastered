package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.world.World;

public class EffectExplode extends StatusEffect {
    public EffectExplode() {
        super(StatusEffectCategory.HARMFUL, 3355443);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        World world = entity.getWorld();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        float strength = 2.0F * (amplifier + 1);
        if (strength > 300.0F) {
            strength = 300.0F;
        }

        world.createExplosion(
                entity,                 // 爆炸发起者（实体自身）
                x, y, z,                // 爆炸位置
                strength,               // 威力
                false,                  // 是否产生火焰
                World.ExplosionSourceType.MOB
        );
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}