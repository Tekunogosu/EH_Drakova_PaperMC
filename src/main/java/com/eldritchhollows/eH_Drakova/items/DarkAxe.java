package com.eldritchhollows.eH_Drakova.items;

import com.eldritchhollows.eH_Drakova.utils.ItemGenerator;
import com.eldritchhollows.eH_Drakova.utils.ItemModelDataEnum;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class DarkAxe {
    public static ItemStack create() {
        return ItemGenerator.CreateNewItem(
                ItemModelDataEnum.DARK_AXE.getDisplayName(),
                ItemModelDataEnum.DARK_AXE.getLore(),
                ItemModelDataEnum.DARK_AXE.getMaterial(),
                ItemModelDataEnum.DARK_AXE.getId(),
                new ItemFlag[]{ItemFlag.HIDE_UNBREAKABLE}
        );
    }
}
