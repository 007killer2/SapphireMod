package com.killer.sapphire.blocks;

import com.killer.sapphire.SapphireMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSapphire extends Block {
    public BlockSapphire(Material material) {
        super(material);
        setCreativeTab(SapphireMod.tabs);
        setBlockName("sapphire_block");
        setBlockTextureName(SapphireMod.MODID + ":sapphire_block");
    }
}
