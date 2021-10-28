package com.magicmayhem247.bore.util;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber
public class BoreConfig
{

    public static ForgeConfigSpec.IntValue zinc_times_rarer;
    public static ForgeConfigSpec.IntValue zinc_max_vein_size;
    public static ForgeConfigSpec.IntValue zinc_max_spawn_height_overworld;

    public static ForgeConfigSpec.BooleanValue enable_server_config_sync;
    public static ForgeConfigSpec.BooleanValue send_config_sync_packet;

    public static ForgeConfigSpec.BooleanValue spawn_zinc_overworld;

    public static void init(ForgeConfigSpec.Builder builder) {


        spawn_zinc_overworld = builder
                .define("spawn_amethyst_overworld", true);

        builder.pop();

        zinc_times_rarer = builder
                .defineInRange("amethyst_chance", 3, 1, Integer.MAX_VALUE);
        zinc_max_vein_size = builder
                .defineInRange("amethyst_max_vein_size", 7, 0, 64);
        zinc_max_spawn_height_overworld = builder
                .defineInRange("amethyst_max_spawn_height_overworld", 16, 1, 255);

        builder.pop();


        builder.push("network");

        enable_server_config_sync = builder
                .define("enable_server_config_sync", true);

        send_config_sync_packet = builder
                .define("send_config_sync_packet", true);

        builder.pop();
    }
}