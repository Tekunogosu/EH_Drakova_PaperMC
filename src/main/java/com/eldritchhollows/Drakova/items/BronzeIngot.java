package com.eldritchhollows.Drakova.items;

import com.eldritchhollows.Drakova.utils.ItemGenerator;
import com.eldritchhollows.Drakova.utils.ItemModelDataEnum;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class BronzeIngot {

    public static ItemStack create() {
        return ItemGenerator.CreateNewItem(
                ItemModelDataEnum.BRONZE_INGOT.getDisplayName(),
                ItemModelDataEnum.BRONZE_INGOT.getLore(),
                ItemModelDataEnum.BRONZE_INGOT.getMaterial(),
                ItemModelDataEnum.BRONZE_INGOT.getId(),
                new ItemFlag[] {ItemFlag.HIDE_ATTRIBUTES}
        );
    }
}

