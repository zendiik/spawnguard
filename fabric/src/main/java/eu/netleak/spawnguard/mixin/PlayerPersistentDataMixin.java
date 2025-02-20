package eu.netleak.spawnguard.mixin;

import eu.netleak.spawnguard.data.PlayerPersistentData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerPersistentDataMixin implements PlayerPersistentData {

    private boolean givenMobAttackProtectionEffect = false;

    @Inject(method = "addAdditionalSaveData", at = @At("HEAD"))
    private void onAddAdditionalSaveData(CompoundTag tag, CallbackInfo info) {
        tag.putBoolean("GivenMobAttackProtectionEffect", givenMobAttackProtectionEffect);
    }

    @Inject(method = "readAdditionalSaveData", at = @At("HEAD"))
    private void onReadAdditionalSaveData(CompoundTag tag, CallbackInfo info) {
        if (tag.contains("GivenMobAttackProtectionEffect")) {
            givenMobAttackProtectionEffect = tag.getBoolean("GivenMobAttackProtectionEffect");
        }
    }

    @Override
    public boolean hasGivenMobAttackProtectionEffect() {
        return givenMobAttackProtectionEffect;
    }

    @Override
    public void setGivenMobAttackProtectionEffect(boolean givenMobAttackProtectionEffect) {
        this.givenMobAttackProtectionEffect = givenMobAttackProtectionEffect;
    }

}
