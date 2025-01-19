package eu.netleak.safespawn.effect;

import eu.netleak.safespawn.SafeSpawn;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SafeSpawn.MOD_ID);

    public static final RegistryObject<MobEffect> MOB_ATTACK_PROTECTION_EFFECT
            = MOB_EFFECTS.register("mob_attack_protection", () -> new MobAttackProtectionEffect(MobEffectCategory.BENEFICIAL, 0x98D98C));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }

}
