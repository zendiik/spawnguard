package eu.netleak.spawnguard.mixin;

import eu.netleak.spawnguard.effect.ModEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mob.class)
public class MobMixin {

    @Inject(method = "setTarget", at = @At("HEAD"), cancellable = true)
    public void onSetTarget(LivingEntity target, CallbackInfo ci) {
        if (((Mob) (Object) this) instanceof Monster && target instanceof Player player && player.hasEffect(ModEffects.MOB_ATTACK_PROTECTION_EFFECT)) {
            ci.cancel();
        }
    }

}
