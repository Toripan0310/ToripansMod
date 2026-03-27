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
        addItem(ToripansItems.TORIPAN_MEAT, "Toripan Meat");
        addItem(ToripansItems.COOKED_TORIPAN_MEAT, "Cooked Toripan Meat");
        addItem(ToripansItems.YAKITORI, "Yakitori");


        add("creativetabs.toripan_tab", "Toripan");

    }
}
