package com.pixilaremedia.pixelcore.tabs;

import com.pixilaremedia.pixelcore.Ref;
import com.pixilaremedia.pixelcore.util.mixin.ItemAccessor;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.ForgeRegistries;

public class SpawnEggTab
{
    public static void spawnEggTab()
    {
        Ref.SPAWN_EGG_TAB = new CreativeModeTab("pixelcore.spawn_egg_tab")
        {
            public ItemStack makeIcon()
            {
                return new ItemStack(Items.CREEPER_SPAWN_EGG);
            }
        };

        ForgeRegistries.ITEMS.getEntries().forEach(entry -> {
            if(isSpawnEgg(entry.getValue()))
            {
                ((ItemAccessor) entry.getValue()).setCategory(Ref.SPAWN_EGG_TAB);
            }
        });
    }

    public static boolean isSpawnEgg(Item item)
    {
        boolean isSpawnEgg = item instanceof SpawnEggItem;
        return isSpawnEgg;
    }
}
