package net.generic_user94.weirdnessincarnate.entity.gecko;

import com.mojang.blaze3d.vertex.PoseStack;
import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GeckoRenderer extends MobRenderer<GeckoEntity, GeckoModel<GeckoEntity>> {

    public GeckoRenderer(EntityRendererProvider.Context context) {
        super(context, new GeckoModel<>(context.bakeLayer(GeckoModel.LAYER_LOCATION)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(GeckoEntity geckoEntity) {
        return ResourceLocation.fromNamespaceAndPath(WeirdnessIncarnate.MOD_ID, "textures/entity/gecko/gecko_blue.png");
    }

    @Override
    public void render(GeckoEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        if (entity.isBaby()){
            poseStack.scale(2f, 2f, 2f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
