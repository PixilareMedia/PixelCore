package pixilaregames.pixelcore.API.ItemsBase;

import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemElytraBase extends ElytraItem
{
	   public ItemElytraBase(Item.Properties builder) {
		      super(builder);
		      this.addPropertyOverride(new ResourceLocation("broken"), (p_210312_0_, p_210312_1_, p_210312_2_) -> {
		         return isUsable(p_210312_0_) ? 0.0F : 1.0F;
		      });
		      DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
		   }

		   public static boolean isUsable(ItemStack stack) {
		      return stack.getDamage() < stack.getMaxDamage() - 1;
		   }

		   /**
		    * Return whether this item is repairable in an anvil.
		    */
		   public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		      return repair.getItem() == Items.PHANTOM_MEMBRANE;
		   }

		   /**
		    * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
		    * {@link #onItemUse}.
		    */
		   public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		      ItemStack itemstack = playerIn.getHeldItem(handIn);
		      EquipmentSlotType equipmentslottype = MobEntity.getSlotForItemStack(itemstack);
		      ItemStack itemstack1 = playerIn.getItemStackFromSlot(equipmentslottype);
		      if (itemstack1.isEmpty()) {
		         playerIn.setItemStackToSlot(equipmentslottype, itemstack.copy());
		         itemstack.setCount(0);
		         return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
		      } else {
		         return new ActionResult<>(ActionResultType.FAIL, itemstack);
		      }
		   }
}
