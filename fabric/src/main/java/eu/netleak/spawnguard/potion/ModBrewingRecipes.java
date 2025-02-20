package eu.netleak.spawnguard.potion;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;

public class ModBrewingRecipes {

    public static void register() {
        PotionBrewing.addMix(
                Potions.WEAKNESS,
                Items.BLAZE_POWDER,
                ModPotions.MOB_ATTACK_PROTECTION_POTION
        );

        PotionBrewing.addMix(
                ModPotions.MOB_ATTACK_PROTECTION_POTION,
                Items.REDSTONE,
                ModPotions.LONG_MOB_ATTACK_PROTECTION_POTION
        );
    }

}
