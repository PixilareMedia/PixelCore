package com.pixilaremedia.pixelcore.compat.jei;

import com.pixilaremedia.pixelcore.Ref;
import com.pixilaremedia.pixelcore.init.BlockInit;
import com.pixilaremedia.pixelcore.init.RecipeTypeInit;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

@JeiPlugin
public class JeiCompat implements IModPlugin
{
    private static final ResourceLocation UID = Ref.location("jei_plugin");

    @Override
    public ResourceLocation getPluginUid()
    {
        return UID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration)
    {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(
                new CurrencyConversionCategory(guiHelper),
                new EtchingCategory(guiHelper)
        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        ClientLevel world = Minecraft.getInstance().level;

        if(world != null)
        {
            RecipeManager manager = world.getRecipeManager();

            registration.addRecipes(manager.byType(RecipeTypeInit.CURRENCY_CONVERSION).values(), CurrencyConversionCategory.UID);
            registration.addRecipes(manager.byType(RecipeTypeInit.ETCHING).values(), EtchingCategory.UID);
        }
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(BlockInit.CURRENCY_CONVERSION_TABLE.get()), CurrencyConversionCategory.UID);
        registration.addRecipeCatalyst(new ItemStack(BlockInit.ETCHING_TABLE.get()), EtchingCategory.UID);
    }
}
