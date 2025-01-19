package eu.netleak.safespawn.event;

import eu.netleak.safespawn.SafeSpawn;
import eu.netleak.safespawn.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SafeSpawn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void onSpawn(EntityJoinLevelEvent event) {
        if (!event.getLevel().isClientSide && event.getEntity() instanceof Player
                && !event.getEntity().getPersistentData().getBoolean("GivenMobAttackProtectionEffect")) {
            event.getEntity().getPersistentData().putBoolean("GivenMobAttackProtectionEffect", true);
            ((Player) event.getEntity()).addEffect(new MobEffectInstance(ModEffects.MOB_ATTACK_PROTECTION_EFFECT.get(), 6000, 0, false, false, true));
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
        if (event.getEntity() instanceof Mob mob
                && event.getNewTarget() instanceof Player player
                && player.hasEffect(ModEffects.MOB_ATTACK_PROTECTION_EFFECT.get())) {
            mob.setTarget(null);
        }
    }

}
