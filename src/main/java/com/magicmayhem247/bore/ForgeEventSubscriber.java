package com.magicmayhem247.bore;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Bore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber
{
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void biomeLoadingEvent(BiomeLoadingEvent event)
    {

    }
}
