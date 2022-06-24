package com.streakerone.smithplusmod.item.custom;

import com.streakerone.smithplusmod.util.variables.temperature.Heatable;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class CrucibleWithMetalBlockItem extends BlockItem implements Heatable {
    protected int temperature = 130;
    public static final int MIN_TEMP = 2;
    public static final int MAX_TEMP = 250;

    public CrucibleWithMetalBlockItem(Block p_40565_, Properties p_40566_) {
        super(p_40565_, p_40566_);
    }


    @Override
    public void inventoryTick(ItemStack item, Level level, Entity entity, int p_41407_, boolean p_41408_) {
        if(entity.tickCount % 40 == 0){
            setTemperature(temperature - 1);
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> pTooltipComponents, TooltipFlag tooltipFlag) {
        pTooltipComponents.add(new TranslatableComponent("tooltip.smithplusmod.crucible.temperature" + temperature + "0"));
        pTooltipComponents.add(new TranslatableComponent("tooltip.smithplusmod.crucible.contents"));
    }

    @Override
    public void setTemperature(int argTemperature) {
        temperature = checkForValidTemp(argTemperature);
    }
    @Override
    public int getTemperature() {
        return temperature;
    }

    @Override
    public void changeTemperature(int increment) {
        temperature = checkForValidTemp(temperature + increment);
    }

    private int checkForValidTemp(int temp){
        if(temp < MIN_TEMP){
            return MIN_TEMP;
        } else {
            return Math.min(temp, MAX_TEMP);
        }
    }


}
