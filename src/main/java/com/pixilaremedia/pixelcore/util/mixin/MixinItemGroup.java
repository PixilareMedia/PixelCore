package com.pixilaremedia.pixelcore.util.mixin;

import com.pixilaremedia.pixelcore.Ref;
import com.pixilaremedia.pixelcore.tabs.SpawnEggTab;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Redirect;

//@Mixin(CreativeModeTab.class)
public class MixinItemGroup
{
    /*@Redirect(method = "fill", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item;fillItemGroup(Lnet/minecraft/item/ItemGroup;Lnet/minecraft/util/NonNullList;)V"))
    private void fixCustomFill(Item item, CreativeModeTab tab, NonNullList<ItemStack> items) {
        if (tab != Ref.SPAWN_EGG_TAB && SpawnEggTab.isSpawnEgg(item)) {
            // Don't run fillItemGroup for spawn eggs in the wrong item group
            return;
        }

        // Default behaviour
        item.fillItemCategory(tab, items);
    }*/
}
