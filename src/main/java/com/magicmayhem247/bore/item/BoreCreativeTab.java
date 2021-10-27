package com.magicmayhem247.bore.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class BoreCreativeTab
{
    public static final CreativeModeTab BORE_TAB = new CreativeModeTab("boreTab")
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(BoreItems.BRASS_INGOT.get());
        }
    };
}
