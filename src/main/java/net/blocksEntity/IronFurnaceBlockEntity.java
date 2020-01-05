package net.blocksEntity;
import net.Prueba;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.container.Container;
import net.minecraft.container.FurnaceContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.MathHelper;


public class IronFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public IronFurnaceBlockEntity(){
          super(Prueba.IRON_FURNACE,RecipeType.SMELTING);
    }
    protected Text getContainerName() {
        return new TranslatableText("Horno de Hierro", new Object[0]);
    }

    protected int getFuelTime(ItemStack fuel) {
        return super.getFuelTime(fuel)*2;
    }

    protected int getCookTime() {
        return (Integer)this.world.getRecipeManager().getFirstMatch(this.recipeType, this, this.world).map(AbstractCookingRecipe::getCookTime).orElse(200)/10;
    }



    protected Container createContainer(int i, PlayerInventory playerInventory) {
        return new FurnaceContainer(i, playerInventory, this, this.propertyDelegate);
    }
}
