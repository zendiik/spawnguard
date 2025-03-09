package eu.netleak.spawnguard.event;

import eu.netleak.spawnguard.SpawnGuard;
import eu.netleak.spawnguard.data.PlayerPersistentData;
import eu.netleak.spawnguard.effect.ModEffects;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class ModEntityEvents {

    public static void register() {
        ServerEntityEvents.ENTITY_LOAD.register((Entity entity, ServerLevel world) -> {
            if (SpawnGuard.CONFIG.enableSpawnGuard()
                    && entity instanceof Player player
                    && player instanceof PlayerPersistentData persistentData
                    && !persistentData.spawnGuard$hasGivenMobAttackProtectionEffect()) {
                persistentData.spawnGuard$setGivenMobAttackProtectionEffect(true);

                player.addEffect(new MobEffectInstance(
                        ModEffects.MOB_ATTACK_PROTECTION_EFFECT,
                        SpawnGuard.CONFIG.mobAttackProtectionDuration(),
                        0, false, false, true
                ));
            }
        });
    }

}
