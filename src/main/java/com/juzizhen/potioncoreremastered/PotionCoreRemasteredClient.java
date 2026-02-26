package com.juzizhen.potioncoreremastered;

import com.juzizhen.potioncoreremastered.network.StepHeightUpdate;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class PotionCoreRemasteredClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(StepHeightUpdate.STEP_HEIGHT_UPDATE, (client, handler, buf, responseSender) -> {
            float newHeight = buf.readFloat();
            client.execute(() -> {
                if (client.player != null) {
                    client.player.setStepHeight(newHeight);
                }
            });
        });
    }
}
