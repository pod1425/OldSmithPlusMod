package com.streakerone.smithplusmod.block.custom;

import com.streakerone.smithplusmod.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CrucibleBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 8, 12);

    public CrucibleBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState bState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext){
        return SHAPE;
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext){
        return this.defaultBlockState().setValue(FACING, placeContext.getHorizontalDirection().getOpposite());
    }
    @Override
    public BlockState rotate(BlockState bState, Rotation rotation){
        return bState.setValue(FACING, rotation.rotate(bState.getValue(FACING)));
    }
    @Override
    public BlockState mirror(BlockState bState, Mirror mirror){
        return bState.rotate(mirror.getRotation(bState.getValue(FACING)));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder){
        pBuilder.add(FACING);
    }

}
