package com.juzizhen.potioncoreremastered.damagetypes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDamageTypes {

    public static final RegistryKey<DamageType> COUNTERATTACK =
            RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("potioncoreremastered", "counterattack"));

    public static DamageSource counterattack(World world, Entity source, Entity attacker) {
        return new DamageSource(
                world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(COUNTERATTACK),
                source,
                attacker
        );
    }
}

