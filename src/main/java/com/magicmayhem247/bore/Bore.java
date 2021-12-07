package com.magicmayhem247.bore;

import com.magicmayhem247.bore.block.BoreBlocks;
import com.magicmayhem247.bore.fluid.util.BoreFluids;
import com.magicmayhem247.bore.item.BoreItems;
import com.magicmayhem247.bore.util.BoreConfigManager;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(Bore.MOD_ID)
public class Bore
{
    public static final String MOD_ID = "bore";
    private static final Logger LOGGER = LogManager.getLogger();

    //OreGen
    public static ConfiguredFeature<?, ?> ZINC_ORE_CF;
    public static PlacedFeature ZINC_ORE_PF;


    public Bore()
    {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.addListener(this::BiomeModification);

        BoreConfigManager.initialize();

        //Registers
        BoreItems.register(eventBus);
        BoreBlocks.register(eventBus);
        BoreFluids.register(eventBus);

        eventBus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);


    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            ZINC_ORE_CF = Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Bore.MOD_ID, "zinc_ore"),
                    Feature.ORE.configured(new OreConfiguration(
                            new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD),
                            BoreBlocks.ZINC_ORE.get().defaultBlockState(),
                            12,
                            0.2f

                    )));

            ZINC_ORE_PF = Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(Bore.MOD_ID, "zinc_ore"),
                    ZINC_ORE_CF.placed(
                            CountPlacement.of(25),
                            InSquarePlacement.spread(),
                            HeightRangePlacement.uniform(
                                    VerticalAnchor.aboveBottom(15),
                                    VerticalAnchor.belowTop(30)
                            ), BiomeFilter.biome()
                    ));
        });
    }

    public void BiomeModification (final BiomeLoadingEvent event)
    {
        Biome.BiomeCategory category = event.getCategory();
        if (category != Biome.BiomeCategory.NETHER || category != Biome.BiomeCategory.THEEND || category != Biome.BiomeCategory.NONE)
        {
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ZINC_ORE_PF);
        }
    }
}
