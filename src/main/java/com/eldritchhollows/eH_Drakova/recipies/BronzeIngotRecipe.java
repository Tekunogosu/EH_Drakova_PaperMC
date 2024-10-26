package com.eldritchhollows.eH_Drakova.recipies;

import com.eldritchhollows.eH_Drakova.items.BronzeAlloy;
import com.eldritchhollows.eH_Drakova.items.BronzeIngot;
import com.eldritchhollows.eH_Drakova.utils.ItemModelDataEnum;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.BlastingRecipe;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class BronzeIngotRecipe {
    public final JavaPlugin plugin;

    public BronzeIngotRecipe(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void register() {
        ItemStack bronzeIngot = BronzeIngot.create();

        NamespacedKey furnaceKey = new NamespacedKey(plugin, "drak_bronze_ingot_furnace");
        NamespacedKey blastFurnaceKey = new NamespacedKey(plugin, "drak_bronze_ingot_blast_furnace");

        FurnaceRecipe furnaceRecipe = new FurnaceRecipe(furnaceKey, bronzeIngot, bronzeIngot.getType(), 0.5f, 250);
        furnaceRecipe.setInput(BronzeAlloy.create().getType());
        Bukkit.addRecipe(furnaceRecipe);

        BlastingRecipe blastingRecipe = new BlastingRecipe(blastFurnaceKey, bronzeIngot, bronzeIngot.getType(), 0.5f, 100);
        blastingRecipe.setInput(BronzeAlloy.create().getType());
        Bukkit.addRecipe(blastingRecipe);
    }
}
