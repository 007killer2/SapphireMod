package com.killer.sapphire.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileJ104 extends TileEntity {
    public int timer;
    public int ticks;
    @Override
    public void updateEntity() {
        if (worldObj.isRemote) return;

        //System.out.println("ticks = " + ticks);
        //System.out.println("timer = " + timer);
        if (++ticks >= 100) {
            worldObj.setBlock(xCoord, yCoord + 1, zCoord, Blocks.fire);
            ticks = 0;
            if (++timer >= 5) {
                worldObj.setBlock(xCoord, yCoord + 1, zCoord, Blocks.air);
                timer = 0;
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        writeCustomNBT(tag);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        readCustomNBT(tag);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeCustomNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, -999, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        super.onDataPacket(net, packet);
        readCustomNBT(packet.func_148857_g());
    }

    public void readCustomNBT(NBTTagCompound tag) {
        this.ticks = tag.getInteger("Ticks");
        this.timer = tag.getShort("Timer");
    }


    public void writeCustomNBT(NBTTagCompound tag) {
        tag.setInteger("Ticks", this.ticks);
        tag.setInteger("Timer",  this.timer);
    }
}
