package net.generic_user94.weirdnessincarnate.entity;

import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.generic_user94.weirdnessincarnate.entity.brat.BratEntity;
import net.generic_user94.weirdnessincarnate.entity.gecko.GeckoEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, WeirdnessIncarnate.MOD_ID);


    public static final Supplier<EntityType<GeckoEntity>> GECKO =
            ENTITY_TYPES.register("gecko", () -> EntityType.Builder.of(GeckoEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 0.35f)
                    .build("gecko"));

    public static final Supplier<EntityType<BratEntity>> BRAT =
            ENTITY_TYPES.register("subaru_brat",
                    () -> EntityType.Builder.of(BratEntity::new, MobCategory.MISC)
                            .sized(3f, 2f)
                            .clientTrackingRange(10)
                            .updateInterval(1)
                            .build("subaru_brat"));




    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
