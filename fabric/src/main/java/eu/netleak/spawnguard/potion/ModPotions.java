package eu.netleak.spawnguard.potion;

import eu.netleak.spawnguard.Constants;
import eu.netleak.spawnguard.effect.ModEffects;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

public class ModPotions {

    public static final Potion MOB_ATTACK_PROTECTION_POTION
            = new Potion(new MobEffectInstance(ModEffects.MOB_ATTACK_PROTECTION_EFFECT, 3600, 0));

    public static final Potion LONG_MOB_ATTACK_PROTECTION_POTION
            = new Potion(new MobEffectInstance(ModEffects.MOB_ATTACK_PROTECTION_EFFECT, 9600, 0));

    public static void register() {
        Registry.register(
                BuiltInRegistries.POTION,
                new ResourceLocation(Constants.MOD_ID, "mob_attack_protection"),
                MOB_ATTACK_PROTECTION_POTION
        );

        Registry.register(
                BuiltInRegistries.POTION,
                new ResourceLocation(Constants.MOD_ID, "long_mob_attack_protection"),
                LONG_MOB_ATTACK_PROTECTION_POTION
        );
    }

}
