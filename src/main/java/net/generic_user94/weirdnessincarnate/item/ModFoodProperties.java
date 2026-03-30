package net.generic_user94.weirdnessincarnate.item;

import net.generic_user94.weirdnessincarnate.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties BURGER = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.WIND_CHARGED, 20), 0.9999999f)
            .build();

    public static final FoodProperties SLIME = new FoodProperties.Builder()
            .nutrition(0)
            .saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 200), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 4000), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 1f)
            .effect(() -> new MobEffectInstance(ModEffects.SLIMEY_EFFECT, 4000), 1f)
            .build();

}
