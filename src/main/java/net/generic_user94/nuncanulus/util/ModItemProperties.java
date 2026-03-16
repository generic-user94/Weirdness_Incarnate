package net.generic_user94.nuncanulus.util;

import net.generic_user94.nuncanulus.NuncAnulus;
import net.generic_user94.nuncanulus.component.ModDataComponents;
import net.generic_user94.nuncanulus.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItemProperties {

    public static void addCustomItemProperties() {

        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(NuncAnulus.MOD_ID, "used"),
                (stack, level, entity, seed) ->
                        stack.get(ModDataComponents.COORDINATES) != null ? 1f : 0f);

    }

}
