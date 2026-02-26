package com.juzizhen.potioncoreremastered.network;

import com.juzizhen.potioncoreremastered.PotionCoreRemastered;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class StepHeightUpdate {
    public static final Identifier STEP_HEIGHT_UPDATE = new Identifier(PotionCoreRemastered.MOD_ID, "step_height_update");

    public static void register() {
        System.out.print(STEP_HEIGHT_UPDATE);
    }

    public static void sendStepHeightUpdate(ServerPlayerEntity player, float height) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeFloat(height);
        ServerPlayNetworking.send(player, STEP_HEIGHT_UPDATE, buf);
    }
}
