package eu.netleak.spawnguard.event;

import eu.netleak.spawnguard.SpawnGuard;
import eu.netleak.spawnguard.config.SpawnGuardConfig;
import eu.netleak.spawnguard.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SpawnGuard.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void onSpawn(EntityJoinLevelEvent event) {
        if (SpawnGuardConfig.ENABLE_SPAWN_GUARD.get() && !event.getLevel().isClientSide
                && event.getEntity() instanceof Player player
                && !player.getPersistentData().getBoolean("GivenMobAttackProtectionEffect")) {
            player.getPersistentData().putBoolean("GivenMobAttackProtectionEffect", true);
            player.addEffect(new MobEffectInstance(
                    ModEffects.MOB_ATTACK_PROTECTION_EFFECT.get(),
                    SpawnGuardConfig.MOB_ATTACK_PROTECTION_DURATION.get(),
                    0, false, false, true
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
        if (event.getEntity() instanceof Monster monster
                && event.getNewTarget() instanceof Player player
                && player.hasEffect(ModEffects.MOB_ATTACK_PROTECTION_EFFECT.get())) {
            monster.setTarget(null);
            event.setCanceled(true);
        }
    }

}
