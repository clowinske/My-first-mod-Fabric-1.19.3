package net.code7y7.myfirstmod.event;

import net.code7y7.myfirstmod.networking.ModMessages;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_FIRSTMOD = "key.category.firstmod";
    public static final String KEY_CALL_HORSE = "key.firstmod.drop_items";

    public static KeyBinding itemdropKey;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
           if(itemdropKey.wasPressed()){
               //On key pressed
               ClientPlayNetworking.send(ModMessages.EXAMPLE_ID, PacketByteBufs.create());
           }
        });
    }
    public static void register(){
        itemdropKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
           KEY_CALL_HORSE,
           InputUtil.Type.KEYSYM,
           GLFW.GLFW_KEY_H,
           KEY_CATEGORY_FIRSTMOD
        ));

        registerKeyInputs();
    }

}
