package com.eldritchhollows.eH_Drakova.utils;

import org.bukkit.Material;

public enum ItemModelDataEnum {
    CASSITERITE_ORE(666001, "Cassiterite Ore", "Raw Cassiterite ore",           Material.IRON_NUGGET),
    BRONZE_ALLOY(666002, "Bronze Alloy", "An alloy of iron and cassiterite",    Material.COPPER_ORE),
    BRONZE_INGOT(666003, "Bronze Ingot", "An ingot of Bronze Alloy",            Material.COPPER_INGOT),
    BRONZE_CHEST(667001, "Bronze Chest", "",                                    Material.CHAINMAIL_CHESTPLATE),
    BRONZE_HELM(667002, "Bronze Helmet", "",                                    Material.CHAINMAIL_HELMET),
    BRONZE_LEGS(667003, "Bronze Pants", "",                                     Material.CHAINMAIL_LEGGINGS),
    BRONZE_BOOTS(667004, "Bronze Boots", "",                                    Material.CHAINMAIL_BOOTS),
    DARK_AXE(668001, "Dark Axe of Death", "It's dark AND an Axe, crazy!",       Material.IRON_AXE)
    ;

    private final int id;
    private final String displayName;
    private final String lore;
    private final Material material;

    ItemModelDataEnum(int id, String displayName, String lore, Material material) {
        this.id = id;
        this.displayName = displayName;
        this.lore = lore;
        this.material = material;
    }

    public int getId() {
        return this.id;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getLore() {
        return this.lore;
    }

    public Material getMaterial() {
        return this.material;
    }
}
