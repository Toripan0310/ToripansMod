package com.github.toripan0310.toripans.item;

import com.github.toripan0310.toripans.ToripansMod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ToripansItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ToripansMod.MOD_ID);

    public static final RegistryObject<Item> TORIPAN_EGG = ITEMS.register("toripan_egg", () -> new Item(new Item.Properties()
            .stacksTo(16)
            .fireResistant()));

    public static final RegistryObject<Item> TORIPAN_JWEL = ITEMS.register("toripan_jwel", () -> new Item(new Item.Properties()
            .fireResistant()));

    public static final RegistryObject<Item> TORIPAN_MEAT = ITEMS.register("toripan_meat", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.5f)
                    .build())
            .fireResistant()));

    public static final RegistryObject<Item> COOKED_TORIPAN_MEAT = ITEMS.register("cooked_toripan_meat", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(7)
                    .saturationMod(0.5f)
                    .effect( () -> new MobEffectInstance(MobEffects.GLOWING, 150, 0),10f)
                    .build())
            .fireResistant()));


    public static final RegistryObject<Item> YAKITORI = ITEMS.register("yakitori", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(21)
                    .saturationMod(0.7f)
                    .effect( () -> new MobEffectInstance(MobEffects.REGENERATION, 10, 0), 100f)
                    .build())
            .fireResistant()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
