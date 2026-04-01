package net.generic_user94.weirdnessincarnate;

import net.generic_user94.weirdnessincarnate.block.ModBlocks;
import net.generic_user94.weirdnessincarnate.item.ModItems;
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
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WeirdnessIncarnate.MOD_ID);


    public static final Supplier<CreativeModeTab> ANULITE_ITEMS_TAB = CREATIVE_MODE_TAB.register("funny_stuff_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ANULITE.get()))
                    .title(Component.translatable("creativetab.weirdnessincarnate.funny_stuff"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.ANULITE);
                        output.accept(ModItems.RAW_ANULITE);

                        output.accept(ModBlocks.ANULITE_BLOCK);
                        output.accept(ModBlocks.ANULITE_ORE);

                        output.accept(ModBlocks.ANULITE_STAIR);
                        output.accept(ModBlocks.ANULITE_SLAB);

                        output.accept(ModItems.BURGER);
                        output.accept(ModItems.SLIME_BUCKET);

                        output.accept(ModItems.GECKO_SPAWN_EGG);

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
