package eu.netleak.spawnguard.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "spawnguard")
public class SpawnGuardConfigModel implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public boolean enableSpawnGuard = true;

    @ConfigEntry.Gui.Tooltip
    public int mobAttackProtectionDuration = 6000;

}
