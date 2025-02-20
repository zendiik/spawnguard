package eu.netleak.spawnguard.effect;

import eu.netleak.spawnguard.Constants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ModEffects {

    public static final MobEffect MOB_ATTACK_PROTECTION_EFFECT = new MobAttackProtectionEffect(MobEffectCategory.BENEFICIAL, 0x98D98C);

    public static void register() {
        Registry.register(BuiltInRegistries.MOB_EFFECT, new ResourceLocation(Constants.MOD_ID, "mob_attack_protection"), MOB_ATTACK_PROTECTION_EFFECT);
    }

}
