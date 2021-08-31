package com.pixilaremedia.pixelcore.client.render.block;

import com.pixilaremedia.pixelcore.init.BlockInit;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;

public class CutoutRendering
{
    public static void render()
    {
        ItemBlockRenderTypes.setRenderLayer(BlockInit.CURRENCY_CONVERSION_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.ETCHING_TABLE.get(), RenderType.cutout());
    }
}
