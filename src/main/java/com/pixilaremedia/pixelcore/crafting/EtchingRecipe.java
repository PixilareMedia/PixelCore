package com.pixilaremedia.pixelcore.crafting;

import com.pixilaremedia.pixelcore.init.BlockInit;
import com.pixilaremedia.pixelcore.init.RecipeSerializerInit;
import com.pixilaremedia.pixelcore.init.RecipeTypeInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;

public class EtchingRecipe extends SingleItemRecipe
{
    public EtchingRecipe(ResourceLocation location, String group, Ingredient ingredient, ItemStack result)
    {
        super(RecipeTypeInit.ETCHING, RecipeSerializerInit.ETCHING, location, group, ingredient, result);
    }

    @Override
    public boolean matches(Container container, Level level)
    {
        return this.ingredient.test(container.getItem(0));
    }

    @Override
    public boolean isSpecial()
    {
        return true;
    }

    @Override
    public ItemStack getToastSymbol()
    {
        return new ItemStack(BlockInit.ETCHING_TABLE.get());
    }

    public Ingredient getIngredient()
    {
        return this.ingredient;
    }
}
