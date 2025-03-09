package eu.netleak.spawnguard.event;

import eu.netleak.spawnguard.Constants;
import eu.netleak.spawnguard.config.SpawnGuardConfig;
import eu.netleak.spawnguard.effect.ModEffects;
import eu.netleak.spawnguard.potion.ModPotions;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    @SubscribeEvent
    public static void onSpawn(EntityJoinLevelEvent event) {
        if (SpawnGuardConfig.CONFIG.enableSpawnGuard.get() && !event.getLevel().isClientSide
                && event.getEntity() instanceof Player player
                && !player.getPersistentData().getBoolean("GivenMobAttackProtectionEffect")) {
            player.getPersistentData().putBoolean("GivenMobAttackProtectionEffect", true);
            player.addEffect(new MobEffectInstance(
                    ModEffects.MOB_ATTACK_PROTECTION_EFFECT,
                    SpawnGuardConfig.CONFIG.mobAttackProtectionDuration.get(),
                    0, false, false, true
            ));
        }
    }

    @SubscribeEvent
    public static void onAttack(LivingDamageEvent.Pre event) {
        if (event.getEntity() instanceof Player player
                && player.hasEffect(ModEffects.MOB_ATTACK_PROTECTION_EFFECT)
                && (event.getSource().getEntity() instanceof Mob
                || event.getSource() == player.damageSources().magic()
                || event.getSource() == player.damageSources().wither())) {
            event.setNewDamage(0);
        }
    }

    @SubscribeEvent
    public static void onTargetSet(LivingChangeTargetEvent event) {
        if (event.getEntity() instanceof Monster monster
                && event.getNewAboutToBeSetTarget() instanceof Player player
                && player.hasEffect(ModEffects.MOB_ATTACK_PROTECTION_EFFECT)) {
            monster.setTarget(null);
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.WEAKNESS, Items.BLAZE_POWDER, ModPotions.MOB_ATTACK_PROTECTION_POTION);
        builder.addMix(ModPotions.MOB_ATTACK_PROTECTION_POTION, Items.REDSTONE, ModPotions.LONG_MOB_ATTACK_PROTECTION_POTION);
    }

}
