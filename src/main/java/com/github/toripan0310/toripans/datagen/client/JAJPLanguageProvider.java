package com.github.toripan0310.toripans.datagen.client;

import com.github.toripan0310.toripans.ToripansMod;
import com.github.toripan0310.toripans.block.ToripansBlocks;
import com.github.toripan0310.toripans.item.ToripansItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class JAJPLanguageProvider extends LanguageProvider {
    public JAJPLanguageProvider(PackOutput output) {
        super(output, ToripansMod.MOD_ID, Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(ToripansItems.TORIPAN_EGG, "tori卵");
        addItem(ToripansItems.TORIPAN_JWEL, "toripan宝石");
        addBlock(ToripansBlocks.TORIPAN_JWEL_BLOCK, "toripan宝石ブロック");
        addBlock(ToripansBlocks.TORIPAN_JWEL_ORE, "toripan宝石");
        addBlock(ToripansBlocks.DEEPSLATE_TORIPAN_JWEL_ORE, "深層toripan宝石");
        addBlock(ToripansBlocks.TORIPAN_LOG, "toriの原木");
        addBlock(ToripansBlocks.TORIPAN_WOOD, "toriの木");
        addBlock(ToripansBlocks.TORIPAN_LEAVES, "Toriの葉");
        addBlock(ToripansBlocks.STRIPPED_TORIPAN_LOG, "樹皮を剥いだtoriの原木");
        addBlock(ToripansBlocks.STRIPPED_TORIPAN_WOOD, "樹皮を剥いだToriの木");
        addItem(ToripansItems.TORIPAN_MEAT, "toripan");
        addItem(ToripansItems.COOKED_TORIPAN_MEAT, "焼きたてのtoripan");
        addItem(ToripansItems.YAKITORI, "焼き鳥");

        add("creativetabs.toripan_tab", "Toripan");

    }
}
