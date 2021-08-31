package com.pixilaremedia.pixelcore.init;

import com.pixilaremedia.pixelcore.Ref;
import com.pixilaremedia.pixelcore.block.CurrencyConversionBlock;
import com.pixilaremedia.pixelcore.block.EtchingBlock;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ref.MODID);

    public static final RegistryObject<Block> END_GATEWAY = BLOCKS.register("end_gateway", () -> new Block(BlockBehaviour.Properties.of(Material.PORTAL, MaterialColor.COLOR_BLACK).noCollission().lightLevel((light) -> { return 15; }).strength(-1.0F, 3600000.0F).noDrops()));
    public static final RegistryObject<Block> END_PORTAL = BLOCKS.register("end_portal", () -> new Block(BlockBehaviour.Properties.of(Material.PORTAL, MaterialColor.COLOR_BLACK).noCollission().lightLevel((light) -> { return 15; }).strength(-1.0F, 3600000.0F).noDrops()));
    public static final RegistryObject<Block> NETHER_PORTAL_X = BLOCKS.register("nether_portal_x", () -> new Block(BlockBehaviour.Properties.of(Material.PORTAL).noCollission().randomTicks().strength(-1.0F).sound(SoundType.GLASS).lightLevel((light) -> { return 11; })));
    public static final RegistryObject<Block> NETHER_PORTAL_Z = BLOCKS.register("nether_portal_z", () -> new Block(BlockBehaviour.Properties.of(Material.PORTAL).noCollission().randomTicks().strength(-1.0F).sound(SoundType.GLASS).lightLevel((light) -> { return 11; })));

    public static final RegistryObject<Block> CURRENCY_CONVERSION_TABLE = BLOCKS.register("currency_conversion_table", () -> new CurrencyConversionBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.5F)));
    public static final RegistryObject<Block> ETCHING_TABLE = BLOCKS.register("etching_table", () -> new EtchingBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.5F)));
}
