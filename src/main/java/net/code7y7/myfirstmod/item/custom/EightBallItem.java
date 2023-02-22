package net.code7y7.myfirstmod.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EightBallItem extends Item {
    public EightBallItem(Settings settings){
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            // output random number and add cooldown
            outputRandomNumber(user);
            user.getItemCooldownManager().set(this, 20);
        }

        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.literal("Right click to get a random number!").formatted(Formatting.AQUA));
            tooltip.add(Text.literal("Test!").formatted(Formatting.AQUA));
            tooltip.add(Text.literal("Test2").formatted(Formatting.AQUA));
        } else {
            tooltip.add(Text.literal("Press Shift for more info!").formatted(Formatting.YELLOW));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    private void outputRandomNumber(PlayerEntity player){
        player.sendMessage(Text.literal("Your numer is: "+getRandomNumber()));
    }
    private int getRandomNumber(){
        return (int)(Math.random()*10);
    }
}
