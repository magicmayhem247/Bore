package com.magicmayhem247.bore;

import com.magicmayhem247.bore.block.BoreBlocks;
import com.magicmayhem247.bore.item.BoreItems;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
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

    public Bore() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Registers
        BoreItems.register(eventBus);
        BoreBlocks.register(eventBus);

        eventBus.addListener(this::setup);


        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

}
