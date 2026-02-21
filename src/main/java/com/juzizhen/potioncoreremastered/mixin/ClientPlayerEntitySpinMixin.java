package com.juzizhen.potioncoreremastered.mixin;

import com.juzizhen.potioncoreremastered.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(PlayerEntity.class)
abstract class ClientPlayerEntitySpinMixin {
    @Unique
    private static final Random RANDOM = new Random();

    @Inject(method = "tickMovement", at = @At("TAIL"))
    private void onTickMovementTail(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        StatusEffectInstance effect = player.getStatusEffect(ModEffects.SPIN);
        if (effect == null) return;

        int amplifier = effect.getAmplifier();
        float minAngle = (amplifier + 1) * 2.0f;
        float maxAngle = (amplifier + 1) * 10.0f;

        float yawDelta = (RANDOM.nextFloat() * (maxAngle - minAngle) + minAngle)
                * (RANDOM.nextBoolean() ? 1 : -1);
        float pitchDelta = (RANDOM.nextFloat() * (maxAngle - minAngle) + minAngle)
                * (RANDOM.nextBoolean() ? 1 : -1);

        player.setYaw(player.getYaw() + yawDelta);
        player.setPitch(player.getPitch() + pitchDelta);
    }
}