package net.generic_user94.weirdnessincarnate.event;

import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.generic_user94.weirdnessincarnate.entity.ModEntities;
import net.generic_user94.weirdnessincarnate.entity.gecko.GeckoEntity;
import net.generic_user94.weirdnessincarnate.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber(modid = WeirdnessIncarnate.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent.Pre event) {


        if(event.getEntity() instanceof Cow cow && event.getSource().getDirectEntity() instanceof Player player) {
            if(player.getMainHandItem().getItem() == ModItems.BURGER.get()) {
                if(player instanceof ServerPlayer) {

                    Entity gecko = new GeckoEntity(ModEntities.GECKO.get(), event.getEntity().level());
                    gecko.moveTo(Vec3.atLowerCornerOf(cow.getOnPos()));
                    event.getEntity().level().addFreshEntity(gecko);

                }
            }
        }
    }

    @SubscribeEvent
    public static void breakBlock(BlockEvent.BreakEvent event){

        if ((event.getState().is(Blocks.DIRT) || event.getState().is(Blocks.GRASS_BLOCK)) && event.getPlayer() instanceof ServerPlayer){
            if(event.getPlayer().getMainHandItem().getItem() == Items.RED_MUSHROOM){
                if (event.getPlayer() instanceof ServerPlayer){

                    Entity mooshroom = new MushroomCow(EntityType.MOOSHROOM, event.getPlayer().level());
                    mooshroom.moveTo(Vec3.upFromBottomCenterOf(event.getPos(), 1F));
                    event.getPlayer().level().addFreshEntity(mooshroom);

                    event.getPlayer().getMainHandItem().shrink(1);

                }
            }
        }

    }

}
