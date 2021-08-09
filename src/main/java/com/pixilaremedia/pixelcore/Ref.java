package com.pixilaremedia.pixelcore;

import com.pixilaremedia.pixelcore.tabs.MoneyTab;
import com.pixilaremedia.pixelcore.tabs.SpawnEggTab;
import com.pixilaremedia.pixelcore.tabs.UnobtainableTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

public class Ref
{
    public static Main INSTANCE;
    public static final String MODID = "pixelcore";
    public static final String CONFIG_FILE = MODID+".toml";

    public static MoneyTab MONEY_TAB = new MoneyTab(CreativeModeTab.TABS.length, "money_tab");
    public static UnobtainableTab UNOBTAINABLE_TAB = new UnobtainableTab(CreativeModeTab.TABS.length, "unobtainable_tab");
    public static SpawnEggTab SPAWN_EGG_TAB = new SpawnEggTab(CreativeModeTab.TABS.length, "spawn_egg_tab");;
    public static CreativeModeTab ENCHANTMENT_TAB;

    public static ResourceLocation location(String name)
    {
        return new ResourceLocation(MODID, name);
    }
}
