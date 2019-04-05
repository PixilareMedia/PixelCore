package pixilaregames.pixelcore.API.ItemsBase;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemSword;

public class ItemSwordBase extends ItemSword
{

	public ItemSwordBase(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

}
