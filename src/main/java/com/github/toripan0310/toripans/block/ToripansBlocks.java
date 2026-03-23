package com.github.toripan0310.toripans.block;

import com.github.toripan0310.toripans.ToripansMod;
import com.github.toripan0310.toripans.item.ToripansItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ToripansBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ToripansMod.MOD_ID);

    public static final RegistryObject<Block> TORIPAN_JWEL_BLOCK = registerBlockItem("toripan_jwel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));

    public static final RegistryObject<Block> TORIPAN_JWEL_ORE = registerBlockItem("toripan_jwel_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE)));

    private static <T extends Block> RegistryObject<T> registerBlockItem(String name,
                                                                         Supplier<T> supplier){
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ToripansItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
