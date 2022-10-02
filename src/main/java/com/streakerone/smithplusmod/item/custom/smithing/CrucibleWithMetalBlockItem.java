package com.streakerone.smithplusmod.item.custom.smithing;

import com.streakerone.smithplusmod.item.ModItems;
import com.streakerone.smithplusmod.util.variables.Contents;
import com.streakerone.smithplusmod.util.variables.temperature.Temperature;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class CrucibleWithMetalBlockItem extends BlockItem {
    //Temperature is basically int wrapper
    Temperature temperature;
    Contents contents;

    public CrucibleWithMetalBlockItem(Block block, Properties properties) {
        super(block, properties);
        temperature = new Temperature(130);
        contents = new Contents(5);
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            addNbtData();
        }
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

    private void addNbtData() {
        ItemStack crucible = new ItemStack(this);
        CompoundTag nbtData = new CompoundTag();
        nbtData.putInt("smithplusmod.temperature", temperature.getValue());
        crucible.setTag(nbtData);
    }

    @Override
    public void inventoryTick(ItemStack item, Level level, Entity entity, int p_41407_, boolean p_41408_) {
        if (!level.isClientSide) {
            if (entity.tickCount % 40 == 0) {
                coolDown(item);
            }
        }
    }

    public void heatUp(ItemStack item) {
        CompoundTag nbtData = new CompoundTag();
        if (item.hasTag()) {
            Temperature temp = new Temperature(item.getTag().getInt("smithplusmod.temperature"));
            temp.heatUp();
            nbtData.putInt("smithplusmod.temperature", temp.getValue());
        } else {
            nbtData.putInt("smithplusmod.temperature", temperature.getValue());
        }
        item.setTag(nbtData);
    }

    public void coolDown(ItemStack item) {
        CompoundTag nbtData = new CompoundTag();
        if (item.hasTag()) {
            Temperature temp = new Temperature(item.getTag().getInt("smithplusmod.temperature"));
            temp.coolDown();
            nbtData.putInt("smithplusmod.temperature", temp.getValue());
        } else {
            nbtData.putInt("smithplusmod.temperature", temperature.getValue());
        }
        item.setTag(nbtData);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> pTooltipComponents, TooltipFlag tooltipFlag) {
        if (itemStack.hasTag()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.smithplusmod.crucible.temperature"));
            pTooltipComponents.add(new TextComponent(itemStack.getTag().getInt("smithplusmod.temperature") + "0"));
            pTooltipComponents.add(new TranslatableComponent("tooltip.smithplusmod.crucible.contents"));
        }
    }

    //TODO: make so that if hot block under it, it heats up
    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        if (!entity.isInWater() && entity.tickCount % 200 == 0
                || entity.tickCount % 50 == 0) {
            coolDown(stack);
        }
        return super.onEntityItemUpdate(stack, entity);
    }
}
