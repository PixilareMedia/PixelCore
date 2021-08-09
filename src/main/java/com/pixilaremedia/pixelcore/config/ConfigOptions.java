package com.pixilaremedia.pixelcore.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class ConfigOptions
{
    public static BooleanValue enablePixelMoney;
    public static BooleanValue enableThriveCraftMoney;
    public static BooleanValue enableDecorationBlocksMoney;
    public static BooleanValue enableNewMinecraftStufflMoney;
    public static BooleanValue enableOreSpawnRenewedMoney;

    public static BooleanValue enableSpawnerCrafting;
    public static BooleanValue enableSpawnEggCrafting;

    public static BooleanValue enableEnchantmentTab;
    public static BooleanValue enableSpawnEggTab;
    /*public static BooleanValue enableUnobtainableTab;
    public static BooleanValue enableMoneyTab;*/

    public static BooleanValue enableMadScientistPlainsHouses;
    public static BooleanValue enableMadScientistTaigaHouses;
    public static BooleanValue enableMadScientistSavannaHouses;
    public static BooleanValue enableMadScientistSnowyHouses;
    public static BooleanValue enableMadScientistDesertHouses;

    public static void init(ForgeConfigSpec.Builder builder)
    {
        enablePixelMoney = builder
                .comment("Enable/Disable the Pixel Money.")
                .define("Money.enablePixelMoney", true);
        enableThriveCraftMoney = builder
                .comment("Enable/Disable the Thrive Craft Money.")
                .define("Money.enableThriveCraftMoney", true);
        enableDecorationBlocksMoney = builder
                .comment("Enable/Disable the Decoration Blocks Money.")
                .define("Money.enableDecorationBlocksMoney", true);
        enableNewMinecraftStufflMoney = builder
                .comment("Enable/Disable the New Minecraft Stuff Money.")
                .define("Money.enableNewMinecraftStufflMoney", true);
        enableOreSpawnRenewedMoney = builder
                .comment("Enable/Disable the OreSpawn Renewed Money.")
                .define("Money.enableOreSpawnRenewedMoney", true);

        enableSpawnerCrafting = builder
                .comment("Enable/Disable the Spawner Crafting.")
                .define("Crafting.enableSpawnerCrafting", true);
        enableSpawnEggCrafting = builder
                .comment("Enable/Disable the Spawn Egg Crafting.")
                .define("Crafting.enableSpawnEggCrafting", true);

        enableEnchantmentTab = builder
                .comment("Enable/Disable the Enchantment Creative Tab.")
                .define("Creative Tabs.enableEnchantmentTab", true);
        enableSpawnEggTab = builder
                .comment("Enable/Disable the Spawn Eggs Creative Tab. (If you disable this I highly recommend that you also disable the Spawner & Spawn Egg Crafting as well.)")
                .define("Creative Tabs.enableSpawnEggTab", true);
        /*enableUnobtainableTab = builder
                .comment("Enable/Disable the Unobtainable Creative Tab.")
                .define("Creative Tabs.enableUnobtainableTab", true);
        enableMoneyTab = builder
                .comment("Enable/Disable the Money Creative Tab. (If you disable this I highly recommend that you also disabled ALL the different types of money.)")
                .define("Creative Tabs.enableMoneyTab", true);*/

        enableMadScientistPlainsHouses = builder
                .comment("Enable/Disable the generation of the Mad Scientist building in Plains Villages.")
                .define("Village Generation.enableMadScientistPlainsHouses", true);
        enableMadScientistTaigaHouses = builder
                .comment("Enable/Disable the generation of the Mad Scientist building in Taiga Villages.")
                .define("Village Generation.enableMadScientistTaigaHouses", true);
        enableMadScientistSavannaHouses = builder
                .comment("Enable/Disable the generation of the Mad Scientist building in Savanna Villages.")
                .define("Village Generation.enableMadScientistSavannaHouses", true);
        enableMadScientistSnowyHouses = builder
                .comment("Enable/Disable the generation of the Mad Scientist building in Snowy Villages.")
                .define("Village Generation.enableMadScientistSnowyHouses", true);
        enableMadScientistDesertHouses = builder
                .comment("Enable/Disable the generation of the Mad Scientist building in Desert Villages.")
                .define("Village Generation.enableMadScientistDesertHouses", true);
    }
}
