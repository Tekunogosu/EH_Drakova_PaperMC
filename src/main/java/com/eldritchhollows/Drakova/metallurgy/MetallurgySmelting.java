package com.eldritchhollows.Drakova.metallurgy;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import com.eldritchhollows.Drakova.metallurgy.items.HotIronIngot;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

public class MetallurgySmelting {

    private final DrakovaPlugin plugin;

    public final NamespacedKey craftingState;

    public MetallurgySmelting(DrakovaPlugin plugin) {
        this.plugin = plugin;

        craftingState = new NamespacedKey(plugin, "craftingstate");
    }

    public void addRecipes() {

        ItemStack hotIron = HotIronIngot.create(plugin);

        NamespacedKey ironIngotKey = new NamespacedKey(plugin, DrakovaPlugin.id + "_hot_iron_ingot_from_raw");
        FurnaceRecipe ironIngotFurnaceRecipe = new FurnaceRecipe(ironIngotKey, hotIron, Material.RAW_IRON, 0.5f, 150);
        Bukkit.addRecipe(ironIngotFurnaceRecipe);

        NamespacedKey furnaceKey = new NamespacedKey(plugin, DrakovaPlugin.id + "_hot_iron_ingot_from_ingot");
        FurnaceRecipe furnaceRecipe = new FurnaceRecipe(furnaceKey, hotIron, Material.IRON_INGOT, 0.5f, 150);
        Bukkit.addRecipe(furnaceRecipe);
    }

}
