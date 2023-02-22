package net.code7y7.myfirstmod.item;

import net.code7y7.myfirstmod.MyFirstMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup SUS = FabricItemGroup.builder(new Identifier(MyFirstMod.MOD_ID, "sus"))
            .displayName(Text.literal("Sus"))
            .icon(() -> new ItemStack(ModItems.CREWMATE))
            .build();

}
