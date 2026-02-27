package com.juzizhen.potioncoreremastered.attribute;

import com.juzizhen.potioncoreremastered.PotionCoreRemastered;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModAttributes {
    public static final EntityAttribute MAGIC_SHIELD = new ClampedEntityAttribute(
            "attribute.name.generic." + PotionCoreRemastered.MOD_ID + '.' + "magic_shield",
            0.0, 0.0, Integer.MAX_VALUE).setTracked(true);

    public static void registerAttribute() {
        Registry.register(Registries.ATTRIBUTE, new Identifier(PotionCoreRemastered.MOD_ID, "magic_shield"), MAGIC_SHIELD);

        FabricDefaultAttributeRegistry.register(EntityType.PLAYER, PlayerEntity.createPlayerAttributes().add(MAGIC_SHIELD).add(ModAttributes.MAGIC_SHIELD, 0));
    }
}