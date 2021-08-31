package com.pixilaremedia.pixelcore.init;

import com.pixilaremedia.pixelcore.Ref;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;

public class StatsInit
{
    public static final ResourceLocation INTERACT_WITH_CURRENCY_CONVERSION_TABLE = register("interact_with_currency_conversion_table");
    public static final ResourceLocation INTERACT_WITH_ETCHING_TABLE = register("interact_with_etching_table");

    private static ResourceLocation register(String name)
    {
        return Stats.makeCustomStat(Ref.MODID + ":" + name, StatFormatter.DEFAULT);
    }
}
