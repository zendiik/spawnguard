package eu.netleak.spawnguard.potion;

import eu.netleak.spawnguard.Constants;
import eu.netleak.spawnguard.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, Constants.MOD_ID);

    private static final RegistryObject<Potion> MOB_ATTACK_PROTECTION_POTION_REGISTRY
            = POTIONS.register("mob_attack_protection",
            () -> new Potion("mob_attack_protection", new MobEffectInstance(ModEffects.MOB_ATTACK_PROTECTION_EFFECT.get(), 3600, 0)));

    private static final RegistryObject<Potion> LONG_MOB_ATTACK_PROTECTION_POTION_REGISTRY
            = POTIONS.register("long_mob_attack_protection",
            () -> new Potion("long_mob_attack_protection", new MobEffectInstance(ModEffects.MOB_ATTACK_PROTECTION_EFFECT.get(), 9600, 0)));

    public static final Supplier<Holder<Potion>> MOB_ATTACK_PROTECTION_POTION =
            () -> MOB_ATTACK_PROTECTION_POTION_REGISTRY.getHolder().orElseThrow();

    public static final Supplier<Holder<Potion>> LONG_MOB_ATTACK_PROTECTION_POTION =
            () -> LONG_MOB_ATTACK_PROTECTION_POTION_REGISTRY.getHolder().orElseThrow();

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

}
