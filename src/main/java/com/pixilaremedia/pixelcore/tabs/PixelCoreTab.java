package com.pixilaremedia.pixelcore.tabs;

import com.pixilaremedia.pixelcore.init.BlockInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class PixelCoreTab extends CreativeModeTab
{
    public PixelCoreTab(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(BlockInit.CURRENCY_CONVERSION_TABLE.get());
    }
}
