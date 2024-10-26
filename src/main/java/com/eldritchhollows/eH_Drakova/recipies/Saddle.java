package com.eldritchhollows.eH_Drakova.recipies;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Saddle extends DrakovaRecipe {
    public Saddle(JavaPlugin plugin) {
        super(plugin, "drak_saddle_crafting_bench");
    }

    public void register() {
        ItemStack saddle = new ItemStack(Material.SADDLE);
        super.key = new NamespacedKey(plugin, super.RecipeKey);

        ShapedRecipe saddleRecipe = new ShapedRecipe(key, saddle);
        saddleRecipe.shape("LLL", "SLS", "T T");
        saddleRecipe.setIngredient('L', Material.LEATHER);
        saddleRecipe.setIngredient('S', Material.STRING);
        saddleRecipe.setIngredient('T', new ItemStack(Material.TRIPWIRE_HOOK));

        Bukkit.addRecipe(saddleRecipe);
    }
}
