package eu.netleak.spawnguard;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import eu.netleak.spawnguard.config.SpawnGuardConfigModel;
import eu.netleak.spawnguard.effect.ModEffects;
import eu.netleak.spawnguard.event.ModEntityEvents;
import eu.netleak.spawnguard.potion.ModPotions;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;

public class SpawnGuard implements ModInitializer, ModMenuApi {

    public static SpawnGuardConfigModel CONFIG;

    @Override
    public void onInitialize() {
        AutoConfig.register(SpawnGuardConfigModel.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(SpawnGuardConfigModel.class).getConfig();

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

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(SpawnGuardConfigModel.class, parent).get();
    }
}
