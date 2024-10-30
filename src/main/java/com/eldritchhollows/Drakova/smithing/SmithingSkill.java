package com.eldritchhollows.Drakova.smithing;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import com.eldritchhollows.Drakova.smithing.listeners.SmithingHammerListener;
import com.eldritchhollows.Drakova.utils.DrakovaSkill;
import com.eldritchhollows.Drakova.utils.DrakovaSkillsManager;
import com.eldritchhollows.Drakova.utils.EDrakovaSkills;
import dev.aurelium.auraskills.api.AuraSkillsApi;
import dev.aurelium.auraskills.api.source.SourceType;
import org.bukkit.Bukkit;

public class SmithingSkill extends DrakovaSkill {

    public SmithingSkill(DrakovaPlugin plugin, AuraSkillsApi auraSkills) {
        super(plugin, auraSkills);
    }

    @Override
    public void register() {
        registry.registerSkill(DrakovaSkillsManager.SMITHING);

        setSources();
        setItems();
        setListeners();
    }

    @Override
    protected void setSources() {
        SourceType smithingSource = registry.registerSourceType(EDrakovaSkills.SMITHING.id(), new SmithingSourceParser());
        new SmithingLeveler(plugin, smithingSource).register();
    }

    @Override
    protected void setItems() {
    }

    @Override
    protected void setRecipes() {

    }

    @Override
    protected void setListeners() {
        Bukkit.getPluginManager().registerEvents(new SmithingHammerListener(auraSkills), plugin);
    }
}
