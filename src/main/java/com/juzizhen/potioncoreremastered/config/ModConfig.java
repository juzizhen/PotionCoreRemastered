package com.juzizhen.potioncoreremastered.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "potioncoreremastered")
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    public boolean PotionSicknessEnabled = false;


    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 0, max = Integer.MAX_VALUE)
    public String PotionSicknessBadEffectChance = "1000";


    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 0, max = Integer.MAX_VALUE)
    public String PotionSicknessThreshold = "8";
}