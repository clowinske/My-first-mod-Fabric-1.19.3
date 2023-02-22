package net.code7y7.myfirstmod.block.custom;

import it.unimi.dsi.fastutil.booleans.BooleanPredicate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Lamp extends Block {
    public static final BooleanProperty LIT = BooleanProperty.of("lit");
    public Lamp(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient() && hand == Hand.MAIN_HAND && !Screen.hasShiftDown()){
            world.setBlockState(pos, state.cycle(LIT));
            player.swingHand(Hand.MAIN_HAND);
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
            builder.add(LIT);
    }
}
