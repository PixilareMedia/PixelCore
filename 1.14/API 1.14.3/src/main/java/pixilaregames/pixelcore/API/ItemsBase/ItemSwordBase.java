package pixilaregames.pixelcore.API.ItemsBase;

import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;

public class ItemSwordBase extends SwordItem
{

	public ItemSwordBase(IItemTier teir, int attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(teir, attackDamageIn, attackSpeedIn, builder);
	}
	
}
