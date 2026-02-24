package com.juzizhen.potioncoreremastered.mixin;

import com.juzizhen.potioncoreremastered.attribute.ModAttributes;
import com.juzizhen.potioncoreremastered.damagetypes.ModDamageTypes;
import com.juzizhen.potioncoreremastered.effect.EffectMagicFocus;
import com.juzizhen.potioncoreremastered.effect.EffectMagicShield;
import com.juzizhen.potioncoreremastered.effect.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
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

    @Shadow
    public abstract boolean damage(DamageSource source, float amount);

    /*
     * 溺水 DROWN
     */
    @Redirect(method = "baseTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setAir(I)V"))
    private void redirectSetAir(LivingEntity self, int air) {
        if (!(self.hasStatusEffect(ModEffects.DROWN))) {
            self.setAir(air);
        }
    }

    /*
     * 失去精度 LOSS_ACCURACY
     * 提高精度 IMPROVE_ACCURACY
     * 脆弱 VULNERABLE
     */
    @ModifyVariable(method = "damage", at = @At("HEAD"), argsOnly = true, ordinal = 0)
    private float modifyDamage(float amount, DamageSource source) {
        LivingEntity self = (LivingEntity) (Object) this;

        Entity attackerEntity = source.getSource();
        if (attackerEntity instanceof ProjectileEntity projectile) {
            Entity owner = projectile.getOwner();
            if (owner instanceof LivingEntity living) {
                if (living.hasStatusEffect(ModEffects.LOSS_ACCURACY)) {
                    int level = Objects.requireNonNull(living.getStatusEffect(ModEffects.LOSS_ACCURACY)).getAmplifier() + 1;
                    amount -= level * 4.0f;
                }

                if (living.hasStatusEffect(ModEffects.IMPROVE_ACCURACY)) {
                    int level = Objects.requireNonNull(living.getStatusEffect(ModEffects.IMPROVE_ACCURACY)).getAmplifier() + 1;
                    amount += level * 3.0f;
                }
            }
        }

        if (self.hasStatusEffect(ModEffects.VULNERABLE)) {
            int level = Objects.requireNonNull(self.getStatusEffect(ModEffects.VULNERABLE)).getAmplifier() + 1;
            amount *= (1.0F + 0.5F * level);
        }

        if (amount < 0.0F) {
            amount = 0.0F;
        }

        return amount;
    }

    /*
     * 魔抗 MAGIC_SHIELD
     */
    @ModifyVariable(method = "damage", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private float modifyMagicShieldDamage(float amount, DamageSource source) {
        LivingEntity self = (LivingEntity) (Object) this;
        World world = self.getWorld();
        if (world.isClient) return amount;

        // 没有魔法护盾效果 或 不是玩家 → 不处理
        if (!self.hasStatusEffect(ModEffects.MAGIC_SHIELD)) return amount;
        if (!(self instanceof PlayerEntity)) return amount;

        // 只处理魔法伤害（你可以抽成单独方法更清晰）
        if (!source.isOf(DamageTypes.MAGIC)
                && !source.isOf(DamageTypes.INDIRECT_MAGIC)
                && !source.isOf(DamageTypes.WITHER)
                && !source.isOf(ModDamageTypes.COUNTERATTACK)) {
            return amount;
        }

        EntityAttributeInstance attr = self.getAttributeInstance(ModAttributes.MAGIC_SHIELD);
        if (attr == null) return amount;

        double magicShield = attr.getValue();
        if (magicShield <= 0) return amount;

        if (amount >= magicShield) { // 破盾
            EffectMagicShield.isOverlay = false;
            self.removeStatusEffect(ModEffects.MAGIC_SHIELD);
            return (float) (amount - magicShield);
        }
        return amount;
    }

    /*
     * 魔抗 MAGIC_SHIELD
     */
    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void cancelMagicDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        World world = self.getWorld();
        if (world.isClient) return;

        if (!self.hasStatusEffect(ModEffects.MAGIC_SHIELD)) return;
        if (!(self instanceof PlayerEntity)) return;

        if (source.isOf(DamageTypes.MAGIC)
                || source.isOf(DamageTypes.INDIRECT_MAGIC)
                || source.isOf(DamageTypes.WITHER)
                || source.isOf(ModDamageTypes.COUNTERATTACK)) {

            EntityAttributeInstance attr = self.getAttributeInstance(ModAttributes.MAGIC_SHIELD);
            if (attr == null) return;

            double magicShield = attr.getValue();
            if (magicShield > 0 && amount < magicShield) {
                EffectMagicShield.clearAttribute(attr);
                EffectMagicShield.setAttribute(attr, magicShield - amount, EntityAttributeModifier.Operation.ADDITION);
                cir.setReturnValue(false);
            }
        }
    }


    /*
     * 反伤 COUNTERATTACK
     */
    @Inject(method = "damage", at = @At("HEAD"))
    private void onDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        World world = self.getWorld();
        if (world.isClient) return;

        if (source.isOf(ModDamageTypes.COUNTERATTACK)) {
            return;
        }

        StatusEffectInstance counterattack = self.getStatusEffect(ModEffects.COUNTERATTACK);
        if (counterattack == null) return;

        Entity attacker = source.getAttacker();
        if (!(attacker instanceof LivingEntity target)) return;

        int amplifier = counterattack.getAmplifier();
        float damage = amount * (amplifier + 1) * 0.25f;

        target.damage(ModDamageTypes.counterattack(world, target, self), damage);
    }

    /*
     * 沉重 WEIGHT
     */
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

    /*
     * 解毒 ANTIDOTE
     * 凋零抗性 PURITY
     * 魔抗 MAGIC_SHIELD
     */
    @Inject(method = "addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;Lnet/minecraft/entity/Entity;)Z", at = @At("HEAD"), cancellable = true)
    private void onAddStatusEffect(StatusEffectInstance effect, @Nullable Entity source, CallbackInfoReturnable<Boolean> cir) {
        if (effect.getEffectType() == StatusEffects.POISON) {
            LivingEntity self = (LivingEntity) (Object) this;
            if (self.hasStatusEffect(ModEffects.ANTIDOTE)) {
                cir.setReturnValue(false);
                cir.cancel();
            }
        }

        if (effect.getEffectType() == StatusEffects.WITHER) {
            LivingEntity self = (LivingEntity) (Object) this;
            if (self.hasStatusEffect(ModEffects.PURITY)) {
                cir.setReturnValue(false);
                cir.cancel();
            }
        }

        if (effect.getEffectType() == ModEffects.MAGIC_SHIELD) {
            LivingEntity self = (LivingEntity) (Object) this;

            if (self.hasStatusEffect(ModEffects.MAGIC_SHIELD)) {
                EffectMagicShield.isOverlay = true;
            }

            if (self instanceof PlayerEntity) {
                EntityAttributeInstance attr = self.getAttributeInstance(ModAttributes.MAGIC_SHIELD);
                if (attr != null) {
                    float amp = effect.getAmplifier() + 1;
                    double value = attr.getValue() + 4.0F * amp;
                    EffectMagicShield.clearAttribute(attr);
                    EffectMagicShield.setAttribute(attr, value, EntityAttributeModifier.Operation.ADDITION);
                }
            }
        }
    }

    @ModifyVariable(method = "damage", at = @At("HEAD"), argsOnly = true, ordinal = 0)
    private float modifyMagicDamage(float amount, DamageSource source) {
        LivingEntity attacker = EffectMagicFocus.getLivingEntity(source);
        if (source.isOf(DamageTypes.MAGIC) || source.isOf(DamageTypes.INDIRECT_MAGIC)) {
            if (attacker != null) {
                float finalDamage = amount;
                if (attacker.hasStatusEffect(ModEffects.MAGIC_INHIBITION)) {
                    StatusEffectInstance StatusEffect = attacker.getStatusEffect(ModEffects.MAGIC_INHIBITION);
                    if (StatusEffect != null) {
                        int amp = StatusEffect.getAmplifier();
                        finalDamage = finalDamage - (amp + 1) * 0.3f;
                    }
                }

                if (attacker.hasStatusEffect(ModEffects.MAGIC_FOCUS)) {
                    StatusEffectInstance StatusEffect = attacker.getStatusEffect(ModEffects.MAGIC_FOCUS);
                    if (StatusEffect != null) {
                        int amp = StatusEffect.getAmplifier();
                        finalDamage = finalDamage + (amp + 1) * 0.75f;
                    }
                }
                return finalDamage;
            }
        }
        return amount;
    }
}