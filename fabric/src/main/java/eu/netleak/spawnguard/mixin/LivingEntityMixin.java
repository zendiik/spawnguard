package eu.netleak.spawnguard.mixin;

import eu.netleak.spawnguard.effect.ModEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    public void onHurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;

        if (self instanceof Player player && player.hasEffect(ModEffects.MOB_ATTACK_PROTECTION_EFFECT)) {
            if (source.getEntity() instanceof Mob ||
                    source == player.damageSources().magic() ||
                    source == player.damageSources().wither()) {
                cir.setReturnValue(false);
            }
        }
    }

}
