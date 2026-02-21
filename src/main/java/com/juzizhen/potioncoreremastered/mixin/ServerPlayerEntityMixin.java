package com.juzizhen.potioncoreremastered.mixin;

import com.juzizhen.potioncoreremastered.effect.ModEffects;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin {

    @Inject(method = "onDeath", at = @At("HEAD"), cancellable = true)
    private void onDeathRevival(DamageSource source, CallbackInfo ci) {
        ServerPlayerEntity player = (ServerPlayerEntity)(Object)this;

        if (player.hasStatusEffect(ModEffects.REVIVAL)) {
            int amplifier = Objects.requireNonNull(player.getStatusEffect(ModEffects.REVIVAL)).getAmplifier();

            player.removeStatusEffect(ModEffects.REVIVAL);

            float healAmount = (amplifier + 1) * 4.0F;

            player.setHealth(Math.min(player.getMaxHealth(), healAmount));

            ServerWorld world = player.getServerWorld();
            world.spawnParticles(ParticleTypes.HEART,
                    player.getX(), player.getY() + 1, player.getZ(),
                    10, 0.5, 0.5, 0.5, 0.1);
            player.playSound(SoundEvents.ITEM_TOTEM_USE, 1.0F, 1.0F);

            ci.cancel();
        }
    }
}
