package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import java.util.Objects;
import java.util.UUID;

public class EffectWeight extends StatusEffect {

    private static final UUID WEIGHT_MODIFIER_ID = UUID.fromString("d6ce667a-3175-4782-afd9-101f358ae47b");

    public EffectWeight() {
        super(StatusEffectCategory.HARMFUL, 5592405);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, attributes, amplifier);
        double reduction = -0.05 * (amplifier + 1);

        Objects.requireNonNull(entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED))
                .addPersistentModifier(new EntityAttributeModifier(
                        WEIGHT_MODIFIER_ID,
                        "weight_effect",
                        reduction,
                        EntityAttributeModifier.Operation.MULTIPLY_TOTAL
                ));

    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        Objects.requireNonNull(entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED))
                .removeModifier(WEIGHT_MODIFIER_ID);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return false;
    }
}