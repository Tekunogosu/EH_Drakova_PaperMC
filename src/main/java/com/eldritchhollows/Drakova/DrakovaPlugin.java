package com.eldritchhollows.Drakova;

import com.eldritchhollows.Drakova.commands.GiveItem;
import com.eldritchhollows.Drakova.mining.listeners.OreDropListener;
import com.eldritchhollows.Drakova.recipies.SaddleRecipe;
import com.eldritchhollows.Drakova.utils.ConfigManager;
import com.eldritchhollows.Drakova.utils.DrakovaSkillsManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;

public final class DrakovaPlugin extends JavaPlugin {

    public static final String id = "drakova";

    private ConfigManager configManager;

    @Override
    public void onEnable() {

        // create the ConfigManager and initialize all the configurations (this happens in the ConfigManager);
        configManager = new ConfigManager(this);

        disableRecipes();

        // Plugin startup logic
        registerCustomRecipes();
        registerListeners();
        registerCommands();


        // All skills are registered within DrakovaSkillsManager class
        new DrakovaSkillsManager(this).register();


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /**
     * Remove base minecraft recipes so custom recipes can take priority
     */
    private void disableRecipes() {
        Iterator<Recipe> iterator = Bukkit.recipeIterator();
        while (iterator.hasNext()) {
            Recipe recipe = iterator.next();
            if (recipe instanceof ShapedRecipe shapedRecipe) {
                if (shapedRecipe.getResult().getType() == Material.IRON_CHESTPLATE) {
                    Bukkit.removeRecipe(shapedRecipe.getKey());
                    break;
                }
            }
        }
    }

    private void registerCustomRecipes() {
        new SaddleRecipe(this).register();
    }

    private void registerListeners() {
        new OreDropListener(this).register();
    }

    private void registerCommands() {
        this.getCommand("giveitem").setExecutor(new GiveItem(this));
    }

}
