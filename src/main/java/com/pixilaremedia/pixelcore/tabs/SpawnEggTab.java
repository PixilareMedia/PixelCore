package com.pixilaremedia.pixelcore.tabs;

import com.pixilaremedia.pixelcore.util.mixin.ItemAccessor;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.ForgeRegistries;

public class SpawnEggTab extends CreativeModeTab
{
    //The Code for when Mixins Become Available to move the spawn eggs to a new tab
    /*public static CreativeModeTab SPAWN_EGG_TAB;

    public static void spawnEggTab()
    {
        SPAWN_EGG_TAB = new CreativeModeTab("spawn_egg_tab") {
            public ItemStack makeIcon() {
                return new ItemStack(Items.CREEPER_SPAWN_EGG);
            }
        };

        ForgeRegistries.ITEMS.getEntries().forEach(entry -> {
            if(isSpawnEgg(entry.getValue()))
            {
                ((ItemAccessor) entry.getValue()).setTab(SPAWN_EGG_TAB);
            }
        });
    }

    public static boolean isSpawnEgg(Item item)
    {
        boolean isSpawnEgg = item instanceof SpawnEggItem;
        return isSpawnEgg;
    }*/

    public SpawnEggTab(int length, String label) {
        super(length, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.CREEPER_SPAWN_EGG);
    }

    @Override
    public void fillItemList(NonNullList<ItemStack> items) {
        super.fillItemList(items);
        items.add(new ItemStack(Items.AXOLOTL_SPAWN_EGG));
        items.add(new ItemStack(Items.BAT_SPAWN_EGG));
        items.add(new ItemStack(Items.BEE_SPAWN_EGG));
        items.add(new ItemStack(Items.BLAZE_SPAWN_EGG));
        items.add(new ItemStack(Items.CAT_SPAWN_EGG));
        items.add(new ItemStack(Items.CAVE_SPIDER_SPAWN_EGG));
        items.add(new ItemStack(Items.CHICKEN_SPAWN_EGG));
        items.add(new ItemStack(Items.COD_SPAWN_EGG));
        items.add(new ItemStack(Items.COW_SPAWN_EGG));
        items.add(new ItemStack(Items.CREEPER_SPAWN_EGG));
        items.add(new ItemStack(Items.DOLPHIN_SPAWN_EGG));
        items.add(new ItemStack(Items.DONKEY_SPAWN_EGG));
        items.add(new ItemStack(Items.DROWNED_SPAWN_EGG));
        items.add(new ItemStack(Items.ELDER_GUARDIAN_SPAWN_EGG));
        items.add(new ItemStack(Items.ENDERMAN_SPAWN_EGG));
        items.add(new ItemStack(Items.ENDERMITE_SPAWN_EGG));
        items.add(new ItemStack(Items.EVOKER_SPAWN_EGG));
        items.add(new ItemStack(Items.FOX_SPAWN_EGG));
        items.add(new ItemStack(Items.GHAST_SPAWN_EGG));
        items.add(new ItemStack(Items.GLOW_SQUID_SPAWN_EGG));
        items.add(new ItemStack(Items.GOAT_SPAWN_EGG));
        items.add(new ItemStack(Items.GUARDIAN_SPAWN_EGG));
        items.add(new ItemStack(Items.HOGLIN_SPAWN_EGG));
        items.add(new ItemStack(Items.HORSE_SPAWN_EGG));
        items.add(new ItemStack(Items.HUSK_SPAWN_EGG));
        items.add(new ItemStack(Items.LLAMA_SPAWN_EGG));
        items.add(new ItemStack(Items.MAGMA_CUBE_SPAWN_EGG));
        items.add(new ItemStack(Items.MOOSHROOM_SPAWN_EGG));
        items.add(new ItemStack(Items.MULE_SPAWN_EGG));
        items.add(new ItemStack(Items.OCELOT_SPAWN_EGG));
        items.add(new ItemStack(Items.PANDA_SPAWN_EGG));
        items.add(new ItemStack(Items.PARROT_SPAWN_EGG));
        items.add(new ItemStack(Items.PHANTOM_SPAWN_EGG));
        items.add(new ItemStack(Items.PIG_SPAWN_EGG));
        items.add(new ItemStack(Items.PIGLIN_SPAWN_EGG));
        items.add(new ItemStack(Items.PIGLIN_BRUTE_SPAWN_EGG));
        items.add(new ItemStack(Items.PILLAGER_SPAWN_EGG));
        items.add(new ItemStack(Items.POLAR_BEAR_SPAWN_EGG));
        items.add(new ItemStack(Items.PUFFERFISH_SPAWN_EGG));
        items.add(new ItemStack(Items.RABBIT_SPAWN_EGG));
        items.add(new ItemStack(Items.RAVAGER_SPAWN_EGG));
        items.add(new ItemStack(Items.SALMON_SPAWN_EGG));
        items.add(new ItemStack(Items.SHEEP_SPAWN_EGG));
        items.add(new ItemStack(Items.SHULKER_SPAWN_EGG));
        items.add(new ItemStack(Items.SILVERFISH_SPAWN_EGG));
        items.add(new ItemStack(Items.SKELETON_SPAWN_EGG));
        items.add(new ItemStack(Items.SKELETON_HORSE_SPAWN_EGG));
        items.add(new ItemStack(Items.SLIME_SPAWN_EGG));
        items.add(new ItemStack(Items.SPIDER_SPAWN_EGG));
        items.add(new ItemStack(Items.SQUID_SPAWN_EGG));
        items.add(new ItemStack(Items.STRAY_SPAWN_EGG));
        items.add(new ItemStack(Items.STRIDER_SPAWN_EGG));
        items.add(new ItemStack(Items.TRADER_LLAMA_SPAWN_EGG));
        items.add(new ItemStack(Items.TROPICAL_FISH_SPAWN_EGG));
        items.add(new ItemStack(Items.TURTLE_SPAWN_EGG));
        items.add(new ItemStack(Items.VEX_SPAWN_EGG));
        items.add(new ItemStack(Items.VILLAGER_SPAWN_EGG));
        items.add(new ItemStack(Items.VINDICATOR_SPAWN_EGG));
        items.add(new ItemStack(Items.WANDERING_TRADER_SPAWN_EGG));
        items.add(new ItemStack(Items.WITCH_SPAWN_EGG));
        items.add(new ItemStack(Items.WITHER_SKELETON_SPAWN_EGG));
        items.add(new ItemStack(Items.WOLF_SPAWN_EGG));
        items.add(new ItemStack(Items.ZOGLIN_SPAWN_EGG));
        items.add(new ItemStack(Items.ZOMBIE_SPAWN_EGG));
        items.add(new ItemStack(Items.ZOMBIE_HORSE_SPAWN_EGG));
        items.add(new ItemStack(Items.ZOMBIE_VILLAGER_SPAWN_EGG));
        items.add(new ItemStack(Items.ZOMBIFIED_PIGLIN_SPAWN_EGG));
    }
}
