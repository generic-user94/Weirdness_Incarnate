package net.generic_user94.weirdnessincarnate.entity.brat;

import net.generic_user94.weirdnessincarnate.item.ModItems;
import net.generic_user94.weirdnessincarnate.util.ModDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BratEntity extends Entity {

    public BratEntity(EntityType<? extends BratEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.hasControllingPassenger()) {
            Player controller = (Player) this.getControllingPassenger();

            float forward = controller.zza;
            float turn = controller.xxa;

            float newYaw = this.getYRot() + turn * -8f;

            this.setYRot(newYaw);
            this.setYHeadRot(newYaw);
            this.setRot(newYaw, this.getXRot());

            if (forward != 0){

                Vec3 forwardVec = Vec3.directionFromRotation(0, this.getYRot());

                Vec3 newMotion = this.getDeltaMovement().add(forwardVec.x * (forward * 0.3f),
                0, forwardVec.z * (forward * 0.3f));

                if (newMotion.horizontalDistance() > 1.5f) {
                    newMotion = newMotion.normalize().scale(1.5);
                }

                this.setDeltaMovement(newMotion);

            }

        }

        this.setDeltaMovement(this.getDeltaMovement().multiply(0.85, 1, 0.85));
        this.setDeltaMovement(this.getDeltaMovement().x,
                this.getDeltaMovement().y-this.getGravity(), this.getDeltaMovement().z);

        if (this.onGround() && this.hasControllingPassenger()) {
            Vec3 motion = this.getDeltaMovement();

            float forward = this.getControllingPassenger().zza;

            if (forward != 0) {

                double yawRad = Math.toRadians(this.getYRot());
                double checkX = this.getX() + (-Math.sin(yawRad) * 3);
                double checkZ = this.getZ() + ( Math.cos(yawRad) * 3);

                BlockPos frontPos = BlockPos.containing(checkX, this.getY(), checkZ);

                boolean frontBlocked = this.level().getBlockState(frontPos).isSolid();

                boolean aboveFree = !this.level().getBlockState(frontPos.above()).isSolid();

                if (frontBlocked && aboveFree) {
                    this.setDeltaMovement(motion.x, 0.42, motion.z);
                } else {
                    this.setDeltaMovement(motion.x, 0, motion.z);
                }
            }
        }

        this.move(MoverType.SELF, this.getDeltaMovement());


        List<Entity> roadkills = checkForEntityHits();

        for (Entity roadkill : roadkills){
            if (!this.getPassengers().contains(roadkill)) {
                Level level = roadkill.level();
                DamageSource damageSource = new DamageSource(level.registryAccess()
                        .registryOrThrow(Registries.DAMAGE_TYPE)
                        .getHolderOrThrow(ModDamageTypes.ROADKILL));
                roadkill.hurt(damageSource, Float.MAX_VALUE);
            }
        }

    }

    public List<Entity> checkForEntityHits() {

        List<Entity> cols = new ArrayList<>();

        if(this.getDeltaMovement().y < 0){
            AABB box = this.getBoundingBox().move(0, -0.05, 0);
            for (Entity entity : this.level().getEntities(this, box)) {
                cols.add(entity);
            }
        }

        if(this.getDeltaMovement().z > 0){
            AABB box = this.getBoundingBox().move(0, 0, -0.05);
            for (Entity entity : this.level().getEntities(this, box)) {
                cols.add(entity);
            }
        }

        if(this.getDeltaMovement().z > 0){
            AABB box = this.getBoundingBox().move(0, 0, 0.05);
            for (Entity entity : this.level().getEntities(this, box)) {
                cols.add(entity);
            }
        }

        if(this.getDeltaMovement().x > 0){
            AABB box = this.getBoundingBox().move(0.05, 0, 0);
            for (Entity entity : this.level().getEntities(this, box)) {
                cols.add(entity);
            }
        }

        if(this.getDeltaMovement().x < 0){
            AABB box = this.getBoundingBox().move(-0.05, 0, 0);
            for (Entity entity : this.level().getEntities(this, box)) {
                cols.add(entity);
            }
        }

        return cols;
    }



    public boolean isCarOnGround() {
        AABB box = this.getBoundingBox().move(0, -0.05, 0);

        return !this.level().getBlockCollisions(this, box).iterator().hasNext();
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    public boolean canRiderInteract() {
        return true;
    }

    @Override
    public boolean mayInteract(Level level, BlockPos pos) {
        return super.mayInteract(level, pos);
    }

    @Override
    protected double getDefaultGravity() {
        return 0.04;
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public @Nullable LivingEntity getControllingPassenger() {
        if (this.getPassengers().isEmpty()) {
            return null;
        }

        Entity first = this.getPassengers().get(0);
        return first instanceof LivingEntity living ? living : null;
    }

    @Override
    public boolean isControlledByLocalInstance() {
        Entity controller = this.getControllingPassenger();
        return controller instanceof Player;
    }

    @Override
    public @Nullable Entity getFirstPassenger() {
        if (!this.getPassengers().isEmpty()){
            return this.getPassengers().get(0);
        } else {
            return null;
        }
    }

    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return passenger instanceof Player && this.getPassengers().size() < 4;
    }

    @Override
    protected void addPassenger(Entity passenger) {
        super.addPassenger(passenger);
        passenger.setYRot(this.getYRot());
    }

    @Override
    protected void positionRider(Entity passenger, MoveFunction callback) {
        List<Entity> riders = this.getPassengers();
        int index = riders.indexOf(passenger);

        float dir = this.getYRot();

        switch (index) {
            case 0 -> passenger.setPos(getRiderPos(dir, 0.2, 0.4));
            case 1 -> passenger.setPos(getRiderPos(dir, 0.2, -0.4));
            case 2 -> passenger.setPos(getRiderPos(dir, -0.4, -0.4));
            case 3 -> passenger.setPos(getRiderPos(dir, -0.4, 0.4));
        }

        Player controller = (Player) this.getControllingPassenger();
        float turn = controller.xxa;

        float newYaw = turn * -8f;

        passenger.setYRot(passenger.getYRot() + newYaw);

        if (index == 0 || index == 1) {
            passenger.setYBodyRot(this.getYRot());
            float f = Mth.wrapDegrees(passenger.getYRot() - this.getYRot());
            float f1 = Mth.clamp(f, -105.0F, 105.0F);
            passenger.yRotO += f1 - f;
            passenger.setYRot(passenger.getYRot() + f1 - f);
            passenger.setYHeadRot(passenger.getYRot());
        } else {
            passenger.setYBodyRot(this.getYRot()+180);
            float f = Mth.wrapDegrees(passenger.getYRot() - this.getYRot()+180);
            float f1 = Mth.clamp(f, -105.0F, 105.0F);
            passenger.yRotO += f1 - f;
            passenger.setYRot(passenger.getYRot() + f1 - f);
            passenger.setYHeadRot(passenger.getYRot());
        }
    }

    private Vec3 getRiderPos(double dir, double x, double z) {

        double dir2 = dir + 90;

        Vec3 xVec = new Vec3(x*(java.lang.Math.cos(Math.toRadians(dir))), 0,
                x*(java.lang.Math.sin(Math.toRadians(dir))));

        Vec3 finVec = new Vec3(xVec.x + z*(java.lang.Math.cos(Math.toRadians(dir))), 0,
                xVec.z + z*(java.lang.Math.sin(Math.toRadians(dir))));


        return new Vec3(finVec.x + this.getX(), this.getY() + 0.2f, finVec.z + this.getZ());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        if (!this.level().isClientSide) {
            if (hand == InteractionHand.MAIN_HAND) {
                if (!player.isShiftKeyDown()) {
                    player.startRiding(this);
                } else {
                    if (player.getMainHandItem().isEmpty()){
                        player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.BRAT.get(), 1));
                        this.discard();
                    }
                }
            }
        }
        return InteractionResult.SUCCESS;
    }



}
