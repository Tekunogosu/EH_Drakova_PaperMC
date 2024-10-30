package com.eldritchhollows.Drakova.smithing.items.armor;

import com.eldritchhollows.Drakova.utils.ItemGenerator;
import com.eldritchhollows.Drakova.utils.EItemModelData;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class BronzeArmor {


    public static ItemStack createHelm() {
        return ItemGenerator.CreateNewItem(
                EItemModelData.BRONZE_HELM.getDisplayName(),
                EItemModelData.BRONZE_HELM.getLore(),
                EItemModelData.BRONZE_HELM.getMaterial(),
                EItemModelData.BRONZE_HELM.getId(),
                new ItemFlag[]{}
        );
    }

    public static ItemStack createChestplate() {
        return ItemGenerator.CreateNewItem(
                EItemModelData.BRONZE_CHEST.getDisplayName(),
                EItemModelData.BRONZE_CHEST.getLore(),
                EItemModelData.BRONZE_CHEST.getMaterial(),
                EItemModelData.BRONZE_CHEST.getId(),
                new ItemFlag[]{}
        );
    }

}
