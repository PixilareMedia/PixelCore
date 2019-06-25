package pixilaregames.pixelcore.Config;

import net.minecraftforge.common.ForgeConfigSpec;

public class PixelCoreConfig
{
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final General GENERAL = new General(BUILDER);
	public static final ForgeConfigSpec spec = BUILDER.build();
	
	public static class General
	{
		public final ForgeConfigSpec.ConfigValue<Boolean> CommandExclusivesTab;
		public final ForgeConfigSpec.ConfigValue<Boolean> PixelMoneyTab;
		public final ForgeConfigSpec.ConfigValue<Boolean> PixelMoney;
		public final ForgeConfigSpec.ConfigValue<Boolean> ThriveCraftMoney;
		public final ForgeConfigSpec.ConfigValue<Boolean> NewMinecraftStuffMoney;
		
		public General(ForgeConfigSpec.Builder builder)
		{
			builder.push("General");
			CommandExclusivesTab = builder
					.comment("Enables/Disables the Command Exclusives Tab [false/true|default:ture]")
					.translation("cet.config")
					.define("enableCET", true);
			PixelMoneyTab = builder
					.comment("Enables/Disables the Pixel Money Tab [false/true|default:true]")
					.translation("pmt.config")
					.define("enablePMT", true);
			PixelMoney = builder
					.comment("Enables/Disables the Pixel Money [false/true|default:true]")
					.translation("pm.config")
					.define("enablePM", true);
			ThriveCraftMoney = builder
					.comment("Enables/Disables (only if the ThriveCraft Mod is installed) the Thrive Craft Money [false/true|default:true]")
					.translation("tcm.config")
					.define("enablePM", true);
			NewMinecraftStuffMoney = builder
					.comment("Enables/Disables (only if the NewMinecraftStuff Mod is installed) the New Minecraft Stuff Money [false/true|default:true]")
					.translation("nmsm.config")
					.define("enablePM", true);
			builder.pop();
		}
	}
}
