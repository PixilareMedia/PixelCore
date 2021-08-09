package com.pixilaremedia.pixelcore.tabs;

import com.pixilaremedia.pixelcore.Ref;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import java.util.Arrays;

public class EnchantmentTab
{
    public static void enchantTab()
    {
        Arrays.stream(CreativeModeTab.TABS).forEach(CreativeModeTab::setEnchantmentCategories);

        Ref.ENCHANTMENT_TAB = new CreativeModeTab(CreativeModeTab.TABS.length, "enchantment_tab")
        {
            public ItemStack makeIcon()
            {
                return new ItemStack(Items.ENCHANTED_BOOK);
            }
        }.setEnchantmentCategories(EnchantmentCategory.values());
    }
}
