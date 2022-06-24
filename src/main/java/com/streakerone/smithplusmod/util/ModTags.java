package com.streakerone.smithplusmod.util;

import com.streakerone.smithplusmod.SmithPlusMod;
import com.streakerone.smithplusmod.util.variables.metal.Metals;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;


public class ModTags {
    public static final Metals METALS_LIST = new Metals();

    public static class Blocks {
        public static final TagKey<Block> HOT_BLOCKS = tag("hot_blocks");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(SmithPlusMod.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}
