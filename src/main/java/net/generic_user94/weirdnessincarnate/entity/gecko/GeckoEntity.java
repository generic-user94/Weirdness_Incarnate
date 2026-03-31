package net.generic_user94.weirdnessincarnate.entity.gecko;

import net.generic_user94.weirdnessincarnate.entity.ModEntities;
import net.generic_user94.weirdnessincarnate.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class GeckoEntity extends Animal {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public GeckoEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new FlyingMoveControl(this, 10, true);
        this.navigation = new FlyingPathNavigation(this, level);
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(3333, new PanicGoal(this, 2.0));
        this.goalSelector.addGoal(3332, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(1, new TemptGoal(this, 2, stack -> stack.is(ModItems.BURGER), false));

        this.goalSelector.addGoal(3334, new FollowParentGoal(this, 1.25));

        this.goalSelector.addGoal(3335, new WaterAvoidingRandomFlyingGoal(this, 1.0));
        this.goalSelector.addGoal(3336, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(3337, new RandomLookAroundGoal(this));

    }

    public static AttributeSupplier.Builder createAttributes() {
        return  Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.FLYING_SPEED, 1D)
                .add(Attributes.FOLLOW_RANGE, 2500000D);

    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(ModItems.BURGER.get());
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
        return ModEntities.GECKO.get().create(level);
    }

    @Override
    protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {
        super.checkFallDamage(y, true, state, pos);
    }

    private void setupAnimationStates() {

        if (this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()){
            this.setupAnimationStates();
        }
    }
}
