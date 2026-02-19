package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectVulnerable extends StatusEffect {
    public EffectVulnerable() {
        super(StatusEffectCategory.HARMFUL, 0xFF5555); // 红色效果颜色，表示危险
    }
}