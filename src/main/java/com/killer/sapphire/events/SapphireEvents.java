package com.killer.sapphire.events;

import com.killer.sapphire.items.SapphireChest;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class SapphireEvents {

    @SubscribeEvent
    public void onDamage(LivingHurtEvent  e) {
        if (e.entityLiving instanceof EntityPlayer) {
            if (!(e.source.getEntity() instanceof EntityLiving)) {
                EntityPlayer player = (EntityPlayer) e.entityLiving;
                if (checkChest(player) && player.isBurning()) {
                    player.setHealth(0f);
                    System.out.println("SaphireEvents.onDamage");
                }
//                if (checkHelm(player) && player.isSneaking()) {
//                    int ticks = (int) (System.currentTimeMillis() * 20 / 60);
//                    System.out.println(ticks);
//
//                }
            }
        }
    }


    public boolean checkChest(EntityPlayer player) {
        if (player.getEquipmentInSlot(3) != null && player.getEquipmentInSlot(3).getItem() instanceof SapphireChest) {
            //System.out.println("SaphireEvents.checkChest");
            return true;
        } else {
            System.out.println("SaphireEvents.checkChest2");
            return false;
        }
    }

}
