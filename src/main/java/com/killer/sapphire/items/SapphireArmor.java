package com.killer.sapphire.items;

import com.killer.sapphire.SapphireMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class SapphireArmor extends ItemArmor {
    public final int id;
    public SapphireArmor(ArmorMaterial material, int id, int armorType) {
        super(material, id, armorType);
        setCreativeTab(SapphireMod.tabs);
        this.id = armorType;
        setUnlocalizedName("sapphire_helm");
        setTextureName();
        setUnlocalizedName("sapphire_armor_" + armorType);
        setTextureName(SapphireMod.MODID + ":sapphire_armor_" + armorType);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        if (this.armorType == 0) {
            list.add(StatCollector.translateToLocal("sapphire_helm.desc"));
        } else if (this.armorType == 1) {
            list.add(StatCollector.translateToLocal("sapphire_chest.desc"));
        }
    }


    private String texturePath = SapphireMod.MODID + ":textures/models/";
    public void setTextureName ()
    {
        if(armorType == 0||armorType == 1||armorType == 3){
            this.texturePath += "sapphire_armor.png";
        } else {
            this.texturePath += "sapphire_armor.png";
        }
    }

    @Override
    public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type){
        return this.texturePath;
    }

}
