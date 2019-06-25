package pixilaregames.pixelcore.Config;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ConfigManager
{
	private static Set<Setting<?>> settings = new HashSet<>();
	public static File configDir;
	
	public static Setting<Boolean> enableCET;
	public static Setting<Boolean> enablePMT;
	public static Setting<Boolean> enablePM;
	public static Setting<Boolean> enableTM;
	public static Setting<Boolean> enableNMSM;
	public static Setting<Boolean> enableGM;
	
	public static void loadConfig(File mcConfigDir)
	{
		configDir = new File(mcConfigDir, "config");
		configDir.mkdirs();
		Configuration config = loadConfig();
		
		enableCET = setup(config, "general", "cet", false, "If set to true the Command Exclusives Tab is enabled");
		enablePMT = setup(config, "general", "pmt", false, "If set to true the Pixel Money Tab is enabled");
		enablePM = setup(config, "general", "pm", false, "If set to true the Pixel Money is enabled");
		enableTM = setup(config, "general", "tm", false, "If set to true the ThriveCraft Money is enabled");
		enableNMSM = setup(config, "general", "nmsm", false, "If set to true the NewMinecraftStuff Money is enabled");
		enableGM = setup(config, "general", "gm", false, "If set to true the /gm command is enabled");
		
		config.save();
	}

    public static Configuration loadConfig() {
        Configuration config = new Configuration(new File(configDir, "PixelCore.cfg"));
        config.load();
        return config;
    }

    public static void saveConfig() {
        Configuration config = new Configuration(new File(configDir, "PixelCore.cfg"));
        for (Setting<?> setting : settings) {
            config.put(setting);
        }
        config.save();
    }

    private static <T> Setting<T> setup(Configuration config, String category, String settingName, T defaultValue, String comment) {
        Setting<T> setting = config.get(category, settingName, defaultValue);
        setting.category = category;
        setting.name = settingName;
        setting.comment = comment + " (default: " + defaultValue.toString() + ")";
        settings.add(setting);
        return setting;
    }
}
