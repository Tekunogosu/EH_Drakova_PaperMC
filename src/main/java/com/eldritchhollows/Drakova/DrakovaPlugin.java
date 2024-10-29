package com.eldritchhollows.Drakova;

import com.eldritchhollows.Drakova.commands.GiveItem;
import com.eldritchhollows.Drakova.items.SmithingHammer;
import com.eldritchhollows.Drakova.listeners.OreDropListener;
import com.eldritchhollows.Drakova.listeners.cauldron.BronzeAlloyListener;
import com.eldritchhollows.Drakova.recipies.BronzeIngotRecipe;
import com.eldritchhollows.Drakova.recipies.SaddleRecipe;
import com.eldritchhollows.Drakova.skills.CustomSkills;
import com.eldritchhollows.Drakova.skills.SmithingLeveler;
import com.eldritchhollows.Drakova.skills.SmithingSourceParser;
import com.eldritchhollows.Drakova.skills.smithing.MetallurgySmelting;
import com.eldritchhollows.Drakova.utils.ConfigManager;
import com.eldritchhollows.Drakova.utils.DrakSkills;
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
        registerCustomSkills();

        new MetallurgySmelting(this).register().addRecipes();
        new SmithingHammer(this).register();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCustomRecipes() {
        new SaddleRecipe(this).register();
        new BronzeIngotRecipe(this).register();

    }

    private void registerListeners() {
        new OreDropListener(this).register();
        new BronzeAlloyListener(this).register();
    }

    private void registerCommands() {
        this.getCommand("giveitem").setExecutor(new GiveItem(this));
    }

    private void registerCustomSkills() {
        AuraSkillsApi auraSkills = AuraSkillsApi.get();
        NamespacedRegistry registry = auraSkills.useRegistry(id, this.getDataFolder());
        registry.registerSkill(CustomSkills.SMITHING);
        // registry.registerSkill(CustomSkills.WOODWORKING);

        SourceType smithingSource = registry.registerSourceType(DrakSkills.SMITHING.id(), new SmithingSourceParser());
        new SmithingLeveler(this, smithingSource).register();
    }

}
