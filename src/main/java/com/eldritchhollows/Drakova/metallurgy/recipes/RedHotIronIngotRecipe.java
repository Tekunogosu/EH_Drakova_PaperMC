package com.eldritchhollows.Drakova.metallurgy.recipes;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import com.eldritchhollows.Drakova.metallurgy.items.HotIronIngot;
import com.eldritchhollows.Drakova.metallurgy.items.RedHotIronIngot;
import com.eldritchhollows.Drakova.utils.DrakovaRecipe;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

public class RedHotIronIngotRecipe extends DrakovaRecipe {

    public RedHotIronIngotRecipe(DrakovaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void register() {
        ItemStack hotIronIngot = HotIronIngot.create();
        ItemStack redhotIronIngot = RedHotIronIngot.create();

        NamespacedKey key = new NamespacedKey(plugin, DrakovaPlugin.id + "_redhot_iron_ingot_furnace_recipe");

        FurnaceRecipe furnaceRecipe = new FurnaceRecipe(key, redhotIronIngot, redhotIronIngot.getType(), 0.5f, 200);
        furnaceRecipe.setInput(hotIronIngot.getType());
        Bukkit.addRecipe(furnaceRecipe);
    }


}
