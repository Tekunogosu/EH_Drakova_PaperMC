package com.eldritchhollows.Drakova.utils;

public enum DrakSkills {
    BLACKSMITHING("blacksmithing", "Blacksmithing", "Mistress of metal"),
    WOODWORKING("woodworking", "Woodworking", "Shaper of trees");

    private String skillName;
    private String description;
    private String lore;

    DrakSkills(String skillName, String description, String lore) {
        this.skillName = skillName;
        this.description = description;
        this.lore = lore;
    }

    public String id() {
        return this.skillName;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLore() {
        return this.lore;
    }

}
