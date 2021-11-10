package com.magicmayhem247.bore.world;


import com.google.common.collect.ImmutableList;
import com.magicmayhem247.bore.Bore;
import com.magicmayhem247.bore.block.BoreBlocks;
import com.magicmayhem247.bore.util.BoreWorldGen;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import org.apache.commons.lang3.tuple.Pair;

import javax.swing.text.AbstractDocument;
import java.util.function.Predicate;

public final class BoreOreGen
{
    public static ConfiguredFeature<?, ?> ZINC_OVERWORLD;

    public static ImmutableList<OreConfiguration.TargetBlockState> ZINC_TARGET_BLOCKS;

    public static ConfiguredFeature<?, ?> buildOverworldOre(ImmutableList<OreConfiguration.TargetBlockState> targets, int veinSize, int maxHeight)
    {
        return Feature.ORE.configured(new OreConfiguration(targets,
                veinSize))
                .rangeUniform(VerticalAnchor.bottom(),
                VerticalAnchor.aboveBottom(maxHeight)).squared()
                .squared()
                .count(BoreWorldGen.zincOreMaxClustersPerChunk.get());

    }

    public static void registerConfiguredFeature()
    {
        ZINC_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, BoreBlocks.ZINC_ORE.get().defaultBlockState()));
        ZINC_OVERWORLD = buildOverworldOre(ZINC_TARGET_BLOCKS, BoreWorldGen.zincOrePerCluster.get(), BoreWorldGen.zincOreMaxY.get());


        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Bore.MOD_ID, "zinc_ore"), ZINC_OVERWORLD);

    }


}
