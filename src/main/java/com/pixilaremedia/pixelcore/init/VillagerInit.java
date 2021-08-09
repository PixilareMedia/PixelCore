package com.pixilaremedia.pixelcore.init;

import com.google.common.collect.ImmutableSet;
import com.pixilaremedia.pixelcore.Ref;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VillagerInit
{
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, Ref.MODID);
    public static final DeferredRegister<PoiType> POINT_OF_INTREST_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, Ref.MODID);

    public static final RegistryObject<PoiType> MAD_SCIENTIST_POI = POINT_OF_INTREST_TYPES.register("mad_scientist", () -> new PoiType("mad_scientist", PoiType.getBlockStates(Blocks.ENCHANTING_TABLE), 1, 1));
    public static final RegistryObject<VillagerProfession> MAD_SCIENTIST = VILLAGER_PROFESSIONS.register("mad_scientist", () -> new VillagerProfession("mad_scientist", MAD_SCIENTIST_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_CLERIC));
}
