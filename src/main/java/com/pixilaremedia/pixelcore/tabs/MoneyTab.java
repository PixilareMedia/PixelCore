package com.pixilaremedia.pixelcore.tabs;

import com.pixilaremedia.pixelcore.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MoneyTab extends CreativeModeTab
{
    public MoneyTab(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemInit.PIXEL_MONEY_20_DOLLARS.get());
    }
}
