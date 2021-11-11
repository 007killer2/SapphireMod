package com.killer.sapphire.events;

import com.killer.sapphire.items.SapphireArmor;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;

public class SapphireTickEvents {

    @SubscribeEvent
    public void onDamaged(TickEvent.PlayerTickEvent event) {
        if(event.player != null) {
            EntityPlayer player = event.player;
            if(!player.capabilities.isCreativeMode) {
                if(checkHelm(player) && player.isSneaking()) {
                    event.player.attackEntityFrom(DamageSource.causePlayerDamage(player), 1f);
                    //System.out.println("SaphireEvents.onDamaged");
                }
            }
        }
    }

    public boolean checkHelm(EntityPlayer player) {
        if (player.getEquipmentInSlot(4) != null && player.getEquipmentInSlot(4).getItem() instanceof SapphireArmor) {
            //System.out.println("SaphireEvents.CheckHelm");
            return true;
        } else {
            //System.out.println("SaphireEvents.CheckHelm2");
            return false;
        }
    }
}
