package com.juzizhen.potioncoreremastered.mixin;

import com.juzizhen.potioncoreremastered.effect.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.ProjectileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow
    public abstract boolean hasStatusEffect(StatusEffect effect);

    @Redirect(method = "baseTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setAir(I)V"))
    private void redirectSetAir(LivingEntity self, int air) {
        if (!(self.hasStatusEffect(ModEffects.DROWN))) {
            self.setAir(air);
        }
    }

    @ModifyVariable(method = "damage", at = @At("HEAD"), argsOnly = true, ordinal = 0)
    private float modifyDamage(float amount, DamageSource source) {
        LivingEntity self = (LivingEntity) (Object) this;

        Entity attackerEntity = source.getSource();
        if (attackerEntity instanceof ProjectileEntity projectile) {
            Entity owner = projectile.getOwner();
            if (owner instanceof LivingEntity living) {
                if (living.hasStatusEffect(ModEffects.LOSS_ACCURACY)) {
                    int level = Objects.requireNonNull(living.getStatusEffect(ModEffects.LOSS_ACCURACY)).getAmplifier() + 1;
                    float reduction = level * 4.0f;
                    amount = Math.max(0, amount - reduction);
                }
            }
        }

        if (self.hasStatusEffect(ModEffects.VULNERABLE)) {
            int level = Objects.requireNonNull(self.getStatusEffect(ModEffects.VULNERABLE)).getAmplifier() + 1;
            amount *= (1.0F + 0.5F * level);
        }

        return amount;
    }

    @Inject(method = "addStatusEffect*", at = @At("HEAD"), cancellable = true)
    private void weakenNewBuff(StatusEffectInstance original, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;

        if (self.getWorld().isClient) return;
        if (self.getCommandTags().contains("potioncoreremastered:internal_weaken")) return;

        StatusEffectInstance inhibitor = self.getStatusEffect(ModEffects.MAGIC_INHIBITION);
        if (inhibitor != null) {
            StatusEffect eff = original.getEffectType();

            if (eff == ModEffects.POTION_SICKNESS) return;
            if (eff == ModEffects.MAGIC_INHIBITION) return;

            int inhibitorLevel = inhibitor.getAmplifier() + 1;
            double reductionFactor = inhibitorLevel * 0.3;

            int reducedAmp = (int) Math.round(original.getAmplifier() - reductionFactor);
            if (reducedAmp < 0) reducedAmp = 0;

            StatusEffectInstance newInst = new StatusEffectInstance(
                    eff,
                    original.getDuration(),
                    reducedAmp,
                    original.isAmbient(),
                    original.shouldShowParticles(),
                    original.shouldShowIcon()
            );

            self.addCommandTag("potioncoreremastered:internal_weaken");
            try {
                cir.setReturnValue(self.addStatusEffect(newInst));
            } finally {
                self.removeScoreboardTag("potioncoreremastered:internal_weaken");
            }
        }
    }

    @Inject(method = "jump", at = @At("TAIL"))
    private void modifyJump(CallbackInfo ci) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (self.hasStatusEffect(ModEffects.WEIGHT)) {
            int amplifier = Objects.requireNonNull(self.getStatusEffect(ModEffects.WEIGHT)).getAmplifier();
            double reduction = 1.0 - 0.03 * (amplifier + 1);
            self.setVelocity(self.getVelocity().x,
                    self.getVelocity().y * reduction,
                    self.getVelocity().z);
        }
    }
}