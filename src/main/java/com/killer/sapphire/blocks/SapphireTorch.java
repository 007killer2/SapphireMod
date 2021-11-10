package com.killer.sapphire.blocks;

import com.killer.sapphire.SapphireMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class SapphireTorch extends BlockTorch implements ITileEntityProvider {

    public SapphireTorch() {
        super();
        setCreativeTab(SapphireMod.tabs);
        setBlockName("sapphire_torch");
        setBlockTextureName(SapphireMod.MODID + ":sapphire_torch_on");
        setLightLevel(0.9375F);
    }

    public boolean canProvidePower()
    {
        return true;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 2;
    }

    @Override
    public boolean isBlockSolid(IBlockAccess p_149747_1_, int p_149747_2_, int p_149747_3_, int p_149747_4_, int p_149747_5_) {
        return true;
    }

    @Override
    public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
        return true;
    }

    @Override
    public boolean hasTileEntity(int meta) {
        return true;
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int meta) {
        TileEntity te = world.getTileEntity(x, y, z);
        TileSapphireTorch detector = (te != null && te instanceof TileSapphireTorch) ? (TileSapphireTorch) te : null;
        if (detector != null) {
            return detector.output ? 15 : 0;
        } else {
            return 0;
        }
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int meta) {
        TileEntity te = world.getTileEntity(x, y, z);
        TileSapphireTorch detector = (te != null && te instanceof TileSapphireTorch) ? (TileSapphireTorch) te : null;
        if (detector != null) {
            return detector.output ? 15 : 0;
        } else {
            return 0;
        }
    }


    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileSapphireTorch();
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        super.breakBlock(world, x, y, z, block, meta);
        world.notifyBlocksOfNeighborChange(x - 1, y, z, world.getBlock(x, y, z));
        world.notifyBlocksOfNeighborChange(x + 1, y, z, world.getBlock(x, y, z));
        world.notifyBlocksOfNeighborChange(x, y - 1, z, world.getBlock(x, y, z));
        world.notifyBlocksOfNeighborChange(x, y + 1, z, world.getBlock(x, y, z));
        world.notifyBlocksOfNeighborChange(x, y, z - 1, world.getBlock(x, y, z));
        world.notifyBlocksOfNeighborChange(x, y, z + 1, world.getBlock(x, y, z));
    }

//    @SideOnly(Side.CLIENT)
//    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
//        int l = world.getBlockMetadata(x, y, z);
//        double x0 = ((float)x + 0.5F);
//        double y1 = ((float)y + 0.7F);
//        double z2 = ((float)z + 0.5F);
//        double d3 = 0.2199999988079071D;
//        double d4 = 0.27000001072883606D;
//
//        if (l == 1) {
//            world.spawnParticle("smoke", x0 - d4, y1 + d3, z2, 0.0D, 0.0D, 0.0D);
//            world.spawnParticle("flame", x0 - d4, y1 + d3, z2, 0.0D, 0.0D, 0.0D);
//        } else if (l == 2) {
//            world.spawnParticle("smoke", x0 + d4, y1 + d3, z2, 0.0D, 0.0D, 0.0D);
//            world.spawnParticle("flame", x0 + d4, y1 + d3, z2, 0.0D, 0.0D, 0.0D);
//        } else if (l == 3) {
//            world.spawnParticle("smoke", x0, y1 + d3, z2 - d4, 0.0D, 0.0D, 0.0D);
//            world.spawnParticle("flame", x0, y1 + d3, z2 - d4, 0.0D, 0.0D, 0.0D);
//        } else if (l == 4) {
//            world.spawnParticle("smoke", x0, y1 + d3, z2 + d4, 0.0D, 0.0D, 0.0D);
//            world.spawnParticle("flame", x0, y1 + d3, z2 + d4, 0.0D, 0.0D, 0.0D);
//        } else {
//            world.spawnParticle("smoke", x0, y1, z2, 0.0D, 0.0D, 0.0D);
//            world.spawnParticle("flame", x0, y1, z2, 0.0D, 0.0D, 0.0D);
//        }
//    }
}
