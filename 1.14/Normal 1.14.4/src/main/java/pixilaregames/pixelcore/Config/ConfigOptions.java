package pixilaregames.pixelcore.Config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigOptions
{
	public static ForgeConfigSpec.BooleanValue enablepixelmoney;
	public static ForgeConfigSpec.BooleanValue enablethrivecraftmoney;
	public static ForgeConfigSpec.BooleanValue enablenewminecraftstuffmoney;
	public static ForgeConfigSpec.BooleanValue enabledecorationmoney;
	public static ForgeConfigSpec.BooleanValue enablespawnercrafting;
	public static ForgeConfigSpec.BooleanValue enablespawneggcrafting;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
	{
		server.comment("Money");

		enablepixelmoney = server
				.comment("Should the Pixel Money be enabled")
				.define("Money.Pixel Money", true);
		enablethrivecraftmoney = server
				.comment("Should the Thrive Craft Money be enabled")
				.define("Money.Thrive Craft Money", true);
		enablenewminecraftstuffmoney = server
				.comment("Should the New Minecraft Stuff Money be enabled")
				.define("Money.New Minecraft Stuff Money", true);
		enabledecorationmoney = server
				.comment("Should the Decoration Money be enabled")
				.define("Money.Decoration Money", true);
		
		server.comment("Spawning");
		
		enablespawnercrafting = server
				.comment("Should player beable to craft spawners")
				.define("Spawning.Spawner Crafting", true);
		enablespawneggcrafting = server
				.comment("Should players beable to craft spawn eggs")
				.define("Spawning.Spawn Egg Crafting", true);
	}
}
