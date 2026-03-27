package com.github.toripan0310.toripans.datagen.server;

import com.github.toripan0310.toripans.ToripansMod;
import com.github.toripan0310.toripans.worldgen.biome.ToripansBiomeModifiers;
import com.github.toripan0310.toripans.worldgen.features.ToripansOreFeatures;
import com.github.toripan0310.toripans.worldgen.placement.ToripansOrePlacement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ToripansWorldGenProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ToripansOreFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ToripansOrePlacement::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ToripansBiomeModifiers::bootstrap);

    public ToripansWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(ToripansMod.MOD_ID));
    }
}
