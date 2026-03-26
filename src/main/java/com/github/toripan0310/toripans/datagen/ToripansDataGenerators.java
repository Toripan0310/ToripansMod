package com.github.toripan0310.toripans.datagen;

import com.github.toripan0310.toripans.ToripansMod;
import com.github.toripan0310.toripans.datagen.client.ENUSLanguageProvider;
import com.github.toripan0310.toripans.datagen.client.JAJPLanguageProvider;
import com.github.toripan0310.toripans.datagen.client.ToripansBlockStateProvider;
import com.github.toripan0310.toripans.datagen.client.ToripansItemModelProvider;
import com.github.toripan0310.toripans.datagen.server.ToripansBlockTagsProvider;
import com.github.toripan0310.toripans.datagen.server.ToripansRecipeProvider;
import com.github.toripan0310.toripans.datagen.server.loot.ToripansLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ToripansMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ToripansDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> LookUpProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new ToripansItemModelProvider(packOutput,
                existingFileHelper));
        generator.addProvider(event.includeClient(), new ToripansBlockStateProvider(packOutput,
                existingFileHelper));

        generator.addProvider(event.includeClient(), new ENUSLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new JAJPLanguageProvider(packOutput));

        generator.addProvider(event.includeServer(), new ToripansRecipeProvider(packOutput));

        generator.addProvider(event.includeServer(), ToripansLootTables.create(packOutput));

        generator.addProvider(event.includeServer(), new ToripansBlockTagsProvider(packOutput, LookUpProvider, existingFileHelper));


    }
}
