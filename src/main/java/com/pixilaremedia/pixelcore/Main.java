package com.pixilaremedia.pixelcore;

import com.pixilaremedia.pixelcore.config.Config;
import com.pixilaremedia.pixelcore.config.ConfigOptions;
import com.pixilaremedia.pixelcore.init.BlockInit;
import com.pixilaremedia.pixelcore.init.ItemInit;
import com.pixilaremedia.pixelcore.init.VillagerInit;
import com.pixilaremedia.pixelcore.init.VillagerTradesInit;
import com.pixilaremedia.pixelcore.tabs.EnchantmentTab;
import com.pixilaremedia.pixelcore.util.helpers.ConfigHelper;
import com.pixilaremedia.pixelcore.util.helpers.JigsawHelper;
import com.pixilaremedia.pixelcore.util.helpers.VillagerHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.VersionChecker;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;
import net.minecraftforge.fmlserverevents.FMLServerAboutToStartEvent;

@Mod("pixelcore")
@Mod.EventBusSubscriber(modid = Ref.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Main
{
    public Main()
    {
        Ref.INSTANCE = this;
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.server, Ref.CONFIG_FILE);

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        VillagerInit.VILLAGER_PROFESSIONS.register(bus);
        VillagerInit.POINT_OF_INTREST_TYPES.register(bus);

        bus.addListener(this::commonSetup);
        bus.addListener(this::enqueueIMC);
        bus.addListener(this::processIMC);

        Config.loadConfig(Config.server, FMLPaths.CONFIGDIR.get().resolve(Ref.CONFIG_FILE).toString());

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void commonSetup(final FMLCommonSetupEvent event)
    {
        if(ConfigHelper.booleanTest(ConfigOptions.enableEnchantmentTab))
            EnchantmentTab.enchantTab();

        event.enqueueWork(() -> {
            VillagerHelper.registerVillagerTrades(VillagerInit.MAD_SCIENTIST, VillagerTradesInit.MAD_SCIENTIST_LEVEL_1, VillagerTradesInit.MAD_SCIENTIST_LEVEL_2, VillagerTradesInit.MAD_SCIENTIST_LEVEL_3, VillagerTradesInit.MAD_SCIENTIST_LEVEL_4, VillagerTradesInit.MAD_SCIENTIST_LEVEL_5);
            VillagerHelper.registerVillagerPOI(VillagerInit.MAD_SCIENTIST_POI);
        });
    }

    @SubscribeEvent
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
    }

    private void enqueueIMC(final InterModEnqueueEvent event) { }

    private void processIMC(final InterModProcessEvent event) { }
}
