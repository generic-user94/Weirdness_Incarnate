package net.generic_user94.weirdnessincarnate.item;

import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.generic_user94.weirdnessincarnate.entity.ModEntities;
import net.generic_user94.weirdnessincarnate.sound.ModSounds;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

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

    public static final DeferredItem<ArmorItem> BLUE_GECKO_HELMET = ITEMS.register("blue_gecko_helmet",
            () -> new ArmorItem(ModArmorMaterials.BLUE_GECKO_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(20))));
    public static final DeferredItem<ArmorItem> BLUE_GECKO_CHESTPLATE = ITEMS.register("blue_gecko_chestplate",
            () -> new ArmorItem(ModArmorMaterials.BLUE_GECKO_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(20))));
    public static final DeferredItem<ArmorItem> BLUE_GECKO_LEGGINGS = ITEMS.register("blue_gecko_leggings",
            () -> new ArmorItem(ModArmorMaterials.BLUE_GECKO_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(20))));
    public static final DeferredItem<ArmorItem> BLUE_GECKO_BOOTS = ITEMS.register("blue_gecko_boots",
            () -> new ArmorItem(ModArmorMaterials.BLUE_GECKO_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(20))));

    public static final DeferredItem<Item> CASIN_MUSIC_DISC = ITEMS.register("casin_music_disc",
            () -> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(ModSounds.CASIN_KEY)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }
}
