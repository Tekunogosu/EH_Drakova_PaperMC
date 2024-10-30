package com.eldritchhollows.Drakova.items;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DrakItem {

    private final ItemStack stack;
    private final String id;

    public DrakItem(String id, String name, Material material) {
        this.id = id;
        this.stack = new ItemStack(material);
        ItemMeta meta = this.stack.getItemMeta();
        meta.displayName(Component.text(name));
    }
}
