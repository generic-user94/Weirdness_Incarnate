package net.generic_user94.nuncanulus;

import net.generic_user94.nuncanulus.block.ModBlocks;
import net.generic_user94.nuncanulus.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NuncAnulus.MOD_ID);


    public static final Supplier<CreativeModeTab> ANULITE_ITEMS_TAB = CREATIVE_MODE_TAB.register("anulite_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ANULITE.get()))
                    .title(Component.translatable("creativetab.nuncanulus.anulite_items"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.ANULITE);
                        output.accept(ModItems.RAW_ANULITE);

                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.BURGER);
                        output.accept(ModItems.SLIME_BUCKET);

                        output.accept(ModItems.ANULITE_SWORD);
                        output.accept(ModItems.ANULITE_AXE);
                        output.accept(ModItems.ANULITE_PICKAXE);
                        output.accept(ModItems.ANULITE_SHOVEL);
                        output.accept(ModItems.ANULITE_HOE);

                        output.accept(ModItems.ANULITE_HAMMER);

                        output.accept(ModItems.ANULITE_HELMET);
                        output.accept(ModItems.ANULITE_CHESTPLATE);
                        output.accept(ModItems.ANULITE_LEGGINGS);
                        output.accept(ModItems.ANULITE_BOOTS);

                        output.accept(ModItems.ANULITE_BOW);

                        output.accept(ModItems.GECKO_SPAWN_EGG);

                    }).build());


    public static final Supplier<CreativeModeTab> ANULITE_BLOCKS_TAB = CREATIVE_MODE_TAB.register("anulite_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.ANULITE_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NuncAnulus.MOD_ID, "anulite_items_tab"))
                    .title(Component.translatable("creativetab.nuncanulus.anulite_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.ANULITE_BLOCK);
                        output.accept(ModBlocks.ANULITE_ORE);

                        output.accept(ModBlocks.MAGIC_BLOCK);
                        output.accept(ModBlocks.MAGIC_BLOCK_TWO);

                        output.accept(ModBlocks.ANULITE_STAIR);
                        output.accept(ModBlocks.ANULITE_SLAB);

                        output.accept(ModBlocks.ANULITE_PRESSURE_PLATE);
                        output.accept(ModBlocks.ANULITE_BUTTON);

                        output.accept(ModBlocks.ANULITE_DOOR);
                        output.accept(ModBlocks.ANULITE_TRAPDOOR);

                        output.accept(ModBlocks.ANULITE_FENCE);
                        output.accept(ModBlocks.ANULITE_FENCE_GATE);
                        output.accept(ModBlocks.ANULITE_WALL);

                        output.accept(ModBlocks.ANULITE_LAMP);

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
