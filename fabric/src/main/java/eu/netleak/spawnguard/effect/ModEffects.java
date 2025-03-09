package eu.netleak.spawnguard.effect;

import eu.netleak.spawnguard.Constants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectCategory;

public class ModEffects {

    public static final Holder<MobEffect> MOB_ATTACK_PROTECTION_EFFECT = registerEffect("mob_attack_protection",
            new MobAttackProtectionEffect(MobEffectCategory.BENEFICIAL, 0x98D98C));

    private static Holder<MobEffect> registerEffect(String name, MobEffect effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name), effect);
    }

    public static void register() {
        Constants.LOG.info("Registering effects");
    }

}
