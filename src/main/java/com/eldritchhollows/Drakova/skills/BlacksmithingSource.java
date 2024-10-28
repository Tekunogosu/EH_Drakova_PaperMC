package com.eldritchhollows.Drakova.skills;

import dev.aurelium.auraskills.api.source.CustomSource;
import dev.aurelium.auraskills.api.source.SourceValues;

public class BlacksmithingSource extends CustomSource {

    private final double multiplier;

    public BlacksmithingSource(SourceValues values, double multiplier) {
        super(values);
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return this.multiplier;
    }
}
