package com.pixilaremedia.pixelcore.util.helpers;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigHelper
{
    public static boolean booleanTest(ForgeConfigSpec.BooleanValue booleanValue)
    {
        return booleanValue.get().booleanValue();
    }
    public static int intTest(ForgeConfigSpec.IntValue intValue)
    {
        return intValue.get().intValue();
    }
    public static double doubleTest(ForgeConfigSpec.DoubleValue doubleValue)
    {
        return doubleValue.get().doubleValue();
    }
    public static long longTest(ForgeConfigSpec.LongValue longValue)
    {
        return longValue.get().longValue();
    }
}
