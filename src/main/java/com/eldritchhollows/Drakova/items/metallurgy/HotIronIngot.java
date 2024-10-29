package com.eldritchhollows.Drakova.items.metallurgy;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import com.eldritchhollows.Drakova.skills.smithing.MetallurgyFlags;
import com.eldritchhollows.Drakova.skills.smithing.MetallurgyStates;
import com.eldritchhollows.Drakova.utils.ItemModelDataEnum;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class HotIronIngot {

    public static ItemStack create(DrakovaPlugin plugin) {
        ItemStack hotIronIngot = new ItemStack(Material.IRON_INGOT);
        ItemMeta hotIronMeta = hotIronIngot.getItemMeta();
        if (hotIronMeta != null) {
            hotIronMeta.setCustomModelData(ItemModelDataEnum.HOT_IRON_INGOT.getId());
            hotIronMeta.lore(List.of(Component.text("Hot")));
            hotIronMeta.setRarity(ItemRarity.COMMON);
            hotIronMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, MetallurgyStates.TEMP.key), PersistentDataType.BYTE, MetallurgyFlags.HOT.flag);
            hotIronIngot.setItemMeta(hotIronMeta);
        }

        return hotIronIngot;
    }
}
