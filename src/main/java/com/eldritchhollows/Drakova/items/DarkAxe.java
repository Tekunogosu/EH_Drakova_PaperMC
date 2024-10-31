package com.eldritchhollows.Drakova.items;

import com.eldritchhollows.Drakova.utils.EItemModelData;
import com.eldritchhollows.Drakova.utils.ItemGenerator;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class DarkAxe {
    public static ItemStack create() {
        return ItemGenerator.CreateNewItem(
                EItemModelData.DARK_AXE.getDisplayName(),
                EItemModelData.DARK_AXE.getLore(),
                EItemModelData.DARK_AXE.getType(),
                EItemModelData.DARK_AXE.getId(),
                new ItemFlag[]{ItemFlag.HIDE_UNBREAKABLE}
        );
    }
}
