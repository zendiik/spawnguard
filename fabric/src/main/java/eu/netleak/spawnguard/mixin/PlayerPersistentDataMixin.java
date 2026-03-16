package eu.netleak.spawnguard.mixin;

import eu.netleak.spawnguard.data.PlayerPersistentData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerPersistentDataMixin implements PlayerPersistentData {
    @Unique
    private static final String NBT_KEY_MOB_ATTACK_PROTECTION = "GivenMobAttackProtectionEffect";

    @Unique
    private boolean givenMobAttackProtectionEffect = false;

    @Inject(method = "addAdditionalSaveData", at = @At("HEAD"))
    private void onAddAdditionalSaveData(ValueOutput output, CallbackInfo ci) {
        output.putBoolean(NBT_KEY_MOB_ATTACK_PROTECTION, givenMobAttackProtectionEffect);
    }

    @Inject(method = "readAdditionalSaveData", at = @At("HEAD"))
    private void onReadAdditionalSaveData(ValueInput input, CallbackInfo info) {
        givenMobAttackProtectionEffect = input.getBooleanOr(NBT_KEY_MOB_ATTACK_PROTECTION, false);
    }

    @Override
    public boolean spawnGuard$hasGivenMobAttackProtectionEffect() {
        return givenMobAttackProtectionEffect;
    }

    @Override
    public void spawnGuard$setGivenMobAttackProtectionEffect(boolean givenMobAttackProtectionEffect) {
        this.givenMobAttackProtectionEffect = givenMobAttackProtectionEffect;
    }
}
