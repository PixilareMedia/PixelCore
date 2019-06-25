package pixilaregames.pixelcore.ItemGroups;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class CommandExclusivesItemGroup extends ItemGroup
{
	public CommandExclusivesItemGroup()
	{
		super("commandexclusives");
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(Blocks.COMMAND_BLOCK);
	}
	
	@Override
	public void fill(NonNullList<ItemStack> items)
	{
		super.fill(items);
	}
}
