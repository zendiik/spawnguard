package eu.netleak.spawnguard.event;

import eu.netleak.spawnguard.potion.ModPotions;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.Nonnull;
import java.util.Arrays;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PotionRecipeEvents {

    @SubscribeEvent
    public static void register(FMLCommonSetupEvent event) {
        ItemStack weakness = createPotion(Potions.WEAKNESS);
        ItemStack mobAttackProtection = createPotion(ModPotions.MOB_ATTACK_PROTECTION_POTION.get());
        ItemStack longMobAttackProtection = createPotion(ModPotions.LONG_MOB_ATTACK_PROTECTION_POTION.get());

        BrewingRecipeRegistry.addRecipe(new WorkingBrewingRecipe(Ingredient.of(weakness), Ingredient.of(Items.BLAZE_POWDER), mobAttackProtection));
        BrewingRecipeRegistry.addRecipe(new WorkingBrewingRecipe(Ingredient.of(mobAttackProtection), Ingredient.of(Items.REDSTONE), longMobAttackProtection));
    }

    private static ItemStack createPotion(Potion potion) {
        return PotionUtils.setPotion(Items.POTION.getDefaultInstance(), potion);
    }


    public static class WorkingBrewingRecipe extends BrewingRecipe {
        Ingredient potionIn;
        Ingredient reagent;
        ItemStack output;

        public WorkingBrewingRecipe(Ingredient potionIn, Ingredient reagent, ItemStack output) {
            super(potionIn, reagent, output);
            this.potionIn = potionIn;
            this.reagent = reagent;
            this.output = output;
        }

        @Override
        public boolean isInput(@Nonnull ItemStack potionIn) {
            ItemStack[] matchingStacks = this.potionIn.getItems();

            if (matchingStacks.length == 0) {
                return potionIn.isEmpty();
            }

            return Arrays.stream(matchingStacks).anyMatch(itemStack -> ItemStack.isSameItemSameTags(itemStack, potionIn));
        }

        @Override
        public boolean isIngredient(@Nonnull ItemStack ingredient) {
            ItemStack[] matchingStacks = this.reagent.getItems();

            if (matchingStacks.length == 0) {
                return ingredient.isEmpty();
            }

            return Arrays.stream(matchingStacks).anyMatch(itemStack -> ItemStack.isSameItemSameTags(itemStack, ingredient));
        }
    }

}
