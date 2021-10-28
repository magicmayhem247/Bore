package com.magicmayhem247.bore.world;

import com.google.common.collect.ImmutableList;
import com.magicmayhem247.bore.Bore;
import com.magicmayhem247.bore.block.BoreBlocks;
import com.magicmayhem247.bore.util.BoreConfig;
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

    public static ConfiguredFeature<?, ?> buildOverWorldOre(ImmutableList<OreConfiguration.TargetBlockState> targets, int veinSize, int maxHeight, int rarity)
    {
        return Feature.ORE.configured(new OreConfiguration(targets,
                veinSize))
                .rangeUniform(VerticalAnchor.bottom(),
                VerticalAnchor.aboveBottom(maxHeight)).squared()
                .squared()
                .rarity(rarity);
    }

    public static void registerConfiguredFeatures()
    {
        ZINC_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, BoreBlocks.ZINC_ORE.get().defaultBlockState()),
                OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, BoreBlocks.DEEPSLATE_ZINC_ORE.get().defaultBlockState()));

        ZINC_OVERWORLD = buildOverWorldOre(ZINC_TARGET_BLOCKS, BoreConfig.zinc_max_vein_size.get(), BoreConfig.zinc_max_spawn_height_overworld.get(), BoreConfig.zinc_times_rarer.get());

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Bore.MOD_ID, "zinc_ore"), ZINC_OVERWORLD);
    }
}
