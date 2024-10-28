package com.eldritchhollows.Drakova.utils;

public enum DrakSkills {
    SMITHING("smithing", "Smithing", "Mistress of metal"),
    WOODWORKING("woodworking", "Woodworking", "Shaper of trees");

    private String skillName;
    private String description;
    private String displayName;

    DrakSkills(String skillName, String description, String displayName) {
        this.skillName = skillName;
        this.description = description;
        this.displayName = displayName;
    }

    public String id() {
        return this.skillName;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDisplayName() {
        return this.displayName;
    }

}
