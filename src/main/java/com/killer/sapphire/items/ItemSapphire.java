package com.killer.sapphire.items;

import com.killer.sapphire.SapphireMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemSapphire extends Item {
    public ItemSapphire() {
        super();
        setCreativeTab(SapphireMod.tabs);
        setUnlocalizedName("sapphire");
        setTextureName(SapphireMod.MODID + ":sapphire");
    }
}
