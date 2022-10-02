package com.streakerone.smithplusmod.item.custom;

import com.streakerone.smithplusmod.item.ModItems;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;


public class BarkItem extends Item {
    public BarkItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        if (entity.tickCount == 200) {
            if (entity.isInWater()) {
                int amount = stack.getCount();
                entity.setItem(new ItemStack(ModItems.FIBER.get(), amount));
            }
        }
        return super.onEntityItemUpdate(stack, entity);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 150;
    }
}
