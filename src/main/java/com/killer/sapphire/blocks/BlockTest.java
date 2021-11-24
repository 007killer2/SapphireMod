package com.killer.sapphire.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTest extends BlockStairs {

    public BlockTest(Block block, int meta) {
        super(block, meta);
        setCreativeTab(CreativeTabs.tabBlock);
    }
}
