package com.juzizhen.potioncoreremastered;

import com.juzizhen.potioncoreremastered.effect.ModEffects;
import com.juzizhen.potioncoreremastered.potion.ModPotions;
import com.juzizhen.potioncoreremastered.util.EffectClassifier;
import net.fabricmc.api.ModInitializer;

public class PotionCoreRemastered implements ModInitializer {

	public void onInitialize() {

		ModEffects.registerEffects();
		ModPotions.registerPotions();

		EffectClassifier.initialize();
	}
}
