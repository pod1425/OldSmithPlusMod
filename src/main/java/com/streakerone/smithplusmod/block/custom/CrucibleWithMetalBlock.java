package com.streakerone.smithplusmod.block.custom;

import com.streakerone.smithplusmod.block.entity.custom.CrucibleWithMetalBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;


public class CrucibleWithMetalBlock extends BaseEntityBlock {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    //Block.box(9, 7, 7, 16, 7, 9)
    private static final VoxelShape SHAPE_SOUTH = Shapes.or(Block.box(4, 0, 4 - 3, 12, 8, 12 - 3), Block.box(7, 6, 8, 9, 7, 16));
    private static final VoxelShape SHAPE_EAST = Shapes.or(Block.box(4 - 3, 0, 4, 12 - 3, 8, 12), Block.box(8, 6, 7, 16, 7, 9));
    private static final VoxelShape SHAPE_NORTH = Shapes.or(Block.box(4, 0, 4 + 3, 12, 8, 12 + 3), Block.box(7, 6, 0, 9, 7, 7));
    private static final VoxelShape SHAPE_WEST = Shapes.or(Block.box(4 + 3, 0, 4, 12 + 3, 8, 12), Block.box(0, 6, 7, 7, 7, 9));


    public CrucibleWithMetalBlock(Properties properties) {
        super(properties);
        //this.registerDefaultState(this.stateDefinition.any().setValue(TEMPERATURE, Integer.valueOf(10)));
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState state, Entity entity) {
        if (level.isClientSide()) {
            BlockEntity tile = level.getBlockEntity(blockPos);
            int temperature = ((CrucibleWithMetalBlockEntity) tile).temperature.getValue();
            if (temperature > 200) {
                entity.hurt(new DamageSource("Very hot crucible"), 3f);
            } else if (temperature > 40) {
                entity.hurt(new DamageSource("Hot crucible"), 1.2f);
            } else if (temperature > 8) {
                entity.hurt(new DamageSource("Hot crucible"), 0.3f);
            }
            try{
                Player player = Minecraft.getInstance().player;
                player.sendMessage(new TextComponent(temperature + ""), player.getUUID());
            } catch (NullPointerException ignored){}
        }
        super.stepOn(level, blockPos, state, entity);
    }

    @Override
    public VoxelShape getShape(BlockState bState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch ((Direction) bState.getValue(FACING)) {
            case SOUTH:
                return SHAPE_SOUTH;
            case EAST:
                return SHAPE_EAST;
            case WEST:
                return SHAPE_WEST;
            default:
                return SHAPE_NORTH;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        return this.defaultBlockState().setValue(FACING, placeContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState bState, Rotation rotation) {
        return bState.setValue(FACING, rotation.rotate(bState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState bState, Mirror mirror) {
        return bState.rotate(mirror.getRotation(bState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CrucibleWithMetalBlockEntity(blockPos, blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return (l, pos, blockState, blockEntity) ->
                ((CrucibleWithMetalBlockEntity) blockEntity).tick(l, pos, blockState, (CrucibleWithMetalBlockEntity) blockEntity);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

}
