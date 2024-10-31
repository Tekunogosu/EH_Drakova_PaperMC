package com.eldritchhollows.Drakova.utils;

import org.bukkit.inventory.ItemRarity;

public enum EItemRarity {
    RED_HOT_IRON_SHEET(ItemRarity.COMMON);
    private ItemRarity rarity;

    EItemRarity(ItemRarity rarity) {
        this.rarity = rarity;
    }

    public ItemRarity getRarity() {
        return this.rarity;
    }
}
