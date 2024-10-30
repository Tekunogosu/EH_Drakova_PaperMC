package com.eldritchhollows.Drakova.metallurgy.items;

import com.eldritchhollows.Drakova.utils.ItemGenerator;
import com.eldritchhollows.Drakova.utils.EItemModelData;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class BronzeIngot {

    public static ItemStack create() {
        return ItemGenerator.CreateNewItem(
                EItemModelData.BRONZE_INGOT.getDisplayName(),
                EItemModelData.BRONZE_INGOT.getLore(),
                EItemModelData.BRONZE_INGOT.getMaterial(),
                EItemModelData.BRONZE_INGOT.getId(),
                new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES}
        );
    }
}

