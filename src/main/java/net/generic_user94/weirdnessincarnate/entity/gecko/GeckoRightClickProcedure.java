package net.generic_user94.weirdnessincarnate.entity.gecko;

import net.generic_user94.weirdnessincarnate.item.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class GeckoRightClickProcedure {

    //Credit to @knarfy for the general idea of how this works. SUBSCRIBE TO KNARFY

    public static void pickUpGecko(Entity gecko, Player player){
        if (player instanceof ServerPlayer){
            if (player.getMainHandItem() == ItemStack.EMPTY){

                player.swing(InteractionHand.MAIN_HAND);
                gecko.discard();
                ItemStack itemStack = new ItemStack(ModItems.GECKO_SPAWN_EGG.get());
                itemStack.setCount(1);
                player.setItemInHand(InteractionHand.MAIN_HAND, itemStack);


            }
        }
    }
}
