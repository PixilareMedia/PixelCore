package pixilaregames.pixelcore.ItemGroups;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WIPItemGroup extends ItemGroup
{
	
	public WIPItemGroup()
	{
		super("wip");
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(Blocks.BARRIER);
	}

}
