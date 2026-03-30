package net.generic_user94.weirdnessincarnate.item;

import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.generic_user94.weirdnessincarnate.entity.ModEntities;
import net.generic_user94.weirdnessincarnate.item.custom.ChiselItem;
import net.generic_user94.weirdnessincarnate.item.custom.HammerItem;
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

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(1000)));

    public static final DeferredItem<Item> BURGER = ITEMS.register("burger",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BURGER)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

                    tooltipComponents.add(Component.translatable("tooltip.nuncanulus.burger.tooltip"));

                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> SLIME_BUCKET = ITEMS.register("slime_bucket",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SLIME)));

    public static final DeferredItem<SwordItem> ANULITE_SWORD = ITEMS.register("anulite_sword",
            () -> new SwordItem(ModToolTiers.ANULITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.ANULITE, 5, 3f))));
    public static final DeferredItem<PickaxeItem> ANULITE_PICKAXE = ITEMS.register("anulite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ANULITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ANULITE, 5, 3f))));
    public static final DeferredItem<ShovelItem> ANULITE_SHOVEL = ITEMS.register("anulite_shovel",
            () -> new ShovelItem(ModToolTiers.ANULITE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.ANULITE, 5, 3f))));
    public static final DeferredItem<AxeItem> ANULITE_AXE = ITEMS.register("anulite_axe",
            () -> new AxeItem(ModToolTiers.ANULITE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.ANULITE, 5, 3f))));
    public static final DeferredItem<HoeItem> ANULITE_HOE = ITEMS.register("anulite_hoe",
            () -> new HoeItem(ModToolTiers.ANULITE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.ANULITE, 5, 3f))));

    public static final DeferredItem<HammerItem> ANULITE_HAMMER = ITEMS.register("anulite_hammer",
            () -> new HammerItem(ModToolTiers.ANULITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ANULITE, 7, 1f))));

    public static final DeferredItem<ArmorItem> ANULITE_HELMET = ITEMS.register("anulite_helmet",
            () -> new ArmorItem(ModArmorMaterials.ANULITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> ANULITE_CHESTPLATE = ITEMS.register("anulite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ANULITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> ANULITE_LEGGINGS = ITEMS.register("anulite_leggings",
            () -> new ArmorItem(ModArmorMaterials.ANULITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()
                            .durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> ANULITE_BOOTS = ITEMS.register("anulite_boots",
            () -> new ArmorItem(ModArmorMaterials.ANULITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties()
                            .durability(ArmorItem.Type.BOOTS.getDurability(19))));

    public static final DeferredItem<Item> ANULITE_BOW = ITEMS.register("anulite_bow",
            () -> new BowItem(new Item.Properties().durability(500)));

    public static final DeferredItem<Item> GECKO_SPAWN_EGG = ITEMS.register("gecko_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.GECKO, 0x31afaf, 0xffac00,
                    new Item.Properties()));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }
}
