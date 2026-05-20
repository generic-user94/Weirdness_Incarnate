package net.generic_user94.weirdnessincarnate.effect.custom;

import net.generic_user94.weirdnessincarnate.event.ModClientEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FlightEffect extends MobEffect {

    public FlightEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity player, int amplifier) {

        if (ModClientEvents.FLIGHT_UP.get().isDown()) {

            player.setDeltaMovement(player.getDeltaMovement().x, 1, player.getDeltaMovement().z);
            player.sendSystemMessage(Component.literal("testing UP"));

        } else if (ModClientEvents.FLIGHT_DOWN.get().isDown()) {

            player.setDeltaMovement(player.getDeltaMovement().x, -1, player.getDeltaMovement().z);
            player.sendSystemMessage(Component.literal("testing DOWN"));

        }

        return super.applyEffectTick(player, amplifier);

    }



    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return super.shouldApplyEffectTickThisTick(duration, amplifier);
    }
}
