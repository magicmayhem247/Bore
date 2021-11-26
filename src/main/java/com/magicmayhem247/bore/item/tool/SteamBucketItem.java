package com.magicmayhem247.bore.item.tool;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

public class SteamBucketItem extends BucketItem
{
    public SteamBucketItem(Supplier<? extends Fluid> supplier, Properties builder)
    {
        super(supplier, builder);
    }
}
