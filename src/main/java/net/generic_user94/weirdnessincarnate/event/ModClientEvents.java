package net.generic_user94.weirdnessincarnate.event;

import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;
import net.neoforged.neoforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = WeirdnessIncarnate.MOD_ID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class ModClientEvents {

    public static final Lazy<KeyMapping> FLIGHT_UP = Lazy.of(() -> new KeyMapping("key.weirdnessincarnate.flight_up", GLFW.GLFW_KEY_G, "key.misc.weirdnessincarnate"));
    public static final Lazy<KeyMapping> FLIGHT_DOWN = Lazy.of(() -> new KeyMapping("key.weirdnessincarnate.flight_down", GLFW.GLFW_KEY_V, "key.misc.weirdnessincarnate"));

    @SubscribeEvent
    public static float ComputeFovModifierEvent(ComputeFovModifierEvent event){
        return 0F;
    }


}
