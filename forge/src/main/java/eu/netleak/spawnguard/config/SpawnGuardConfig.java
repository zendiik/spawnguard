package eu.netleak.spawnguard.config;

import eu.netleak.spawnguard.Constants;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpawnGuardConfig {

    public static final ForgeConfigSpec COMMON_CONFIG;
    public static final ForgeConfigSpec.BooleanValue ENABLE_SPAWN_GUARD;
    public static final ForgeConfigSpec.IntValue MOB_ATTACK_PROTECTION_DURATION;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        ENABLE_SPAWN_GUARD = builder
                .comment("Enable the spawn guard effect")
                .define("enableSpawnGuard", true);

        MOB_ATTACK_PROTECTION_DURATION = builder
                .comment("Duration of the mob attack protection effect in ticks applied to players when they join the world for the first time")
                .defineInRange("mobAttackProtectionDuration", 6000, 600, Integer.MAX_VALUE);

        COMMON_CONFIG = builder.build();
    }

}
