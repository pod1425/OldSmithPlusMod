package com.streakerone.smithplusmod.item.custom;

import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BladeItem extends Item {
    public BladeItem(Properties p_41383_) {
        super(p_41383_);
    }

    //TODO: figure out why it works only on player
    @Override
    public void inventoryTick(ItemStack item, Level level, Entity entity, int p_41407_, boolean p_41408_) {
        if(entity.tickCount % 20 == 0){
            if(entity instanceof LivingEntity livingEntity){
                for (ItemStack itemStack : livingEntity.getHandSlots()){
                    if(itemStack.sameItem(item)){
                        livingEntity.hurt(new DamageSource("blade"), 2f);
                    }
                }
            }
        }
    }
}
