package com.magicmayhem247.bore.world;

import com.google.common.collect.ImmutableList;
import com.magicmayhem247.bore.Bore;
import com.magicmayhem247.bore.block.BoreBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;


public class BoreOreGeneration
{
    public static ConfiguredFeature<?, ?> ZINC_OVERWORLD;

    public static ImmutableList<OreConfiguration.TargetBlockState> ZINC_TARGET_BLOCKS;

    public static ConfiguredFeature<?, ?> buildOverWorldOre(ImmutableList<OreConfiguration.TargetBlockState> targets, int veinSize, int maxHeight)
    {
        return Feature.ORE.configured(new OreConfiguration(targets,
                veinSize))
                .rangeUniform(VerticalAnchor.bottom(),
                VerticalAnchor.aboveBottom(maxHeight))
                .squared();
    }

    public static void registerConfiguredFeatures()
    {
        ZINC_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, BoreBlocks.ZINC_ORE.get().defaultBlockState()),
                OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, BoreBlocks.DEEPSLATE_ZINC_ORE.get().defaultBlockState()));

        ZINC_OVERWORLD = buildOverWorldOre(ZINC_TARGET_BLOCKS, 16, 50);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Bore.MOD_ID, "zinc_ore"), ZINC_OVERWORLD);
    }
}
