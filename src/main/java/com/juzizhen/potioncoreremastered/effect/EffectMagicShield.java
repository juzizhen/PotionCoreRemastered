package com.juzizhen.potioncoreremastered.effect;

import com.juzizhen.potioncoreremastered.attribute.ModAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import java.util.UUID;

public class EffectMagicShield extends StatusEffect {
    public static String MagicShieldUUID = "8590f955-e602-4b16-aa1e-619b84e8473b";
    public static boolean isOverlay = false;

    public EffectMagicShield() {
        super(StatusEffectCategory.BENEFICIAL, 16729770);
    }

    public static void setAttribute(EntityAttributeInstance attributes, double value,
                                    EntityAttributeModifier.Operation operation) {
        EntityAttributeModifier modifier = new EntityAttributeModifier(
                UUID.fromString(MagicShieldUUID),
                "magic_shield_bonus",
                value,
                operation
        );
        attributes.addPersistentModifier(modifier);
    }

    public static void clearAttribute(EntityAttributeInstance attributes) {
        attributes.clearModifiers();
        attributes.setBaseValue(0);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (!isOverlay) {
            EntityAttributeInstance attr = entity.getAttributeInstance(ModAttributes.MAGIC_SHIELD);
            if (attr != null) {
                clearAttribute(attr);
            }
        }
        isOverlay = false;
    }
}