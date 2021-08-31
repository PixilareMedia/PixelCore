package com.pixilaremedia.pixelcore.init;

import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;

public class VillagerTradesInit
{
    public static final VillagerTrades.ItemListing[] MAD_SCIENTIST_LEVEL_1 = new VillagerTrades.ItemListing[] {
            new VillagerTrades.ItemsAndEmeraldsToItems(ItemInit.PIXEL_MONEY_5_DOLLARS.get(), 1, Items.EXPERIENCE_BOTTLE, 16, 16, 2),
            new VillagerTrades.ItemsAndEmeraldsToItems(ItemInit.PIXEL_MONEY_20_DOLLARS.get(), 1, Items.END_CRYSTAL, 4, 16, 2)
    };
    public static final VillagerTrades.ItemListing[] MAD_SCIENTIST_LEVEL_2 = new VillagerTrades.ItemListing[] {
            new VillagerTrades.ItemsAndEmeraldsToItems(ItemInit.PIXEL_MONEY_50_DOLLARS.get(), 1, Items.HEART_OF_THE_SEA, 2, 16, 4),
            new VillagerTrades.ItemsAndEmeraldsToItems(ItemInit.PIXEL_MONEY_100_DOLLARS.get(), 1, Items.SHULKER_SHELL, 2, 16, 4)
    };
    public static final VillagerTrades.ItemListing[] MAD_SCIENTIST_LEVEL_3 = new VillagerTrades.ItemListing[] {
            new VillagerTrades.ItemsAndEmeraldsToItems(ItemInit.PIXEL_MONEY_500_DOLLARS.get(), 1, Items.NETHER_STAR, 1, 16, 6),
            new VillagerTrades.ItemsAndEmeraldsToItems(ItemInit.PIXEL_MONEY_1000_DOLLARS.get(), 1, Items.ELYTRA, 1, 16, 6)
    };
    public static final VillagerTrades.ItemListing[] MAD_SCIENTIST_LEVEL_4 = new VillagerTrades.ItemListing[] {
            new VillagerTrades.ItemsAndEmeraldsToItems(ItemInit.PIXEL_MONEY_1000_DOLLARS.get(), 24, Items.TOTEM_OF_UNDYING, 1, 16, 8),
            new VillagerTrades.ItemsAndEmeraldsToItems(ItemInit.PIXEL_MONEY_1000_DOLLARS.get(), 48, Items.ENCHANTED_GOLDEN_APPLE, 1, 16, 8)
    };
    public static final VillagerTrades.ItemListing[] MAD_SCIENTIST_LEVEL_5 = new VillagerTrades.ItemListing[] {
            new VillagerTrades.ItemsAndEmeraldsToItems(ItemInit.PIXEL_MONEY_1000_DOLLARS.get(), 64, Items.DRAGON_EGG, 1, 16, 10)
    };
}
