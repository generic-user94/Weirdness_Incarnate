package net.generic_user94.weirdnessincarnate.util;


import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.Bootstrap;
import net.minecraft.world.damagesource.DamageType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModDamageTypes {

    public static final ResourceKey<DamageType> ROADKILL =
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(
                    WeirdnessIncarnate.MOD_ID, "roadkill"
            ));

    public static void bootstrap(BootstrapContext<DamageType> context) {

        context.register(ROADKILL, new DamageType("death.roadkill", 0.1f));

    }
}