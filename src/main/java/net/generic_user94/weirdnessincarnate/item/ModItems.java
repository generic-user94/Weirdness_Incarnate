package net.generic_user94.weirdnessincarnate.item;

import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.generic_user94.weirdnessincarnate.entity.ModEntities;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WeirdnessIncarnate.MOD_ID);


    public static final DeferredItem<Item> ANULITE = ITEMS.register("anulite",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ANULITE = ITEMS.register("raw_anulite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BURGER = ITEMS.register("burger",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BURGER)));

    public static final DeferredItem<Item> SLIME_BUCKET = ITEMS.register("slime_bucket",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SLIME)));

    public static final DeferredItem<Item> GECKO_SPAWN_EGG = ITEMS.register("gecko_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.GECKO, 0x31afaf, 0xffac00,
                    new Item.Properties()));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }
}
