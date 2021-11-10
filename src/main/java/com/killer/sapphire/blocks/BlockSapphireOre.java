package com.killer.sapphire.blocks;

import com.killer.sapphire.SapphireMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSapphireOre extends Block {
    public BlockSapphireOre(Material material) {
        super(material);
        setCreativeTab(SapphireMod.tabs);
        setBlockName("sapphire_ore");
        setBlockTextureName(SapphireMod.MODID + ":sapphire_ore");
    }
}
