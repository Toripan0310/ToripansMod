package com.github.toripan0310.toripans.tag;

import com.github.toripan0310.toripans.ToripansMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ToripansTags {

    @SuppressWarnings({ "unchecked", "removal" })
    public static class Blocks{
        public static final TagKey<Block> TORIPAN_LOG = tag("toripan_log");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(ToripansMod.MOD_ID, name));
        }
    }

    @SuppressWarnings({ "unchecked", "removal" })
    public static class Items{
        public static final TagKey<Item> TORIPAN_LOG = tag("toripan_log");

        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(ToripansMod.MOD_ID, name));
        }
    }
}
