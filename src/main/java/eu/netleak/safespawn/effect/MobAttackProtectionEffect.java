package eu.netleak.safespawn.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class MobAttackProtectionEffect extends MobEffect {
    protected MobAttackProtectionEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        // Do nothing
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }


}
