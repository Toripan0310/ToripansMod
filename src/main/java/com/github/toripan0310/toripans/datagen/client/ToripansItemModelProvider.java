package com.github.toripan0310.toripans.datagen.client;

import com.github.toripan0310.toripans.ToripansMod;
import com.github.toripan0310.toripans.item.ToripansItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ToripansItemModelProvider extends ItemModelProvider {
    public ToripansItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, ToripansMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ToripansItems.TORIPAN_EGG.get());
        basicItem(ToripansItems.TORIPAN_MEAT.get());
        basicItem(ToripansItems.COOKED_TORIPAN_MEAT.get());

    }
}
