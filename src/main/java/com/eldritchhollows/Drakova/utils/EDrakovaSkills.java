package com.eldritchhollows.Drakova.utils;

public enum EDrakovaSkills {
    SMITHING("smithing", "Smithing", "Smithing"),
    WOODWORKING("woodworking", "Woodworking", "Shaper of trees"),
    METALLURGY("metallurgy", "Melty metal", "Metallurgy");

    private String skillName;
    private String description;
    private String displayName;

    EDrakovaSkills(String skillName, String description, String displayName) {
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
