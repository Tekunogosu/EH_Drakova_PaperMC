package com.eldritchhollows.Drakova.utils;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import dev.aurelium.auraskills.api.AuraSkillsApi;
import dev.aurelium.auraskills.api.registry.NamespacedRegistry;

public abstract class DrakovaSkill {
    protected final DrakovaPlugin plugin;
    protected final NamespacedRegistry registry;
    protected final AuraSkillsApi auraSkills;

    public DrakovaSkill(DrakovaPlugin plugin, AuraSkillsApi auraSkills) {
        this.plugin = plugin;
        this.registry = auraSkills.useRegistry(DrakovaPlugin.id, plugin.getDataFolder());
        this.auraSkills = auraSkills;
    }


    public abstract void register();

    protected abstract void setItems();

    protected abstract void setSources();

    protected abstract void setRecipes();

    protected abstract void setListeners();
}
