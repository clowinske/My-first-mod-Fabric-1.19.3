package net.code7y7.myfirstmod;

import net.code7y7.myfirstmod.event.KeyInputHandler;
import net.code7y7.myfirstmod.networking.ModMessages;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import static net.code7y7.myfirstmod.block.ModBlocks.EGGPLANT_CROP;

public class MyFirstModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(EGGPLANT_CROP, RenderLayer.getCutout());
        KeyInputHandler.register();

        ModMessages.registerS2CPackets();
    }
}
