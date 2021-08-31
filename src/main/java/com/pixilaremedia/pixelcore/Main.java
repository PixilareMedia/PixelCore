package com.pixilaremedia.pixelcore;

import com.google.common.reflect.Reflection;
import com.pixilaremedia.pixelcore.client.render.block.CutoutRendering;
import com.pixilaremedia.pixelcore.config.Config;
import com.pixilaremedia.pixelcore.config.ConfigOptions;
import com.pixilaremedia.pixelcore.init.*;
import com.pixilaremedia.pixelcore.init.MenuTypeInit;
import com.pixilaremedia.pixelcore.inventory.CurrencyConversionScreen;
import com.pixilaremedia.pixelcore.inventory.EtchingScreen;
import com.pixilaremedia.pixelcore.tabs.EnchantmentTab;
import com.pixilaremedia.pixelcore.util.helpers.ConfigHelper;
import com.pixilaremedia.pixelcore.util.helpers.JigsawHelper;
import com.pixilaremedia.pixelcore.util.helpers.VillagerHelper;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fmlserverevents.FMLServerAboutToStartEvent;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;

@SuppressWarnings("deprecation, UnstableApiUsage")
@Mod(Ref.MODID)
@Mod.EventBusSubscriber(modid = Ref.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Main
{
    public Main()
    {
        Ref.INSTANCE = this;
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        //Initialize & Load config stuff
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.common, Ref.CONFIG_FILE);
        Config.loadConfig(Config.common, FMLPaths.CONFIGDIR.get().resolve(Ref.CONFIG_FILE).toString());

        //Register Stuff
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        SoundInit.SOUNDS.register(bus);
        VillagerInit.VILLAGER_PROFESSIONS.register(bus);
        VillagerInit.POINT_OF_INTREST_TYPES.register(bus);
        MenuTypeInit.MENUS.register(bus);
        Reflection.initialize(StatsInit.class);

        //Register Items based on if their config options are enabled
        if(ConfigHelper.booleanTest(ConfigOptions.enableSpawnEggCrafting))
            ItemInit.SPAWN_EGG_CRAFTING.register(bus);
        if(ConfigHelper.booleanTest(ConfigOptions.enableSpawnerCrafting))
            ItemInit.SPAWNER_CRAFTING.register(bus);
        if(ConfigHelper.booleanTest(ConfigOptions.enableMusicDiscs))
            ItemInit.MUSIC_DISCS.register(bus);
        if(ConfigHelper.booleanTest(ConfigOptions.enablePixelMoney))
            ItemInit.MONEY_PIXEL.register(bus);
        if(ConfigHelper.booleanTest(ConfigOptions.enableThriveCraftMoney)/* && References.THRIVE_CRAFT_INSTALLED*/)
            ItemInit.MONEY_THRIVE_CRAFT.register(bus);
        if(ConfigHelper.booleanTest(ConfigOptions.enableDecorationBlocksMoney)/* && References.DECORATION_BLOCKS_INSTALLED*/)
            ItemInit.MONEY_DECORATION_BLOCKS.register(bus);
        if(ConfigHelper.booleanTest(ConfigOptions.enableNewMinecraftStufflMoney)/* && References.NEW_MINECRAFT_STUFF_INSTALLED*/)
            ItemInit.MONEY_NEW_MINECRAFT_STUFF.register(bus);
        if(ConfigHelper.booleanTest(ConfigOptions.enableDangerDangerMoney)/* && References.DANGER_DANGER_INSTALLED*/)
            ItemInit.MONEY_DANGER_DANGER.register(bus);

        //Call a bunch of random things
        bus.addListener(this::commonSetup);
        bus.addListener(this::enqueueIMC);
        bus.addListener(this::processIMC);
        bus.addListener(this::postSetup);
        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            bus.addListener(this::clientSetup);
        });

        //Enable creative mode tabs if they are enabled in the config
        if(ConfigHelper.booleanTest(ConfigOptions.enableEnchantmentTab))
            EnchantmentTab.enchantTab();
        /*if(ConfigHelper.booleanTest(ConfigOptions.enableSpawnEggTab))
            SpawnEggTab.spawnEggTab();*/

        //Finish all the registering calls
        MinecraftForge.EVENT_BUS.addListener(this::onServerAboutToStartEvent);
        MinecraftForge.EVENT_BUS.addListener(this::onServerStarting);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void commonSetup(FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            VillagerHelper.registerVillagerTrades(VillagerInit.MAD_SCIENTIST, VillagerTradesInit.MAD_SCIENTIST_LEVEL_1, VillagerTradesInit.MAD_SCIENTIST_LEVEL_2, VillagerTradesInit.MAD_SCIENTIST_LEVEL_3, VillagerTradesInit.MAD_SCIENTIST_LEVEL_4, VillagerTradesInit.MAD_SCIENTIST_LEVEL_5);
            VillagerHelper.registerVillagerPOI(VillagerInit.MAD_SCIENTIST_POI);
        });
        References.LOGGER.info("Finished Common Setup");
    }

    @OnlyIn(Dist.CLIENT)
    public void clientSetup(FMLClientSetupEvent event)
    {
        MenuScreens.register(MenuTypeInit.CURRENCY_CONVERSION.get(), CurrencyConversionScreen::new);
        MenuScreens.register(MenuTypeInit.ETCHING.get(), EtchingScreen::new);
        CutoutRendering.render();
        References.LOGGER.info("Finished Client Setup");
    }

    public void onServerAboutToStartEvent(FMLServerAboutToStartEvent event)
    {
        if(ConfigHelper.booleanTest(ConfigOptions.enableMadScientistPlainsHouses))
        {
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"), Ref.location("village/plains/plains_mad_scientist"), 12);
        }
        if(ConfigHelper.booleanTest(ConfigOptions.enableMadScientistTaigaHouses))
        {
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/taiga/houses"), Ref.location("village/taiga/taiga_mad_scientist"), 12);
        }
        if(ConfigHelper.booleanTest(ConfigOptions.enableMadScientistSavannaHouses))
        {
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/savanna/houses"), Ref.location("village/savanna/savanna_mad_scientist"), 12);
        }
        if(ConfigHelper.booleanTest(ConfigOptions.enableMadScientistSnowyHouses))
        {
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/snowy/houses"), Ref.location("village/snowy/snowy_mad_scientist"), 12);
        }
        if(ConfigHelper.booleanTest(ConfigOptions.enableMadScientistDesertHouses))
        {
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/desert/houses"), Ref.location("village/desert/desert_mad_scientist"), 12);
        }
        References.LOGGER.info("Finished Server About To Start");
    }

    public void onServerStarting(FMLServerStartingEvent event)
    {
        int count = event.getServer().overworld().getRecipeManager().byType(RecipeTypeInit.CURRENCY_CONVERSION).size();
        References.LOGGER.info(count + " currency conversion recipes loaded.");
    }

    public void enqueueIMC(InterModEnqueueEvent event) { }

    public void processIMC(InterModProcessEvent event) { }

    public void postSetup(FMLLoadCompleteEvent event)
    {
        References.PIXEL_CORE_INSTALLED = References.modsList("pixelcore");
        References.THRIVE_CRAFT_INSTALLED = References.modsList("thrivecraft");
        References.DECORATION_BLOCKS_INSTALLED = References.modsList("decorationblocks");
        References.NEW_MINECRAFT_STUFF_INSTALLED = References.modsList("newminecraftstuff");
        References.DANGER_DANGER_INSTALLED = References.modsList("dangerdanger");
        References.LOGGER.info("Finished Post Setup");
    }
}
