package com.pixilaremedia.pixelcore.util.mixin;

import com.pixilaremedia.pixelcore.Ref;
import com.pixilaremedia.pixelcore.tabs.SpawnEggTab;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CreativeModeTab.class)
public class MixinItemGroup
{
    /**
     * Fix mods that have a custom fillItemGroup implementation (to change order for example)
     * This would otherwise not remove the spawn eggs from the original creative tab
     */
    @Redirect(method = "fillItemList", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item;fillItemCategory(Lnet/minecraft/world/item/CreativeModeTab;Lnet/minecraft/core/NonNullList;)V"))
    private void fixCustomFill(Item item, CreativeModeTab itemGroup, NonNullList<ItemStack> items) {
        if (itemGroup != Ref.SPAWN_EGG_TAB && SpawnEggTab.isSpawnEgg(item)) {
            // Don't run fillItemGroup for spawn eggs in the wrong item group
            return;
        }

        // Default behaviour
        item.fillItemCategory(itemGroup, items);
    }
}
