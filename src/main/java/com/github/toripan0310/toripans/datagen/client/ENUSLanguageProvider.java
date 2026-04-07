package com.github.toripan0310.toripans.datagen.client;

import com.github.toripan0310.toripans.ToripansMod;
import com.github.toripan0310.toripans.block.ToripansBlocks;
import com.github.toripan0310.toripans.item.ToripansItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {
    public ENUSLanguageProvider(PackOutput output) {
        super(output, ToripansMod.MOD_ID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(ToripansItems.TORIPAN_EGG, "Toripan Egg");
        addItem(ToripansItems.TORIPAN_JWEL, "Toripan Jwel");
        addBlock(ToripansBlocks.TORIPAN_JWEL_BLOCK, "Toripan Jwel Block");
        addBlock(ToripansBlocks.TORIPAN_JWEL_ORE, "Toripan Jwel Ore");
        addBlock(ToripansBlocks.DEEPSLATE_TORIPAN_JWEL_ORE, "Deepslate Toripan Jwel Ore");
        addBlock(ToripansBlocks.TORIPAN_LOG, "Toripan Log");
        addBlock(ToripansBlocks.TORIPAN_WOOD, "Toripan Wood");
        addBlock(ToripansBlocks.TORIPAN_LEAVES, "Toripan Leaves");
        addBlock(ToripansBlocks.STRIPPED_TORIPAN_LOG, "Stripped Toripan Log");
        addBlock(ToripansBlocks.STRIPPED_TORIPAN_WOOD, "Stripped Toripan Wood");
        addItem(ToripansItems.TORIPAN_MEAT, "Toripan Meat");
        addItem(ToripansItems.COOKED_TORIPAN_MEAT, "Cooked Toripan Meat");
        addItem(ToripansItems.YAKITORI, "Yakitori");
        addBlock(ToripansBlocks.TORIPAN_PLANKS, "Toripan Planks");
        addBlock(ToripansBlocks.TORIPAN_PRESSURE_PLATE, "Toripan Pressure plate");
        addBlock(ToripansBlocks.TORIPAN_FENCE_GATE, "Toripan FenceGate");
        addBlock(ToripansBlocks.TORIPAN_FENCE, "Toripan Fence");
        addBlock(ToripansBlocks.TORIPAN_TRAPDOOR, "Toripan Trapdoor");
        addBlock(ToripansBlocks.TORIPAN_DOOR, "Toripan Door");
        addBlock(ToripansBlocks.TORIPAN_BUTTON, "Toripan Button");
        addBlock(ToripansBlocks.TORIPAN_SLAB, "Toripan Slab");
        addBlock(ToripansBlocks.TORIPAN_STAIRS, "Toripan Stairs");
        addBlock(ToripansBlocks.TORIPAN_SAPLING, "Toripan Sapling");


        add("creativetabs.toripan_tab", "Toripan");

    }
}
