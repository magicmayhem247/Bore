package com.magicmayhem247.bore.fluid.block;

import com.magicmayhem247.bore.block.BoreBlocks;
import com.magicmayhem247.bore.fluid.BoreFluids;
import com.magicmayhem247.bore.item.BoreItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class SteamFluid extends ForgeFlowingFluid
{

    protected SteamFluid(Properties properties)
    {
        super(properties);
    }

    public static ForgeFlowingFluid.Properties createProperties()
    {
        return new ForgeFlowingFluid.Properties(BoreFluids.STEAM_STILL, BoreFluids.STEAM_FLOWING, FluidAttributes.builder(
                new ResourceLocation("bore:block/still_steam"),
                new ResourceLocation("bore:block/flowing_steam"))
                .density(100).viscosity(100).luminosity(0)).canMultiply()
                .bucket(BoreItems.STEAM_BUCKET).block(BoreBlocks.STEAM_BLOCK);
    }

    @Override
    public boolean isSource(FluidState State)
    {
        return false;
    }

    @Override
    public int getAmount(FluidState State)
    {
        return State.getValue(LEVEL);
    }
}
