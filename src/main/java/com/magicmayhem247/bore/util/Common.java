package com.magicmayhem247.bore.util;

import net.minecraftforge.common.ForgeConfigSpec;

public class Common
{
    public final BoreWorldGen boreWorldGen;

    Common(final ForgeConfigSpec.Builder builder)
    {
        builder.comment("Bore Config Settings").push("boreConfig");

        this.boreWorldGen = new BoreWorldGen(builder);
    }
}
