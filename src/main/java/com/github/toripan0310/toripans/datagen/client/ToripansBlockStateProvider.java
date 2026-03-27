package com.github.toripan0310.toripans.datagen.client;

import com.github.toripan0310.toripans.ToripansMod;
import com.github.toripan0310.toripans.block.ToripansBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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

        logBlock((RotatedPillarBlock) ToripansBlocks.TORIPAN_LOG.get());
        logBlock((RotatedPillarBlock) ToripansBlocks.STRIPPED_TORIPAN_LOG.get());
        axisBlock((RotatedPillarBlock) ToripansBlocks.TORIPAN_WOOD.get(),
                blockTexture(ToripansBlocks.TORIPAN_LOG.get()),
                blockTexture(ToripansBlocks.TORIPAN_LOG.get()));
        axisBlock((RotatedPillarBlock) ToripansBlocks.STRIPPED_TORIPAN_WOOD.get(),
                blockTexture(ToripansBlocks.STRIPPED_TORIPAN_LOG.get()),
                blockTexture(ToripansBlocks.STRIPPED_TORIPAN_LOG.get()));
        item(ToripansBlocks.TORIPAN_LOG);
        item(ToripansBlocks.STRIPPED_TORIPAN_LOG);
        item(ToripansBlocks.TORIPAN_WOOD);
        item(ToripansBlocks.STRIPPED_TORIPAN_WOOD);
        simpleLeaves(ToripansBlocks.TORIPAN_LEAVES);

    }

    private void simpleBlockWithItem(RegistryObject<Block> block){
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    private void item(RegistryObject<Block> block) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(
                ToripansMod.MOD_ID + ":block/" +
                        ForgeRegistries.BLOCKS.getKey(block.get()).getPath()
        ));
    }

    @SuppressWarnings({ "unchecked", "removal" })
    private void simpleLeaves(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), models().singleTexture(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                new ResourceLocation("minecraft:block/leaves"),
                "all", blockTexture(block.get())).renderType("cutout"));
    }




}
