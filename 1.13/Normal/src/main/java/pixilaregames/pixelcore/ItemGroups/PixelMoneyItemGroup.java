package pixilaregames.pixelcore.ItemGroups;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import pixilaregames.pixelcore.Lists.ItemList;

public class PixelMoneyItemGroup extends ItemGroup
{
	public PixelMoneyItemGroup()
	{
		super("pixelmoney");
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(ItemList.pixel_money_1);
	}

}
