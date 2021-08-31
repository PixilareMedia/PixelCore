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
    public static final DeferredRegister<Item> SPAWNER_CRAFTING = DeferredRegister.create(ForgeRegistries.ITEMS, Ref.MODID);
    public static final DeferredRegister<Item> SPAWN_EGG_CRAFTING = DeferredRegister.create(ForgeRegistries.ITEMS, Ref.MODID);
    public static final DeferredRegister<Item> MONEY_PIXEL = DeferredRegister.create(ForgeRegistries.ITEMS, Ref.MODID);
    public static final DeferredRegister<Item> MONEY_THRIVE_CRAFT = DeferredRegister.create(ForgeRegistries.ITEMS, Ref.MODID);
    public static final DeferredRegister<Item> MONEY_DECORATION_BLOCKS = DeferredRegister.create(ForgeRegistries.ITEMS, Ref.MODID);
    public static final DeferredRegister<Item> MONEY_NEW_MINECRAFT_STUFF = DeferredRegister.create(ForgeRegistries.ITEMS, Ref.MODID);
    public static final DeferredRegister<Item> MONEY_DANGER_DANGER = DeferredRegister.create(ForgeRegistries.ITEMS, Ref.MODID);
    public static final DeferredRegister<Item> MUSIC_DISCS = DeferredRegister.create(ForgeRegistries.ITEMS, Ref.MODID);

    //Spawn Egg Items
    public static final RegistryObject<Item> IRON_GOLEM_SPAWN_EGG = ITEMS.register("iron_golem_spawn_egg", () -> new SpawnEggItem(EntityType.IRON_GOLEM, 16777215, 9935530, (new Item.Properties().tab(CreativeModeTab.TAB_MISC))));
    public static final RegistryObject<Item> SNOW_GOLEM_SPAWN_EGG = ITEMS.register("snow_golem_spawn_egg", () -> new SpawnEggItem(EntityType.SNOW_GOLEM, 16777215, 16236598, (new Item.Properties().tab(CreativeModeTab.TAB_MISC))));
    public static final RegistryObject<Item> GIANT_SPAWN_EGG = ITEMS.register("giant_spawn_egg", () -> new SpawnEggItem(EntityType.GIANT, 51141, 9943682, (new Item.Properties().tab(CreativeModeTab.TAB_MISC))));
    public static final RegistryObject<Item> ILLUSIONER_SPAWN_EGG = ITEMS.register("illusioner_spawn_egg", () -> new SpawnEggItem(EntityType.ILLUSIONER, 1868218, 12171962, (new Item.Properties().tab(CreativeModeTab.TAB_MISC))));
    public static final RegistryObject<Item> WITHER_SPAWN_EGG = ITEMS.register("wither_spawn_egg", () -> new SpawnEggItem(EntityType.WITHER, 12566463, 7237230, (new Item.Properties().tab(CreativeModeTab.TAB_MISC))));
    public static final RegistryObject<Item> ENDER_DRAGON_SPAWN_EGG = ITEMS.register("ender_dragon_spawn_egg", () -> new SpawnEggItem(EntityType.ENDER_DRAGON, 0, 16726072, (new Item.Properties().tab(CreativeModeTab.TAB_MISC))));

    //Minecart Items
    public static final RegistryObject<Item> SPAWNER_MINECART = ITEMS.register("spawner_minecart", () -> new MinecartItem(AbstractMinecart.Type.SPAWNER, (new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).tab(Ref.UNOBTAINABLE_TAB))));

    //Unobtainable Item Blocks
    public static final RegistryObject<BlockItem> END_GATEWAY = ITEMS.register("end_gateway", () -> new BlockItem(BlockInit.END_GATEWAY.get(), new Item.Properties().rarity(Rarity.EPIC).tab(Ref.UNOBTAINABLE_TAB)));
    public static final RegistryObject<BlockItem> END_PORTAL = ITEMS.register("end_portal", () -> new BlockItem(BlockInit.END_PORTAL.get(), new Item.Properties().rarity(Rarity.EPIC).tab(Ref.UNOBTAINABLE_TAB)));
    public static final RegistryObject<BlockItem> NETHER_PORTAL_X = ITEMS.register("nether_portal_x", () -> new BlockItem(BlockInit.NETHER_PORTAL_X.get(), new Item.Properties().rarity(Rarity.EPIC).tab(Ref.UNOBTAINABLE_TAB)));
    public static final RegistryObject<BlockItem> NETHER_PORTAL_Z = ITEMS.register("nether_portal_z", () -> new BlockItem(BlockInit.NETHER_PORTAL_Z.get(), new Item.Properties().rarity(Rarity.EPIC).tab(Ref.UNOBTAINABLE_TAB)));

    //Currency Conversion Table Item Block
    public static final RegistryObject<BlockItem> CURRENCY_CONVERSION_TABLE = ITEMS.register("currency_conversion_table", () -> new BlockItem(BlockInit.CURRENCY_CONVERSION_TABLE.get(), new Item.Properties().tab(Ref.PIXEL_CORE_TAB)));
    public static final RegistryObject<BlockItem> ETCHING_TABLE = ITEMS.register("etching_table", () -> new BlockItem(BlockInit.ETCHING_TABLE.get(), new Item.Properties().tab(Ref.PIXEL_CORE_TAB)));

    //Spawners & Spawn Egg Crafting Items
    public static final RegistryObject<Item> BASE_SPAWN_EGG = SPAWN_EGG_CRAFTING.register("base_spawn_egg", () -> new Item(new Item.Properties().tab(Ref.PIXEL_CORE_TAB)));
    public static final RegistryObject<Item> SPANWER_HEART = SPAWNER_CRAFTING.register("spawner_heart", () -> new Item(new Item.Properties().tab(Ref.PIXEL_CORE_TAB)));

    //Music Discs
    public static final RegistryObject<Item> BLANK_MUSIC_DISC = MUSIC_DISCS.register("blank_music_disc", () -> new Item(new Item.Properties().tab(Ref.PIXEL_CORE_TAB)));
    public static final RegistryObject<Item> OBSIDIAN_PLATES = MUSIC_DISCS.register("obsidian_plates", () -> new Item(new Item.Properties().tab(Ref.PIXEL_CORE_TAB)));
    public static final RegistryObject<Item> MUSIC_DISC_AINT_NO_CRYING = MUSIC_DISCS.register("music_disc_aint_no_crying", () -> new RecordItem(1, SoundInit.AINT_NO_CRYING, new Item.Properties().stacksTo(1).tab(Ref.PIXEL_CORE_TAB).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> MUSIC_DISC_SYNDICATE = MUSIC_DISCS.register("music_disc_syndicate", () -> new RecordItem(2, SoundInit.SYNDICATE, new Item.Properties().stacksTo(1).tab(Ref.PIXEL_CORE_TAB).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> MUSIC_DISC_WELCOME_HOME = MUSIC_DISCS.register("music_disc_welcome_home", () -> new RecordItem(3, SoundInit.WELCOME_HOME, new Item.Properties().stacksTo(1).tab(Ref.PIXEL_CORE_TAB).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> MUSIC_DISC_BLUE = MUSIC_DISCS.register("music_disc_blue", () -> new RecordItem(4, SoundInit.BLUE, new Item.Properties().stacksTo(1).tab(Ref.PIXEL_CORE_TAB).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> MUSIC_DISC_IN_MY_HEAD = MUSIC_DISCS.register("music_disc_in_my_head", () -> new RecordItem(5, SoundInit.IN_MY_HEAD, new Item.Properties().stacksTo(1).tab(Ref.PIXEL_CORE_TAB).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> MUSIC_DISC_KISS_YOUR_DREAMS_GOODBYE = MUSIC_DISCS.register("music_disc_kiss_your_dreams_goodbye", () -> new RecordItem(6, SoundInit.KISS_YOUR_DREAMS_GOODBYE, new Item.Properties().stacksTo(1).tab(Ref.PIXEL_CORE_TAB).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> MUSIC_DISC_TURN_BACK_TIME = MUSIC_DISCS.register("music_disc_turn_back_time", () -> new RecordItem(7, SoundInit.TURN_BACK_TIME, new Item.Properties().stacksTo(1).tab(Ref.PIXEL_CORE_TAB).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> MUSIC_DISC_FOUR_AM = MUSIC_DISCS.register("music_disc_four_am", () -> new RecordItem(8, SoundInit.FOUR_AM, new Item.Properties().stacksTo(1).tab(Ref.PIXEL_CORE_TAB).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> MUSIC_DISC_TELL_YOUR_STORY = MUSIC_DISCS.register("music_disc_tell_your_story", () -> new RecordItem(1, SoundInit.TELL_YOUR_STORY, new Item.Properties().stacksTo(1).tab(Ref.PIXEL_CORE_TAB).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> MUSIC_DISC_WRITE_IT_DOWN = MUSIC_DISCS.register("music_disc_write_it_down", () -> new RecordItem(2, SoundInit.WRITE_IT_DOWN, new Item.Properties().stacksTo(1).tab(Ref.PIXEL_CORE_TAB).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> MUSIC_DISC_NIGHT_BEFORE_DAWN = MUSIC_DISCS.register("music_disc_night_before_dawn", () -> new RecordItem(3, SoundInit.NIGHT_BEFORE_DAWN, new Item.Properties().stacksTo(1).tab(Ref.PIXEL_CORE_TAB).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> MUSIC_DISC_DOOMSDAY = MUSIC_DISCS.register("music_disc_doomsday", () -> new RecordItem(4, SoundInit.DOOMSDAY, new Item.Properties().stacksTo(1).tab(Ref.PIXEL_CORE_TAB).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> MUSIC_DISC_WHY = MUSIC_DISCS.register("music_disc_why", () -> new RecordItem(5, SoundInit.WHY, new Item.Properties().stacksTo(1).tab(Ref.PIXEL_CORE_TAB).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> MUSIC_DISC_REVIVED = MUSIC_DISCS.register("music_disc_revived", () -> new RecordItem(6, SoundInit.REVIVED, new Item.Properties().stacksTo(1).tab(Ref.PIXEL_CORE_TAB).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> MUSIC_DISC_CASINO_ROYALE = MUSIC_DISCS.register("music_disc_casino_royale", () -> new RecordItem(7, SoundInit.CASINO_ROYALE, new Item.Properties().stacksTo(1).tab(Ref.PIXEL_CORE_TAB).rarity(Rarity.RARE)));

    //Money Items
    //Pixel Core Money
    public static final RegistryObject<Item> PIXEL_MONEY_1_CENT = MONEY_PIXEL.register("pixel_1_cent", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> PIXEL_MONEY_5_CENTS = MONEY_PIXEL.register("pixel_5_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> PIXEL_MONEY_10_CENTS = MONEY_PIXEL.register("pixel_10_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> PIXEL_MONEY_25_CENTS = MONEY_PIXEL.register("pixel_25_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> PIXEL_MONEY_50_CENTS = MONEY_PIXEL.register("pixel_50_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> PIXEL_MONEY_1_DOLLAR = MONEY_PIXEL.register("pixel_1_dollar", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> PIXEL_MONEY_2_DOLLARS = MONEY_PIXEL.register("pixel_2_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> PIXEL_MONEY_5_DOLLARS = MONEY_PIXEL.register("pixel_5_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> PIXEL_MONEY_10_DOLLARS = MONEY_PIXEL.register("pixel_10_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> PIXEL_MONEY_20_DOLLARS = MONEY_PIXEL.register("pixel_20_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> PIXEL_MONEY_25_DOLLARS = MONEY_PIXEL.register("pixel_25_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> PIXEL_MONEY_50_DOLLARS = MONEY_PIXEL.register("pixel_50_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> PIXEL_MONEY_100_DOLLARS = MONEY_PIXEL.register("pixel_100_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> PIXEL_MONEY_500_DOLLARS = MONEY_PIXEL.register("pixel_500_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> PIXEL_MONEY_1000_DOLLARS = MONEY_PIXEL.register("pixel_1000_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    //Thrive Craft Money
    public static final RegistryObject<Item> THRIVE_CRAFT_1_CENT = MONEY_THRIVE_CRAFT.register("thrive_craft_1_cent", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> THRIVE_CRAFT_5_CENTS = MONEY_THRIVE_CRAFT.register("thrive_craft_5_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> THRIVE_CRAFT_10_CENTS = MONEY_THRIVE_CRAFT.register("thrive_craft_10_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> THRIVE_CRAFT_25_CENTS = MONEY_THRIVE_CRAFT.register("thrive_craft_25_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> THRIVE_CRAFT_50_CENTS = MONEY_THRIVE_CRAFT.register("thrive_craft_50_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> THRIVE_CRAFT_1_DOLLAR = MONEY_THRIVE_CRAFT.register("thrive_craft_1_dollar", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> THRIVE_CRAFT_2_DOLLARS = MONEY_THRIVE_CRAFT.register("thrive_craft_2_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> THRIVE_CRAFT_5_DOLLARS = MONEY_THRIVE_CRAFT.register("thrive_craft_5_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> THRIVE_CRAFT_10_DOLLARS = MONEY_THRIVE_CRAFT.register("thrive_craft_10_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> THRIVE_CRAFT_20_DOLLARS = MONEY_THRIVE_CRAFT.register("thrive_craft_20_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> THRIVE_CRAFT_25_DOLLARS = MONEY_THRIVE_CRAFT.register("thrive_craft_25_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> THRIVE_CRAFT_50_DOLLARS = MONEY_THRIVE_CRAFT.register("thrive_craft_50_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> THRIVE_CRAFT_100_DOLLARS = MONEY_THRIVE_CRAFT.register("thrive_craft_100_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> THRIVE_CRAFT_500_DOLLARS = MONEY_THRIVE_CRAFT.register("thrive_craft_500_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> THRIVE_CRAFT_1000_DOLLARS = MONEY_THRIVE_CRAFT.register("thrive_craft_1000_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    //Decoration Blocks Money
    public static final RegistryObject<Item> DECORATION_BLOCKS_1_CENT = MONEY_DECORATION_BLOCKS.register("decoration_blocks_1_cent", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DECORATION_BLOCKS_5_CENTS = MONEY_DECORATION_BLOCKS.register("decoration_blocks_5_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DECORATION_BLOCKS_10_CENTS = MONEY_DECORATION_BLOCKS.register("decoration_blocks_10_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DECORATION_BLOCKS_25_CENTS = MONEY_DECORATION_BLOCKS.register("decoration_blocks_25_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DECORATION_BLOCKS_50_CENTS = MONEY_DECORATION_BLOCKS.register("decoration_blocks_50_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DECORATION_BLOCKS_1_DOLLAR = MONEY_DECORATION_BLOCKS.register("decoration_blocks_1_dollar", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DECORATION_BLOCKS_2_DOLLARS = MONEY_DECORATION_BLOCKS.register("decoration_blocks_2_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DECORATION_BLOCKS_5_DOLLARS = MONEY_DECORATION_BLOCKS.register("decoration_blocks_5_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DECORATION_BLOCKS_10_DOLLARS = MONEY_DECORATION_BLOCKS.register("decoration_blocks_10_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DECORATION_BLOCKS_20_DOLLARS = MONEY_DECORATION_BLOCKS.register("decoration_blocks_20_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DECORATION_BLOCKS_25_DOLLARS = MONEY_DECORATION_BLOCKS.register("decoration_blocks_25_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DECORATION_BLOCKS_50_DOLLARS = MONEY_DECORATION_BLOCKS.register("decoration_blocks_50_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DECORATION_BLOCKS_100_DOLLARS = MONEY_DECORATION_BLOCKS.register("decoration_blocks_100_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DECORATION_BLOCKS_500_DOLLARS = MONEY_DECORATION_BLOCKS.register("decoration_blocks_500_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DECORATION_BLOCKS_1000_DOLLARS = MONEY_DECORATION_BLOCKS.register("decoration_blocks_1000_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    //New Minecraft Stuff Money
    public static final RegistryObject<Item> NEW_MINECRAFT_STUFF_1_CENT = MONEY_NEW_MINECRAFT_STUFF.register("new_minecraft_stuff_1_cent", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> NEW_MINECRAFT_STUFF_5_CENTS = MONEY_NEW_MINECRAFT_STUFF.register("new_minecraft_stuff_5_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> NEW_MINECRAFT_STUFF_10_CENTS = MONEY_NEW_MINECRAFT_STUFF.register("new_minecraft_stuff_10_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> NEW_MINECRAFT_STUFF_25_CENTS = MONEY_NEW_MINECRAFT_STUFF.register("new_minecraft_stuff_25_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> NEW_MINECRAFT_STUFF_50_CENTS = MONEY_NEW_MINECRAFT_STUFF.register("new_minecraft_stuff_50_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> NEW_MINECRAFT_STUFF_1_DOLLAR = MONEY_NEW_MINECRAFT_STUFF.register("new_minecraft_stuff_1_dollar", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> NEW_MINECRAFT_STUFF_2_DOLLARS = MONEY_NEW_MINECRAFT_STUFF.register("new_minecraft_stuff_2_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> NEW_MINECRAFT_STUFF_5_DOLLARS = MONEY_NEW_MINECRAFT_STUFF.register("new_minecraft_stuff_5_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> NEW_MINECRAFT_STUFF_10_DOLLARS = MONEY_NEW_MINECRAFT_STUFF.register("new_minecraft_stuff_10_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> NEW_MINECRAFT_STUFF_20_DOLLARS = MONEY_NEW_MINECRAFT_STUFF.register("new_minecraft_stuff_20_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> NEW_MINECRAFT_STUFF_25_DOLLARS = MONEY_NEW_MINECRAFT_STUFF.register("new_minecraft_stuff_25_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> NEW_MINECRAFT_STUFF_50_DOLLARS = MONEY_NEW_MINECRAFT_STUFF.register("new_minecraft_stuff_50_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> NEW_MINECRAFT_STUFF_100_DOLLARS = MONEY_NEW_MINECRAFT_STUFF.register("new_minecraft_stuff_100_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> NEW_MINECRAFT_STUFF_500_DOLLARS = MONEY_NEW_MINECRAFT_STUFF.register("new_minecraft_stuff_500_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> NEW_MINECRAFT_STUFF_1000_DOLLARS = MONEY_NEW_MINECRAFT_STUFF.register("new_minecraft_stuff_1000_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    //OreSpawn Renwed Money
    public static final RegistryObject<Item> DANGER_DANGER_1_CENT = MONEY_DANGER_DANGER.register("danger_danger_1_cent", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DANGER_DANGER_5_CENTS = MONEY_DANGER_DANGER.register("danger_danger_5_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DANGER_DANGER_10_CENTS = MONEY_DANGER_DANGER.register("danger_danger_10_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DANGER_DANGER_25_CENTS = MONEY_DANGER_DANGER.register("danger_danger_25_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DANGER_DANGER_50_CENTS = MONEY_DANGER_DANGER.register("danger_danger_50_cents", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DANGER_DANGER_1_DOLLAR = MONEY_DANGER_DANGER.register("danger_danger_1_dollar", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DANGER_DANGER_2_DOLLARS = MONEY_DANGER_DANGER.register("danger_danger_2_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DANGER_DANGER_5_DOLLARS = MONEY_DANGER_DANGER.register("danger_danger_5_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DANGER_DANGER_10_DOLLARS = MONEY_DANGER_DANGER.register("danger_danger_10_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DANGER_DANGER_20_DOLLARS = MONEY_DANGER_DANGER.register("danger_danger_20_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DANGER_DANGER_25_DOLLARS = MONEY_DANGER_DANGER.register("danger_danger_25_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DANGER_DANGER_50_DOLLARS = MONEY_DANGER_DANGER.register("danger_danger_50_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DANGER_DANGER_100_DOLLARS = MONEY_DANGER_DANGER.register("danger_danger_100_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DANGER_DANGER_500_DOLLARS = MONEY_DANGER_DANGER.register("danger_danger_500_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
    public static final RegistryObject<Item> DANGER_DANGER_1000_DOLLARS = MONEY_DANGER_DANGER.register("danger_danger_1000_dollars", () -> new Item(new Item.Properties().tab(Ref.MONEY_TAB)));
}
