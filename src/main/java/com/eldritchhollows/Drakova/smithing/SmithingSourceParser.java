package com.eldritchhollows.Drakova.smithing;

import dev.aurelium.auraskills.api.config.ConfigNode;
import dev.aurelium.auraskills.api.source.SourceContext;
import dev.aurelium.auraskills.api.source.XpSourceParser;

public class SmithingSourceParser implements XpSourceParser<SmithingSource> {
    @Override
    public SmithingSource parse(ConfigNode source, SourceContext context) {
        double multiplier = source.node("multiplier").getDouble(1.0);
        return new SmithingSource(context.parseValues(source), multiplier);
    }
}
