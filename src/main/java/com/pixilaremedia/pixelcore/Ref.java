package com.pixilaremedia.pixelcore;

import com.pixilaremedia.pixelcore.tabs.MoneyTab;
import com.pixilaremedia.pixelcore.tabs.PixelCoreTab;
import com.pixilaremedia.pixelcore.tabs.UnobtainableTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

public class Ref
{
    public static Main INSTANCE;
    public static final String MODID = "pixelcore";
    public static final String CONFIG_FILE = MODID+".toml";
    public static final String LOG_NAME = "[" + MODID.toUpperCase() + "]";

    public static PixelCoreTab PIXEL_CORE_TAB = new PixelCoreTab(CreativeModeTab.TABS.length, "pixelcore.pixel_core_tab");
    public static MoneyTab MONEY_TAB = new MoneyTab(CreativeModeTab.TABS.length, "pixelcore.money_tab");
    public static UnobtainableTab UNOBTAINABLE_TAB = new UnobtainableTab(CreativeModeTab.TABS.length, "pixelcore.unobtainable_tab");
    public static CreativeModeTab SPAWN_EGG_TAB;
    public static CreativeModeTab ENCHANTMENT_TAB;

    public static ResourceLocation location(String name)
    {
        return new ResourceLocation(MODID, name);
    }
}
