package io.github.macaylamarvelous81.nexus1;

import io.github.macaylamarvelous81.nexus1.recipes.*;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class RecipeRegistry {

    private static ArrayList<CustomRecipe> recipes = new ArrayList<CustomRecipe>();

    public static void loadRecipes() {
        recipes.add(new CupcakeRecipe());
        recipes.add(new PortableCraftingTableRecipe());
    }

    public static void registerRecipes() {
        Server server = Nexus1.getInstance().getServer();
        recipes.forEach((recipe) -> server.addRecipe(recipe.constructRecipe()));
    }

    public static void learnAllRecipes(Player player) {
        recipes.forEach((recipe) -> player.discoverRecipe(recipe.getRecipeKey()));
    }

}
