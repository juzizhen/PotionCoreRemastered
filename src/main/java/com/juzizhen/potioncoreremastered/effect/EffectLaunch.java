package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.Nullable;

public class EffectLaunch extends StatusEffect {
    public EffectLaunch() {
        super(StatusEffectCategory.HARMFUL, 65280);
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        super.applyInstantEffect(source, attacker, target, amplifier, proximity);

        int level = amplifier + 1;
        double height = (level == 1) ? 6.0 : level * 6.0 + 2.0;
        double velocityY = Math.sqrt(0.16 * height);

        target.setVelocity(target.getVelocity().x, velocityY, target.getVelocity().z);
        target.velocityModified = true;

        if (target.getWorld() instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(
                    ParticleTypes.EXPLOSION,
                    target.getX(), target.getY(), target.getZ(),
                    1, 0.0, 0.0, 0.0, 0.0
            );

            serverWorld.playSound(
                    null,
                    target.getX(), target.getY(), target.getZ(),
                    SoundEvents.ENTITY_GENERIC_EXPLODE,
                    SoundCategory.PLAYERS,
                    1.0F,
                    1.0F
            );
        }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        int level = amplifier + 1;
        double height = (level == 1) ? 6.0 : level * 6.0 + 2.0;
        double velocityY = Math.sqrt(0.16 * height);

        entity.setVelocity(entity.getVelocity().x, velocityY, entity.getVelocity().z);
        entity.velocityModified = true;

        if (entity.getWorld() instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(ParticleTypes.EXPLOSION, entity.getX(), entity.getY(), entity.getZ(), 1, 0, 0, 0, 0);
            serverWorld.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0F, 1.0F);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean isInstant() {
        return true;
    }
}