package com.streakerone.smithplusmod.item.custom;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModLoader;

import java.util.ArrayList;
import java.util.List;

public class BladeItem extends Item {
    public BladeItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void inventoryTick(ItemStack item, Level level, Entity entity, int p_41407_, boolean p_41408_) {
        if(entity.tickCount % 20 == 0){
            for ( ItemStack _item : entity.getHandSlots()){
                if(_item.sameItem(item)){
                    entity.hurt(new DamageSource("Blade"), 2f);
                }
            }
        }
    }
}
