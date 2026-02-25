package com.juzizhen.potioncoreremastered.effect;

import com.juzizhen.potioncoreremastered.PotionCoreRemastered;
import com.juzizhen.potioncoreremastered.util.EffectClassifier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

import java.util.Comparator;
import java.util.List;

public class EffectOrderliness extends StatusEffect {
    public EffectOrderliness() {
        super(StatusEffectCategory.BENEFICIAL, 0x40E0D0);
    }

    public static void sortInventoryByName(PlayerEntity player) {
        List<ItemStack> inventory = player.getInventory().main;

        List<ItemStack> backpack = inventory.subList(9, 36);

        backpack.sort(Comparator.comparing(stack -> {
            if (stack.isEmpty()) {
                return "\uFFFF";
            }
            String name = stack.getName().getString().toLowerCase();
            return name.isEmpty() ? "\uFFFF" : name.substring(0, 1);
        }));
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!(entity instanceof PlayerEntity player)) return;

        var effect = player.getStatusEffect(this);
        if (effect == null) return;

        int intervalSeconds = EffectClassifier.safeParseInt(
                PotionCoreRemastered.CONFIG.BackpackAutoSortInterval, 30);

        int intervalTicks = intervalSeconds * 20;

        int duration = effect.getDuration();

        if (duration > 0 && (duration + 1) % intervalTicks == 0) {
            sortInventoryByName(player);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
