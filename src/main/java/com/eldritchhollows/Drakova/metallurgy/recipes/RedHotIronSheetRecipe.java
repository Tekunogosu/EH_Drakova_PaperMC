package com.eldritchhollows.Drakova.metallurgy.recipes;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import com.eldritchhollows.Drakova.metallurgy.items.RedHotIronIngot;
import com.eldritchhollows.Drakova.smithing.items.RedHotIronSheet;
import com.eldritchhollows.Drakova.utils.DrakovaRecipe;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

public class RedHotIronSheetRecipe extends DrakovaRecipe {

    public RedHotIronSheetRecipe(DrakovaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void register() {
        ItemStack redhotIronIngot = RedHotIronIngot.create();
        ItemStack redhotIronSheet = RedHotIronSheet.create();

        NamespacedKey key = new NamespacedKey(plugin, DrakovaPlugin.id + "_redhot_iron_sheet_furnace_recipe");

        FurnaceRecipe furnaceRecipe = new FurnaceRecipe(key, redhotIronSheet, redhotIronSheet.getType(), 0.5f, 200);
        furnaceRecipe.setInput(redhotIronIngot.getType());
        Bukkit.addRecipe(furnaceRecipe);
    }
}
