package com.github.toripan0310.toripans.datagen.server.loot;

import com.github.toripan0310.toripans.block.ToripansBlocks;
import com.github.toripan0310.toripans.item.ToripansItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ToripansBlockLootTables extends BlockLootSubProvider {
    protected ToripansBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.dropSelf(ToripansBlocks.TORIPAN_JWEL_BLOCK.get());
        this.add(ToripansBlocks.TORIPAN_JWEL_ORE.get(),
                block -> this.createOreDrop(block, ToripansItems.TORIPAN_JWEL.get()));
        this.add(ToripansBlocks.DEEPSLATE_TORIPAN_JWEL_ORE.get(),
                block -> this.createOreDrop(block, ToripansItems.TORIPAN_JWEL.get()));
        this.dropSelf(ToripansBlocks.TORIPAN_LOG.get());
        this.dropSelf(ToripansBlocks.STRIPPED_TORIPAN_LOG.get());
        this.dropSelf(ToripansBlocks.TORIPAN_WOOD.get());
        this.dropSelf(ToripansBlocks.STRIPPED_TORIPAN_WOOD.get());
        this.add(ToripansBlocks.TORIPAN_LEAVES.get(), block ->
                createLeavesDrops(block, ToripansBlocks.TORIPAN_JWEL_BLOCK.get(),
                        NORMAL_LEAVES_SAPLING_CHANCES));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ToripansBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
