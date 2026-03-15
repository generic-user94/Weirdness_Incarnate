package net.generic_user94.nuncanulus.datagen;

import net.generic_user94.nuncanulus.NuncAnulus;
import net.generic_user94.nuncanulus.block.ModBlocks;
import net.generic_user94.nuncanulus.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, NuncAnulus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(ModItems.ANULITE.get());
        basicItem(ModItems.RAW_ANULITE.get());

        handheldItem(ModItems.CHISEL.get());
        basicItem(ModItems.BURGER.get());

        buttonItem(ModBlocks.ANULITE_BUTTON, ModBlocks.ANULITE_BLOCK);
        fenceItem(ModBlocks.ANULITE_FENCE, ModBlocks.ANULITE_BLOCK);
        wallItem(ModBlocks.ANULITE_WALL, ModBlocks.ANULITE_BLOCK);

        basicItem(ModBlocks.ANULITE_DOOR.asItem());

        handheldItem(ModItems.ANULITE_SWORD.get());
        handheldItem(ModItems.ANULITE_PICKAXE.get());
        handheldItem(ModItems.ANULITE_AXE.get());
        handheldItem(ModItems.ANULITE_HOE.get());
        handheldItem(ModItems.ANULITE_SHOVEL.get());

        handheldItem(ModItems.ANULITE_HAMMER.get());

    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(NuncAnulus.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(NuncAnulus.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(NuncAnulus.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(NuncAnulus.MOD_ID,"item/" + item.getId().getPath()));
    }
}
