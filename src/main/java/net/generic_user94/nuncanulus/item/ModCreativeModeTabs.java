package net.generic_user94.nuncanulus.item;

import net.generic_user94.nuncanulus.NuncAnulus;
import net.generic_user94.nuncanulus.block.ModBlocks;
import net.minecraft.client.Minecraft;
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

                    }).build());


    public static final Supplier<CreativeModeTab> ANULITE_BLOCKS_TAB = CREATIVE_MODE_TAB.register("anulite_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.ANULITE_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NuncAnulus.MOD_ID, "anulite_items_tab"))
                    .title(Component.translatable("creativetab.nuncanulus.anulite_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.ANULITE_BLOCK);
                        output.accept(ModBlocks.RAW_ANULITE_BLOCK);
                        output.accept(ModBlocks.ANULITE_ORE);

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
