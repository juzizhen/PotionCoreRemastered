package com.juzizhen.potioncoreremastered.mixin;

import com.juzizhen.potioncoreremastered.effect.ModEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.Input;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * 客户端 Mixin：修改 ClientPlayerEntity 的输入
 * 仅在客户端生效，配置在 mixins.potioncoreremastered.json 的 "client" 部分
 */
@Mixin(KeyboardInput.class)
public abstract class KeyboardInputMixin extends Input {

    /*
     * 镜像 MIRROR
     */
    @Inject(method = "tick", at = @At("TAIL"))
    private void onTick(boolean slowDown, float f, CallbackInfo ci) {
        PlayerEntity self = MinecraftClient.getInstance().player;
        if (self != null && self.hasStatusEffect(ModEffects.MIRROR)) {
            // 反转 WASD
            this.movementForward *= -1;
            this.movementSideways *= -1;

            // 如果需要交换跳跃/潜行
            boolean originalSneaking = this.sneaking;
            boolean originalJumping = this.jumping;
            this.sneaking = originalJumping;
            this.jumping = originalSneaking;
        }
    }
}

