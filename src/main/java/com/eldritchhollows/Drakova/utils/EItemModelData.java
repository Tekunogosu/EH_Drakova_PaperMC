package com.eldritchhollows.Drakova.utils;

import org.bukkit.Material;

public enum EItemModelData {

    /**
     * Number scheme prefix
     * 600 - ore
     * 601 - ingot
     * 611 - sheet
     * 602 - alloy
     * 603 - armor
     * 604 - weapon
     * 605 - tools
     * 666 - misc
     */

    // Ore
    CASSITERITE_ORE(600000, "Cassiterite Ore", "Raw Cassiterite ore", Material.IRON_NUGGET),
    RAW_IRON(600001, "Raw Iron", null, Material.RAW_IRON),

    // Ingots
    HOT_IRON_INGOT(601001, "Iron Ingot", "Hot", Material.IRON_INGOT),
    RED_HOT_IRON_INGOT(601002, "Iron Ingot", "Red Hot", Material.IRON_INGOT),
    BRONZE_INGOT(601003, "Bronze Ingot", "An ingot of Bronze Alloy", Material.COPPER_INGOT),
    HOT_COPPER_INGOT(601004, "Copper Ingot", "Hot", Material.COPPER_INGOT),
    RED_HOT_COPPER_INGOT(601005, "Copper Ingot", "Red Hot", Material.IRON_INGOT),

    // Sheets
    RED_HOT_IRON_SHEET(611000, "Iron Sheet", "Red Hot", Material.IRON_INGOT),
    HOT_IRON_SHEET(611001, "Iron Sheet", "Hot", Material.IRON_INGOT),
    IRON_SHEET(611002, "Iron Sheet", null, Material.IRON_INGOT),

    // Alloy
    BRONZE_ALLOY(602000, "Bronze Alloy", "An alloy of iron and cassiterite", Material.COPPER_ORE),

    // Armor
    BRONZE_CHEST(603001, "Bronze Chest", "", Material.CHAINMAIL_CHESTPLATE),
    BRONZE_HELM(603002, "Bronze Helmet", "", Material.CHAINMAIL_HELMET),
    BRONZE_LEGS(603003, "Bronze Pants", "", Material.CHAINMAIL_LEGGINGS),
    BRONZE_BOOTS(603004, "Bronze Boots", "", Material.CHAINMAIL_BOOTS),

    IRON_CHESTPLATE_BLANK(603005, "Iron Chestplate", "Blank", Material.IRON_CHESTPLATE),

    // Weapons
    DARK_AXE(604000, "Dark Axe of Death", "It's dark AND an Axe, crazy!", Material.IRON_AXE),

    // Tools
    SMITHING_HAMMER(605000, "Smithing Hammer", null, Material.MACE),
    ;

    private final int id;
    private final String displayName;
    private String lore;
    private final Material material;

    EItemModelData(int id, String displayName, String lore, Material material) {
        this.id = id;
        this.displayName = displayName;
        if (lore != null) this.lore = lore;
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

    public Material getType() {
        return this.material;
    }
}
