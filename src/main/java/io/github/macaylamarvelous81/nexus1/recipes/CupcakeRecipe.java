package io.github.macaylamarvelous81.nexus1.recipes;

import dev.dbassett.skullcreator.SkullCreator;
import io.github.macaylamarvelous81.nexus1.CustomItem;
import io.github.macaylamarvelous81.nexus1.Nexus1;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class CupcakeRecipe extends CustomRecipe {

    private ItemStack craftResult;

    public CupcakeRecipe() {
        super(new NamespacedKey(Nexus1.getInstance(), "cupcake"));

        ItemStack cupcake = SkullCreator.itemFromUrl("http://textures.minecraft.net/texture/574ccce88396ced37bd6160ec2fb9c897afcc4929fa0e77c1fb081336dea9e15");
        ItemMeta meta = cupcake.getItemMeta();

        meta.setDisplayName(ChatColor.RESET + "Cupcake");
        // meta.getPersistentDataContainer().set(new NamespacedKey(Nexus1.getInstance(), "itemid"), PersistentDataType.STRING, "cupcake");
        meta.getPersistentDataContainer().set(new NamespacedKey(Nexus1.getInstance(), "itemid"), PersistentDataType.INTEGER, CustomItem.CUPCAKE.getItemId());

        cupcake.setItemMeta(meta);
        craftResult = cupcake;
    }

    @Override
    public ShapelessRecipe constructRecipe() {
        /*
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Nexus1.getInstance(), "cupcake"), craftResult)
                .shape(
                        "f",
                        "b"
                )
                .setIngredient('b', Material.BREAD)
                .setIngredient('f', Material.SUGAR);
        recipe.setGroup("miscellaneous");
        */
        ShapelessRecipe recipe = new ShapelessRecipe(getRecipeKey(), craftResult)
                .addIngredient(Material.BREAD)
                .addIngredient(Material.SUGAR);
        // Recipes in the same group will show up as a single entry in the recipe book
        recipe.setGroup("nexus_item");
        return recipe;
    }

}
