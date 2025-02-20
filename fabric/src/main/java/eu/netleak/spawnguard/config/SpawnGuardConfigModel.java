package eu.netleak.spawnguard.config;

import io.wispforest.owo.config.annotation.Config;

@Config(name = "spawnguard-config", wrapperName = "SpawnGuardConfig")
public class SpawnGuardConfigModel {

    public boolean enableSpawnGuard = true;

    public int mobAttackProtectionDuration = 6000;

}
