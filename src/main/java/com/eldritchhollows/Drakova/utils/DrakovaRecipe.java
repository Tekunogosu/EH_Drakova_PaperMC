package com.eldritchhollows.Drakova.utils;

import com.eldritchhollows.Drakova.DrakovaPlugin;

public abstract class DrakovaRecipe {
    protected DrakovaPlugin plugin;

    public DrakovaRecipe(DrakovaPlugin plugin) {
        this.plugin = plugin;
    }

    public abstract void register();

}
