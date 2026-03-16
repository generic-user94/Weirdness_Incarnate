package net.generic_user94.nuncanulus.datagen;

import net.generic_user94.nuncanulus.NuncAnulus;
import net.generic_user94.nuncanulus.item.ModItems;
import net.generic_user94.nuncanulus.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, NuncAnulus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.ANULITE.get())
                .add(Items.STICK)
                .add(Items.COAL);

        tag(ItemTags.SWORDS)
                .add(ModItems.ANULITE_SWORD.get());

        tag(ItemTags.AXES)
                .add(ModItems.ANULITE_AXE.get());

        tag(ItemTags.PICKAXES)
                .add(ModItems.ANULITE_PICKAXE.get());

        tag(ItemTags.SHOVELS)
                .add(ModItems.ANULITE_SHOVEL.get());

        tag(ItemTags.HOES)
                .add(ModItems.ANULITE_HOE.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ANULITE_HELMET.get())
                .add(ModItems.ANULITE_CHESTPLATE.get())
                .add(ModItems.ANULITE_LEGGINGS.get())
                .add(ModItems.ANULITE_BOOTS.get());

    }

}
