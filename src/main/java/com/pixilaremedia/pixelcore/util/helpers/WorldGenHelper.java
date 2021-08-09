package com.pixilaremedia.pixelcore.util.helpers;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class WorldGenHelper
{
    public static void registerFeature(Block block, RuleTest surroundingBlock, int veinSize, int maxY, int minY, int veinsPerChunk)
    {
        OreConfiguration feature = new OreConfiguration(surroundingBlock, block.defaultBlockState(), veinSize);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, block.getRegistryName(), Feature.ORE.configured(feature).rangeUniform(VerticalAnchor.absolute(minY), VerticalAnchor.absolute(maxY)).count(veinsPerChunk).squared());
    }

    public static void addFeatureToBiome(Biome biome, GenerationStep.Decoration decoration, ConfiguredFeature<?, ?> configuredFeature)
    {
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = new ArrayList<>(biome.getGenerationSettings().features());

        while(biomeFeatures.size() <= decoration.ordinal())
        {
            biomeFeatures.add(new ArrayList<>());
        }
        List<Supplier<ConfiguredFeature<?, ?>>> features = new ArrayList<>(biomeFeatures.get(decoration.ordinal()));
        features.add(() -> configuredFeature);
        biomeFeatures.set(decoration.ordinal(), features);
        ObfuscationReflectionHelper.setPrivateValue(BiomeGenerationSettings.class, biome.getGenerationSettings(), biomeFeatures, "features");
    }
}
