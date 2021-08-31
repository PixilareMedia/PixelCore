package com.pixilaremedia.pixelcore.init;

import com.pixilaremedia.pixelcore.Ref;
import com.pixilaremedia.pixelcore.inventory.CurrencyConversionMenu;
import com.pixilaremedia.pixelcore.inventory.EtchingMenu;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class MenuTypeInit
{
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Ref.MODID);

    public static final RegistryObject<MenuType<CurrencyConversionMenu>> CURRENCY_CONVERSION = MENUS.register("currency_conversion", () -> new MenuType<>(CurrencyConversionMenu::new));
    public static final RegistryObject<MenuType<EtchingMenu>> ETCHING = MENUS.register("etching", () -> new MenuType<>(EtchingMenu::new));
}
