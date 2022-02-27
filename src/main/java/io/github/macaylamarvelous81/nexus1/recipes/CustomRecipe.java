package io.github.macaylamarvelous81.nexus1.recipes;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public abstract class CustomRecipe {

    private final NamespacedKey recipeKey;

    public CustomRecipe(NamespacedKey key) {
        recipeKey = key;
    }

    public abstract Recipe constructRecipe();

    public NamespacedKey getRecipeKey() {
        return recipeKey;
    }

}
