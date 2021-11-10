package com.killer.sapphire.blocks;

import com.killer.sapphire.SapphireMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class BlockSapphireGlass extends Block {
    public BlockSapphireGlass(Material material) {
        super(material);
        setCreativeTab(SapphireMod.tabs);
        setBlockUnbreakable();
        setResistance(600000f);
        setBlockName("sapphire_glass");
        setBlockTextureName(SapphireMod.MODID + ":sapphire_glass");
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    protected boolean canSilkHarvest()
    {
        return true;
    }
}
