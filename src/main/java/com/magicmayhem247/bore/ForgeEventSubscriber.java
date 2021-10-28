package com.magicmayhem247.bore;

import com.magicmayhem247.bore.util.BoreWorldGen;
import com.magicmayhem247.bore.world.BoreOreGen;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Bore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber
{
    @SubscribeEvent(priority= EventPriority.HIGH)
    public static void onBiomeLoading(BiomeLoadingEvent event)
    {
        if(BoreWorldGen.enableWorldGen.get() == true) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> BoreOreGen.ZINC_OVERWORLD);
        }
    }
}
