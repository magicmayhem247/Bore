package com.magicmayhem247.bore.item;

import com.magicmayhem247.bore.Bore;
import com.magicmayhem247.bore.fluid.util.BoreFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftforge.registries.RegistryObject;

public class BoreItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Bore.MOD_ID);

    //Metals
    public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", () -> new Item(new Item.Properties().tab(BoreCreativeTab.BORE_TAB)));
    public static final RegistryObject<Item> ZINC_NUGGET = ITEMS.register("zinc_nugget", () -> new Item(new Item.Properties().tab(BoreCreativeTab.BORE_TAB)));
    public static final RegistryObject<Item> ZINC_CHUNK = ITEMS.register("zinc_chunk", () -> new Item(new Item.Properties().tab(BoreCreativeTab.BORE_TAB)));

    public static final RegistryObject<Item> BRASS_INGOT = ITEMS.register("brass_ingot", () -> new Item(new Item.Properties().tab(BoreCreativeTab.BORE_TAB)));
    public static final RegistryObject<Item> BRASS_NUGGET = ITEMS.register("brass_nugget", () -> new Item(new Item.Properties().tab(BoreCreativeTab.BORE_TAB)));

    //Parts
    public static final RegistryObject<Item> RUDIMENTARY_PISTON = ITEMS.register("rudimentary_piston", () -> new Item(new Item.Properties().tab(BoreCreativeTab.BORE_TAB)));
    public static final RegistryObject<Item> BRASS_PISTON = ITEMS.register("brass_piston", () -> new Item(new Item.Properties().tab(BoreCreativeTab.BORE_TAB)));


    //Tools
    public static final RegistryObject<BucketItem> STEAM_BUCKET = ITEMS.register("steam_bucket", () -> new BucketItem(BoreFluids.STEAM, new Item.Properties().tab(BoreCreativeTab.BORE_TAB).stacksTo(1)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
