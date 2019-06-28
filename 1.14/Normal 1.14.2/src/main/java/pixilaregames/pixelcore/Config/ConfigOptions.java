package pixilaregames.pixelcore.Config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigOptions
{
	public static ForgeConfigSpec.BooleanValue enablepixelmoney;
	public static ForgeConfigSpec.BooleanValue enablethrivecraftmoney;
	public static ForgeConfigSpec.BooleanValue enablenewminecraftstuffmoney;
	public static ForgeConfigSpec.BooleanValue enabledecorationmoney;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
	{
		server.comment("Pixel Money");

		enablepixelmoney = server
				.comment("Should the Pixel Money be enabled")
				.define("pixelmoney.enablepixelmoney", true);
		enablethrivecraftmoney = server
				.comment("Should the Thrive Craft Money be enabled")
				.define("pixelmoney.enablethrivecraftmoney", true);
		enablenewminecraftstuffmoney = server
				.comment("Should the New Minecraft Stuff Money be enabled")
				.define("pixelmoney.enablenewminecraftstuffmoney", true);
		enabledecorationmoney = server
				.comment("Should the Decoration Money be enabled")
				.define("pixelmoney.enabledecorationmoney", true);
	}
}
