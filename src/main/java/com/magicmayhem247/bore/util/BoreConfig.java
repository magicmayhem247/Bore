package com.magicmayhem247.bore.util;

import net.minecraftforge.common.ForgeConfigSpec;

public class BoreConfig
{
    public static ForgeConfigSpec.IntValue zinc_times_rarer;

    public static ForgeConfigSpec.IntValue zinc_max_vein_size;

    public static ForgeConfigSpec.IntValue zinc_max_spawn_height_overworld;

    public static ForgeConfigSpec.BooleanValue spawn_zinc_overworld;


    public static void init(ForgeConfigSpec.Builder builder)
    {
        spawn_zinc_overworld = builder
                .comment("Spawn zinc in the overworld? Default = true")
                .define("spawn_zinc_overworld", true);

        builder.pop();

        zinc_times_rarer = builder
                .defineInRange("inc_chance", 1, 1, Integer.MAX_VALUE);
        zinc_max_vein_size = builder
                .defineInRange("zinc_max_vein_size", 12, 6, 64);
        zinc_max_spawn_height_overworld = builder
                .defineInRange("zinc_max_spawn_height_overworld", 45, 1, 255);

    }
}
