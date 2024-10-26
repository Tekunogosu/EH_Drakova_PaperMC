package com.eldritchhollows.eH_Drakova.items;

import com.eldritchhollows.eH_Drakova.utils.ItemGenerator;
import com.eldritchhollows.eH_Drakova.utils.ItemModelDataEnum;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class BronzeArmor {


    public static ItemStack createHelm() {
        return ItemGenerator.CreateNewItem(
                ItemModelDataEnum.BRONZE_HELM.getDisplayName(),
                ItemModelDataEnum.BRONZE_HELM.getLore(),
                ItemModelDataEnum.BRONZE_HELM.getMaterial(),
                ItemModelDataEnum.BRONZE_HELM.getId(),
                new ItemFlag[]{}
        );
    }

    public static ItemStack createChestplate() {
        return ItemGenerator.CreateNewItem(
                ItemModelDataEnum.BRONZE_CHEST.getDisplayName(),
                ItemModelDataEnum.BRONZE_CHEST.getLore(),
                ItemModelDataEnum.BRONZE_CHEST.getMaterial(),
                ItemModelDataEnum.BRONZE_CHEST.getId(),
                new ItemFlag[]{}
        );
    }

}
