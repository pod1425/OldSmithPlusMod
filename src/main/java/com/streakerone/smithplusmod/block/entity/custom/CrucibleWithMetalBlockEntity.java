package com.streakerone.smithplusmod.block.entity.custom;

import com.streakerone.smithplusmod.util.TemperatureImpl;

import com.streakerone.smithplusmod.block.entity.ModBlockEntities;
import com.streakerone.smithplusmod.util.ModTags;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;


public class CrucibleWithMetalBlockEntity extends TemperatureImpl {

    //TODO: make temperature work in crucible tile entity constructor as parameter
    public CrucibleWithMetalBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CRUCIBLE_WITH_METAL_BLOCK_ENTITY.get(), blockPos, blockState);
        temperature = 130;
    }

    private static boolean isHotBlock(Block block) {
        return Registry.BLOCK.getHolderOrThrow(Registry.BLOCK.getResourceKey(block)
                .get()).is(ModTags.Blocks.HOT_BLOCKS);
    }

    //TODO: finish tick() method
    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, CrucibleWithMetalBlockEntity pBlockEntity) {
        if (pLevel.nextSubTickCount() % 40 == 0) {
            Block blockBelow = pLevel.getBlockState(pPos.below()).getBlock();
            int temp = pBlockEntity.getTemperature();

            pBlockEntity.setTemperature(isHotBlock(blockBelow) ? (temp > 120 ? temp - 1 : temp) : temp - 1);

            //for debugging:
            try{
                Player player = Minecraft.getInstance().player;
                player.sendMessage(new TextComponent(temp + "0"), player.getUUID());
            } catch (NullPointerException ignored){}
        }
    }


}
