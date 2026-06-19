package net.generic_user94.weirdnessincarnate.entity.brat;

// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class BratModel<T extends BratEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(WeirdnessIncarnate.MOD_ID, "subaru_brat"), "main");

    private final ModelPart bone;
    private final ModelPart bone2;
    private final ModelPart Top;
    private final ModelPart bone3;
    private final ModelPart bone6;
    private final ModelPart bone4;
    private final ModelPart bone5;
    private final ModelPart bb_main;

    public BratModel(ModelPart root) {
        this.bone = root.getChild("bone");
        this.bone2 = root.getChild("bone2");
        this.Top = root.getChild("Top");
        this.bone3 = root.getChild("bone3");
        this.bone6 = root.getChild("bone6");
        this.bone4 = root.getChild("bone4");
        this.bone5 = root.getChild("bone5");
        this.bb_main = root.getChild("bb_main");
    }

    public BratModel(ModelPart bone, ModelPart bone2, ModelPart top, ModelPart bone3, ModelPart bone6, ModelPart bone4, ModelPart bone5, ModelPart bbMain) {
        this.bone = bone;
        this.bone2 = bone2;
        Top = top;
        this.bone3 = bone3;
        this.bone6 = bone6;
        this.bone4 = bone4;
        this.bone5 = bone5;
        bb_main = bbMain;
    }




    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 58).addBox(-16.0F, -7.0F, -8.0F, 6.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(88, 58).addBox(-1.0F, -2.0F, -8.0F, 3.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.829F));

        PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(72, 76).addBox(-2.0F, -2.0F, -8.0F, 3.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.829F));

        PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(44, 58).addBox(-16.0F, -7.0F, -8.0F, 6.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(26.0F, 24.0F, 0.0F));

        PartDefinition cube_r3 = bone2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 100).addBox(-1.0F, -2.0F, -8.0F, 3.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.829F));

        PartDefinition cube_r4 = bone2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(72, 94).addBox(-2.0F, -2.0F, -8.0F, 3.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.829F));

        PartDefinition Top = partdefinition.addOrReplaceChild("Top", CubeListBuilder.create().texOffs(54, 43).addBox(-14.0F, -5.0F, -7.0F, 10.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 11.0F, 0.0F));

        PartDefinition LW_r1 = Top.addOrReplaceChild("LW_r1", CubeListBuilder.create().texOffs(0, 76).addBox(0.0F, -5.0F, -10.0F, 0.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 0.0F, 7.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition RW_r1 = Top.addOrReplaceChild("RW_r1", CubeListBuilder.create().texOffs(76, 0).addBox(0.0F, -5.0F, -10.0F, 0.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 0.0F, -7.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition BackWindow_r1 = Top.addOrReplaceChild("Back Window_r1", CubeListBuilder.create().texOffs(102, 24).addBox(0.0F, -4.0F, -7.0F, 0.0F, 11.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition FrontWindow_r1 = Top.addOrReplaceChild("Front Window_r1", CubeListBuilder.create().texOffs(110, 105).addBox(0.0F, -6.0F, -7.0F, 0.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7418F));

        PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(58, 126).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(13.5F, 22.0F, 7.0F));

        PartDefinition cube_r5 = bone3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(126, 66).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r6 = bone3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(126, 62).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r7 = bone3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(126, 58).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition bone6 = partdefinition.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(130, 22).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(13.5F, 22.0F, -7.0F));

        PartDefinition cube_r8 = bone6.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(130, 34).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r9 = bone6.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(130, 30).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r10 = bone6.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(130, 26).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition bone4 = partdefinition.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(126, 70).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.5F, 22.0F, 7.0F));

        PartDefinition cube_r11 = bone4.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(100, 126).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r12 = bone4.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(86, 126).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r13 = bone4.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(72, 126).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition bone5 = partdefinition.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(114, 126).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.5F, 22.0F, -7.0F));

        PartDefinition cube_r14 = bone5.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(128, 126).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r15 = bone5.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(42, 127).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r16 = bone5.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(28, 127).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -5.0F, -8.0F, 18.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-17.0F, -6.0F, -2.0F, 34.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 25).addBox(-27.0F, -5.0F, -8.0F, 10.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(112, 0).addBox(-26.0F, -10.0F, -7.0F, 18.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(112, 7).addBox(-26.0F, -10.0F, 5.0F, 18.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(102, 49).addBox(-8.0F, -12.0F, 6.0F, 18.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(110, 96).addBox(-8.0F, -12.0F, -8.0F, 18.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(68, 0).addBox(23.0F, -8.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(68, 4).addBox(23.0F, -8.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(68, 8).addBox(23.0F, -8.0F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(68, 12).addBox(23.0F, -8.0F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(70, 112).addBox(12.5F, -3.0F, -6.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 118).addBox(-14.5F, -3.0F, -6.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Rail_r1 = bb_main.addOrReplaceChild("Rail_r1", CubeListBuilder.create().texOffs(38, 98).addBox(0.0F, -6.0F, -8.0F, 0.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r17 = bb_main.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(112, 14).addBox(2.0F, -3.5F, -0.5F, 14.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(28, 120).addBox(2.0F, -3.5F, 12.5F, 14.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -8.5F, -6.5F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r18 = bb_main.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 43).addBox(-7.5F, -0.5F, -7.5F, 13.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.5F, -10.5F, 0.5F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r19 = bb_main.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(36, 76).addBox(-1.0F, -3.5F, -8.0F, 2.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.0F, -6.5F, 0.0F, 0.0F, 0.0F, -0.0436F));

        PartDefinition cube_r20 = bb_main.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(110, 76).addBox(-1.0F, -3.5F, -7.0F, 2.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, -6.5F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r21 = bb_main.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(52, 25).addBox(-4.0F, -2.0F, -8.0F, 8.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(21.0F, -3.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setupAnim(BratEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer,
                               int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        bone.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        Top.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        bone3.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        bone6.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        bone4.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        bone5.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay);
    }



    @Override
    public ModelPart root() {
        return this.bb_main;
    }
}