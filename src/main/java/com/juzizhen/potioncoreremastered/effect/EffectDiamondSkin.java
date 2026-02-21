package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectDiamondSkin extends StatusEffect {
    private static final String MODIFIER_UUID = "0d5f4768-cdb8-4517-b4db-b821006a476f";

    public EffectDiamondSkin() {
        super(StatusEffectCategory.BENEFICIAL, 2873584);
        this.addAttributeModifier(
                EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                MODIFIER_UUID,
                4,
                EntityAttributeModifier.Operation.ADDITION
        );
    }
}
