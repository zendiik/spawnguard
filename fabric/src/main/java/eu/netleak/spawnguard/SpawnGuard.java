package eu.netleak.spawnguard;

import eu.netleak.spawnguard.config.SpawnGuardConfig;
import eu.netleak.spawnguard.effect.ModEffects;
import eu.netleak.spawnguard.event.ModEntityEvents;
import eu.netleak.spawnguard.potion.ModPotions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;

public class SpawnGuard implements ModInitializer {

    public static final SpawnGuardConfig CONFIG = SpawnGuardConfig.createAndLoad();
    
    @Override
    public void onInitialize() {
        ModEffects.register();
        ModEntityEvents.register();
        ModPotions.register();

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    Potions.WEAKNESS,
                    Ingredient.of(Items.BLAZE_POWDER),
                    ModPotions.MOB_ATTACK_PROTECTION_POTION
            );

            builder.registerPotionRecipe(
                    ModPotions.MOB_ATTACK_PROTECTION_POTION,
                    Ingredient.of(Items.REDSTONE),
                    ModPotions.LONG_MOB_ATTACK_PROTECTION_POTION
            );
        });

        CommonClass.init();
    }
}
