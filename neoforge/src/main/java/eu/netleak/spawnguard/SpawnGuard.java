package eu.netleak.spawnguard;

import eu.netleak.spawnguard.config.SpawnGuardConfig;
import eu.netleak.spawnguard.effect.ModEffects;
import eu.netleak.spawnguard.potion.ModPotions;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(Constants.MOD_ID)
public class SpawnGuard {
    
    public SpawnGuard(IEventBus modEventBus, ModContainer container) {
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        container.registerConfig(ModConfig.Type.COMMON, SpawnGuardConfig.CONFIG_SPEC);

        CommonClass.init();
    }
}