package net.generic_user94.weirdnessincarnate.item;

import net.generic_user94.weirdnessincarnate.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier ANULITE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_ANULITE_TOOL,
            1400, 4f, 5f, 30, () -> Ingredient.of(ModItems.ANULITE));
}
