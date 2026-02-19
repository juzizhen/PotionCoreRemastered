package com.juzizhen.potioncoreremastered.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

/**
 * 镜像效果：反转玩家的所有操作
 */
public class EffectMirror extends StatusEffect {
    public EffectMirror() {
        super(StatusEffectCategory.HARMFUL, 10027263);
    }
}

