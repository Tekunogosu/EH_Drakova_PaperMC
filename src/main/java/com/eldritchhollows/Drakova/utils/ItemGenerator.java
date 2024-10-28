package com.eldritchhollows.Drakova.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemGenerator {

    public static ItemStack CreateNewItem(String displayName, String lore, Material material, int modelData, ItemFlag[] flags) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.displayName(Component.text(displayName));
            meta.lore(List.of(Component.text(lore)));
            meta.setCustomModelData(modelData);
            meta.addItemFlags(flags);
            item.setItemMeta(meta);
        }

        return item;
    }
}
