package net.generic_user94.nuncanulus.event;

import net.generic_user94.nuncanulus.NuncAnulus;
import net.generic_user94.nuncanulus.entity.ModEntities;
import net.generic_user94.nuncanulus.entity.gecko.GeckoModel;
import net.generic_user94.nuncanulus.entity.gecko.GeckoEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = NuncAnulus.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {


    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(GeckoModel.LAYER_LOCATION, GeckoModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.GECKO.get(), GeckoEntity.createAttributes().build());
    }

}
