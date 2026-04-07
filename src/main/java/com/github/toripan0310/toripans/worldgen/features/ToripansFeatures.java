package com.github.toripan0310.toripans.worldgen.features;

import com.github.toripan0310.toripans.ToripansMod;
import com.github.toripan0310.toripans.block.ToripansBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ToripansFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> TORIPAN_JWEL_ORE_KEY =
            createKey("toripan_jwel_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TORIPAN_TREE_KEY =
            createKey("toripan_tree");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){
        RuleTest stone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslate = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> toripan_jwel_ores = List.of(
                OreConfiguration.target(stone,
                        ToripansBlocks.TORIPAN_JWEL_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslate,
                        ToripansBlocks.DEEPSLATE_TORIPAN_JWEL_ORE.get().defaultBlockState())
        );

        FeatureUtils.register(context, TORIPAN_JWEL_ORE_KEY, Feature.ORE,
                new OreConfiguration(toripan_jwel_ores, 9));
        FeatureUtils.register(context, TORIPAN_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ToripansBlocks.TORIPAN_LOG.get()),
                        new StraightTrunkPlacer(5, 3, 4),
                        BlockStateProvider.simple(ToripansBlocks.TORIPAN_LEAVES.get()),
                        new BlobFoliagePlacer(ConstantInt.of(3),
                                ConstantInt.of(2), 3),
                        new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    @SuppressWarnings({ "unchecked", "removal" })
    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,
                new ResourceLocation(ToripansMod.MOD_ID, name));
    }
}
