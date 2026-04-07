package com.github.toripan0310.toripans.block;

import com.github.toripan0310.toripans.ToripansMod;
import com.github.toripan0310.toripans.block.custom.ToripansLeavesBlock;
import com.github.toripan0310.toripans.block.custom.ToripansLogBlock;
import com.github.toripan0310.toripans.block.custom.ToripansStrippableLogBlock;
import com.github.toripan0310.toripans.item.ToripansItems;
import com.github.toripan0310.toripans.worldgen.tree.ToripanTreeGrower;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
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
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE),
                    UniformInt.of(3, 7)));

    public static final RegistryObject<Block> DEEPSLATE_TORIPAN_JWEL_ORE = registerBlockItem("deepslate_toripan_jwel_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_EMERALD_ORE),
                    UniformInt.of(3, 8)));

    public static final RegistryObject<Block> STRIPPED_TORIPAN_LOG = registerBlockItem("stripped_toripan_log",
            () -> new ToripansLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_DARK_OAK_LOG).sound(SoundType.BAMBOO)));

    public static final RegistryObject<Block> STRIPPED_TORIPAN_WOOD = registerBlockItem("stripped_toripan_wood",
            () -> new ToripansLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_DARK_OAK_WOOD).sound(SoundType.BAMBOO)));

    public static final RegistryObject<Block> TORIPAN_LOG = registerBlockItem("toripan_log",
            () -> new ToripansStrippableLogBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_LOG).sound(SoundType.BAMBOO),
                    STRIPPED_TORIPAN_LOG));

    public static final RegistryObject<Block> TORIPAN_WOOD = registerBlockItem("toripan_wood",
            () -> new ToripansStrippableLogBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD).sound(SoundType.BAMBOO),
                    STRIPPED_TORIPAN_WOOD));

    public static final RegistryObject<Block> TORIPAN_LEAVES = registerBlockItem("toripan_leaves",
            () -> new ToripansLeavesBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_LEAVES)));

    public static final RegistryObject<Block> TORIPAN_PLANKS = registerBlockItem(
            "toripan_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));

    public static final RegistryObject<Block> TORIPAN_SLAB = registerBlockItem(
            "toripan_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));

    public static final RegistryObject<Block> TORIPAN_STAIRS = registerBlockItem(
            "toripan_stairs",
            () -> new StairBlock( () -> ToripansBlocks.TORIPAN_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));

    public static final RegistryObject<Block> TORIPAN_FENCE = registerBlockItem(
            "toripan_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));

    public static final RegistryObject<Block> TORIPAN_FENCE_GATE = registerBlockItem(
            "toripan_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS),
                    SoundEvents.BAMBOO_WOOD_FENCE_GATE_OPEN, SoundEvents.BAMBOO_WOOD_FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> TORIPAN_DOOR = registerBlockItem(
            "toripan_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS),
                    BlockSetType.DARK_OAK));

    public static final RegistryObject<Block> TORIPAN_TRAPDOOR = registerBlockItem(
            "toripan_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion(),
                    BlockSetType.DARK_OAK));

    public static final RegistryObject<Block> TORIPAN_BUTTON = registerBlockItem(
            "toripan_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS),
                    BlockSetType.DARK_OAK, 30, true));

    public static final RegistryObject<Block> TORIPAN_PRESSURE_PLATE = registerBlockItem(
            "toripan_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS),
                    BlockSetType.DARK_OAK));

    public static final RegistryObject<Block> TORIPAN_SAPLING = registerBlockItem("toripan_sapling",
            () -> new SaplingBlock(new ToripanTreeGrower(), BlockBehaviour.Properties.copy(Blocks.DARK_OAK_SAPLING)));


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
