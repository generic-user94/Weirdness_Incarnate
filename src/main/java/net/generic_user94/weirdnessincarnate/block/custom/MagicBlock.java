package net.generic_user94.weirdnessincarnate.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;
import java.util.Map;

public class MagicBlock extends Block {

    private static final Map<Item, Item> ITEMS_MAP =
            Map.of(

                    Items.GOLD_INGOT, Items.DIAMOND,
                    Items.DIAMOND, Items.GOLD_INGOT

            );



    public MagicBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hitResult) {

        level.playSound(player, pos, SoundEvents.FOX_SNIFF, SoundSource.BLOCKS, 1, 1f);

        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity){
            if (ITEMS_MAP.containsKey(itemEntity.getItem().getItem())) {
                itemEntity.setItem(new ItemStack(ITEMS_MAP.get(itemEntity.getItem().getItem()), itemEntity.getItem().getCount()));
            }
        }


        super.stepOn(level, pos, state, entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        tooltipComponents.add(Component.translatable("tooltip.nuncanulus.magic_block.tooltip"));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
