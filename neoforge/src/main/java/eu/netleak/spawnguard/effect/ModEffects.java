package eu.netleak.spawnguard.effect;

import eu.netleak.spawnguard.Constants;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {

    public static final net.neoforged.neoforge.registries.DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, Constants.MOD_ID);

    public static final Holder<MobEffect> MOB_ATTACK_PROTECTION_EFFECT = MOB_EFFECTS.register("mob_attack_protection",
            () -> new MobAttackProtectionEffect(MobEffectCategory.BENEFICIAL, 0x98D98C));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }

}
