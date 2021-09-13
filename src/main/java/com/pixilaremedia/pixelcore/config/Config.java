package com.pixilaremedia.pixelcore.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.pixilaremedia.pixelcore.Ref;
import com.pixilaremedia.pixelcore.References;
import net.minecraftforge.common.ForgeConfigSpec;

import java.io.File;

public class Config
{
    public static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec common;

    static
    {
        ConfigOptions.init(builder);
        common = builder.build();
    }

    public static void loadConfig(ForgeConfigSpec config, String path)
    {
        References.LOGGER.info(Ref.LOG_NAME + " Loading config " + path);
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        References.LOGGER.info(Ref.LOG_NAME + " Build config " + path);
        file.load();
        References.LOGGER.info(Ref.LOG_NAME + " Loaded config " + path);
        config.setConfig(file);
    }
}
