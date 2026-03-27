package com.github.toripan0310.toripans.datagen.server;

import com.github.toripan0310.toripans.block.ToripansBlocks;
import com.github.toripan0310.toripans.item.ToripansItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class ToripansRecipeProvider extends RecipeProvider {

    public ToripansRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC,
                ToripansItems.TORIPAN_JWEL.get(),
                RecipeCategory.BUILDING_BLOCKS,
                ToripansBlocks.TORIPAN_JWEL_BLOCK.get());

        SimpleCookingRecipeBuilder.blasting(
                Ingredient.of(ToripansItems.TORIPAN_MEAT.get()),
                        RecipeCategory.MISC,
                        ToripansItems.COOKED_TORIPAN_MEAT.get(),
                        0.8f,
                        100
        )
                        .unlockedBy("has_toripan_meat", has(ToripansItems.TORIPAN_MEAT.get()))
                .save(pWriter, "toripans:cooked_toripan_meat_from_blasting");

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ToripansItems.YAKITORI.get())
                .pattern(" M ")
                .pattern(" M ")
                .pattern("BM ")
                .define('B', Items.BONE)
                .define('M', ToripansItems.COOKED_TORIPAN_MEAT.get())
                .unlockedBy("has_cooked_toriapn_meat", has(ToripansItems.COOKED_TORIPAN_MEAT.get()))
                .save(pWriter);

        woodFromLogs(pWriter, ToripansBlocks.TORIPAN_WOOD.get(),
                ToripansBlocks.TORIPAN_LOG.get());
        woodFromLogs(pWriter, ToripansBlocks.STRIPPED_TORIPAN_WOOD.get(),
                ToripansBlocks.STRIPPED_TORIPAN_LOG.get());


    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                                  RecipeCategory pUnpackedCategory,
                                                  ItemLike pUnpacked,
                                                  RecipeCategory pPackedCategory,
                                                  ItemLike pPacked) {
        ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9)
                .requires(pPacked).unlockedBy(getHasName(pPacked), has(pPacked)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(pPackedCategory, pPacked).define('#', pUnpacked)
                .pattern("###").pattern("###").pattern("###")
                .unlockedBy(getHasName(pUnpacked), has(pUnpacked)).save(pFinishedRecipeConsumer);
    }
}
