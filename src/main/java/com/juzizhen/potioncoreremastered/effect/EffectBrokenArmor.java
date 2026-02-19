package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectBrokenArmor extends StatusEffect {
    private static final String MODIFIER_UUID = "2178c877-9b2f-487a-a973-81744b5fbdc4";

    public EffectBrokenArmor() {
        super(StatusEffectCategory.HARMFUL, 0x9C7B76);
        this.addAttributeModifier(
                EntityAttributes.GENERIC_ARMOR,
                MODIFIER_UUID,
                -2.5,
                EntityAttributeModifier.Operation.ADDITION
        );
    }
}