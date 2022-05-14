package com.streakerone.smithplusmod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class FuelItem extends Item {
    private final int burnTime;

    public FuelItem(int _burnTime, Properties p_41383_) {
        super(p_41383_);
        burnTime = _burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return burnTime;
    }
}
