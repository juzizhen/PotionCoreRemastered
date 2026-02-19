package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EffectDisorganization extends StatusEffect {
    public EffectDisorganization() {
        super(StatusEffectCategory.HARMFUL, 0x64273F);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        if (entity instanceof ServerPlayerEntity player) {
            PlayerInventory inventory = player.getInventory();

            List<ItemStack> allItems = new ArrayList<>(inventory.main.size() + 1);
            for (ItemStack stack : inventory.main) {
                allItems.add(stack.copy());
            }
            allItems.add(inventory.offHand.get(0).copy());

            Collections.shuffle(allItems);

            for (int i = 0; i < inventory.main.size(); i++) {
                inventory.main.set(i, allItems.get(i));
            }
            inventory.offHand.set(0, allItems.get(inventory.main.size()));

            player.playerScreenHandler.sendContentUpdates();
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}