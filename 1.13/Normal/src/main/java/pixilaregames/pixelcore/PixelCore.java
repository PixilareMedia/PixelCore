package pixilaregames.pixelcore;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import pixilaregames.pixelcore.Commands.CmdGamemode;
import pixilaregames.pixelcore.Config.ConfigManager;
import pixilaregames.pixelcore.ItemGroups.CommandExclusivesItemGroup;
import pixilaregames.pixelcore.ItemGroups.PixelMoneyItemGroup;
import pixilaregames.pixelcore.Lists.ItemList;

@Mod("pixelcore")
public class PixelCore
{
	public static PixelCore instance;
	public static final String modid = "pixelcore";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public static final ItemGroup commandexclusives = new CommandExclusivesItemGroup();
	public static final ItemGroup pixelmoney = new PixelMoneyItemGroup();
	
	public static boolean thrivecraftinstalled = false;
	
	public PixelCore()
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegisteries);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.addListener(this::serverStarting);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		ConfigManager.loadConfig(Minecraft.getInstance().gameDir);
		logger.info("Setup method registered");
	}
	
	private void clientRegisteries(final FMLClientSetupEvent event)
	{
		logger.info("Client registeries method registered");
	}
	
	public void enqueueIMC(final InterModEnqueueEvent evnet)
	{
		InterModComms.sendTo("thrivecraft", "Hello ThriveCraft How Are You", () -> {logger.info("Hello from PixelCore"); return "Hello Worlds";});
	}
	
	public void processIMC(final InterModProcessEvent event)
	{
		logger.info("Got IMC {}", event.getIMCStream().map(m->m.getMessageSupplier().get()).collect(Collectors.toList()));
	}
	
	public void serverStarting(FMLServerStartingEvent event)
	{
		final CommandDispatcher<CommandSource> dp = event.getCommandDispatcher();
		CmdGamemode.register(dp);
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final Register<Item> event)
		{
			event.getRegistry().registerAll
			(
					//put items here
					//Pixel Money
					ItemList.pixel_money_1 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("pixel_money_1")),
					ItemList.pixel_money_2 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("pixel_money_2")),
					ItemList.pixel_money_5 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("pixel_money_5")),
					ItemList.pixel_money_10 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("pixel_money_10")),
					ItemList.pixel_money_20 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("pixel_money_20")),
					ItemList.pixel_money_50 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("pixel_money_50")),
					ItemList.pixel_money_100 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("pixel_money_100")),
					ItemList.pixel_money_500 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("pixel_money_500")),
					ItemList.pixel_money_1000 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("pixel_money_1000"))
			);
			
			if(thrivecraftinstalled = ModList.get().isLoaded("thrivecraft"))
			{
				event.getRegistry().registerAll
				(
						//Thrive Craft Money
						ItemList.thrivecraft_money_1 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("thrivecraft_money_1")),
						ItemList.thrivecraft_money_2 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("thrivecraft_money_2")),
						ItemList.thrivecraft_money_5 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("thrivecraft_money_5")),
						ItemList.thrivecraft_money_10 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("thrivecraft_money_10")),
						ItemList.thrivecraft_money_20 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("thrivecraft_money_20")),
						ItemList.thrivecraft_money_50 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("thrivecraft_money_50")),
						ItemList.thrivecraft_money_100 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("thrivecraft_money_100")),
						ItemList.thrivecraft_money_500 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("thrivecraft_money_500")),
						ItemList.thrivecraft_money_1000 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("thrivecraft_money_1000"))
				);
			}
			
			logger.info("Items Registered");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final Register<Block> event)
		{
			event.getRegistry().registerAll
			(
					//put blocks here
			);
			
			logger.info("Blocks Registered");
		}
		
		public static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
		
		@SubscribeEvent
		public static void postSetup(FMLLoadCompleteEvent event)
		{
			thrivecraftinstalled = ModList.get().isLoaded("thrivecraft");
		}
		
	}
}
