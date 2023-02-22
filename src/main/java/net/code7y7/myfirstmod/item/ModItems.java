package net.code7y7.myfirstmod.item;

import net.code7y7.myfirstmod.MyFirstMod;
import net.code7y7.myfirstmod.block.ModBlocks;
import net.code7y7.myfirstmod.item.custom.EightBallItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SUSSY_AMONGUS = registerItem("sussy_amongus",
            new Item(new FabricItemSettings().maxCount(5)));
    public static final Item CREWMATE = registerItem("crewmate",
            new Item(new FabricItemSettings().maxCount(65)));
    public static final Item MOTE = registerItem("mote",
            new Item(new FabricItemSettings().maxCount(65)));
    public static final Item VEX_MYTHOCLAST = registerItem("vex_mythoclast",
            new Item(new FabricItemSettings().maxCount(1)));
    public static final Item EIGHT_BALL = registerItem("eight_ball",
            new EightBallItem(new FabricItemSettings().maxCount(1)));
    public static final Item EGGPLANT_SEEDS = registerItem("eggplant_seeds",
            new AliasedBlockItem(ModBlocks.EGGPLANT_CROP, new FabricItemSettings()));
    public static final Item EGGPLANT = registerItem("eggplant",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(4f).build())));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(MyFirstMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        MyFirstMod.LOGGER.debug("Registering Mod Items for: " + MyFirstMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SUS).register(entries -> entries.add(CREWMATE));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SUS).register(entries -> entries.add(SUSSY_AMONGUS));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SUS).register(entries -> entries.add(MOTE));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SUS).register(entries -> entries.add(VEX_MYTHOCLAST));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SUS).register(entries -> entries.add(EIGHT_BALL));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SUS).register(entries -> entries.add(EGGPLANT_SEEDS));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SUS).register(entries -> entries.add(EGGPLANT));

    }
}
