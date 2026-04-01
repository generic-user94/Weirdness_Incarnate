package net.generic_user94.weirdnessincarnate.event;

import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;

@EventBusSubscriber(modid = WeirdnessIncarnate.MOD_ID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static float ComputeFovModifierEvent(ComputeFovModifierEvent event){
        return 0F;
    }

}
