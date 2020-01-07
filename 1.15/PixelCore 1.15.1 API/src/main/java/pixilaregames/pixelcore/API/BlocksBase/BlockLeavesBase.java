package pixilaregames.pixelcore.API.BlocksBase;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockLeavesBase extends LeavesBlock
{

	public BlockLeavesBase(Properties builder)
	{
		super(builder);
	}
	
	public void randomTick(BlockState state, World worldIn, BlockPos pos, Random random)
	{
		if (!state.get(PERSISTENT) && state.get(DISTANCE) == 7)
		{
			spawnDrops(state, worldIn, pos);
			worldIn.removeBlock(pos, false);
		}
	}
}
