package com.magicmayhem247.bore.fluid.util;

import com.magicmayhem247.bore.Bore;
import com.magicmayhem247.bore.fluid.SteamFluid;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BoreFluids
{
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Bore.MOD_ID);

    //Steam
    public static final RegistryObject<ForgeFlowingFluid> STEAM = FLUIDS.register("steam", () -> new SteamFluid.Source());
    public static final RegistryObject<ForgeFlowingFluid> FLOWING_STEAM = FLUIDS.register("steam_flowing", () -> new SteamFluid.Flowing());

    public static void register(IEventBus eventBus)
    {
        FLUIDS.register(eventBus);
    }
}
