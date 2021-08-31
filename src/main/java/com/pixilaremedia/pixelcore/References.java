package com.pixilaremedia.pixelcore;

import net.minecraftforge.fml.ModList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class References
{
    public static Logger LOGGER = LogManager.getLogger();

    public static boolean PIXEL_CORE_INSTALLED = false;
    public static boolean THRIVE_CRAFT_INSTALLED = false;
    public static boolean DANGER_DANGER_INSTALLED = false;
    public static boolean DECORATION_BLOCKS_INSTALLED = false;
    public static boolean NEW_MINECRAFT_STUFF_INSTALLED = false;

    public static boolean modsList(String modid)
    {
        boolean modList = ModList.get().isLoaded(modid);
        return modList;
    }
}
