package com.magicmayhem247.bore.fluid;

import com.magicmayhem247.bore.Bore;
import com.magicmayhem247.bore.block.BoreBlocks;
import com.magicmayhem247.bore.fluid.util.BoreFluids;
import com.magicmayhem247.bore.item.BoreItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class SteamFluid extends ForgeFlowingFluid
{
    protected SteamFluid()
    {
        super(new ForgeFlowingFluid.Properties(
                BoreFluids.STEAM,
                BoreFluids.FLOWING_STEAM,
                FluidAttributes.builder(
                        new ResourceLocation(Bore.MOD_ID, "block/water_still"),
                        new ResourceLocation(Bore.MOD_ID, "block/water_flow")
                ).overlay(new ResourceLocation(Bore.MOD_ID, "block/water_overlay"))
                        .color(0xFFFFFF))
                .block(BoreBlocks.STEAM)
                .bucket(BoreItems.STEAM_BUCKET)
);
    }

    public static class Flowing extends SteamFluid
    {
        public Flowing()
        {
            registerDefaultState(getStateDefinition().any().setValue(LEVEL, 7));
        }

        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> p_76476_)
        {
            super.createFluidStateDefinition(p_76476_);
            p_76476_.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState p_76480_)
        {
            return p_76480_.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState p_76478_)
        {
            return false;
        }
    }

    public static class Source extends SteamFluid
    {

        @Override
        public int getAmount(FluidState p_76485_)
        {
            return 8;
        }

        @Override
        public boolean isSource(FluidState p_76483_)
        {
            return true;
        }
    }
}
