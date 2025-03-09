package eu.netleak.spawnguard.potion;

import eu.netleak.spawnguard.Constants;
import eu.netleak.spawnguard.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, Constants.MOD_ID);

    public static final RegistryObject<Potion> MOB_ATTACK_PROTECTION_POTION
            = POTIONS.register("mob_attack_protection",
            () -> new Potion(new MobEffectInstance(ModEffects.MOB_ATTACK_PROTECTION_EFFECT.getHolder().get(), 3600, 0)));

    public static final RegistryObject<Potion> LONG_MOB_ATTACK_PROTECTION_POTION
            = POTIONS.register("long_mob_attack_protection",
            () -> new Potion(new MobEffectInstance(ModEffects.MOB_ATTACK_PROTECTION_EFFECT.getHolder().get(), 9600, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

}
