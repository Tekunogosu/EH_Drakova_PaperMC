package com.eldritchhollows.Drakova.utils;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeRemover {
    private DrakovaPlugin plugin;
    private final Map<String, RecipeGroup> recipeGroups = new HashMap<>();

    // Inner class to hold materials and item types
    public static class RecipeGroup {
        private final List<String> materials;
        private final List<String> itemTypes;

        public RecipeGroup(List<String> materials, List<String> itemTypes) {
            this.materials = materials;
            this.itemTypes = itemTypes;
        }
    }

    public RecipeRemover(DrakovaPlugin plugin) {
        this.plugin = plugin;

        List<String> materials = Arrays.asList("leather", "wooden", "stone", "iron", "golden", "diamond", "netherite");
        List<String> recipes = Arrays.asList(
                "pickaxe", "axe", "shovel", "hoe", "sword",
                "helmet", "chestplate", "boots", "leggings",
                "horse_armor"
        );

        recipeGroups.put("minecraft", new RecipeGroup(materials, recipes));
    }

    public void addNamespace(String namespace, List<String> materials, List<String> itemTypes) {
        recipeGroups.put(namespace, new RecipeGroup(materials, itemTypes));
    }

    public void removeRecipes() {
        for (Map.Entry<String, RecipeGroup> entry : recipeGroups.entrySet()) {
            String namespace = entry.getKey();
            RecipeGroup group = entry.getValue();

            // Generate all combinations
            for (String material : group.materials) {
                for (String itemType : group.itemTypes) {
                    String recipeKey = material + "_" + itemType;
                    NamespacedKey key = new NamespacedKey(namespace, recipeKey);

                    if (Bukkit.getRecipe(key) == null) continue;
                    plugin.getLogger().warning("Removing recipe: " + key);
                    Bukkit.removeRecipe(key);
                }
            }
        }
    }
}
