package com.juzizhen.potioncoreremastered;

import com.juzizhen.potioncoreremastered.attribute.ModAttribute;
import com.juzizhen.potioncoreremastered.config.ModConfig;
import com.juzizhen.potioncoreremastered.effect.ModEffects;
import com.juzizhen.potioncoreremastered.potion.ModPotions;
import com.juzizhen.potioncoreremastered.util.EffectClassifier;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class PotionCoreRemastered implements ModInitializer {
	public static ModConfig CONFIG;

	public void onInitialize() {
		AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new);
		CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

		ModAttribute.registerAttribute();

		ModEffects.registerEffects();
		ModPotions.registerPotions();

		EffectClassifier.initialize();

		ServerTickEvents.END_SERVER_TICK.register(this::onServerTick);
	}

	private void onServerTick(MinecraftServer server) {
		if (!CONFIG.PotionSicknessEnabled) return;

		int threshold = EffectClassifier.safeParseInt(CONFIG.PotionSicknessThreshold, 8);
		for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
			long goodCount = player.getActiveStatusEffects().keySet().stream()
					.filter(EffectClassifier::isBeneficial)
					.count();

			var existing = player.getStatusEffect(ModEffects.POTION_SICKNESS);

			if (goodCount >= threshold) {
				int expectedLevel = (int) (goodCount - threshold);

				if (existing == null) {
					player.addStatusEffect(new StatusEffectInstance(
							ModEffects.POTION_SICKNESS,
							StatusEffectInstance.INFINITE,
							expectedLevel,
							false, false, true
					));
				} else if (existing.getAmplifier() != expectedLevel) {
					player.removeStatusEffect(ModEffects.POTION_SICKNESS);
					player.addStatusEffect(new StatusEffectInstance(
							ModEffects.POTION_SICKNESS,
							StatusEffectInstance.INFINITE,
							expectedLevel,
							false, false, true
					));
				}
			} else {
				if (existing != null) {
					player.removeStatusEffect(ModEffects.POTION_SICKNESS);
				}
			}
		}
	}
}
