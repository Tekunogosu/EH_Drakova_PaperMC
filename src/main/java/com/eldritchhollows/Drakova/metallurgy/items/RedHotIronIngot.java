package com.eldritchhollows.Drakova.metallurgy.items;

import com.eldritchhollows.Drakova.utils.EItemModelData;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class RedHotIronIngot {

    public static ItemStack create() {
        ItemStack stack = new ItemStack(EItemModelData.RED_HOT_IRON_INGOT.getType());
        ItemMeta meta = stack.getItemMeta();
        if (meta != null) {
            meta.displayName(Component.text(EItemModelData.RED_HOT_IRON_INGOT.getDisplayName()));
            meta.lore(List.of(Component.text(EItemModelData.RED_HOT_IRON_INGOT.getLore())));
            meta.setCustomModelData(EItemModelData.RED_HOT_IRON_INGOT.getId());
            meta.setRarity(ItemRarity.UNCOMMON);
            stack.setItemMeta(meta);
        }

        return stack;
    }
}
