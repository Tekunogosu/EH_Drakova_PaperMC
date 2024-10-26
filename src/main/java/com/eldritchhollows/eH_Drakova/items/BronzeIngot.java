package com.eldritchhollows.eH_Drakova.items;

import com.eldritchhollows.eH_Drakova.utils.ItemGenerator;
import com.eldritchhollows.eH_Drakova.utils.ItemModelDataEnum;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

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

