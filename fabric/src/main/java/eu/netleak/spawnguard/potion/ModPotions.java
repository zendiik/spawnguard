package eu.netleak.spawnguard.potion;

import eu.netleak.spawnguard.Constants;
import eu.netleak.spawnguard.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

public class ModPotions {

    public static final Holder<Potion> MOB_ATTACK_PROTECTION_POTION
            = registerPotion("mob_attack_protection", new Potion("mob_attack_protection", new MobEffectInstance(ModEffects.MOB_ATTACK_PROTECTION_EFFECT, 3600, 0)));

    public static final Holder<Potion> LONG_MOB_ATTACK_PROTECTION_POTION
            = registerPotion("long_mob_attack_protection", new Potion("long_mob_attack_protection", new MobEffectInstance(ModEffects.MOB_ATTACK_PROTECTION_EFFECT, 9600, 0)));

    private static Holder<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name), potion);
    }

    public static void register() {
        Constants.LOG.info("Registering potions");
    }

}
