package net.generic_user94.weirdnessincarnate.item.custom;

import net.generic_user94.weirdnessincarnate.entity.ModEntities;
import net.generic_user94.weirdnessincarnate.entity.brat.BratEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class BratItem extends Item {

    public BratItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos().above();

        Entity brat = new BratEntity(ModEntities.BRAT.get(), level);
        brat.moveTo(Vec3.atLowerCornerOf(pos));
        level.addFreshEntity(brat);

        context.getPlayer().getMainHandItem().shrink(1);

        return InteractionResult.SUCCESS;
    }
}
