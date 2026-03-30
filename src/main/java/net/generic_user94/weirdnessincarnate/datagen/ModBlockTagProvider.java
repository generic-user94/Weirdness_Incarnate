package net.generic_user94.weirdnessincarnate.datagen;

import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.generic_user94.weirdnessincarnate.block.ModBlocks;
import net.generic_user94.weirdnessincarnate.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, WeirdnessIncarnate.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ANULITE_BLOCK.get())
                .add(ModBlocks.ANULITE_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.MAGIC_BLOCK_TWO.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ANULITE_BLOCK.get())
                .add(ModBlocks.ANULITE_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.MAGIC_BLOCK_TWO.get());

        tag(BlockTags.FENCES)
                .add(ModBlocks.ANULITE_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.ANULITE_FENCE_GATE.get());
        tag(BlockTags.WALLS)
                .add(ModBlocks.ANULITE_WALL.get());

        tag(ModTags.Blocks.NEEDS_ANULITE_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_ANULITE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_ANULITE_TOOL);

    }
}
