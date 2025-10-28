package eu.netleak.spawnguard.effect;

import eu.netleak.spawnguard.Constants;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModEffects {

    private ModEffects() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Constants.MOD_ID);

    private static final RegistryObject<MobEffect> MOB_ATTACK_PROTECTION_EFFECT_REGISTRY = MOB_EFFECTS.register("mob_attack_protection",
            () -> new MobAttackProtectionEffect(MobEffectCategory.BENEFICIAL, 0x98D98C));

    public static final Supplier<Holder<MobEffect>> MOB_ATTACK_PROTECTION_EFFECT =
            () -> MOB_ATTACK_PROTECTION_EFFECT_REGISTRY.getHolder().orElseThrow();

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }

}
