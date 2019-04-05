package pixilaregames.pixelcore.ItemGroups;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

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
}
