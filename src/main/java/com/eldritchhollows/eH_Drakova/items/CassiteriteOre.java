package com.eldritchhollows.eH_Drakova.items;

import com.eldritchhollows.eH_Drakova.utils.ItemGenerator;
import com.eldritchhollows.eH_Drakova.utils.ItemModelDataEnum;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CassiteriteOre {
    // percentage
    private static final double RARITY_VAL = 0.15;

    public static @NotNull ItemStack create() {
        return ItemGenerator.CreateNewItem(
                ItemModelDataEnum.CASSITERITE_ORE.getDisplayName(),
                ItemModelDataEnum.CASSITERITE_ORE.getLore(),
                ItemModelDataEnum.CASSITERITE_ORE.getMaterial(),
                ItemModelDataEnum.CASSITERITE_ORE.getId(),
                new ItemFlag[] {ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE}
        );
    }

    public static double rarity() {
        return RARITY_VAL;
    }
}
