package pixilaregames.pixelcore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("pixelcore")
public class PixelCore
{
	public static PixelCore instance;
	public static final String modid = "pixelcore";
	private static final Logger logger = LogManager.getLogger(modid);
	
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
		logger.info("Setup method registered");
	}
	
	private void clientRegisteries(final FMLClientSetupEvent event)
	{
		logger.info("Client registeries method registered");
	}
	
	public void enqueueIMC(final InterModEnqueueEvent evnet)
	{
		
	}
	
	public void processIMC(final InterModProcessEvent event)
	{
		
	}
	
	public void serverStarting(FMLServerStartingEvent event)
	{
		
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
			);
			
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
			
		}
	}
}
