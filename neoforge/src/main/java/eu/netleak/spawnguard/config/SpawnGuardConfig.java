package eu.netleak.spawnguard.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class SpawnGuardConfig {

    public static final SpawnGuardConfig CONFIG;

    public static final ModConfigSpec CONFIG_SPEC;

    public final ModConfigSpec.ConfigValue<Boolean> enableSpawnGuard;

    public final ModConfigSpec.ConfigValue<Integer> mobAttackProtectionDuration;

    private SpawnGuardConfig(ModConfigSpec.Builder builder) {
        enableSpawnGuard = builder
                .comment("Enable the spawn guard effect")
                .define("enableSpawnGuard", true);

        mobAttackProtectionDuration = builder
                .comment("Duration of the mob attack protection effect in ticks applied to players when they join the world for the first time")
                .defineInRange("mobAttackProtectionDuration", 6000, 600, Integer.MAX_VALUE);
    }

    static {
        Pair<SpawnGuardConfig, ModConfigSpec> pair = new ModConfigSpec.Builder().configure(SpawnGuardConfig::new);

        CONFIG = pair.getLeft();
        CONFIG_SPEC = pair.getRight();
    }

}
