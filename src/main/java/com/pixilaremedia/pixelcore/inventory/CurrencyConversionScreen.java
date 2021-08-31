package com.pixilaremedia.pixelcore.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.pixilaremedia.pixelcore.Ref;
import com.pixilaremedia.pixelcore.crafting.CurrencyConversionRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class CurrencyConversionScreen extends AbstractContainerScreen<CurrencyConversionMenu>
{
    private static final ResourceLocation BG_LOCATION = Ref.location("textures/gui/container/currency_conversion.png");
    private static final int SCROLLER_WIDTH = 12;
    private static final int SCROLLER_HEIGHT = 15;
    private static final int RECIPES_COLUMNS = 4;
    private static final int RECIPES_ROWS = 3;
    private static final int RECIPES_IMAGE_SIZE_WIDTH = 16;
    private static final int RECIPES_IMAGE_SIZE_HEIGHT = 18;
    private static final int SCROLLER_FULL_HEIGHT = 54;
    private static final int RECIPES_X = 52;
    private static final int RECIPES_Y = 14;
    private float scrollOffs;
    private boolean scrolling;
    private int startIndex;
    private boolean displayRecipes;

    public CurrencyConversionScreen(CurrencyConversionMenu menu, Inventory inventory, Component component)
    {
        super(menu, inventory, component);
        menu.registerUpdateListener(this::containerChanged);
        --this.titleLabelY;
    }

    public void render(PoseStack poseStack, int number, int number1, float number2)
    {
        super.render(poseStack, number, number1, number2);
        this.renderTooltip(poseStack, number, number1);
    }

    protected void renderBg(PoseStack poseStack, float number, int number2, int number3)
    {
        this.renderBackground(poseStack);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, BG_LOCATION);
        int var5 = this.leftPos;
        int var6 = this.topPos;
        this.blit(poseStack, var5, var6, 0, 0, this.imageWidth, this.imageHeight);
        int var7 = (int)(41.0F * this.scrollOffs);
        this.blit(poseStack, var5 + 119, var6 + 15 + var7, 176 + (this.isScrollBarActive() ? 0 : 12), 0, 12, 15);
        int var8 = this.leftPos + 52;
        int var9 = this.topPos + 14;
        int var10 = this.startIndex + 12;
        this.renderButtons(poseStack, number2, number3, var8, var9, var10);
        this.renderRecipes(var8, var9, var10);
    }

    protected void renderTooltip(PoseStack poseStack, int number, int number2)
    {
        super.renderTooltip(poseStack, number, number2);
        if(this.displayRecipes)
        {
            int var4 = this.leftPos + 52;
            int var5 = this.topPos + 14;
            int var6 = this.startIndex + 12;
            List<CurrencyConversionRecipe> var7 = ((CurrencyConversionMenu)this.menu).getRecipes();

            for(int var8 = this.startIndex; var8 < var6 && var8 < ((CurrencyConversionMenu)this.menu).getNumRecipes(); ++var8)
            {
                int var9 = var8 - this.startIndex;
                int var10 = var4 + var9 % 4 * 16;
                int var11 = var5 + var9 / 4 * 18 + 2;
                if(number >= var10 && number < var10 + 16 && number2 >= var11 && number2 < var11 + 18)
                {
                    this.renderTooltip(poseStack, ((CurrencyConversionRecipe)var7.get(var8)).getResultItem(), number, number2);
                }
            }
        }
    }

    private void renderButtons(PoseStack poseStack, int number, int number2, int number3, int number4, int number5)
    {
        for(int var7 = this.startIndex; var7 < number5 && var7 < ((CurrencyConversionMenu)this.menu).getNumRecipes(); ++var7)
        {
            int var8 = var7 - this.startIndex;
            int var9 = number3 + var8 % 4 * 16;
            int var10 = var8 / 4;
            int var11 = number4 + var10 * 18 + 2;
            int var12 = this.imageHeight;
            if(var7 == ((CurrencyConversionMenu)this.menu).getSelectedRecipeIndex())
            {
                var12 += 18;
            } else if(number >= var9 && number2 >= var11 && number < var9 + 16 && number2 < var11 + 18) {
                var12 += 36;
            }
            this.blit(poseStack, var9, var11 - 1, 0, var12, 16, 18);
        }
    }

    private void renderRecipes(int number, int number2, int number3)
    {
        List<CurrencyConversionRecipe> var4 = ((CurrencyConversionMenu)this.menu).getRecipes();
        for(int var5 = this.startIndex; var5 < number3 && var5 < ((CurrencyConversionMenu)this.menu).getNumRecipes(); ++var5)
        {
            int var6 = var5 - this.startIndex;
            int var7 = number + var6 % 4 * 16;
            int var8 = var6 / 4;
            int var9 = number2 + var8 * 18 + 2;
            this.minecraft.getItemRenderer().renderAndDecorateItem(((CurrencyConversionRecipe)var4.get(var5)).getResultItem(), var7, var9);
        }
    }

    public boolean mouseClicked(double number, double number2, int number3)
    {
        this.scrolling = false;
        if(this.displayRecipes)
        {
            int var6 = this.leftPos + 52;
            int var7 = this.topPos + 14;
            int var8 = this.startIndex + 12;
            for(int var9 = this.startIndex; var9 < var8; ++var9)
            {
                int var10 = var9 - this.startIndex;
                double var11 = number - (double)(var6 + var10 % 4 * 16);
                double var13 = number2 - (double)(var7 + var10 / 4 * 18);
                if(var11 >= 0.0D && var13 >= 0.0D && var11 < 16.0D && var13 < 18.0D && ((CurrencyConversionMenu)this.menu).clickMenuButton(this.minecraft.player, var9))
                {
                    Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
                    this.minecraft.gameMode.handleInventoryButtonClick(((CurrencyConversionMenu)this.menu).containerId, var9);
                    return true;
                }
            }
            var6 = this.leftPos + 119;
            var7 = this.topPos + 9;
            if(number >= (double)var6 && number < (double)(var6 + 12) && number2 >= (double)var7 && number2 < (double)(var7 + 54))
            {
                this.scrolling = true;
            }
        }
        return super.mouseClicked(number, number2, number3);
    }

    public boolean mouseDragged(double number, double number2, int number3, double number4, double number5)
    {
        if(this.scrolling && this.isScrollBarActive())
        {
            int var10 = this.topPos + 14;
            int var11 = var10 + 54;
            this.scrollOffs = ((float)number2 - (float)var10 - 7.5F) / ((float)(var11 - var10) - 15.0F);
            this.scrollOffs = Mth.clamp(this.scrollOffs, 0.0F, 1.0F);
            this.startIndex = (int)((double)(this.scrollOffs * (float)this.getOffscreenRows()) + 0.5D) * 4;
            return true;
        } else {
            return super.mouseDragged(number, number2, number3, number4, number5);
        }
    }

    public boolean mouseScrolled(double number, double number2, double number3)
    {
        if(this.isScrollBarActive())
        {
            int var7 = this.getOffscreenRows();
            this.scrollOffs = (float)((double)this.scrollOffs - number3 / (double)var7);
            this.scrollOffs = Mth.clamp(this.scrollOffs, 0.0F, 1.0F);
            this.startIndex = (int)((double)(this.scrollOffs * (float)var7) + 0.5D) * 4;
        }
        return true;
    }

    private boolean isScrollBarActive()
    {
        return this.displayRecipes && ((CurrencyConversionMenu)this.menu).getNumRecipes() > 12;
    }

    protected int getOffscreenRows()
    {
        return (((CurrencyConversionMenu)this.menu).getNumRecipes() + 4 - 1) / 4 - 3;
    }

    private void containerChanged()
    {
        this.displayRecipes = ((CurrencyConversionMenu)this.menu).hasInputItem();
        if(!this.displayRecipes)
        {
            this.scrollOffs = 0.0F;
            this.startIndex = 0;
        }
    }
}
