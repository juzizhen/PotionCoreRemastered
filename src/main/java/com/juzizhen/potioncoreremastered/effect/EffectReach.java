package com.juzizhen.potioncoreremastered.effect;

import com.juzizhen.potioncoreremastered.attribute.ModAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import java.util.UUID;
import java.util.WeakHashMap;

public class EffectReach extends StatusEffect {
    private static final UUID REACH_MODIFIER_UUID = UUID.fromString("a80847d9-78ba-4db5-b724-aa0a07f8738d");
    private static final UUID ATTACK_RANGE_MODIFIER_UUID = UUID.fromString("a831113a-3ded-4580-9883-a716b9cb8cf8");

    private final WeakHashMap<LivingEntity, Integer> currentAmplifiers = new WeakHashMap<>();

    public EffectReach() {
        super(StatusEffectCategory.BENEFICIAL, 0x33FF33);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        Integer lastAmplifier = currentAmplifiers.get(entity);
        if (lastAmplifier == null || lastAmplifier != amplifier) {
            updateModifiers(entity, amplifier);
            currentAmplifiers.put(entity, amplifier);
        }
    }

    private void updateModifiers(LivingEntity entity, int amplifier) {
        double amount = (amplifier + 1) * 1.0;

        EntityAttributeInstance reachAttr = entity.getAttributeInstance(ModAttributes.REACH);
        if (reachAttr != null) {
            reachAttr.removeModifier(REACH_MODIFIER_UUID);
            EntityAttributeModifier reachModifier = new EntityAttributeModifier(
                    REACH_MODIFIER_UUID,
                    "Reach boost",
                    amount,
                    EntityAttributeModifier.Operation.ADDITION
            );
            reachAttr.addTemporaryModifier(reachModifier);
        }

        EntityAttributeInstance attackRangeAttr = entity.getAttributeInstance(ModAttributes.ATTACK_RANGE);
        if (attackRangeAttr != null) {
            attackRangeAttr.removeModifier(ATTACK_RANGE_MODIFIER_UUID);
            EntityAttributeModifier attackModifier = new EntityAttributeModifier(
                    ATTACK_RANGE_MODIFIER_UUID,
                    "Attack range boost",
                    amount,
                    EntityAttributeModifier.Operation.ADDITION
            );
            attackRangeAttr.addTemporaryModifier(attackModifier);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        EntityAttributeInstance reachAttr = entity.getAttributeInstance(ModAttributes.REACH);
        if (reachAttr != null) {
            reachAttr.removeModifier(REACH_MODIFIER_UUID);
        }

        EntityAttributeInstance attackRangeAttr = entity.getAttributeInstance(ModAttributes.ATTACK_RANGE);
        if (attackRangeAttr != null) {
            attackRangeAttr.removeModifier(ATTACK_RANGE_MODIFIER_UUID);
        }

        currentAmplifiers.remove(entity);
        super.onRemoved(entity, attributes, amplifier);
    }
}