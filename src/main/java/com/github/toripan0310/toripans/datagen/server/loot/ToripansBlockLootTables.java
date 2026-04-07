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
                createLeavesDrops(block, ToripansBlocks.TORIPAN_SAPLING.get(),
                        NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ToripansBlocks.TORIPAN_PLANKS.get());
        this.dropSelf(ToripansBlocks.TORIPAN_FENCE_GATE.get());
        this.dropSelf(ToripansBlocks.TORIPAN_STAIRS.get());
        this.dropSelf(ToripansBlocks.TORIPAN_FENCE.get());
        this.dropSelf(ToripansBlocks.TORIPAN_PRESSURE_PLATE.get());
        this.dropSelf(ToripansBlocks.TORIPAN_BUTTON.get());
        this.dropSelf(ToripansBlocks.TORIPAN_TRAPDOOR.get());

        this.add(ToripansBlocks.TORIPAN_SLAB.get(),
                createSlabItemTable(ToripansBlocks.TORIPAN_SLAB.get()));
        this.add(ToripansBlocks.TORIPAN_DOOR.get(),
                createDoorTable(ToripansBlocks.TORIPAN_DOOR.get()));

        this.dropSelf(ToripansBlocks.TORIPAN_SAPLING.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ToripansBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
