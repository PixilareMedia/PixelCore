package pixilaregames.pixelcore.ItemGroups;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
		
		items.add(new ItemStack(Items.COMMAND_BLOCK));
		items.add(new ItemStack(Items.CHAIN_COMMAND_BLOCK));
		items.add(new ItemStack(Items.REPEATING_COMMAND_BLOCK));
		items.add(new ItemStack(Items.COMMAND_BLOCK_MINECART));
		items.add(new ItemStack(Items.BARRIER));
		items.add(new ItemStack(Items.STRUCTURE_BLOCK));
		items.add(new ItemStack(Items.STRUCTURE_VOID));
		items.add(new ItemStack(Items.JIGSAW));
		items.add(new ItemStack(Items.DEBUG_STICK));
		items.add(new ItemStack(Items.SPAWNER));
		items.add(new ItemStack(Items.DRAGON_EGG));
		items.add(new ItemStack(Items.KNOWLEDGE_BOOK));
		items.add(new ItemStack(Blocks.NETHER_PORTAL));
	}
}
