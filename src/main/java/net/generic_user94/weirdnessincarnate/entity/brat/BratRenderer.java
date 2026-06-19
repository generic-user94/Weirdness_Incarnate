package net.generic_user94.weirdnessincarnate.entity.brat;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class BratRenderer extends EntityRenderer<BratEntity> {

    private final BratModel model;

    public BratRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
        this.model = new BratModel(ctx.bakeLayer(BratModel.LAYER_LOCATION));
    }

    @Override
    public void render(BratEntity entity, float yaw, float partialTicks,
                       PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        poseStack.pushPose();

        // Fix orientation
        poseStack.translate(0, 3, 0);
        poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(180));
        poseStack.scale(2f, 2f, 2f);

        poseStack.mulPose(Axis.YP.rotationDegrees(entity.getYRot()+90));

        var vc = buffer.getBuffer(model.renderType(getTextureLocation(entity)));
        model.renderToBuffer(poseStack, vc, packedLight, OverlayTexture.NO_OVERLAY,
                1f, 1f, 1f, 1f);

        poseStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(BratEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(
                WeirdnessIncarnate.MOD_ID,
                "textures/entity/subaru_brat/subaru_brat_red.png"
        );
    }
}
