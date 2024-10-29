package com.eldritchhollows.Drakova.skills.smithing;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import com.eldritchhollows.Drakova.items.metallurgy.HotIronIngot;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

public class MetallurgySmelting implements Listener {

    private final DrakovaPlugin plugin;

    public final NamespacedKey craftingState;

    public enum StateFlags {
        HOT((byte) 0),
        RED_HOT((byte) 1),
        GLOWING_RED_HOT((byte) 2);

        private byte flag;

        StateFlags(byte flag) {
            this.flag = flag;
        }
    }

    public MetallurgySmelting(DrakovaPlugin plugin) {
        this.plugin = plugin;

        craftingState = new NamespacedKey(plugin, "craftingstate");
    }

    public MetallurgySmelting register() {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        return this;
    }

    @EventHandler
    public void handleIronState(FurnaceSmeltEvent e) {
//        ItemStack itemStack = e.getSource();
//        if (itemStack.getType() == Material.IRON_INGOT) {
//            ItemStack result = e.getResult();
//            ItemMeta meta = result.getItemMeta();
//
//            PersistentDataContainer container = meta.getPersistentDataContainer();
//
//            //add the hot state
//            container.set(craftingState, PersistentDataType.BYTE, StateFlags.HOT.flag);
//            meta.setCustomModelData(ItemModelDataEnum.HOT_IRON_INGOT.getId());
//            meta.lore(List.of(Component.text("HOT")));
//
//            result.setItemMeta(meta);
//
//        }
    }

    public void addRecipes() {

        ItemStack hotIron = HotIronIngot.create(plugin);

        NamespacedKey ironIngotKey = new NamespacedKey(plugin, DrakovaPlugin.id + "_hot_iron_ingot_from_raw");
        FurnaceRecipe ironIngotFurnaceRecipe = new FurnaceRecipe(ironIngotKey, hotIron, Material.RAW_IRON, 0.5f, 150);
        Bukkit.addRecipe(ironIngotFurnaceRecipe);

        NamespacedKey furnaceKey = new NamespacedKey(plugin, DrakovaPlugin.id + "_hot_iron_ingot_from_ingot");
        FurnaceRecipe furnaceRecipe = new FurnaceRecipe(furnaceKey, hotIron, Material.IRON_INGOT, 0.5f, 150);
        Bukkit.addRecipe(furnaceRecipe);
    }

}
