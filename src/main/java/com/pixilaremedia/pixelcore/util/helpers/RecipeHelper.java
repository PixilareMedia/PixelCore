package com.pixilaremedia.pixelcore.util.helpers;

import com.pixilaremedia.pixelcore.crafting.CurrencyConversionRecipe;
import com.pixilaremedia.pixelcore.crafting.EtchingRecipe;
import com.pixilaremedia.pixelcore.init.RecipeTypeInit;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeHelper
{
    public static List<CurrencyConversionRecipe> getSortedMatchingRecipesCurrencyConversion(Level level, Container inventory)
    {
        return level.getRecipeManager().byType(RecipeTypeInit.CURRENCY_CONVERSION)
                .values().stream()
                .flatMap(recipe -> Util.toStream(RecipeTypeInit.CURRENCY_CONVERSION.tryMatch(recipe, level, inventory)))
                .sorted(recipeComparator)
                .collect(Collectors.toList());
    }
    public static List<EtchingRecipe> getSortedMatchingRecipesEtching(Level level, Container inventory)
    {
        return level.getRecipeManager().byType(RecipeTypeInit.ETCHING)
                .values().stream()
                .flatMap(recipe -> Util.toStream(RecipeTypeInit.ETCHING.tryMatch(recipe, level, inventory)))
                .sorted(recipeComparator)
                .collect(Collectors.toList());
    }

    public static final Comparator<Recipe<Container>> recipeComparator = (r1, r2) -> {
        ResourceLocation registryName1 = r1.getResultItem().getItem().getRegistryName();
        ResourceLocation registryName2 = r2.getResultItem().getItem().getRegistryName();
        assert registryName1 != null && registryName2 != null;
        String[] name1 = registryName1.getPath().split("_");
        String[] name2 = registryName2.getPath().split("_");
        int comp = name1[name1.length - 1].compareTo(name2[name2.length - 1]);
        return comp == 0 ? registryName1.compareTo(registryName2) : comp;
    };
}
