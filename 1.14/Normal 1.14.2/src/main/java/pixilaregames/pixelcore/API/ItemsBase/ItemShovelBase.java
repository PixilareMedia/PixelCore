package pixilaregames.pixelcore.API.ItemsBase;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ShovelItem;

public class ItemShovelBase extends ShovelItem
{

	public ItemShovelBase(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}
}
