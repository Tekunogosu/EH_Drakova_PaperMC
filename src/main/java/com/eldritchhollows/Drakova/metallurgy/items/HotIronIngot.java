package com.eldritchhollows.Drakova.metallurgy.items;

import com.eldritchhollows.Drakova.utils.EItemModelData;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class HotIronIngot {

    public static ItemStack create() {
        ItemStack hotIronIngot = new ItemStack(Material.IRON_INGOT);
        ItemMeta hotIronMeta = hotIronIngot.getItemMeta();
        if (hotIronMeta != null) {
            hotIronMeta.setCustomModelData(EItemModelData.HOT_IRON_INGOT.getId());
            hotIronMeta.lore(List.of(Component.text(EItemModelData.HOT_IRON_INGOT.getLore())));
            hotIronMeta.setRarity(ItemRarity.COMMON);
//            hotIronMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, MetallurgyStates.TEMP.key), PersistentDataType.BYTE, MetallurgyFlags.HOT.flag);
            hotIronIngot.setItemMeta(hotIronMeta);
        }

        return hotIronIngot;
    }
}
