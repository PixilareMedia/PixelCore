package com.pixilaremedia.pixelcore.inventory;

import com.pixilaremedia.pixelcore.crafting.EtchingRecipe;
import com.pixilaremedia.pixelcore.init.BlockInit;
import com.pixilaremedia.pixelcore.init.MenuTypeInit;
import com.pixilaremedia.pixelcore.init.RecipeTypeInit;
import com.pixilaremedia.pixelcore.util.helpers.RecipeHelper;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.ItemHandlerHelper;

import java.util.ArrayList;
import java.util.List;

public class EtchingMenu extends AbstractContainerMenu
{
    private final ContainerLevelAccess access;
    private final DataSlot selectedRecipeIndex = DataSlot.standalone();
    private final Level level;
    private List<EtchingRecipe> recipes = new ArrayList<>();
    private ItemStack input = ItemStack.EMPTY;
    private long lastSoundTime;
    private final Slot inputSlot;
    private final Slot resultSlot;
    private Runnable slotUpdateListener = () -> {};
    private final Container inputInventory = new SimpleContainer(1) {
        @Override
        public void setChanged() {
            super.setChanged();
            slotsChanged(this);
            slotUpdateListener.run();
        }
    };
    private final ResultContainer resultContainer = new ResultContainer();

    public EtchingMenu(int id, Inventory playerInventory) {
        this(id, playerInventory, ContainerLevelAccess.NULL);
    }

    public EtchingMenu(int id, Inventory playerInventory, final ContainerLevelAccess access) {
        super(MenuTypeInit.ETCHING.get(), id);
        this.access = access;
        this.level = playerInventory.player.level;
        this.inputSlot = addSlot(new Slot(this.inputInventory, 0, 20, 33));
        this.resultSlot = addSlot(new Slot(this.resultContainer, 1, 143, 33) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player thePlayer, ItemStack stack) {
                stack.onCraftedBy(thePlayer.level, thePlayer, stack.getCount());
                resultContainer.awardUsedRecipes(thePlayer);
                ItemStack itemstack = inputSlot.remove(1);
                if (!itemstack.isEmpty()) {
                    setupResultSlot();
                }
                access.execute((world, pos) -> {
                    long l = world.getGameTime();
                    if (lastSoundTime != l) {
                        world.playSound(null, pos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1f, 1f);
                        lastSoundTime = l;
                    }
                });
                super.onTake(thePlayer, stack);
            }
        });
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int k = 0; k < 9; ++k) {
            addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
        addDataSlot(this.selectedRecipeIndex);
    }

    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }

    public List<EtchingRecipe> getRecipes() {
        return this.recipes;
    }

    public int getNumRecipes() {
        return this.recipes.size();
    }

    public boolean hasInputItem() {
        return this.inputSlot.hasItem() && !this.recipes.isEmpty();
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, BlockInit.ETCHING_TABLE.get());
    }

    @Override
    public boolean clickMenuButton(Player playerIn, int id) {
        if (isValidRecipeIndex(id)) {
            this.selectedRecipeIndex.set(id);
            setupResultSlot();
        }
        return true;
    }

    private boolean isValidRecipeIndex(int id) {
        return id >= 0 && id < this.recipes.size();
    }

    @Override
    public void slotsChanged(Container inventoryIn) {
        ItemStack stack = this.inputSlot.getItem();
        if (stack.getItem() != this.input.getItem()) {
            this.input = stack.copy();
            setupRecipeList(inventoryIn, stack);
        }
    }

    private void setupRecipeList(Container inventoryIn, ItemStack stack) {
        this.recipes.clear();
        this.selectedRecipeIndex.set(-1);
        this.resultSlot.set(ItemStack.EMPTY);
        if (!stack.isEmpty()) {
            this.recipes = RecipeHelper.getSortedMatchingRecipesEtching(this.level, inventoryIn);
        }
    }

    private void setupResultSlot() {
        if (!this.recipes.isEmpty() && isValidRecipeIndex(this.selectedRecipeIndex.get())) {
            EtchingRecipe recipe = this.recipes.get(this.selectedRecipeIndex.get());
            this.resultContainer.setRecipeUsed(recipe);
            this.resultSlot.set(recipe.assemble(this.inputInventory));
        } else {
            this.resultSlot.set(ItemStack.EMPTY);
        }
        broadcastChanges();
    }

    @Override
    public MenuType<?> getType() {
        return MenuTypeInit.ETCHING.get();
    }

    public void registerUpdateListener(Runnable runnable) {
        this.slotUpdateListener = runnable;
    }

    @Override
    public boolean canTakeItemForPickAll(ItemStack stack, Slot slotIn) {
        return slotIn.container != this.resultContainer && super.canTakeItemForPickAll(stack, slotIn);
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            Item item = itemstack1.getItem();
            stack = itemstack1.copy();
            if (index == 1) {
                item.onCraftedBy(itemstack1, playerIn.level, playerIn);
                if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(itemstack1, stack);
            } else if (index == 0) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.level.getRecipeManager().getRecipeFor(RecipeTypeInit.ETCHING, new SimpleContainer(itemstack1), this.level).isPresent()) {
                if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index < 29) {
                if (!this.moveItemStackTo(itemstack1, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index < 38 && !this.moveItemStackTo(itemstack1, 2, 29, false)) {
                return ItemStack.EMPTY;
            }
            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            }
            slot.setChanged();
            if (itemstack1.getCount() == stack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(playerIn, itemstack1);
            broadcastChanges();
        }

        return stack;
    }

    @Override
    public void removed(Player playerIn) {
        super.removed(playerIn);
        if (this.access == ContainerLevelAccess.NULL) {
            ItemStack leftStack = this.inputInventory.removeItemNoUpdate(0);
            if (!leftStack.isEmpty()) {
                ItemHandlerHelper.giveItemToPlayer(playerIn, leftStack);
            }
        } else {
            this.access.execute((world, pos) -> clearContainer(playerIn, this.inputInventory));
        }
        this.resultContainer.removeItemNoUpdate(0);
    }
}
