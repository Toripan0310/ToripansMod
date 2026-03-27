package com.github.toripan0310.toripans.worldgen.biome;

import com.github.toripan0310.toripans.ToripansMod;
import com.github.toripan0310.toripans.worldgen.placement.ToripansOrePlacement;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ToripansBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_TORIPAN_JWEL_ORE =
            createKey("add_toripan_jwel_ore");

    public static void bootstrap(BootstapContext<BiomeModifier> context){
        HolderGetter<PlacedFeature> placedFeatures =
                context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TORIPAN_JWEL_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ToripansOrePlacement.ORE_TORIPAN_JWEL)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
    }

    @SuppressWarnings({ "unchecked", "removal" })
    private static ResourceKey<BiomeModifier> createKey(String name){
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
                new ResourceLocation(ToripansMod.MOD_ID, name));
    }
}
