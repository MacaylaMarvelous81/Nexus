package io.github.macaylamarvelous81.nexus1.recipes;

import dev.dbassett.skullcreator.SkullCreator;
import io.github.macaylamarvelous81.nexus1.CustomItem;
import io.github.macaylamarvelous81.nexus1.Nexus1;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class PortableCraftingTableRecipe extends CustomRecipe {

    private ItemStack craftResult;

    public PortableCraftingTableRecipe() {
        super(new NamespacedKey(Nexus1.getInstance(), "portable_crafting_table"));

        ItemStack craftingTable = SkullCreator.itemFromUrl("http://textures.minecraft.net/texture/2cdc0feb7001e2c10fd5066e501b87e3d64793092b85a50c856d962f8be92c78");
        ItemMeta meta = craftingTable.getItemMeta();

        meta.setDisplayName(ChatColor.RESET + "Portable Crafting Table");
        meta.getPersistentDataContainer().set(new NamespacedKey(Nexus1.getInstance(), "itemid"), PersistentDataType.INTEGER, CustomItem.PORTABLE_CRAFTING_TABLE.getItemId());

        craftingTable.setItemMeta(meta);
        craftResult = craftingTable;
    }

    @Override
    public ShapedRecipe constructRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(getRecipeKey(), craftResult)
                .shape(
                        " l ",
                        "lcl",
                        " l "
                )
                .setIngredient('l', Material.LEATHER)
                .setIngredient('c', Material.CRAFTING_TABLE);

        return recipe;
    }

}
