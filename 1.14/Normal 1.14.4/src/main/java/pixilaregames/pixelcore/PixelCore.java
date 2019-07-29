package pixilaregames.pixelcore;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.block.Block;
import net.minecraft.command.CommandSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import pixilaregames.pixelcore.Commands.CmdGamemode;
import pixilaregames.pixelcore.Config.Config;
import pixilaregames.pixelcore.Config.ConfigOptions;
import pixilaregames.pixelcore.ItemGroups.CommandExclusivesItemGroup;
import pixilaregames.pixelcore.ItemGroups.PixelMoneyItemGroup;
import pixilaregames.pixelcore.Lists.ItemList;

@Mod("pixelcore")
public class PixelCore
{
	//Basic Things Regarding The Mod
	public static PixelCore instance;
	public static final String modid = "pixelcore";
	public static final Logger logger = LogManager.getLogger(modid);
	
	//Creative Tabs
	public static final ItemGroup commandexclusives = new CommandExclusivesItemGroup();
	public static final ItemGroup pixelmoney = new PixelMoneyItemGroup();

	//Mods That Depend On This One
	public static boolean thrivecraftinstalled = false;
	public static boolean newminecraftstuffinstalled = false;
	public static boolean decorationinstalled = false;
	
	//Registering For Everything Else
	public PixelCore()
	{
		instance = this;
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.server_config);
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.client_config);
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegisteries);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		
		Config.loadConfig(Config.client_config, FMLPaths.CONFIGDIR.get().resolve("pixelcore-client.toml").toString());
		Config.loadConfig(Config.server_config, FMLPaths.CONFIGDIR.get().resolve("pixelcore-server.toml").toString());
		
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.addListener(this::serverStarting);
	}
	
	//Setup For Ore Generation, Entities, Etc.
	private void setup(final FMLCommonSetupEvent event)
	{
		logger.info("Setup method registered");
	}
	
	//Setup For TileEntities, Rendering Entities
	private void clientRegisteries(final FMLClientSetupEvent event)
	{
		logger.info("Client registeries method registered");
	}
	
	//Inter Mod Communications
	public void enqueueIMC(final InterModEnqueueEvent evnet)
	{
		InterModComms.sendTo("thrivecraft", "Hello ThriveCraft How Are You", () -> {logger.info("Hello From PixelCore"); return "Hello Worlds";});
		InterModComms.sendTo("newminecraftstuff", "Hello NewMinecraftStuff How Are You", () -> {logger.info("Hello From PixelCore"); return "Hello Worlds";});
		InterModComms.sendTo("decoration", "Hello Decoration How Are You", () -> {logger.info("Hello from PixelCore"); return "Hello Worlds";});
	}
	
	//More Inter Mod Communications
	public void processIMC(final InterModProcessEvent event)
	{
		logger.info("Got IMC {}", event.getIMCStream().map(m->m.getMessageSupplier().get()).collect(Collectors.toList()));
		logger.info("Got IMC {}", event.getIMCStream().map(m->m.getMessageSupplier().get()).collect(Collectors.toList()));
		logger.info("Got IMC {}", event.getIMCStream().map(m->m.getMessageSupplier().get()).collect(Collectors.toList()));
	}
	
	//Register Commands And Other Server Side Things
	public void serverStarting(FMLServerStartingEvent event)
	{
		final CommandDispatcher<CommandSource> dp = event.getCommandDispatcher();
		CmdGamemode.register(dp);
	}
	
	//Register Blocks And Items
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		//Register Items
		@SubscribeEvent
		public static void registerItems(final Register<Item> event)
		{
			if(ConfigOptions.enablespawnercrafting.get())
			{
				event.getRegistry().registerAll
				(
						//The Crafting Item For A Spawner
						ItemList.spawner_heart = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(location("spawner_heart"))
				);
			}
			if(ConfigOptions.enablespawneggcrafting.get())
			{
				//The Crafting Item For Spawn Eggs
				event.getRegistry().registerAll
				(
						ItemList.base_spawn_egg = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(location("base_spawn_egg"))
				);
			}
			
			if(ConfigOptions.enablepixelmoney.get())
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
			}
			
			if(ConfigOptions.enablethrivecraftmoney.get())
			{
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
			}
			
			if(ConfigOptions.enablenewminecraftstuffmoney.get())
			{
				if(newminecraftstuffinstalled = ModList.get().isLoaded("newminecraftstuff"))
				{
					event.getRegistry().registerAll
					(
							//New Minecraft Stuff Money
							ItemList.newminecraftstuff_money_1 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("newminecraftstuff_money_1")),
							ItemList.newminecraftstuff_money_2 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("newminecraftstuff_money_2")),
							ItemList.newminecraftstuff_money_5 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("newminecraftstuff_money_5")),
							ItemList.newminecraftstuff_money_10 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("newminecraftstuff_money_10")),
							ItemList.newminecraftstuff_money_20 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("newminecraftstuff_money_20")),
							ItemList.newminecraftstuff_money_50 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("newminecraftstuff_money_50")),
							ItemList.newminecraftstuff_money_100 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("newminecraftstuff_money_100")),
							ItemList.newminecraftstuff_money_500 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("newminecraftstuff_money_500")),
							ItemList.newminecraftstuff_money_1000 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("newminecraftstuff_money_1000"))						
					);
				}
			}
			
			if(ConfigOptions.enabledecorationmoney.get())
			{
				if(decorationinstalled = ModList.get().isLoaded("decoration"))
				{
					event.getRegistry().registerAll
					(
							//Decoration Money
							ItemList.decoration_money_1 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("decoration_money_1")),
							ItemList.decoration_money_2 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("decoration_money_2")),
							ItemList.decoration_money_5 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("decoration_money_5")),
							ItemList.decoration_money_10 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("decoration_money_10")),
							ItemList.decoration_money_20 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("decoration_money_20")),
							ItemList.decoration_money_50 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("decoration_money_50")),
							ItemList.decoration_money_100 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("decoration_money_100")),
							ItemList.decoration_money_500 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("decoration_money_500")),
							ItemList.decoration_money_1000 = new Item(new Item.Properties().group(pixelmoney).maxStackSize(99)).setRegistryName(location("decoration_money_1000"))						
					);
				}
			}
			
			logger.info("Items Registered");
		}
		
		//Register Blocks
		@SubscribeEvent
		public static void registerBlocks(final Register<Block> event)
		{
			//put blocks here
			logger.info("Blocks Registered");
		}
		
		//Time Saving Measure For Setting The Names Of New Blocks And Items
		public static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
		
		//Determining If Mods That Are Dependencies Or Dependents Are Loaded
		@SubscribeEvent
		public static void postSetup(FMLLoadCompleteEvent event)
		{
			thrivecraftinstalled = ModList.get().isLoaded("thrivecraft");
			newminecraftstuffinstalled = ModList.get().isLoaded("newminecraftstuff");
			decorationinstalled = ModList.get().isLoaded("decoration");
		}
	}
}
