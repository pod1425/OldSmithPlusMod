package com.streakerone.smithplusmod.block.entity.custom;

import com.streakerone.smithplusmod.block.ModBlocks;
import com.streakerone.smithplusmod.item.custom.smithing.CrucibleWithMetalBlockItem;
import com.streakerone.smithplusmod.util.variables.Contents;
import com.streakerone.smithplusmod.util.variables.temperature.Temperature;

import com.streakerone.smithplusmod.block.entity.ModBlockEntities;
import com.streakerone.smithplusmod.util.ModTags;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.lwjgl.system.CallbackI;


public class CrucibleWithMetalBlockEntity extends BlockEntity {
    private Temperature temperature;
    private Contents contents;

    //TODO: make temperature work in crucible tile entity constructor as parameter
    public CrucibleWithMetalBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CRUCIBLE_WITH_METAL_BLOCK_ENTITY.get(), blockPos, blockState);
        temperature = new Temperature(130);
        contents = new Contents(5);
    }

    public CrucibleWithMetalBlockEntity(BlockPos blockPos, BlockState blockState, Temperature temperature, Contents contents) {
        super(ModBlockEntities.CRUCIBLE_WITH_METAL_BLOCK_ENTITY.get(), blockPos, blockState);
        this.temperature = temperature;
        this.contents = contents;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public Contents getContents() {
        return contents;
    }

    private static boolean isHotBlock(Block block) {
        return Registry.BLOCK.getHolderOrThrow(Registry.BLOCK.getResourceKey(block)
                .get()).is(ModTags.Blocks.HOT_BLOCKS);
    }

    //TODO: finish tick() method
    public void tick(Level pLevel, BlockPos pPos, BlockState pState, CrucibleWithMetalBlockEntity pBlockEntity) {
        if (pLevel.nextSubTickCount() % 40 == 0 && !pLevel.isClientSide) {
            Block blockBelow = pLevel.getBlockState(pPos.below()).getBlock();
            int temp = temperature.getValue();
            if (temp != 120 && isHotBlock(blockBelow)) {
                if (temperature.getValue() > 120) {
                    temperature.coolDown();
                } else if (temperature.getValue() < 120) {
                    temperature.heatUp();
                }
            } else {
                temperature.coolDown();
            }
        }
    }

    @Override
    public void saveToItem(ItemStack itemStack) {
        CompoundTag nbtData = new CompoundTag();
        nbtData.putInt("smithplusmod.temperature", temperature.getValue());
        itemStack.setTag(nbtData);

        super.saveToItem(itemStack);
    }

    public ItemStack getItemStack(CrucibleWithMetalBlockItem crucibleItem) {
        ItemStack stack = new ItemStack(crucibleItem);
        saveToItem(stack);
        return stack;
    }
}
