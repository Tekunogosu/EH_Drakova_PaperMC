package com.eldritchhollows.eH_Drakova.items;

import com.eldritchhollows.eH_Drakova.utils.ItemGenerator;
import com.eldritchhollows.eH_Drakova.utils.ItemModelDataEnum;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BronzeAlloy {
    public static @NotNull ItemStack create() {
        return ItemGenerator.CreateNewItem(
                ItemModelDataEnum.BRONZE_ALLOY.getDisplayName(),
                ItemModelDataEnum.BRONZE_ALLOY.getLore(),
                ItemModelDataEnum.BRONZE_ALLOY.getMaterial(),
                ItemModelDataEnum.BRONZE_ALLOY.getId(),
                new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES}
        );
    }

}
