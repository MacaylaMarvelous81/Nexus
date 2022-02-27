package io.github.macaylamarvelous81.nexus1;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Nexus1 extends JavaPlugin {

    private static Nexus1 instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Logger logger = getLogger();
        instance = this;

        RecipeRegistry.loadRecipes();
        RecipeRegistry.registerRecipes();

        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Nexus1 getInstance() {
        return instance;
    }

}
