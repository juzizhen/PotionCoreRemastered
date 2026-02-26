package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import java.util.UUID;

public class EffectDepletion extends StatusEffect {
    private static final UUID MODIFIER_UUID = UUID.fromString("e47ec319-b594-4d12-af55-d97f0b55d5c0");

    public EffectDepletion() {
        super(StatusEffectCategory.HARMFUL, 0x8B0000);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        double amount = -4.0 * (amplifier + 1);

        EntityAttributeInstance attr = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (attr != null) {
            attr.removeModifier(MODIFIER_UUID);
            attr.addPersistentModifier(new EntityAttributeModifier(
                    MODIFIER_UUID,
                    "effect_depletion",
                    amount,
                    EntityAttributeModifier.Operation.ADDITION
            ));
        }
        entity.setHealth(entity.getHealth());
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        EntityAttributeInstance attr = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (attr != null) {
            attr.removeModifier(MODIFIER_UUID);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return false;
    }
}
