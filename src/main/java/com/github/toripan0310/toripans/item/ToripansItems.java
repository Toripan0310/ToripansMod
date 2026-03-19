package com.github.toripan0310.toripans.item;

import com.github.toripan0310.toripans.ToripansMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ToripansItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ToripansMod.MOD_ID);

    public static final RegistryObject<Item> TORIPAN_EGG = ITEMS.register("toripan_egg", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TORIPAN_MEAT = ITEMS.register("toripan_meat", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COOKED_TORIPAN_MEAT = ITEMS.register("cooked_toripan_meat", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
