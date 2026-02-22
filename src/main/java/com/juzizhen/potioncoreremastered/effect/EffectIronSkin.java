package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectIronSkin extends StatusEffect {
    private static final String MODIFIER_UUID = "66dd2e4a-c29b-48c1-bc2c-0cc2f742bd2b";

    public EffectIronSkin() {
        super(StatusEffectCategory.BENEFICIAL, 13092807);
        this.addAttributeModifier(
                EntityAttributes.GENERIC_ARMOR,
                MODIFIER_UUID,
                2,
                EntityAttributeModifier.Operation.ADDITION
        );
    }
}