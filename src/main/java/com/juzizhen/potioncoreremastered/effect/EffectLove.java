package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

public class EffectLove extends StatusEffect {
    private static final int LOVE_TICKS = 600;

    public EffectLove() {
        super(StatusEffectCategory.BENEFICIAL, 0xFF69B4);
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        if (target.getWorld().isClient) return;

        if (target instanceof AnimalEntity animal) {
            if (animal.isBaby()) return;
            if (animal.isInLove()) return;
            if (animal.getBreedingAge() > 0) return;

            animal.setLoveTicks(LOVE_TICKS);

            if (target.getWorld() instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles(
                        ParticleTypes.HEART,
                        animal.getX(), animal.getY() + 1, animal.getZ(),
                        7,
                        0.5, 0.5, 0.5,
                        0.1
                );
            }

            if (source != null) {
                animal.setLoveTicks(LOVE_TICKS);
            }
        }
    }

    @Override
    public boolean isInstant() {
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return false;
    }
}