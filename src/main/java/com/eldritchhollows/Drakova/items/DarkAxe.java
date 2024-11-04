package com.eldritchhollows.Drakova.items;

import net.Indyuce.mmoitems.ItemStats;
import net.Indyuce.mmoitems.MMOItems;
import net.Indyuce.mmoitems.api.item.mmoitem.MMOItem;
import net.Indyuce.mmoitems.stat.data.DoubleData;
import net.Indyuce.mmoitems.stat.data.MaterialData;
import net.Indyuce.mmoitems.stat.data.StringListData;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DarkAxe {
    public static ItemStack create() {

        MMOItem mmoItem = MMOItems.plugin.getMMOItem(MMOItems.plugin.getTypes().get("AXE"), "BUTCHER_AXE");
        MMOItem blankChest = MMOItems.plugin.getMMOItem(MMOItems.plugin.getTypes().get("ARMOR"), "BLANK_IRON_CHESTPLATE");

        MMOItem sword = new MMOItem(MMOItems.plugin.getTypes().get("ARMOR"), "BLANK_IRON_CHESTPLATE");
        sword.setData(ItemStats.LORE, new StringListData(new String[]{"This is Lore", "#durability#"}));
//        sword.setData(ItemStats.NAME, new StringData("Teras super armor blank"));

        sword.setData(ItemStats.ARMOR, new DoubleData(1.0));
        sword.setData(ItemStats.MAX_HEALTH, new DoubleData(3.0));
        sword.setData(ItemStats.MATERIAL, new MaterialData(Material.IRON_CHESTPLATE));
        sword.setData(ItemStats.MAX_DURABILITY, new DoubleData(200));
        sword.setData(ItemStats.REQUIRED_LEVEL, new DoubleData(1.0));


        return sword.newBuilder().build();
        /*return ItemGenerator.CreateNewItem(
                EItemModelData.DARK_AXE.getDisplayName(),
                EItemModelData.DARK_AXE.getLore(),
                EItemModelData.DARK_AXE.getType(),
                EItemModelData.DARK_AXE.getId(),
                new ItemFlag[]{ItemFlag.HIDE_UNBREAKABLE}
        );*/
    }
}
