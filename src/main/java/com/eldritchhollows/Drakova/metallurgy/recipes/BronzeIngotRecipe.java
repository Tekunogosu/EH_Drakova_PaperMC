package com.eldritchhollows.Drakova.metallurgy.recipes;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import com.eldritchhollows.Drakova.metallurgy.items.BronzeAlloy;
import com.eldritchhollows.Drakova.metallurgy.items.BronzeIngot;
import com.eldritchhollows.Drakova.utils.DrakovaRecipe;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.BlastingRecipe;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

public class BronzeIngotRecipe extends DrakovaRecipe {

    public BronzeIngotRecipe(DrakovaPlugin plugin) {
        super(plugin);
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
