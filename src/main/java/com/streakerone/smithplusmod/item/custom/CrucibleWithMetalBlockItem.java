package com.streakerone.smithplusmod.item.custom;

import com.streakerone.smithplusmod.util.Temperatureable;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class CrucibleWithMetalBlockItem extends Item implements Temperatureable {
    protected int temperature = 130;
    public static final int MIN_TEMP = 2;
    public static final int MAX_TEMP = 250;

    public CrucibleWithMetalBlockItem(Properties p_41383_) {
        super(p_41383_);
    }


    @Override
    public void inventoryTick(ItemStack item, Level level, Entity entity, int p_41407_, boolean p_41408_) {
        if(entity.tickCount % 40 == 0){
            setTemperature(temperature - 1);
            for ( ItemStack _item : entity.getHandSlots()){
                if(_item.sameItem(item)){
                    entity.hurt(new DamageSource("test"), 10f);
                }
            }
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
