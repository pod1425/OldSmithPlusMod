package com.streakerone.smithplusmod.item;

import com.streakerone.smithplusmod.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroup {
    public static final CreativeModeTab SMITH_MATERIALS = new CreativeModeTab("SmithMaterials") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.OAK_BARK.get());
        }
    };
    public static final CreativeModeTab SMITH_PARTS = new CreativeModeTab("SmithParts") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CRIMSON_STEM_BARK.get());
        }
    };
    public static final CreativeModeTab SMITH_BLOCKS = new CreativeModeTab("SmithBlocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.TIN_ORE.get());
        }
    };
}
