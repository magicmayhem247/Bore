package com.magicmayhem247.bore.fluid;

import com.magicmayhem247.bore.Bore;
import com.magicmayhem247.bore.fluid.block.SteamFluid;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.concurrent.Flow;

public class BoreFluids
{
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Bore.MOD_ID);

    //Steam
    public static RegistryObject<FlowingFluid> STEAM_STILL = FLUIDS.register("steam_still", () -> new ForgeFlowingFluid.Source(SteamFluid.createProperties()));
    public static RegistryObject<FlowingFluid> STEAM_FLOWING = FLUIDS.register("steam_flowing", () -> new ForgeFlowingFluid.Flowing(SteamFluid.createProperties()));

    public static void register(IEventBus eventBus)
    {
        FLUIDS.register(eventBus);
    }

}
