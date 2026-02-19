package com.juzizhen.potioncoreremastered.mixin;

import com.juzizhen.potioncoreremastered.effect.ModEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.entity.Entity;

/**
 * 修改视角变化：反转鼠标移动（抬头↔低头，左转头↔右转头）
 * 使用 @ModifyVariable 修改方法参数，argsOnly = true 表示修改参数变量
 */
@Mixin(Entity.class)
public abstract class EntityCameraMixin {

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