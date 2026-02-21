package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;

public class EffectRust extends StatusEffect {
    public EffectRust() {
        super(StatusEffectCategory.HARMFUL, 0x8B4513);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        if (entity.getWorld().getTime() % 20 != 0) return;

        int damageAmount = amplifier + 1;

        if (entity instanceof PlayerEntity player) {
            PlayerInventory inventory = player.getInventory();
            for (ItemStack stack : inventory.main) {
                damageItem(stack, damageAmount, entity);
            }
            for (ItemStack stack : inventory.armor) {
                damageItem(stack, damageAmount, entity);
            }
            damageItem(inventory.offHand.get(0), damageAmount, entity);
        }
        else {
            damageItem(entity.getMainHandStack(), damageAmount, entity);
            damageItem(entity.getOffHandStack(), damageAmount, entity);
            for (EquipmentSlot slot : EquipmentSlot.values()) {
                if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                    damageItem(entity.getEquippedStack(slot), damageAmount, entity);
                }
            }
        }
    }

    /**
     * 对单个物品栈扣除耐久，如果物品消失则自动处理
     */
    private void damageItem(ItemStack stack, int amount, LivingEntity entity) {
        if (stack.isEmpty() || !stack.isDamageable()) return;
        stack.damage(amount, entity, (holder) -> { });
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}