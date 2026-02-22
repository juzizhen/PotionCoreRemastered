package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class EffectRepair extends StatusEffect {
    private static final Map<UUID, Long> LAST_REPAIR_TICK = new ConcurrentHashMap<>();
    private static final int REPAIR_INTERVAL = 100;

    public EffectRepair() {
        super(StatusEffectCategory.BENEFICIAL, 7829367);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, attributes, amplifier);
        if (entity.getWorld().isClient) return;
        if (!(entity instanceof PlayerEntity player)) return;

        UUID uuid = player.getUuid();
        long currentTick = player.getWorld().getTime();
        Long lastTick = LAST_REPAIR_TICK.get(uuid);

        if (!(lastTick != null && currentTick - lastTick < REPAIR_INTERVAL)) {
            repairItems(player, amplifier);
            LAST_REPAIR_TICK.put(uuid, currentTick);
        }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;
        if (!(entity instanceof PlayerEntity player)) return;

        UUID uuid = player.getUuid();
        long currentTick = player.getWorld().getTime();
        Long lastTick = LAST_REPAIR_TICK.get(uuid);

        if (lastTick != null && currentTick >= lastTick + REPAIR_INTERVAL) {
            repairItems(player, amplifier);
            LAST_REPAIR_TICK.put(uuid, currentTick);
        }
    }

    private void repairItems(PlayerEntity player, int amplifier) {
        int repairAmount = amplifier + 1;

        PlayerInventory inventory = player.getInventory();

        repairStack(inventory.getMainHandStack(), repairAmount);
        repairStack(inventory.offHand.get(0), repairAmount);
        for (ItemStack stack : inventory.armor) {
            repairStack(stack, repairAmount);
        }

        player.playerScreenHandler.sendContentUpdates();
    }

    private void repairStack(ItemStack stack, int amount) {
        if (stack.isEmpty() || !stack.isDamageable()) return;
        if (stack.getDamage() > 0) {
            int newDamage = Math.max(0, stack.getDamage() - amount);
            stack.setDamage(newDamage);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}