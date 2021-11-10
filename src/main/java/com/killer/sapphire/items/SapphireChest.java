package com.killer.sapphire.items;

import com.killer.sapphire.SapphireMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;

public class SapphireChest extends ItemArmor {
    public SapphireChest(ArmorMaterial material, int par3, int par4) {
        super(material, par3, par4);
        setCreativeTab(CreativeTabs.tabCombat);
        setUnlocalizedName("sapphire_chest");
        setTextureName(SapphireMod.MODID + ":sapphire_chest");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List list, boolean par4) {
        list.add(StatCollector.translateToLocal("sapphire_chest.desc"));
    }
}
