package com.eldritchhollows.Drakova.utils;

import eu.decentsoftware.holograms.api.holograms.Hologram;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class CraftingSession {
    private UUID playerId;
    private Block station;
    private ItemStack craftingItem;
    private Hologram hologram;

    public CraftingSession(UUID playerId, Block station, ItemStack craftingItem, Hologram hologram) {
        this.playerId = playerId;
        this.station = station;
        this.craftingItem = craftingItem;
        this.hologram = hologram;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public Block getStationId() {
        return station;
    }

    public ItemStack getCraftingItem() {
        return craftingItem;
    }

    public Hologram getHologram() {
        return hologram;
    }
}
