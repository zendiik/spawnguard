package eu.netleak.spawnguard.event;

import eu.netleak.spawnguard.SpawnGuard;
import eu.netleak.spawnguard.data.PlayerPersistentData;
import eu.netleak.spawnguard.effect.ModEffects;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;

public class ModEntityEvents {

    private ModEntityEvents() {
        throw new UnsupportedOperationException("Utility class");
    }

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

        // Use Fabric API event instead of mixin for damage handling
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
            if (entity instanceof Player player && player.hasEffect(ModEffects.MOB_ATTACK_PROTECTION_EFFECT)) {
                return !(source.getEntity() instanceof Mob) &&
                        source != player.damageSources().magic() &&
                        source != player.damageSources().wither(); // Cancel damage
            }

            return true; // Allow damage
        });
    }

}
