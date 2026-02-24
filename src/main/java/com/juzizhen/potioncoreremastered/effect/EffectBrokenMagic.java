package com.juzizhen.potioncoreremastered.effect;

import com.juzizhen.potioncoreremastered.attribute.ModAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import org.jetbrains.annotations.Nullable;

public class EffectBrokenMagic extends StatusEffect {

    public EffectBrokenMagic() {
        super(StatusEffectCategory.HARMFUL, 11012960);
    }


    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        EntityAttributeInstance attr = target.getAttributeInstance(ModAttributes.MAGIC_SHIELD);
        if (attr != null) {
            double attrValue = attr.getValue();
            double value = attrValue - (amplifier + 1) * 0.25;
            EffectMagicShield.clearAttribute(attr);
            EffectMagicShield.setAttribute(attr, value, EntityAttributeModifier.Operation.ADDITION);
        }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;
        EntityAttributeInstance attr = entity.getAttributeInstance(ModAttributes.MAGIC_SHIELD);
        if (attr != null) {
            double attrValue = attr.getValue();
            double value = attrValue - (amplifier + 1) * 0.25;
            EffectMagicShield.clearAttribute(attr);
            EffectMagicShield.setAttribute(attr, value, EntityAttributeModifier.Operation.ADDITION);
        }
    }

    @Override
    public boolean isInstant() {
        return true;
    }
}
