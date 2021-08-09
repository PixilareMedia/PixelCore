package com.pixilaremedia.pixelcore.init;

import com.pixilaremedia.pixelcore.Ref;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.*;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ref.MODID);

    //Spawn Egg Items
    public static final RegistryObject<Item> IRON_GOLEM_SPAWN_EGG = ITEMS.register("iron_golem_spawn_egg", () -> new SpawnEggItem(EntityType.IRON_GOLEM, 16777215, 9935530, (new Item.Properties().tab(Ref.SPAWN_EGG_TAB))));
    public static final RegistryObject<Item> SNOW_GOLEM_SPAWN_EGG = ITEMS.register("snow_golem_spawn_egg", () -> new SpawnEggItem(EntityType.SNOW_GOLEM, 16777215, 16236598, (new Item.Properties().tab(Ref.SPAWN_EGG_TAB))));
    public static final RegistryObject<Item> GIANT_SPAWN_EGG = ITEMS.register("giant_spawn_egg", () -> new SpawnEggItem(EntityType.GIANT, 51141, 9943682, (new Item.Properties().tab(Ref.SPAWN_EGG_TAB))));
    public static final RegistryObject<Item> ILLUSIONER_SPAWN_EGG = ITEMS.register("illusioner_spawn_egg", () -> new SpawnEggItem(EntityType.ILLUSIONER, 1868218, 12171962, (new Item.Properties().tab(Ref.SPAWN_EGG_TAB))));
    public static final RegistryObject<Item> WITHER_SPAWN_EGG = ITEMS.register("wither_spawn_egg", () -> new SpawnEggItem(EntityType.WITHER, 12566463, 7237230, (new Item.Properties().tab(Ref.SPAWN_EGG_TAB))));
    public static final RegistryObject<Item> ENDER_DRAGON_SPAWN_EGG = ITEMS.register("ender_dragon_spawn_egg", () -> new SpawnEggItem(EntityType.ENDER_DRAGON, 0, 16726072, (new Item.Properties().tab(Ref.SPAWN_EGG_TAB))));

    //Minecart Items
    public static final RegistryObject<Item> SPAWNER_MINECART = ITEMS.register("spawner_minecart", () -> new MinecartItem(AbstractMinecart.Type.SPAWNER, (new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).tab(Ref.UNOBTAINABLE_TAB))));

    //Unobtainable Item Blocks
    public static final RegistryObject<BlockItem> END_GATEWAY = ITEMS.register("end_gateway", () -> new BlockItem(BlockInit.END_GATEWAY.get(), new Item.Properties().rarity(Rarity.EPIC).tab(Ref.UNOBTAINABLE_TAB)));
    public static final RegistryObject<BlockItem> END_PORTAL = ITEMS.register("end_portal", () -> new BlockItem(BlockInit.END_PORTAL.get(), new Item.Properties().rarity(Rarity.EPIC).tab(Ref.UNOBTAINABLE_TAB)));
    public static final RegistryObject<BlockItem> NETHER_PORTAL_X = ITEMS.register("nether_portal_x", () -> new BlockItem(BlockInit.NETHER_PORTAL_X.get(), new Item.Properties().rarity(Rarity.EPIC).tab(Ref.UNOBTAINABLE_TAB)));
    public static final RegistryObject<BlockItem> NETHER_PORTAL_Z = ITEMS.register("nether_portal_z", () -> new BlockItem(BlockInit.NETHER_PORTAL_Z.get(), new Item.Properties().rarity(Rarity.EPIC).tab(Ref.UNOBTAINABLE_TAB)));

    //Spawners & Spawn Egg Crafting Items
    public static Item BASE_SPAWN_EGG;
    public static Item SPANWER_HEART;

    //Money Items
    //Pixel Core Money
    public static Item PIXEL_MONEY_1_CENT;
    public static Item PIXEL_MONEY_5_CENTS;
    public static Item PIXEL_MONEY_10_CENTS;
    public static Item PIXEL_MONEY_25_CENTS;
    public static Item PIXEL_MONEY_50_CENTS;
    public static Item PIXEL_MONEY_1_DOLLAR;
    public static Item PIXEL_MONEY_2_DOLLARS;
    public static Item PIXEL_MONEY_5_DOLLARS;
    public static Item PIXEL_MONEY_10_DOLLARS;
    public static Item PIXEL_MONEY_20_DOLLARS;
    public static Item PIXEL_MONEY_25_DOLLARS;
    public static Item PIXEL_MONEY_50_DOLLARS;
    public static Item PIXEL_MONEY_100_DOLLARS;
    public static Item PIXEL_MONEY_500_DOLLARS;
    public static Item PIXEL_MONEY_1000_DOLLARS;
    //Thrive Craft Money
    public static Item THRIVE_CRAFT_1_CENT;
    public static Item THRIVE_CRAFT_5_CENTS;
    public static Item THRIVE_CRAFT_10_CENTS;
    public static Item THRIVE_CRAFT_25_CENTS;
    public static Item THRIVE_CRAFT_50_CENTS;
    public static Item THRIVE_CRAFT_1_DOLLAR;
    public static Item THRIVE_CRAFT_2_DOLLARS;
    public static Item THRIVE_CRAFT_5_DOLLARS;
    public static Item THRIVE_CRAFT_10_DOLLARS;
    public static Item THRIVE_CRAFT_20_DOLLARS;
    public static Item THRIVE_CRAFT_25_DOLLARS;
    public static Item THRIVE_CRAFT_50_DOLLARS;
    public static Item THRIVE_CRAFT_100_DOLLARS;
    public static Item THRIVE_CRAFT_500_DOLLARS;
    public static Item THRIVE_CRAFT_1000_DOLLARS;
    //Decoration Blocks Money
    public static Item DECORATION_BLOCKS_1_CENT;
    public static Item DECORATION_BLOCKS_5_CENTS;
    public static Item DECORATION_BLOCKS_10_CENTS;
    public static Item DECORATION_BLOCKS_25_CENTS;
    public static Item DECORATION_BLOCKS_50_CENTS;
    public static Item DECORATION_BLOCKS_1_DOLLAR;
    public static Item DECORATION_BLOCKS_2_DOLLARS;
    public static Item DECORATION_BLOCKS_5_DOLLARS;
    public static Item DECORATION_BLOCKS_10_DOLLARS;
    public static Item DECORATION_BLOCKS_20_DOLLARS;
    public static Item DECORATION_BLOCKS_25_DOLLARS;
    public static Item DECORATION_BLOCKS_50_DOLLARS;
    public static Item DECORATION_BLOCKS_100_DOLLARS;
    public static Item DECORATION_BLOCKS_500_DOLLARS;
    public static Item DECORATION_BLOCKS_1000_DOLLARS;
    //New Minecraft Stuff Money
    public static Item NEW_MINECRAFT_STUFF_1_CENT;
    public static Item NEW_MINECRAFT_STUFF_5_CENTS;
    public static Item NEW_MINECRAFT_STUFF_10_CENTS;
    public static Item NEW_MINECRAFT_STUFF_25_CENTS;
    public static Item NEW_MINECRAFT_STUFF_50_CENTS;
    public static Item NEW_MINECRAFT_STUFF_1_DOLLAR;
    public static Item NEW_MINECRAFT_STUFF_2_DOLLARS;
    public static Item NEW_MINECRAFT_STUFF_5_DOLLARS;
    public static Item NEW_MINECRAFT_STUFF_10_DOLLARS;
    public static Item NEW_MINECRAFT_STUFF_20_DOLLARS;
    public static Item NEW_MINECRAFT_STUFF_25_DOLLARS;
    public static Item NEW_MINECRAFT_STUFF_50_DOLLARS;
    public static Item NEW_MINECRAFT_STUFF_100_DOLLARS;
    public static Item NEW_MINECRAFT_STUFF_500_DOLLARS;
    public static Item NEW_MINECRAFT_STUFF_1000_DOLLARS;
    //OreSpawn Renwed Money
    public static Item ORESPAWN_RENEWED_1_CENT;
    public static Item ORESPAWN_RENEWED_5_CENTS;
    public static Item ORESPAWN_RENEWED_10_CENTS;
    public static Item ORESPAWN_RENEWED_25_CENTS;
    public static Item ORESPAWN_RENEWED_50_CENTS;
    public static Item ORESPAWN_RENEWED_1_DOLLAR;
    public static Item ORESPAWN_RENEWED_2_DOLLARS;
    public static Item ORESPAWN_RENEWED_5_DOLLARS;
    public static Item ORESPAWN_RENEWED_10_DOLLARS;
    public static Item ORESPAWN_RENEWED_20_DOLLARS;
    public static Item ORESPAWN_RENEWED_25_DOLLARS;
    public static Item ORESPAWN_RENEWED_50_DOLLARS;
    public static Item ORESPAWN_RENEWED_100_DOLLARS;
    public static Item ORESPAWN_RENEWED_500_DOLLARS;
    public static Item ORESPAWN_RENEWED_1000_DOLLARS;
}
