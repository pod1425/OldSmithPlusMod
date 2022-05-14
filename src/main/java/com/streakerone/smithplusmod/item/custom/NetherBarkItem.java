package com.streakerone.smithplusmod.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NetherBarkItem extends Item {
    public NetherBarkItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> pTooltipComponents, TooltipFlag p_41424_) {
        if(Screen.hasShiftDown()){
            pTooltipComponents.add(new TranslatableComponent("tooltip.smithplusmod.nether_bark.tooltip_shift"));
        } else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.smithplusmod.nether_bark.tooltip"));
        }
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }

}
