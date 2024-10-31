package com.eldritchhollows.Drakova.smithing.recipes;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import com.eldritchhollows.Drakova.smithing.items.RedHotIronSheet;
import com.eldritchhollows.Drakova.smithing.items.armor.IronChestplateBlank;
import com.eldritchhollows.Drakova.utils.DrakovaRecipe;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class BlankIronChestplateRecipe extends DrakovaRecipe {

    public BlankIronChestplateRecipe(DrakovaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void register() {

        ItemStack stack = IronChestplateBlank.create();

        NamespacedKey key = new NamespacedKey(plugin, DrakovaPlugin.id + "_blank_iron_chestplate");

        ShapedRecipe recipe = new ShapedRecipe(key, stack);
        recipe.shape("T T", "TTT", "TTT");
        recipe.setIngredient('T', RedHotIronSheet.create());

        boolean fail = Bukkit.addRecipe(recipe);
        if (!fail) {
            plugin.getLogger().warning("Unable to add recipe: " + key.asString());
        }

    }
}
