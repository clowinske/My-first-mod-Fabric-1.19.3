package net.code7y7.myfirstmod;

import net.code7y7.myfirstmod.block.ModBlocks;
import net.code7y7.myfirstmod.item.ModItems;
import net.code7y7.myfirstmod.networking.ModMessages;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyFirstMod implements ModInitializer {
	public static final String MOD_ID = "myfirstmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModMessages.registerC2SPackets();
	}
}
