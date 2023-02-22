package net.code7y7.myfirstmod.block;

import net.code7y7.myfirstmod.MyFirstMod;
import net.code7y7.myfirstmod.block.custom.EggplantCropBlock;
import net.code7y7.myfirstmod.block.custom.Lamp;
import net.code7y7.myfirstmod.block.custom.NewerRedstone;
import net.code7y7.myfirstmod.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.WHEAT;

public class ModBlocks {
    public static final Block NEW_REDSTONE = registerBlock("new_redstone", new Block(FabricBlockSettings.of(Material.METAL).luminance(15).jumpVelocityMultiplier(5f).requiresTool()), ModItemGroup.SUS);

    public static final Block NEWER_REDSTONE = registerBlock("newer_redstone", new NewerRedstone(FabricBlockSettings.of(Material.METAL).requiresTool()), ModItemGroup.SUS);
    public static final Block LAMP = registerBlock("lamp", new Lamp(FabricBlockSettings.of(Material.GLASS).requiresTool().luminance(state -> state.get(Lamp.LIT) ? 15 : 0)), ModItemGroup.SUS);
    public static final Block EGGPLANT_CROP = registerBlockWithoutItem("eggplant_crop", new EggplantCropBlock(FabricBlockSettings.copy(WHEAT)));

    private static Block registerBlockWithoutItem(String name, Block block){
        return Registry.register(Registries.BLOCK, new Identifier(MyFirstMod.MOD_ID, name), block);
    }
    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registries.BLOCK, new Identifier(MyFirstMod.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registries.ITEM, new Identifier(MyFirstMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks(){
        MyFirstMod.LOGGER.debug("Registering Mod Items for: " + MyFirstMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SUS).register(entries -> entries.add(NEW_REDSTONE));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SUS).register(entries -> entries.add(NEWER_REDSTONE));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SUS).register(entries -> entries.add(LAMP));


    }
}
