package com.eldritchhollows.Drakova;

import com.eldritchhollows.Drakova.commands.GiveItem;
import com.eldritchhollows.Drakova.mining.listeners.OreDropListener;
import com.eldritchhollows.Drakova.recipies.SaddleRecipe;
import com.eldritchhollows.Drakova.smithing.SmithingLeveler;
import com.eldritchhollows.Drakova.smithing.SmithingSourceParser;
import com.eldritchhollows.Drakova.utils.ConfigManager;
import com.eldritchhollows.Drakova.utils.DrakovaSkillsManager;
import com.eldritchhollows.Drakova.utils.EDrakovaSkills;
import dev.aurelium.auraskills.api.AuraSkillsApi;
import dev.aurelium.auraskills.api.registry.NamespacedRegistry;
import dev.aurelium.auraskills.api.source.SourceType;
import org.bukkit.plugin.java.JavaPlugin;

public final class DrakovaPlugin extends JavaPlugin {

    public static final String id = "drakova";

    private ConfigManager configManager;

    @Override
    public void onEnable() {

        // create the ConfigManager and initialize all the configurations (this happens in the ConfigManager);
        configManager = new ConfigManager(this);

        // Plugin startup logic
        registerCustomRecipes();
        registerListeners();
        registerCommands();


        // All skills are registered within DrakovaSkillsManager class
        new DrakovaSkillsManager(this).register();


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCustomRecipes() {
        new SaddleRecipe(this).register();
    }

    private void registerListeners() {
        new OreDropListener(this).register();
    }

    private void registerCommands() {
        this.getCommand("giveitem").setExecutor(new GiveItem(this));
    }

    private void registerCustomSkills() {
        AuraSkillsApi auraSkills = AuraSkillsApi.get();
        NamespacedRegistry registry = auraSkills.useRegistry(id, this.getDataFolder());
        registry.registerSkill(DrakovaSkillsManager.SMITHING);
        registry.registerSkill(DrakovaSkillsManager.METALLURGY);
        // registry.registerSkill(DrakovaSkillsManager.WOODWORKING);

        SourceType smithingSource = registry.registerSourceType(EDrakovaSkills.SMITHING.id(), new SmithingSourceParser());
        new SmithingLeveler(this, smithingSource).register();
    }

}
