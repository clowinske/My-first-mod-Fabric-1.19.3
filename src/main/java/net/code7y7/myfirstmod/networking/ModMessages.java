package net.code7y7.myfirstmod.networking;

import net.code7y7.myfirstmod.MyFirstMod;
import net.code7y7.myfirstmod.networking.packet.ExmapleC2SPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier Test_ID = new Identifier(MyFirstMod.MOD_ID, "item_drop");
    public static final Identifier EXAMPLE_ID = new Identifier(MyFirstMod.MOD_ID, "example");


    //client to server
    public static void registerC2SPackets(){
        ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExmapleC2SPacket::receive);
    }
    //server to client
    public static void registerS2CPackets(){

    }
}
