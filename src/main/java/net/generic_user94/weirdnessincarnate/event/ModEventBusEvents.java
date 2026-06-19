package net.generic_user94.weirdnessincarnate.event;

import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.generic_user94.weirdnessincarnate.entity.ModEntities;
import net.generic_user94.weirdnessincarnate.entity.brat.BratEntity;
import net.generic_user94.weirdnessincarnate.entity.brat.BratModel;
import net.generic_user94.weirdnessincarnate.entity.brat.BratRenderer;
import net.generic_user94.weirdnessincarnate.entity.gecko.GeckoModel;
import net.generic_user94.weirdnessincarnate.entity.gecko.GeckoEntity;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = WeirdnessIncarnate.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {




    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){

        event.registerLayerDefinition(GeckoModel.LAYER_LOCATION, GeckoModel::createBodyLayer);
        event.registerLayerDefinition(BratModel.LAYER_LOCATION, BratModel::createBodyLayer);

    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){

        event.put(ModEntities.GECKO.get(), GeckoEntity.createAttributes().build());

    }




    @SubscribeEvent // on the mod event bus only on the physical client
    @OnlyIn(Dist.CLIENT)
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(ModClientEvents.FLIGHT_DOWN.get());
        event.register(ModClientEvents.FLIGHT_UP.get());
    }


}
