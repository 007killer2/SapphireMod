package com.killer.sapphire;

import com.killer.sapphire.blocks.*;
import com.killer.sapphire.events.SapphireEvents;
import com.killer.sapphire.events.SapphireTickEvents;
import com.killer.sapphire.items.ItemSapphire;
import com.killer.sapphire.items.SapphireChest;
import com.killer.sapphire.items.SapphireHelm;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.MinecraftForge;

import java.util.Random;

import static com.killer.sapphire.SapphireMod.*;
@Mod(modid = MODID, version = VERSION, name = MODNAME)
public class SapphireMod {
    public static final String MODID = "sapphiremod";
    public static final String MODNAME = "Sapphire Mod";
    public static final String VERSION = "1.0";

    public static CreativeTabs tabs = new CreativeTabs("sapphire_tab") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(SAPPHIRE_ORE);
        }
    };

    public static final Item ITEM_SAPPHIRE = new ItemSapphire();
    public static final Item SAPPHIRE_HELM = new SapphireHelm(ItemArmor.ArmorMaterial.DIAMOND, 0, 0);
    public static final Item SAPPHIRE_CHEST = new SapphireChest(ItemArmor.ArmorMaterial.DIAMOND, 0, 1);
    public static final Block SAPPHIRE_BLOCK = new BlockSapphire(Material.rock);
    public static final Block BLOCK_J104 = new BlockJ104(Material.rock);
    public static final Block SAPPHIRE_ORE = new BlockSapphireOre(Material.rock);
    public static final Block SAPPHIRE_GLASS = new BlockSapphireGlass(Material.glass);
    public static final BlockTorch SAPPHIRE_TORCH = new SapphireTorch();

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {

        GameRegistry.registerItem(ITEM_SAPPHIRE, "sapphire");
        GameRegistry.registerItem(SAPPHIRE_HELM, "sapphire_helm");
        GameRegistry.registerItem(SAPPHIRE_CHEST, "sapphire_chest");
        GameRegistry.registerBlock(BLOCK_J104, "j104");
        GameRegistry.registerBlock(SAPPHIRE_ORE, "sapphire_ore");
        GameRegistry.registerBlock(SAPPHIRE_GLASS, "sapphire_glass");
        GameRegistry.registerBlock(SAPPHIRE_TORCH, "sapphire_torch");
        GameRegistry.registerBlock(SAPPHIRE_BLOCK, "sapphire_block");
        GameRegistry.registerTileEntity(TileSapphireTorch.class, "TileSapphireTorch");
        GameRegistry.registerTileEntity(TileJ104.class, "TileJ104");
        GameRegistry.addShapelessRecipe(new ItemStack(SAPPHIRE_GLASS, 4), new Object[] {Blocks.glass, ITEM_SAPPHIRE});
        GameRegistry.registerWorldGenerator(new IWorldGenerator() {
            @Override
            public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
                                 IChunkProvider chunkProvider) {
                if(!world.isRemote && world.provider.dimensionId == 0) {
                    int x,y,z;
                    for (int i = 0; i < 10; i++) {
                        x = chunkX*16 + random.nextInt(16) + 8;
                        z = chunkZ*16 + random.nextInt(16) + 8;
                        y = random.nextInt(64);
                        if (world.getBlock(x, y, z) == Blocks.stone) {
                            world.setBlock(x, y, z, SAPPHIRE_ORE);
                        }
                    }
                }
            }
        }, 1);
        MinecraftForge.EVENT_BUS.register(new SapphireEvents());
        FMLCommonHandler.instance().bus().register(new SapphireTickEvents());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {
    }
}
