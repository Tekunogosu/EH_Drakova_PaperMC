package com.eldritchhollows.Drakova.mining.items;

import com.eldritchhollows.Drakova.utils.ItemGenerator;
import com.eldritchhollows.Drakova.utils.EItemModelData;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CassiteriteOre {
    // percentage
    private static final double RARITY_VAL = 0.15;

    public static @NotNull ItemStack create() {
        return ItemGenerator.CreateNewItem(
                EItemModelData.CASSITERITE_ORE.getDisplayName(),
                EItemModelData.CASSITERITE_ORE.getLore(),
                EItemModelData.CASSITERITE_ORE.getMaterial(),
                EItemModelData.CASSITERITE_ORE.getId(),
                new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE}
        );
    }

    public static double rarity() {
        return RARITY_VAL;
    }
}
