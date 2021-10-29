package com.magicmayhem247.bore.util;

import net.minecraftforge.common.ForgeConfigSpec;

public class BoreWorldGen
{
    public static ForgeConfigSpec.BooleanValue enableWorldGen;
    public static ForgeConfigSpec.BooleanValue enableWorldRegeneration;
    public static ForgeConfigSpec.IntValue userWorldGenVersion;

    public static ForgeConfigSpec.BooleanValue zincOreEnableWorldGen;
    public static ForgeConfigSpec.IntValue zincOreMaxClustersPerChunk;
    public static ForgeConfigSpec.IntValue zincOrePerCluster;
    public static ForgeConfigSpec.IntValue zincOreMaxY;

    BoreWorldGen(final ForgeConfigSpec.Builder builder)
    {
        builder.comment("Define how ores generates in the world").push("worldgen");

        this.enableWorldGen = builder
                .comment("If false, disables all world gen from Bore;",
                        "all other worldgen settings are automatically ignored.")
                .worldRestart()
                .define("enableWorldGen", true);
        this.enableWorldRegeneration = builder
                .comment("Re-run world gen in chunks that have already been generated (once they have been loaded), ",
                        "but have not been modified by Bore before.")
                .worldRestart()
                .define("enableWorldRegeneration", false);
        this.userWorldGenVersion = builder
                .comment("User-set world generation version.",
                        "Increase this by one if you want Bore to re-run world generation in already modified chunks.")
                .worldRestart()
                .defineInRange("userWorldGenVersion", 1, 0, Integer.MAX_VALUE);

        this.zincOreEnableWorldGen = builder
                .comment("Enable generation of Zinc Ore.")
                .worldRestart()
                .define("zincOreEnableWorldGen", true);

        this.zincOreMaxClustersPerChunk = builder
                .comment("Maximum number of Zinc Ore clusters per chunk.")
                .worldRestart()
                .defineInRange("zincOreMaxClustersPerChunk", 1/2, 1, 1);

        this.zincOrePerCluster = builder
                .comment("Maximum number of Zinc Ores to generate in each cluster.")
                .worldRestart()
                .defineInRange("zincOrePerCluster", 8, 1, 16);

        this.zincOreMaxY = builder
                .comment("Maximum height (Y coordinate) in the world to generate Zinc Ore.")
                .worldRestart()
                .defineInRange("zincOreMaxY", 36, 1, 256);

        builder.pop();
    }
}
