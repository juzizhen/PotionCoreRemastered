package com.juzizhen.potioncoreremastered.mixin;

import com.juzizhen.potioncoreremastered.effect.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.projectile.ProjectileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Objects;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow
    public abstract boolean hasStatusEffect(StatusEffect effect);

    @Redirect(
            method = "baseTick",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setAir(I)V")
    )
    private void redirectSetAir(LivingEntity self, int air) {
        if (!(self.hasStatusEffect(ModEffects.DROWN))) {
            self.setAir(air);
        }
    }

    @ModifyVariable(
            method = "damage",
            at = @At("HEAD"),
            argsOnly = true,
            ordinal = 0
    )
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
                    System.out.println("[DEBUG] LossAccuracy triggered: level=" + level + ", newDamage=" + amount);
                }
            }
        }

        if (self.hasStatusEffect(ModEffects.VULNERABLE)) {
            int level = Objects.requireNonNull(self.getStatusEffect(ModEffects.VULNERABLE)).getAmplifier() + 1;
            amount *= (1.0F + 0.5F * level);
            System.out.println("[DEBUG] Vulnerable triggered: level=" + level + ", newDamage=" + amount);
        }

        return amount;
    }
}