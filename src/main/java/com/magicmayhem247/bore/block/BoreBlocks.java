package com.magicmayhem247.bore.block;

import com.magicmayhem247.bore.Bore;
import com.magicmayhem247.bore.block.machine.FiredAlloyFurnaceBlock;
import com.magicmayhem247.bore.block.machine.RudimentaryBoilerBlock;
import com.magicmayhem247.bore.fluid.util.BoreFluids;
import com.magicmayhem247.bore.fluid.util.FixedLiquidBlock;
import com.magicmayhem247.bore.item.BoreCreativeTab;
import com.magicmayhem247.bore.item.BoreItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BoreBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Bore.MOD_ID);

    //Metals
    public static final RegistryObject<Block> ZINC_BLOCK = registerBlock("zinc_block", () -> new Block(BlockBehaviour.Properties
            .of(Material.METAL).strength(6f)));
    public static final RegistryObject<Block> ZINC_ORE = registerBlock("zinc_ore", () -> new Block(BlockBehaviour.Properties
            .of(Material.METAL).strength(6f)));
    public static final RegistryObject<Block> DEEPSLATE_ZINC_ORE = registerBlock("deepslate_zinc_ore", () -> new Block(BlockBehaviour.Properties
            .of(Material.METAL).strength(6f)));

    public static final RegistryObject<Block> BRASS_BLOCK = registerBlock("brass_block", () -> new Block(BlockBehaviour.Properties
            .of(Material.METAL).strength(6f)));

    //Machines
    public static final RegistryObject<FiredAlloyFurnaceBlock> FIRED_ALLOY_FURNACE = registerBlock("fired_alloy_furnace", () -> new FiredAlloyFurnaceBlock(BlockBehaviour.Properties
            .of(Material.CLAY).strength(8f)));

    public static final RegistryObject<RudimentaryBoilerBlock> RUDIMENTARY_BOILER_BLOCK = registerBlock("rudimentary_boiler", () -> new RudimentaryBoilerBlock(BlockBehaviour.Properties
            .of(Material.METAL).strength(8f)));


    //FluidBlocks
    public static final RegistryObject<FixedLiquidBlock> STEAM = BLOCKS.register("steam", () -> new FixedLiquidBlock(BoreFluids.STEAM, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noDrops()));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        BoreItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(BoreCreativeTab.BORE_TAB)));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
