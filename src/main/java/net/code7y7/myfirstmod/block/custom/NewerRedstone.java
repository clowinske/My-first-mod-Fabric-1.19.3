package net.code7y7.myfirstmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NewerRedstone extends Block {
    public NewerRedstone(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof LivingEntity livingEntity){
            livingEntity.damage(DamageSource.sonicBoom(livingEntity),5f);
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            player.sendMessage(Text.literal(player.getEntityName()+" Right clicked this block!"));
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }
}
