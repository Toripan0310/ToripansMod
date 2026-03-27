package com.github.toripan0310.toripans.block.custom;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ToripansStrippableLogBlock extends ToripansLogBlock{

    private final Supplier<Block> strippedLog;

    public ToripansStrippableLogBlock(Properties pProperties, Supplier<Block> strippedLog) {
        super(pProperties);
        this.strippedLog = strippedLog;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (toolAction == ToolActions.AXE_STRIP){
            return strippedLog.get().defaultBlockState()
                    .setValue(AXIS, state.getValue(AXIS));
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
