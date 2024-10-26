package com.eldritchhollows.eH_Drakova;

import com.eldritchhollows.eH_Drakova.commands.GiveItem;
import com.eldritchhollows.eH_Drakova.listeners.OreDropListener;
import com.eldritchhollows.eH_Drakova.listeners.cauldron.BronzeAlloyListener;
import com.eldritchhollows.eH_Drakova.recipies.BronzeIngotRecipe;
import com.eldritchhollows.eH_Drakova.recipies.Saddle;
import org.bukkit.plugin.java.JavaPlugin;

public final class EH_Drakova extends JavaPlugin  {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerCustomRecipes();
        registerListeners();
        registerCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCustomRecipes() {
        new Saddle(this).register();
        new BronzeIngotRecipe(this).register();
    }

    private void registerListeners() {
        new OreDropListener(this).register();
        new BronzeAlloyListener(this).register();
    }

    private void registerCommands() {
        this.getCommand("giveitem").setExecutor(new GiveItem(this));
    }
}
