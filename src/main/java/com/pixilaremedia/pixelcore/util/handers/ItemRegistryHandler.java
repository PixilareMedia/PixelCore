package com.pixilaremedia.pixelcore.util.handers;

import com.pixilaremedia.pixelcore.Ref;
import com.pixilaremedia.pixelcore.References;
import com.pixilaremedia.pixelcore.config.ConfigOptions;
import com.pixilaremedia.pixelcore.init.ItemInit;
import com.pixilaremedia.pixelcore.util.helpers.ConfigHelper;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegistryHandler
{
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
        //Check if the Spawn Egg Crafting is enabled
        if(ConfigHelper.booleanTest(ConfigOptions.enableSpawnEggCrafting))
        {
            //Register the Base Spawn Egg for crafting the other Spawn Eggs
            event.getRegistry().register(
                    ItemInit.BASE_SPAWN_EGG = new Item(new Item.Properties().tab(Ref.SPAWN_EGG_TAB)).setRegistryName(Ref.location("base_spawn_egg"))
            );
        }
        //Check if the Spawner Crafting is enabled
        if(ConfigHelper.booleanTest(ConfigOptions.enableSpawnerCrafting))
        {
            //Register the Spawner Heart for crafting Spawners
            event.getRegistry().register(
                    ItemInit.SPANWER_HEART = new Item(new Item.Properties().tab(Ref.SPAWN_EGG_TAB)).setRegistryName(Ref.location("spawner_heart"))
            );
        }
        //Check if the Pixel Money is enabled
        if(ConfigHelper.booleanTest(ConfigOptions.enablePixelMoney))
        {
            //Register the Pixel Money items
            event.getRegistry().registerAll(
                    ItemInit.PIXEL_MONEY_1_CENT = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("pixel_1_cent")),
                    ItemInit.PIXEL_MONEY_5_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("pixel_5_cents")),
                    ItemInit.PIXEL_MONEY_10_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("pixel_10_cents")),
                    ItemInit.PIXEL_MONEY_25_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("pixel_25_cents")),
                    ItemInit.PIXEL_MONEY_50_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("pixel_50_cents")),
                    ItemInit.PIXEL_MONEY_1_DOLLAR = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("pixel_1_dollar")),
                    ItemInit.PIXEL_MONEY_2_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("pixel_2_dollars")),
                    ItemInit.PIXEL_MONEY_5_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("pixel_5_dollars")),
                    ItemInit.PIXEL_MONEY_10_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("pixel_10_dollars")),
                    ItemInit.PIXEL_MONEY_20_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("pixel_20_dollars")),
                    ItemInit.PIXEL_MONEY_25_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("pixel_25_dollars")),
                    ItemInit.PIXEL_MONEY_50_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("pixel_50_dollars")),
                    ItemInit.PIXEL_MONEY_100_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("pixel_100_dollars")),
                    ItemInit.PIXEL_MONEY_500_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("pixel_500_dollars")),
                    ItemInit.PIXEL_MONEY_1000_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("pixel_1000_dollars"))
            );
        }
        //Check if the Thrive Craft Money is enabled & that Thrive Craft is installed
        if(ConfigHelper.booleanTest(ConfigOptions.enableThriveCraftMoney)/* && References.THRIVE_CRAFT_INSTALLED*/)
        {
            //Register the Thrive Craft Money
            event.getRegistry().registerAll(
                    ItemInit.THRIVE_CRAFT_1_CENT = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("thrive_craft_1_cent")),
                    ItemInit.THRIVE_CRAFT_5_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("thrive_craft_5_cents")),
                    ItemInit.THRIVE_CRAFT_10_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("thrive_craft_10_cents")),
                    ItemInit.THRIVE_CRAFT_25_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("thrive_craft_25_cents")),
                    ItemInit.THRIVE_CRAFT_50_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("thrive_craft_50_cents")),
                    ItemInit.THRIVE_CRAFT_1_DOLLAR = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("thrive_craft_1_dollar")),
                    ItemInit.THRIVE_CRAFT_2_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("thrive_craft_2_dollars")),
                    ItemInit.THRIVE_CRAFT_5_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("thrive_craft_5_dollars")),
                    ItemInit.THRIVE_CRAFT_10_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("thrive_craft_10_dollars")),
                    ItemInit.THRIVE_CRAFT_20_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("thrive_craft_20_dollars")),
                    ItemInit.THRIVE_CRAFT_25_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("thrive_craft_25_dollars")),
                    ItemInit.THRIVE_CRAFT_50_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("thrive_craft_50_dollars")),
                    ItemInit.THRIVE_CRAFT_100_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("thrive_craft_100_dollars")),
                    ItemInit.THRIVE_CRAFT_500_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("thrive_craft_500_dollars")),
                    ItemInit.THRIVE_CRAFT_1000_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("thrive_craft_1000_dollars"))
            );
        }
        //Check if the Decoration Blocks Money is enabled & that Decoration Blocks is installed
        if(ConfigHelper.booleanTest(ConfigOptions.enableDecorationBlocksMoney)/* && References.DECORATION_BLOCKS_INSTALLED*/)
        {
            //Register the Decoration Blocks Money
            event.getRegistry().registerAll(
                    ItemInit.DECORATION_BLOCKS_1_CENT = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("decoration_blocks_1_cent")),
                    ItemInit.DECORATION_BLOCKS_5_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("decoration_blocks_5_cents")),
                    ItemInit.DECORATION_BLOCKS_10_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("decoration_blocks_10_cents")),
                    ItemInit.DECORATION_BLOCKS_25_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("decoration_blocks_25_cents")),
                    ItemInit.DECORATION_BLOCKS_50_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("decoration_blocks_50_cents")),
                    ItemInit.DECORATION_BLOCKS_1_DOLLAR = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("decoration_blocks_1_dollar")),
                    ItemInit.DECORATION_BLOCKS_2_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("decoration_blocks_2_dollars")),
                    ItemInit.DECORATION_BLOCKS_5_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("decoration_blocks_5_dollars")),
                    ItemInit.DECORATION_BLOCKS_10_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("decoration_blocks_10_dollars")),
                    ItemInit.DECORATION_BLOCKS_20_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("decoration_blocks_20_dollars")),
                    ItemInit.DECORATION_BLOCKS_25_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("decoration_blocks_25_dollars")),
                    ItemInit.DECORATION_BLOCKS_50_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("decoration_blocks_50_dollars")),
                    ItemInit.DECORATION_BLOCKS_100_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("decoration_blocks_100_dollars")),
                    ItemInit.DECORATION_BLOCKS_500_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("decoration_blocks_500_dollars")),
                    ItemInit.DECORATION_BLOCKS_1000_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("decoration_blocks_1000_dollars"))
            );
        }
        //Check if the New Minecraft Stuff Money is enabled & that New Minecraft Stuff is installed
        if(ConfigHelper.booleanTest(ConfigOptions.enableNewMinecraftStufflMoney)/* && References.NEW_MINECRAFT_STUFF_INSTALLED*/)
        {
            //Register the New Minecraft Stuff Money
            event.getRegistry().registerAll(
                    ItemInit.NEW_MINECRAFT_STUFF_1_CENT = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("new_minecraft_stuff_1_cent")),
                    ItemInit.NEW_MINECRAFT_STUFF_5_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("new_minecraft_stuff_5_cents")),
                    ItemInit.NEW_MINECRAFT_STUFF_10_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("new_minecraft_stuff_10_cents")),
                    ItemInit.NEW_MINECRAFT_STUFF_25_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("new_minecraft_stuff_25_cents")),
                    ItemInit.NEW_MINECRAFT_STUFF_50_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("new_minecraft_stuff_50_cents")),
                    ItemInit.NEW_MINECRAFT_STUFF_1_DOLLAR = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("new_minecraft_stuff_1_dollar")),
                    ItemInit.NEW_MINECRAFT_STUFF_2_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("new_minecraft_stuff_2_dollars")),
                    ItemInit.NEW_MINECRAFT_STUFF_5_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("new_minecraft_stuff_5_dollars")),
                    ItemInit.NEW_MINECRAFT_STUFF_10_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("new_minecraft_stuff_10_dollars")),
                    ItemInit.NEW_MINECRAFT_STUFF_20_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("new_minecraft_stuff_20_dollars")),
                    ItemInit.NEW_MINECRAFT_STUFF_25_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("new_minecraft_stuff_25_dollars")),
                    ItemInit.NEW_MINECRAFT_STUFF_50_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("new_minecraft_stuff_50_dollars")),
                    ItemInit.NEW_MINECRAFT_STUFF_100_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("new_minecraft_stuff_100_dollars")),
                    ItemInit.NEW_MINECRAFT_STUFF_500_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("new_minecraft_stuff_500_dollars")),
                    ItemInit.NEW_MINECRAFT_STUFF_1000_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("new_minecraft_stuff_1000_dollars"))
            );
        }
        //Check if the OreSpawn Renewed Money is enabled & that OreSpawn Renewed is installed
        if(ConfigHelper.booleanTest(ConfigOptions.enableOreSpawnRenewedMoney)/* && References.ORESPAWN_RENEWED_INSTALLED*/)
        {
            //Register the OreSpawn Renewed Money
            event.getRegistry().registerAll(
                    ItemInit.ORESPAWN_RENEWED_1_CENT = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("orespawn_renewed_1_cent")),
                    ItemInit.ORESPAWN_RENEWED_5_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("orespawn_renewed_5_cents")),
                    ItemInit.ORESPAWN_RENEWED_10_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("orespawn_renewed_10_cents")),
                    ItemInit.ORESPAWN_RENEWED_25_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("orespawn_renewed_25_cents")),
                    ItemInit.ORESPAWN_RENEWED_50_CENTS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("orespawn_renewed_50_cents")),
                    ItemInit.ORESPAWN_RENEWED_1_DOLLAR = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("orespawn_renewed_1_dollar")),
                    ItemInit.ORESPAWN_RENEWED_2_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("orespawn_renewed_2_dollars")),
                    ItemInit.ORESPAWN_RENEWED_5_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("orespawn_renewed_5_dollars")),
                    ItemInit.ORESPAWN_RENEWED_10_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("orespawn_renewed_10_dollars")),
                    ItemInit.ORESPAWN_RENEWED_20_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("orespawn_renewed_20_dollars")),
                    ItemInit.ORESPAWN_RENEWED_25_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("orespawn_renewed_25_dollars")),
                    ItemInit.ORESPAWN_RENEWED_50_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("orespawn_renewed_50_dollars")),
                    ItemInit.ORESPAWN_RENEWED_100_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("orespawn_renewed_100_dollars")),
                    ItemInit.ORESPAWN_RENEWED_500_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("orespawn_renewed_500_dollars")),
                    ItemInit.ORESPAWN_RENEWED_1000_DOLLARS = new Item(new Item.Properties().tab(Ref.MONEY_TAB)).setRegistryName(Ref.location("orespawn_renewed_1000_dollars"))
            );
        }
        References.LOGGER.info("Register all the items.");
    }
}
