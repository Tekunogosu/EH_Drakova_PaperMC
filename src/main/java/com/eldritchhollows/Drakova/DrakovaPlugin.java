package com.eldritchhollows.Drakova;

import com.eldritchhollows.Drakova.commands.GiveItem;
import com.eldritchhollows.Drakova.listeners.OreDropListener;
import com.eldritchhollows.Drakova.listeners.cauldron.BronzeAlloyListener;
import com.eldritchhollows.Drakova.recipies.BronzeIngotRecipe;
import com.eldritchhollows.Drakova.recipies.SaddleRecipe;
import com.eldritchhollows.Drakova.skills.CustomSkills;
import com.eldritchhollows.Drakova.utils.ConfigManager;
import com.eldritchhollows.Drakova.utils.DrakSkills;
import dev.aurelium.auraskills.api.AuraSkillsApi;
import dev.aurelium.auraskills.api.registry.NamespacedRegistry;
import net.kyori.adventure.text.Component;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class DrakovaPlugin extends JavaPlugin {

    private final String id = "drakova";

    private ConfigManager configManager;

    @Override
    public void onEnable() {

        this.getComponentLogger().info(Component.text("******************************************** DRAKOVA INFO!!!!! ************************"));
        this.getComponentLogger().warn(Component.text("******************************************** DRAKOVA WARN!!!!! ************************"));
        this.getComponentLogger().error(Component.text("******************************************** DRAKOVA ERROR!!!! ************************"));
        // create the ConfigManager and initialize all the configurations (this happens in the ConfigManager);
        configManager = new ConfigManager(this);

        // Plugin startup logic
        registerCustomRecipes();
        registerListeners();
        registerCommands();
        registerCustomSkills();
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
        NamespacedRegistry registry = auraSkills.useRegistry(this.id, this.getDataFolder());
        registry.registerSkill(CustomSkills.BLACKSMITHING);
        // registry.registerSkill(CustomSkills.WOODWORKING);

        FileConfiguration bsConfig = configManager.getSource(DrakSkills.BLACKSMITHING.id());
    }

    public String id() {
        return this.id;
    }

}
