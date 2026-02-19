package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectCurse extends StatusEffect {
    private static final String MODIFIER_UUID = "634287c8-8c07-4ead-be17-2ab54df049b0";

     public  EffectCurse(StatusEffectCategory type, int color) {
         super(StatusEffectCategory.HARMFUL, 0x9C7B76);
     }
}
