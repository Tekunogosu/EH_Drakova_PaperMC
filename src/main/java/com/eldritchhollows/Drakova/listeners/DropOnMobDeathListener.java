package com.eldritchhollows.Drakova.listeners;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DropOnMobDeathListener implements Listener {

    private final DrakovaPlugin plugin;

    public DropOnMobDeathListener(DrakovaPlugin plugin) {
        this.plugin = plugin;
    }

    public void register() {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void doKillEvent(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        entity.getWorld().dropItemNaturally(entity.getLocation(), new ItemStack(Material.SUNFLOWER));
    }

}
