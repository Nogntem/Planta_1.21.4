package net.nogntem.block.custom;


import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;


import java.util.Map;

public class BigPotPlastic extends Block implements InventoryProvider{
    public static final MapCodec<BigPotPlastic> CODEC = createCodec(BigPotPlastic::new);
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 12.0, 15.0, 12.0);


    public BigPotPlastic(Settings settings) {
        super(settings);
    }

    @Override
    protected  MapCodec<? extends Block> getCodec(){
        return CODEC;
    }
    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        return null;
    }
}



