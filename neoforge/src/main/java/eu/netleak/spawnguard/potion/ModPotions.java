package eu.netleak.spawnguard.potion;

import eu.netleak.spawnguard.Constants;
import eu.netleak.spawnguard.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(BuiltInRegistries.POTION, Constants.MOD_ID);

    public static final Holder<Potion> MOB_ATTACK_PROTECTION_POTION
            = POTIONS.register("mob_attack_protection",
            () -> new Potion(new MobEffectInstance(ModEffects.MOB_ATTACK_PROTECTION_EFFECT, 3600, 0)));

    public static final Holder<Potion> LONG_MOB_ATTACK_PROTECTION_POTION
            = POTIONS.register("long_mob_attack_protection",
            () -> new Potion(new MobEffectInstance(ModEffects.MOB_ATTACK_PROTECTION_EFFECT, 9600, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

}
