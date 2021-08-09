package com.pixilaremedia.pixelcore.util.helpers;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class VillagerHelper
{
    public static void registerVillagerPOI(RegistryObject<PoiType> poi)
    {
        try
        {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockstates", PoiType.class).invoke(null, poi.get());
        }
        catch (InvocationTargetException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }

    public static void registerVillagerTrades(RegistryObject<VillagerProfession> profession, VillagerTrades.ItemListing[] tradeLevel1, VillagerTrades.ItemListing[] tradeLevel2, VillagerTrades.ItemListing[] tradeLevel3, VillagerTrades.ItemListing[] tradeLevel4, VillagerTrades.ItemListing[] tradeLevel5)
    {
        VillagerTrades.TRADES.put(profession.get(), toIntMap(ImmutableMap.of(1, tradeLevel1, 2, tradeLevel2, 3, tradeLevel3, 4, tradeLevel4, 5, tradeLevel5)));
    }

    public static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> immutableMap)
    {
        return new Int2ObjectOpenHashMap<>(immutableMap);
    }
}
