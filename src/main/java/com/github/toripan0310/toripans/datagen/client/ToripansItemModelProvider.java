package com.github.toripan0310.toripans.datagen.client;

import com.github.toripan0310.toripans.ToripansMod;
import com.github.toripan0310.toripans.block.ToripansBlocks;
import com.github.toripan0310.toripans.item.ToripansItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ToripansItemModelProvider extends ItemModelProvider {
    public ToripansItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, ToripansMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ToripansItems.TORIPAN_EGG.get());
        basicItem(ToripansItems.TORIPAN_JWEL.get());
        basicItem(ToripansItems.TORIPAN_MEAT.get());
        basicItem(ToripansItems.COOKED_TORIPAN_MEAT.get());
        basicItem(ToripansItems.YAKITORI.get());

        itemWithBlock(ToripansBlocks.TORIPAN_SLAB);
        itemWithBlock(ToripansBlocks.TORIPAN_STAIRS);
        itemWithBlock(ToripansBlocks.TORIPAN_FENCE_GATE);
        itemWithBlock(ToripansBlocks.TORIPAN_PRESSURE_PLATE);

        basicItem(ToripansBlocks.TORIPAN_DOOR.get().asItem());
        trapdoor(ToripansBlocks.TORIPAN_TRAPDOOR);
        fence(ToripansBlocks.TORIPAN_FENCE, ToripansBlocks.TORIPAN_PLANKS);
        button(ToripansBlocks.TORIPAN_BUTTON, ToripansBlocks.TORIPAN_PLANKS);

        sapling(ToripansBlocks.TORIPAN_SAPLING);

    }
    public void itemWithBlock(RegistryObject<Block> block) {
        this.getBuilder(ForgeRegistries.BLOCKS.getKey(block.get()).getPath())
                .parent(new ModelFile.UncheckedModelFile(
                        ToripansMod.MOD_ID + ":block/" +
                                ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void trapdoor(RegistryObject<Block> block) {
        this.getBuilder(ForgeRegistries.BLOCKS.getKey(block.get()).getPath())
                .parent(new ModelFile.UncheckedModelFile(
                        ToripansMod.MOD_ID + ":block/" +
                                ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }
    @SuppressWarnings({ "unchecked", "removal" })
    public void fence(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(ToripansMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    @SuppressWarnings({ "unchecked", "removal" })
    public void button(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(ToripansMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    @SuppressWarnings({ "unchecked", "removal" })
    private void sapling(RegistryObject<Block> block) {
        this.withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ToripansMod.MOD_ID,"block/" + block.getId().getPath()));
    }
}
