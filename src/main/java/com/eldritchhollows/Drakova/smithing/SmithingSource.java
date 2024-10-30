package com.eldritchhollows.Drakova.smithing;

import dev.aurelium.auraskills.api.AuraSkillsApi;
import dev.aurelium.auraskills.api.source.CustomSource;
import dev.aurelium.auraskills.api.source.SourceValues;

public class SmithingSource extends CustomSource {

    private final double multiplier;
    private static final AuraSkillsApi auraSkills = AuraSkillsApi.get();


    public SmithingSource(SourceValues values, double multiplier) {
        super(values);
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return this.multiplier;
    }
}
