package com.juzizhen.potioncoreremastered.mixin;

import com.juzizhen.potioncoreremastered.effect.ModEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Entity.class)
abstract class EntityMixin {

    /*
     * 头晕 SPIN
     */
    @Redirect(method = "changeLookDirection(DD)V", at = @At( value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;clamp(FFF)F"))
    private float redirectClamp(float value, float min, float max) {
        Entity self = (Entity)(Object)this;
        if (self instanceof PlayerEntity player) {
            StatusEffectInstance effect = player.getStatusEffect(ModEffects.SPIN);
            if (effect != null) {
                return value;
            }
        }
        return MathHelper.clamp(value, min, max);
    }

    /*
     * 镜像 MIRROR
     */
    @ModifyVariable(method = "changeLookDirection", at = @At("HEAD"), argsOnly = true, ordinal = 0)
    private double modifyLookDirectionX(double cursorDeltaX) {
        PlayerEntity self = MinecraftClient.getInstance().player;
        if (self != null && self.hasStatusEffect(ModEffects.MIRROR)) {
            return -cursorDeltaX;
        }
        return cursorDeltaX;
    }

    @ModifyVariable(method = "changeLookDirection", at = @At("HEAD"), argsOnly = true, ordinal = 1)
    private double modifyLookDirectionY(double cursorDeltaY) {
        PlayerEntity self = MinecraftClient.getInstance().player;
        if (self != null && self.hasStatusEffect(ModEffects.MIRROR)) {
            return -cursorDeltaY;
        }
        return cursorDeltaY;
    }
}

