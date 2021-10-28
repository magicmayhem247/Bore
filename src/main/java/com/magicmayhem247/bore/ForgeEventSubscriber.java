package com.magicmayhem247.bore;

import com.magicmayhem247.bore.util.BoreConfig;
import com.magicmayhem247.bore.world.BoreOreGeneration;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Bore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber
{
    @SubscribeEvent(priority=EventPriority.HIGH)
    public static void onBiomeLoading(BiomeLoadingEvent event)
    {
        if (event.getCategory() == Biome.BiomeCategory.NETHER)
        {

        }
        else if(event.getCategory() == Biome.BiomeCategory.THEEND)
        {

        }
        else
        {
            if(BoreConfig.spawn_zinc_overworld.get() == true)
            {
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> BoreOreGeneration.ZINC_OVERWORLD);
            }
        }
    }
}


