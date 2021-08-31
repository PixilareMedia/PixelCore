package com.pixilaremedia.pixelcore.init;

import com.pixilaremedia.pixelcore.Ref;
import com.pixilaremedia.pixelcore.crafting.CurrencyConversionRecipe;
import com.pixilaremedia.pixelcore.crafting.EtchingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public class RecipeTypeInit
{
    public static final RecipeType<CurrencyConversionRecipe> CURRENCY_CONVERSION = registerRecipeType("currency_conversion");
    public static final RecipeType<EtchingRecipe> ETCHING = registerRecipeType("etching");

    private static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String name) {
        return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(Ref.MODID, name), new RecipeType<T>() {
            public String toString() {
                return Ref.MODID + ":" + name;
            }
        });
    }
}
