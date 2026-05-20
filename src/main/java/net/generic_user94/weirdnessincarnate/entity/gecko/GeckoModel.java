package net.generic_user94.weirdnessincarnate.entity.gecko;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class GeckoModel <T extends GeckoEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(WeirdnessIncarnate.MOD_ID, "gecko_blue"), "main");

    private final ModelPart Gecko;
    private final ModelPart NeckAndFace;
    private final ModelPart Face;
    private final ModelPart Rigs;
    private final ModelPart Body;
    private final ModelPart Legs;
    private final ModelPart FrontLegs;
    private final ModelPart BackLegs;
    private final ModelPart Tail;

    public GeckoModel(ModelPart root) {
        this.Gecko = root.getChild("Gecko");
        this.NeckAndFace = this.Gecko.getChild("Neck And Face");
        this.Face = this.NeckAndFace.getChild("Face");
        this.Rigs = this.Face.getChild("Rigs");
        this.Body = this.Gecko.getChild("Body");
        this.Legs = this.Gecko.getChild("Legs");
        this.FrontLegs = this.Legs.getChild("Front Legs");
        this.BackLegs = this.Legs.getChild("Back Legs");
        this.Tail = this.Gecko.getChild("Tail");
    }

    public GeckoModel(ModelPart gecko, ModelPart neckAndFace, ModelPart face, ModelPart rigs, ModelPart body, ModelPart legs, ModelPart frontLegs, ModelPart backLegs, ModelPart tail) {
        Gecko = gecko;
        NeckAndFace = neckAndFace;
        Face = face;
        Rigs = rigs;
        Body = body;
        Legs = legs;
        FrontLegs = frontLegs;
        BackLegs = backLegs;
        Tail = tail;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Gecko = partdefinition.addOrReplaceChild("Gecko", CubeListBuilder.create(), PartPose.offset(3.0F, 24.0F, 0.0F));

        PartDefinition NeckAndFace = Gecko.addOrReplaceChild("Neck And Face", CubeListBuilder.create(), PartPose.offset(-8.0F, -1.0F, 0.0F));

        PartDefinition Neck_r1 = NeckAndFace.addOrReplaceChild("Neck_r1", CubeListBuilder.create().texOffs(18, 14).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition Face = NeckAndFace.addOrReplaceChild("Face", CubeListBuilder.create().texOffs(12, 0).addBox(-4.5F, -3.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition L_r1 = Face.addOrReplaceChild("L_r1", CubeListBuilder.create().texOffs(12, 7).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.0F, 1.0F, 0.0631F, -0.3435F, -0.1855F));

        PartDefinition R_r1 = Face.addOrReplaceChild("R_r1", CubeListBuilder.create().texOffs(12, 4).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.0F, -1.0F, -0.0631F, 0.3435F, -0.1855F));

        PartDefinition Rigs = Face.addOrReplaceChild("Rigs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition LowerJaw_r1 = Rigs.addOrReplaceChild("Lower Jaw_r1", CubeListBuilder.create().texOffs(0, 12).addBox(-5.0F, -2.0F, -1.5F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

        PartDefinition Body = Gecko.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition Body_r1 = Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -8.0F, -2.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.4399F));

        PartDefinition Legs = Gecko.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(-7.0F, -1.0F, 3.0F));

        PartDefinition FrontLegs = Legs.addOrReplaceChild("Front Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition LF_r1 = FrontLegs.addOrReplaceChild("LF_r1", CubeListBuilder.create().texOffs(20, 20).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -0.3491F, 0.0F, 0.8727F));

        PartDefinition RF_r1 = FrontLegs.addOrReplaceChild("RF_r1", CubeListBuilder.create().texOffs(16, 20).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.8727F));

        PartDefinition BackLegs = Legs.addOrReplaceChild("Back Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition LB_r1 = BackLegs.addOrReplaceChild("LB_r1", CubeListBuilder.create().texOffs(16, 10).addBox(0.0F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 1.0F, 0.0F, -0.4363F, 0.4363F, 0.0F));

        PartDefinition RB_r1 = BackLegs.addOrReplaceChild("RB_r1", CubeListBuilder.create().texOffs(10, 16).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 1.0F, -6.0F, 0.4363F, -0.4363F, 0.0F));

        PartDefinition Tail = Gecko.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 17).addBox(2.0F, -2.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 19).addBox(4.0F, -2.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 20).addBox(6.0F, -2.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(GeckoEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(GeckoAnimations.ANIM_GECKO_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, GeckoAnimations.ANIM_GECKO_IDLE, ageInTicks, 1f);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.NeckAndFace.yRot = headYaw * ((float)Math.PI / 180f);
        this.NeckAndFace.xRot = headPitch *  ((float)Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Gecko.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return Body;
    }
}
