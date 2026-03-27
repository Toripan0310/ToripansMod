package com.github.toripan0310.toripans.datagen.server;

import com.github.toripan0310.toripans.ToripansMod;
import com.github.toripan0310.toripans.block.ToripansBlocks;
import com.github.toripan0310.toripans.tag.ToripansTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ToripansBlockTagsProvider extends BlockTagsProvider {
    public ToripansBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ToripansMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ToripansBlocks.TORIPAN_JWEL_BLOCK.get(),
                        ToripansBlocks.TORIPAN_JWEL_ORE.get(),
                        ToripansBlocks.DEEPSLATE_TORIPAN_JWEL_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ToripansBlocks.TORIPAN_JWEL_BLOCK.get(),
                        ToripansBlocks.TORIPAN_JWEL_ORE.get(),
                        ToripansBlocks.DEEPSLATE_TORIPAN_JWEL_ORE.get());

        this.tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(ToripansBlocks.TORIPAN_JWEL_BLOCK.get());

        this.tag(ToripansTags.Blocks.TORIPAN_LOG)
                .add(ToripansBlocks.TORIPAN_LOG.get())
                .add(ToripansBlocks.STRIPPED_TORIPAN_LOG.get())
                .add(ToripansBlocks.TORIPAN_WOOD.get())
                .add(ToripansBlocks.STRIPPED_TORIPAN_WOOD.get());

        this.tag(BlockTags.LOGS)
                .add(ToripansBlocks.TORIPAN_LOG.get())
                .add(ToripansBlocks.STRIPPED_TORIPAN_LOG.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ToripansBlocks.TORIPAN_LOG.get())
                .add(ToripansBlocks.STRIPPED_TORIPAN_LOG.get())
                .add(ToripansBlocks.TORIPAN_WOOD.get())
                .add(ToripansBlocks.STRIPPED_TORIPAN_WOOD.get());

        this.tag(BlockTags.LEAVES)
                .add(ToripansBlocks.TORIPAN_LEAVES.get());
    }
}
