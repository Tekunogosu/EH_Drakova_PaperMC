package com.eldritchhollows.Drakova.metallurgy;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import com.eldritchhollows.Drakova.metallurgy.listeners.BronzeAlloyListener;
import com.eldritchhollows.Drakova.metallurgy.recipes.BronzeIngotRecipe;
import com.eldritchhollows.Drakova.metallurgy.recipes.HotIronIngotRecipe;
import com.eldritchhollows.Drakova.metallurgy.recipes.RedHotIronIngotRecipe;
import com.eldritchhollows.Drakova.metallurgy.recipes.RedHotIronSheetRecipe;
import com.eldritchhollows.Drakova.utils.DrakovaSkill;
import com.eldritchhollows.Drakova.utils.DrakovaSkillsManager;
import dev.aurelium.auraskills.api.AuraSkillsApi;

public class MetallurgySkill extends DrakovaSkill {

    public MetallurgySkill(DrakovaPlugin plugin, AuraSkillsApi auraSkills) {
        super(plugin, auraSkills);
    }

    @Override
    public void register() {
        registry.registerSkill(DrakovaSkillsManager.METALLURGY);

        setSources();
        setItems();
        setListeners();
        setRecipes();
    }

    @Override
    protected void setItems() {

    }

    @Override
    protected void setSources() {

    }

    @Override
    protected void setRecipes() {
        new HotIronIngotRecipe(plugin).register();
        new RedHotIronIngotRecipe(plugin).register();
        new RedHotIronSheetRecipe(plugin).register();
        new BronzeIngotRecipe(plugin).register();
    }

    @Override
    protected void setListeners() {
        new BronzeAlloyListener(plugin).register();
    }
}
