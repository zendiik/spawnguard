package eu.netleak.spawnguard.mixin;

import eu.netleak.spawnguard.data.PlayerPersistentData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerPersistentDataMixin implements PlayerPersistentData {

    @Unique
    private boolean givenMobAttackProtectionEffect = false;

    @Inject(method = "addAdditionalSaveData", at = @At("HEAD"))
    private void onAddAdditionalSaveData(CompoundTag nbt, CallbackInfo ci) {
        nbt.putBoolean("GivenMobAttackProtectionEffect", givenMobAttackProtectionEffect);
    }

    @Inject(method = "readAdditionalSaveData", at = @At("HEAD"))
    private void onReadAdditionalSaveData(CompoundTag nbt, CallbackInfo info) {
        if (nbt.contains("GivenMobAttackProtectionEffect")) {
            givenMobAttackProtectionEffect = nbt.getBoolean("GivenMobAttackProtectionEffect");
        }
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
