package com.eldritchhollows.Drakova.recipies;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class DrakovaRecipe {
    protected String RecipeKey = "";
    protected NamespacedKey key;
    protected JavaPlugin plugin;

    public DrakovaRecipe(JavaPlugin plugin, String recipeKey) {
        this.plugin = plugin;
        this.RecipeKey = recipeKey;
    }

    public abstract void register();

    public void UnRegister() {
        Bukkit.removeRecipe(key);
    }
}
