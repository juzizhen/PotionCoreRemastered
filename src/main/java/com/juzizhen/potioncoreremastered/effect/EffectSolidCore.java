package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectSolidCore extends StatusEffect {
    private static final String MODIFIER_UUID = "e8f5edff-d83d-453b-91aa-98e8830b599f";

    public EffectSolidCore() {
        super(StatusEffectCategory.BENEFICIAL, 2236962);
        this.addAttributeModifier(
                EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
                MODIFIER_UUID,
                1,
                EntityAttributeModifier.Operation.ADDITION
        );
    }
}