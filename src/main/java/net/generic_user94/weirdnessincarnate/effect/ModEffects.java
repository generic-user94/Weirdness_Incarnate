package net.generic_user94.weirdnessincarnate.effect;

import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.generic_user94.weirdnessincarnate.effect.custom.FlightEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, WeirdnessIncarnate.MOD_ID);

    public static final Holder<MobEffect> FLIGHT_EFFECT = MOB_EFFECTS.register("flight",
            () -> new FlightEffect(MobEffectCategory.NEUTRAL, 0x87cefa)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED,
                            ResourceLocation.fromNamespaceAndPath(WeirdnessIncarnate.MOD_ID, "flight"), 5f,
                          AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));






    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }

}
