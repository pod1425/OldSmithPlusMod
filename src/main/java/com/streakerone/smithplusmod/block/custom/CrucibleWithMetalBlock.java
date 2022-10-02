package com.streakerone.smithplusmod.block.custom;

import com.streakerone.smithplusmod.block.ModBlocks;
import com.streakerone.smithplusmod.block.entity.custom.CrucibleWithMetalBlockEntity;
import com.streakerone.smithplusmod.item.custom.smithing.CrucibleWithMetalBlockItem;
import com.streakerone.smithplusmod.util.variables.Contents;
import com.streakerone.smithplusmod.util.variables.temperature.Temperature;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeConfig;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class CrucibleWithMetalBlock extends BaseEntityBlock {
    //public static final IntegerProperty TEMPERATURE = IntegerProperty.create("temperature", 2, 250);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    //Block.box(9, 7, 7, 16, 7, 9)
    private static final VoxelShape SHAPE_SOUTH = Shapes.or(Block.box(4, 0, 1, 12, 8, 9), Block.box(7, 6, 8, 9, 7, 16));
    private static final VoxelShape SHAPE_EAST = Shapes.or(Block.box(1, 0, 4, 9, 8, 12), Block.box(8, 6, 7, 16, 7, 9));
    private static final VoxelShape SHAPE_NORTH = Shapes.or(Block.box(4, 0, 7, 12, 8, 15), Block.box(7, 6, 0, 9, 7, 7));
    private static final VoxelShape SHAPE_WEST = Shapes.or(Block.box(7, 0, 4, 15, 8, 12), Block.box(0, 6, 7, 7, 7, 9));


    public CrucibleWithMetalBlock(Properties properties) {
        super(properties);
        //this.registerDefaultState(this.stateDefinition.any().setValue(TEMPERATURE, Integer.valueOf(10)));
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState state, Entity entity) {
        if (!level.isClientSide() && entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;

            BlockEntity tile = level.getBlockEntity(blockPos);
            int temperature = ((CrucibleWithMetalBlockEntity) tile).getTemperature().getValue();
            if (temperature > 200) {
                livingEntity.hurt(new DamageSource("Very hot crucible"), 3f);
            } else if (temperature > 40) {
                livingEntity.hurt(new DamageSource("Hot crucible"), 1.2f);
            } else if (temperature > 8) {
                livingEntity.hurt(new DamageSource("Hot crucible"), 0.3f);
            }
            try {
                Player player = Minecraft.getInstance().player;
                player.sendMessage(new TextComponent(temperature + ""), player.getUUID());
            } catch (NullPointerException ignored) {
            }
        }
        super.stepOn(level, blockPos, state, entity);
    }

    @Override
    public VoxelShape getShape(BlockState bState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (bState.getValue(FACING)) {
            case SOUTH -> SHAPE_SOUTH;
            case EAST -> SHAPE_EAST;
            case WEST -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
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
        //pBuilder.add(TEMPERATURE);
        pBuilder.add(FACING);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CrucibleWithMetalBlockEntity(blockPos, blockState);
    }

    public BlockEntity newBlockEntity(BlockPos bPos, BlockState bState, Temperature temperature, Contents contents) {
        return new CrucibleWithMetalBlockEntity(bPos, bState, temperature, contents);
    }



    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return (l, pos, blockState, blockEntity) ->
                ((CrucibleWithMetalBlockEntity) blockEntity)
                        .tick(l, pos, blockState, (CrucibleWithMetalBlockEntity) blockEntity);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public int getLightEmission(BlockState bState, BlockGetter level, BlockPos bPos) {
        BlockEntity blockEntity = level.getBlockEntity(bPos);
        if (blockEntity instanceof CrucibleWithMetalBlockEntity) {
            CrucibleWithMetalBlockEntity crucibleBlockEntity =
                    (CrucibleWithMetalBlockEntity) blockEntity;
            Integer temperature = crucibleBlockEntity.getTemperature().getValue();
            if (temperature > 210) {
                return 5;
            } else if (temperature > 150) {
                return 3;
            } else if (temperature > 100) {
                return 2;
            } else if (temperature > 15) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public InteractionResult use(BlockState bState, Level level, BlockPos bPos, Player player,
                                 InteractionHand hand, BlockHitResult p_60508_) {
        if (hand == InteractionHand.MAIN_HAND && player.getMainHandItem() == ItemStack.EMPTY) {
            BlockEntity blockEntity = level.getBlockEntity(bPos);
            if (blockEntity instanceof CrucibleWithMetalBlockEntity) {
                CrucibleWithMetalBlockEntity crucibleBlockEntity =
                        (CrucibleWithMetalBlockEntity) blockEntity;

                level.removeBlock(bPos, false);
                player.setItemSlot(EquipmentSlot.MAINHAND, crucibleBlockEntity.getItemStack(
                        (CrucibleWithMetalBlockItem) bState.getBlock().asItem()));

            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos bPos, BlockState bState, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(bPos);
        if (blockEntity instanceof CrucibleWithMetalBlockEntity) {
            CrucibleWithMetalBlockEntity crucibleBlockEntity =
                    (CrucibleWithMetalBlockEntity) blockEntity;
            if (!level.isClientSide) {
                ItemStack itemstack = crucibleBlockEntity.getItemStack(
                        (CrucibleWithMetalBlockItem) bState.getBlock().asItem());

                ItemEntity itemEntity = new ItemEntity(level,
                        (double) bPos.getX() + 0.5D, (double) bPos.getY() + 0.5D, (double) bPos.getZ() + 0.5D, itemstack);
                itemEntity.setDefaultPickUpDelay();
                level.addFreshEntity(itemEntity);
            }
        }
        super.playerWillDestroy(level, bPos, bState, player);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, @Nullable LivingEntity p_49850_, ItemStack itemStack) {
        super.setPlacedBy(level, blockPos, blockState, p_49850_, itemStack);
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if(blockEntity instanceof CrucibleWithMetalBlockEntity) {
            CrucibleWithMetalBlockEntity tile = (CrucibleWithMetalBlockEntity) blockEntity;
            CrucibleWithMetalBlockItem item =
                    (CrucibleWithMetalBlockItem) itemStack.getItem();
            tile.setContents(item.getContents());
            tile.setTemperature(item.getTemperature());
        }
    }
}
