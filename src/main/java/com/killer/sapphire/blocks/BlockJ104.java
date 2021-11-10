package com.killer.sapphire.blocks;

import com.killer.sapphire.SapphireMod;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockJ104 extends Block implements ITileEntityProvider {
    public BlockJ104(Material material) {
        super(material);
        setCreativeTab(SapphireMod.tabs);
        setBlockName("j104");
        //setBlockTextureName(SapphireMod.MODID + ":BlockJ104");
    }


    @Override
    public void registerBlockIcons(IIconRegister register) {
        this.icons[0] = register.registerIcon("dispenser_front_vertical");
        this.icons[2] = register.registerIcon(SapphireMod.MODID + ":cobblestone");
        this.icons[1] = register.registerIcon(SapphireMod.MODID + ":cobblestone");
    }


    IIcon[] icons = new IIcon[3];
    @Override
    public IIcon getIcon(int side, int meta) {
        if (side == 1) return this.icons[0];
        if (side > 1) return this.icons[1];
        if (side < 1) return this.icons[2];

        return this.icons[1];
    }


    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileJ104();
    }
}
