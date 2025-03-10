package eu.netleak.spawnguard;

import eu.netleak.spawnguard.config.SpawnGuardConfig;
import eu.netleak.spawnguard.effect.ModEffects;
import eu.netleak.spawnguard.potion.ModPotions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class SpawnGuard {
    
    public SpawnGuard(FMLJavaModLoadingContext modLoadingContext) {
        IEventBus modEventBus = modLoadingContext.getModEventBus();

        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        modLoadingContext.registerConfig(ModConfig.Type.COMMON, SpawnGuardConfig.COMMON_CONFIG);

        MinecraftForge.EVENT_BUS.register(this);

        CommonClass.init();
    }
}