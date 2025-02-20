package eu.netleak.spawnguard;

import eu.netleak.spawnguard.config.SpawnGuardConfig;
import eu.netleak.spawnguard.effect.ModEffects;
import eu.netleak.spawnguard.event.ModEntityEvents;
import eu.netleak.spawnguard.potion.ModBrewingRecipes;
import eu.netleak.spawnguard.potion.ModPotions;
import net.fabricmc.api.ModInitializer;

public class SpawnGuard implements ModInitializer {

    public static final SpawnGuardConfig CONFIG = SpawnGuardConfig.createAndLoad();
    
    @Override
    public void onInitialize() {
        ModEffects.register();
        ModEntityEvents.register();
        ModPotions.register();
        ModBrewingRecipes.register();

        CommonClass.init();
    }
}
