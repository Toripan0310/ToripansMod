package com.github.toripan0310.toripans.datagen.client;

import com.github.toripan0310.toripans.ToripansMod;
import com.github.toripan0310.toripans.block.ToripansBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;

public class ToripansBlockStateProvider extends BlockStateProvider {
    public ToripansBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ToripansMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ToripansBlocks.TORIPAN_JWEL_BLOCK);
        simpleBlockWithItem(ToripansBlocks.TORIPAN_JWEL_ORE);
        simpleBlockWithItem(ToripansBlocks.DEEPSLATE_TORIPAN_JWEL_ORE);

    }

    private void simpleBlockWithItem(RegistryObject<Block> block){
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
