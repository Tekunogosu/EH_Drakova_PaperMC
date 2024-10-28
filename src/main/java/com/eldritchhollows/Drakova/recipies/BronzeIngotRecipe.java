package com.eldritchhollows.Drakova.recipies;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import com.eldritchhollows.Drakova.items.BronzeAlloy;
import com.eldritchhollows.Drakova.items.BronzeIngot;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.BlastingRecipe;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

public class BronzeIngotRecipe {
    public final DrakovaPlugin plugin;

    public BronzeIngotRecipe(DrakovaPlugin plugin) {
        this.plugin = plugin;
    }

    public void register() {
        ItemStack bronzeIngot = BronzeIngot.create();

        NamespacedKey furnaceKey = new NamespacedKey(plugin, DrakovaPlugin.id + "_bronze_ingot_furnace");
        NamespacedKey blastFurnaceKey = new NamespacedKey(plugin, DrakovaPlugin.id + "_bronze_ingot_blast_furnace");

        FurnaceRecipe furnaceRecipe = new FurnaceRecipe(furnaceKey, bronzeIngot, bronzeIngot.getType(), 0.5f, 250);
        furnaceRecipe.setInput(BronzeAlloy.create().getType());
        Bukkit.addRecipe(furnaceRecipe);

        BlastingRecipe blastingRecipe = new BlastingRecipe(blastFurnaceKey, bronzeIngot, bronzeIngot.getType(), 0.5f, 100);
        blastingRecipe.setInput(BronzeAlloy.create().getType());
        Bukkit.addRecipe(blastingRecipe);
    }
}
