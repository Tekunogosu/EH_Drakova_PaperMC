package com.eldritchhollows.Drakova.metallurgy.items;

import com.eldritchhollows.Drakova.utils.EItemModelData;
import com.eldritchhollows.Drakova.utils.ItemGenerator;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BronzeAlloy {
    public static @NotNull ItemStack create() {
        return ItemGenerator.CreateNewItem(
                EItemModelData.BRONZE_ALLOY.getDisplayName(),
                EItemModelData.BRONZE_ALLOY.getLore(),
                EItemModelData.BRONZE_ALLOY.getType(),
                EItemModelData.BRONZE_ALLOY.getId(),
                new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES}
        );
    }

}
