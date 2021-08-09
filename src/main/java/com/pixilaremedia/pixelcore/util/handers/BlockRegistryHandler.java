package com.pixilaremedia.pixelcore.util.handers;

import com.pixilaremedia.pixelcore.Ref;
import com.pixilaremedia.pixelcore.References;
import com.pixilaremedia.pixelcore.init.BlockInit;
import com.pixilaremedia.pixelcore.init.ItemInit;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistryHandler
{
    @SubscribeEvent
    public static void onRegisterBlocks(final RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(
                //BlockInit.END_GATEWAY = new Block(BlockBehaviour.Properties.of(Material.PORTAL, MaterialColor.COLOR_BLACK).noCollission().lightLevel((light) -> { return 15; }).strength(-1.0F, 3600000.0F).noDrops()).setRegistryName(Ref.location("end_gateway")),
                //BlockInit.END_PORTAL = new Block(BlockBehaviour.Properties.of(Material.PORTAL, MaterialColor.COLOR_BLACK).noCollission().lightLevel((light) -> { return 15; }).strength(-1.0F, 3600000.0F).noDrops()).setRegistryName(Ref.location("end_portal")),
                //BlockInit.NETHER_PORTAL_X = new Block(BlockBehaviour.Properties.of(Material.PORTAL).noCollission().randomTicks().strength(-1.0F).sound(SoundType.GLASS).lightLevel((light) -> { return 11; })).setRegistryName(Ref.location("nether_portal_x")),
                //BlockInit.NETHER_PORTAL_Z = new Block(BlockBehaviour.Properties.of(Material.PORTAL).noCollission().randomTicks().strength(-1.0F).sound(SoundType.GLASS).lightLevel((light) -> { return 11; })).setRegistryName(Ref.location("nether_portal_z"))
        );
        References.LOGGER.info("Register all the blocks.");
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(
                //ItemInit.END_GATEWAY = new BlockItem(BlockInit.END_GATEWAY, new Item.Properties().rarity(Rarity.EPIC).tab(Ref.UNOBTAINABLE_TAB)).setRegistryName(BlockInit.END_GATEWAY.getRegistryName()),
                //ItemInit.END_PORTAL = new BlockItem(BlockInit.END_PORTAL, new Item.Properties().rarity(Rarity.EPIC).tab(Ref.UNOBTAINABLE_TAB)).setRegistryName(BlockInit.END_PORTAL.getRegistryName()),
                //ItemInit.NETHER_PORTAL_X = new BlockItem(BlockInit.NETHER_PORTAL_X, new Item.Properties().rarity(Rarity.EPIC).tab(Ref.UNOBTAINABLE_TAB)).setRegistryName(BlockInit.NETHER_PORTAL_X.getRegistryName()),
                //ItemInit.NETHER_PORTAL_Z = new BlockItem(BlockInit.NETHER_PORTAL_Z, new Item.Properties().rarity(Rarity.EPIC).tab(Ref.UNOBTAINABLE_TAB)).setRegistryName(BlockInit.NETHER_PORTAL_Z.getRegistryName())
        );
        References.LOGGER.info("Register all the blocks into item blocks.");
    }
}
