package com.magicmayhem247.bore.util;

import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

public final class BoreConfigManager
{
    public static final Common COMMON;

    public static void initialize()
    {

        register(ModConfig.Type.COMMON, BoreConfigManager.s_commonSpec);
    }

    //region internals

    private static final ForgeConfigSpec s_commonSpec;

    static
    {
        final Pair<Common, ForgeConfigSpec> pair2 = new ForgeConfigSpec.Builder().configure(Common::new);

        COMMON = pair2.getLeft();
        s_commonSpec = pair2.getRight();
    }

    private static void register(final ModConfig.Type type, final ForgeConfigSpec spec) {
        ModLoadingContext.get().registerConfig(type, spec, String.format("bore.toml", type.extension()));
    }

}
