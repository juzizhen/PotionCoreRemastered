package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.particle.ParticleTypes;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;

import java.util.Objects;

public class EffectRevival extends StatusEffect {

    public EffectRevival() {
        super(StatusEffectCategory.BENEFICIAL, 16711680);
        ServerLivingEntityEvents.ALLOW_DEATH.register((entity, damageSource, damageAmount) -> {
            if (entity.hasStatusEffect(ModEffects.REVIVAL)) {
                int amplifier = Objects.requireNonNull(entity.getStatusEffect(ModEffects.REVIVAL)).getAmplifier();

                entity.removeStatusEffect(ModEffects.REVIVAL);

                float healAmount = (amplifier + 1) * 4.0F;

                entity.setHealth(Math.min(entity.getMaxHealth(), healAmount));

                if (entity.getWorld() instanceof ServerWorld serverWorld) {
                    serverWorld.spawnParticles(ParticleTypes.HEART,
                            entity.getX(), entity.getY() + 1, entity.getZ(),

                            20, 0.5, 0.5, 0.5, 0.1);
                    serverWorld.spawnParticles(ParticleTypes.TOTEM_OF_UNDYING,
                            entity.getX(), entity.getY() + 1, entity.getZ(),
                            50, 0.5, 0.5, 0.5, 0.5);

                    serverWorld.playSound(
                            null,
                            entity.getX(), entity.getY(), entity.getZ(),
                            SoundEvents.ITEM_TOTEM_USE,
                            SoundCategory.PLAYERS,
                            1.0F, 1.0F
                    );
                }
                return false;
            }
            return true;
        });
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return false;
    }
}
