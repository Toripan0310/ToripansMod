package com.github.toripan0310.toripans.datagen.client;

import com.github.toripan0310.toripans.ToripansMod;
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
        addItem(ToripansItems.TORIPAN_EGG, "卵のtoripan");
        addItem(ToripansItems.TORIPAN_MEAT, "toripan");
        addItem(ToripansItems.COOKED_TORIPAN_MEAT, "焼きたてのtoripan");

        add("creativetabs.toripan_tab", "Toripan");

    }
}
