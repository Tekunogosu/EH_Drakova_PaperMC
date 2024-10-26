package com.eldritchhollows.eH_Drakova.listeners;

import com.eldritchhollows.eH_Drakova.items.CassiteriteOre;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class OreDropListener implements Listener {

    private final JavaPlugin plugin;
    private final Random random = new Random();

    public OreDropListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void register() {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getBlock().getType() == Material.STONE) {
            if (random.nextDouble() < CassiteriteOre.rarity()) {
                event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), CassiteriteOre.create());
            }
        }
    }
}
