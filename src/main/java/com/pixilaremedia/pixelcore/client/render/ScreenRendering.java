package com.pixilaremedia.pixelcore.client.render;

import com.pixilaremedia.pixelcore.init.MenuTypeInit;
import com.pixilaremedia.pixelcore.inventory.CurrencyConversionScreen;
import com.pixilaremedia.pixelcore.inventory.EtchingScreen;
import net.minecraft.client.gui.screens.MenuScreens;

public class ScreenRendering
{
    public static void render()
    {
        MenuScreens.register(MenuTypeInit.CURRENCY_CONVERSION.get(), CurrencyConversionScreen::new);
        MenuScreens.register(MenuTypeInit.ETCHING.get(), EtchingScreen::new);
    }
}
