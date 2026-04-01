package net.generic_user94.weirdnessincarnate.datagen;

import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.generic_user94.weirdnessincarnate.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, WeirdnessIncarnate.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.ANULITE_BLOCK);
        blockWithItem(ModBlocks.ANULITE_ORE);

        stairsBlock(ModBlocks.ANULITE_STAIR.get(), blockTexture(ModBlocks.ANULITE_BLOCK.get()));
        blockItem(ModBlocks.ANULITE_STAIR);
        slabBlock(ModBlocks.ANULITE_SLAB.get(), blockTexture(ModBlocks.ANULITE_BLOCK.get()), blockTexture(ModBlocks.ANULITE_BLOCK.get()));
        blockItem(ModBlocks.ANULITE_SLAB);

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("weirdnessincarnate:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("weirdnessincarnate:block/" + deferredBlock.getId().getPath() + appendix));
    }

}
