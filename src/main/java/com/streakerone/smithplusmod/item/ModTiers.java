package com.streakerone.smithplusmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier BRONZE = new ForgeTier(2, 550, 1.5f,
            2f, 15, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.TIN_INGOT.get()));
    public static final ForgeTier STEEL = new ForgeTier(3, 1561, 8.0f,
            3.0f, 10, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.TIN_INGOT.get()));
    public static final ForgeTier FLINT = new ForgeTier(1, 329, 6.5f,
            2.5f, 8, BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.FLINT));
    public static final ForgeTier KATANA_TIER = new ForgeTier(3, 180, 8.0f,
            3.0f, 10, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.IRON_INGOT));
}
