package com.eldritchhollows.Drakova.smithing.items;

import com.eldritchhollows.Drakova.utils.EItemModelData;
import com.eldritchhollows.Drakova.utils.EItemRarity;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class RedHotIronSheet {

    public static ItemStack create() {
        ItemStack stack = new ItemStack(EItemModelData.RED_HOT_IRON_SHEET.getType());
        ItemMeta meta = stack.getItemMeta();
        if (meta != null) {
            meta.displayName(Component.text(EItemModelData.RED_HOT_IRON_SHEET.getDisplayName()));
            meta.setCustomModelData(EItemModelData.RED_HOT_IRON_SHEET.getId());
            meta.lore(List.of(Component.text(EItemModelData.RED_HOT_IRON_SHEET.getLore())));
            meta.setRarity(EItemRarity.RED_HOT_IRON_SHEET.getRarity());
            stack.setItemMeta(meta);
        }

        return stack;
    }
}
