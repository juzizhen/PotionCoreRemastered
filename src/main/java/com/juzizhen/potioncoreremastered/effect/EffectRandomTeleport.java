package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class EffectRandomTeleport extends StatusEffect {
    private static final Random RANDOM = new Random();
    private static final int BASE_RANGE = 16;
    private static final int RANGE_PER_LEVEL = 8;

    public EffectRandomTeleport() {
        super(StatusEffectCategory.HARMFUL, 52377);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        teleportRandomly(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 5 == 0;
    }

    private static void teleportRandomly(LivingEntity entity, int amplifier) {
        if (!(entity.getWorld() instanceof ServerWorld world)) return;

        double range = BASE_RANGE + (amplifier + 1) * RANGE_PER_LEVEL;
        for (int i = 0; i < 16; ++i) {
            double x = entity.getX() + (RANDOM.nextDouble() - 0.5) * range;
            double y = entity.getY() + (RANDOM.nextInt((int)range) - range / 2);
            double z = entity.getZ() + (RANDOM.nextDouble() - 0.5) * range;

            if (teleportTo(entity, world, x, y, z)) {
                world.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                        SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS,
                        1.0f, 1.0f);
                entity.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                return;
            }
        }
    }

    private static boolean teleportTo(LivingEntity entity, ServerWorld world, double x, double y, double z) {
        BlockPos.Mutable mutable = new BlockPos.Mutable(x, y, z);
        while (mutable.getY() > world.getBottomY() && !world.getBlockState(mutable).blocksMovement()) {
            mutable.move(net.minecraft.util.math.Direction.DOWN);
        }
        if (world.getBlockState(mutable).blocksMovement()) {
            mutable.move(net.minecraft.util.math.Direction.UP);
        }

        return entity.teleport(mutable.getX() + 0.5, mutable.getY(), mutable.getZ() + 0.5, true);
    }
}