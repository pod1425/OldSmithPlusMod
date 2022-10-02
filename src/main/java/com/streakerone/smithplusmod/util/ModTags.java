package com.streakerone.smithplusmod.util;

import com.streakerone.smithplusmod.SmithPlusMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> HOT_BLOCKS = tagBlock("hot_blocks");
        public static final TagKey<Item> DUST = tagItem("dust");
        public static final TagKey<Item> WOODEN_PARTS = tagItem("wooden_parts");
        public static final TagKey<Item> STONE_PARTS = tagItem("stone_parts");
        public static final TagKey<Item> BRONZE_PARTS = tagItem("dust");
        public static final TagKey<Item> IRON_PARTS = tagItem("iron_parts");
        public static final TagKey<Item> STEEL_PARTS = tagItem("steel_parts");
        public static final TagKey<Item> TITANIUM_PARTS = tagItem("titanium_parts");

        public static final TagKey<Item> AXE_PARTS = tagItem("axe_parts");
        public static final TagKey<Item> SHOVEL_PARTS = tagItem("shovel_parts");
        public static final TagKey<Item> PICKAXE_PARTS = tagItem("pickaxe_parts");
        public static final TagKey<Item> HOE_PARTS = tagItem("hoe_parts");
        public static final TagKey<Item> BLADE_PARTS = tagItem("blade_parts");
        public static final TagKey<Item> GUARD_PARTS = tagItem("guard_parts");
        public static final TagKey<Item> COUNTERWEIGHT_PARTS = tagItem("counterweight_parts");


        private static TagKey<Block> tagBlock(String name) {
            return BlockTags.create(new ResourceLocation(SmithPlusMod.MOD_ID, name));
        }

        private static TagKey<Item> tagItem(String name) {
            return ItemTags.create(new ResourceLocation(SmithPlusMod.MOD_ID, name));
        }

        private static TagKey<Block> forgeTagBlock(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
        private static TagKey<Item> forgeTagItem(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
