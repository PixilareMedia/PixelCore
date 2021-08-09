package com.pixilaremedia.pixelcore.tabs;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class UnobtainableTab extends CreativeModeTab
{
    public UnobtainableTab(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.COMMAND_BLOCK);
    }

    @Override
    public void fillItemList(NonNullList<ItemStack> items) {
        super.fillItemList(items);
        items.add(new ItemStack(Items.COMMAND_BLOCK));
        items.add(new ItemStack(Items.CHAIN_COMMAND_BLOCK));
        items.add(new ItemStack(Items.REPEATING_COMMAND_BLOCK));
        items.add(new ItemStack(Items.COMMAND_BLOCK_MINECART));
        items.add(new ItemStack(Items.BARRIER));
        items.add(new ItemStack(Items.SPAWNER));
        items.add(new ItemStack(Items.STRUCTURE_BLOCK));
        items.add(new ItemStack(Items.STRUCTURE_VOID));
        items.add(new ItemStack(Items.JIGSAW));
        items.add(new ItemStack(Items.LIGHT));
        items.add(new ItemStack(Items.DRAGON_EGG));
        items.add(new ItemStack(Items.KNOWLEDGE_BOOK));
        items.add(new ItemStack(Items.DEBUG_STICK));
        items.add(new ItemStack(Items.SUSPICIOUS_STEW));
    }
}
