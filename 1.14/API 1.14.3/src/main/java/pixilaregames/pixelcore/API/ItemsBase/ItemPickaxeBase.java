package pixilaregames.pixelcore.API.ItemsBase;

import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;

public class ItemPickaxeBase extends PickaxeItem
{

	public ItemPickaxeBase(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}
}
