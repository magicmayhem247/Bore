package com.magicmayhem247.bore.block.machine;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

import javax.annotation.Nullable;
import java.util.Objects;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class RudimentaryBoilerBlock extends Block
{
    public RudimentaryBoilerBlock(Properties p_49795_)
    {
        super(p_49795_);
    }

    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
    public static final BooleanProperty PROPERTY = BooleanProperty.create("property");

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(FACING, PROPERTY);
        super.createBlockStateDefinition(builder);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        return defaultBlockState().setValue(PROPERTY, Objects.requireNonNull(context.getPlayer()).isCrouching()).setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
}

