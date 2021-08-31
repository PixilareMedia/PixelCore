package com.pixilaremedia.pixelcore.compat.jei;

import com.pixilaremedia.pixelcore.Ref;
import com.pixilaremedia.pixelcore.crafting.EtchingRecipe;
import com.pixilaremedia.pixelcore.init.BlockInit;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SingleItemRecipe;

public class EtchingCategory<T extends SingleItemRecipe> implements IRecipeCategory<EtchingRecipe>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation("jei", "textures/gui/gui_vanilla.png");
    public static final ResourceLocation UID = Ref.location("etching");
    private static final int WIDTH = 116, HEIGHT = 18;
    private final IDrawable background, icon;

    EtchingCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.drawableBuilder(TEXTURE, 49, 168, WIDTH, HEIGHT).addPadding(0,0,40,0).build();
        this.icon = guiHelper.createDrawableIngredient(new ItemStack(BlockInit.ETCHING_TABLE.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return this.UID;
    }

    @Override
    public Class<? extends EtchingRecipe> getRecipeClass() {
        return EtchingRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TranslatableComponent("jei.category.pixelcore.etching");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setIngredients(EtchingRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, EtchingRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup guiItemStackGroup = recipeLayout.getItemStacks();
        guiItemStackGroup.init(0, true, 40, 0);
        guiItemStackGroup.init(1, false, 98, 0);
        guiItemStackGroup.set(0, ingredients.getInputs(VanillaTypes.ITEM).get(0));
        guiItemStackGroup.set(1, ingredients.getOutputs(VanillaTypes.ITEM).get(0));
    }
}
