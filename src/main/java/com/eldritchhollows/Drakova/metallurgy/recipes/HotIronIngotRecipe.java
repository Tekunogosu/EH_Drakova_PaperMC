package com.eldritchhollows.Drakova.metallurgy.recipes;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import com.eldritchhollows.Drakova.metallurgy.items.HotIronIngot;
import com.eldritchhollows.Drakova.utils.DrakovaRecipe;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

public class HotIronIngotRecipe extends DrakovaRecipe {

    public HotIronIngotRecipe(DrakovaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void register() {
        ItemStack hotIron = HotIronIngot.create();

        NamespacedKey ironIngotKey = new NamespacedKey(plugin, DrakovaPlugin.id + "_hot_iron_ingot_from_raw");
        FurnaceRecipe ironIngotFurnaceRecipe = new FurnaceRecipe(ironIngotKey, hotIron, Material.RAW_IRON, 0.5f, 150);
        Bukkit.addRecipe(ironIngotFurnaceRecipe);

        NamespacedKey furnaceKey = new NamespacedKey(plugin, DrakovaPlugin.id + "_hot_iron_ingot_from_ingot");
        FurnaceRecipe furnaceRecipe = new FurnaceRecipe(furnaceKey, hotIron, Material.IRON_INGOT, 0.5f, 150);
        Bukkit.addRecipe(furnaceRecipe);
    }
}
