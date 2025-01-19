package eu.netleak.spawnguard.event;

import eu.netleak.spawnguard.SpawnGuard;
import eu.netleak.spawnguard.config.SpawnGuardConfig;
import eu.netleak.spawnguard.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SpawnGuard.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void onSpawn(EntityJoinLevelEvent event) {
        ForgeConfigSpec.BooleanValue enableSpawnGuard = SpawnGuardConfig.ENABLE_SPAWN_GUARD;
        ForgeConfigSpec.IntValue mobAttackProtectionDuration = SpawnGuardConfig.MOB_ATTACK_PROTECTION_DURATION;

        if (enableSpawnGuard.get() &&
                !event.getLevel().isClientSide && event.getEntity() instanceof Player
                && !event.getEntity().getPersistentData().getBoolean("GivenMobAttackProtectionEffect")) {
            event.getEntity().getPersistentData().putBoolean("GivenMobAttackProtectionEffect", true);
            ((Player) event.getEntity()).addEffect(new MobEffectInstance(
                    ModEffects.MOB_ATTACK_PROTECTION_EFFECT.get(),
                    mobAttackProtectionDuration.get(),
                    0,
                    false,
                    false,
                    true
            ));
        }
    }

    @SubscribeEvent
    public static void onAttack(LivingAttackEvent event) {
        if (event.getEntity() instanceof Player player
                && player.hasEffect(ModEffects.MOB_ATTACK_PROTECTION_EFFECT.get())
                && (event.getSource().getEntity() instanceof Mob
                || event.getSource() == player.damageSources().magic()
                || event.getSource() == player.damageSources().wither())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onTargetSet(LivingChangeTargetEvent event) {
        LivingEntity entity = event.getEntity();

        if (entity instanceof Monster && event.getNewTarget() instanceof LivingEntity) {
            LivingEntity target = event.getNewTarget();

            if (target instanceof Player player && player.hasEffect(ModEffects.MOB_ATTACK_PROTECTION_EFFECT.get())) {
                ((Monster) entity).setTarget(null);
                event.setCanceled(true);
            }
        }
    }

}
