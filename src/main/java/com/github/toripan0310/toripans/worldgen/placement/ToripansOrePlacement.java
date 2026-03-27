package com.github.toripan0310.toripans.worldgen.placement;

import com.github.toripan0310.toripans.ToripansMod;
import com.github.toripan0310.toripans.worldgen.features.ToripansOreFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static com.github.toripan0310.toripans.worldgen.features.ToripansOreFeatures.createKey;

public class ToripansOrePlacement {
    public static final ResourceKey<PlacedFeature> ORE_TORIPAN_JWEL =
            createKey("ore_toripan_jwel");

    public static void bootstrap(BootstapContext<PlacedFeature> context){
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures =
                context.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(context, ORE_TORIPAN_JWEL,
                configuredFeatures.getOrThrow(ToripansOreFeatures.TORIPAN_JWEL_ORE_KEY),
                commonOrePlacement(90,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(112))));
    }
    @SuppressWarnings({ "unchecked", "removal" })
    private static ResourceKey<PlacedFeature> createKey(String name){
        return ResourceKey.create(Registries.PLACED_FEATURE,
                new ResourceLocation(ToripansMod.MOD_ID, name));
    }
    private static List<PlacementModifier> orePlacement(PlacementModifier pCountPlacement, PlacementModifier pHeightRange){
        return List.of(pCountPlacement, InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }
    private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange){
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }
    private static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange){
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }
}
