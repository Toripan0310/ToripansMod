package com.github.toripan0310.toripans.item;

import com.github.toripan0310.toripans.ToripansMod;
import com.github.toripan0310.toripans.block.ToripansBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ToripansTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ToripansMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TORIPAN_TAB = TABS.register("toripan_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetabs.toripan_tab"))
                    .icon(ToripansItems.TORIPAN_EGG.get()::getDefaultInstance)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ToripansItems.TORIPAN_EGG.get());
                        pOutput.accept(ToripansItems.TORIPAN_JWEL.get());
                        pOutput.accept(ToripansBlocks.TORIPAN_JWEL_BLOCK.get());
                        pOutput.accept(ToripansBlocks.TORIPAN_JWEL_ORE.get());
                        pOutput.accept(ToripansItems.TORIPAN_MEAT.get());
                        pOutput.accept(ToripansItems.COOKED_TORIPAN_MEAT.get());
                        pOutput.accept(ToripansItems.YAKITORI.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }
}
