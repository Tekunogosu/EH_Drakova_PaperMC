package com.eldritchhollows.Drakova.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager {
    private JavaPlugin plugin;

    private static final String REWARDS_DIR = "rewards";
    private static final String SOURCES_DIR = "sources";
    private final Map<String, FileConfiguration> configs = new HashMap<>();

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
        initConfigs();
    }

    public void initConfigs() {
        plugin.getLogger().warning("Attempting to create drakova configs...");
        registerConfig("config.yml");
        registerConfig(REWARDS_DIR + "/" + DrakSkills.BLACKSMITHING.id());
        registerConfig(SOURCES_DIR + "/" + DrakSkills.BLACKSMITHING.id());
    }

    private void registerConfig(String configName) {
        File file = new File(plugin.getDataFolder(), configName + ".yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        if (!file.exists()) {
            if (file.getParentFile().mkdirs()) {
                plugin.saveResource(configName + ".yml", false);
                plugin.getLogger().info("Created config: " + configName + ".yml");
            }
        }
        configs.put(configName, config);
    }

    public FileConfiguration getConfig(String configName) {
        return configs.get(configName);
    }

    public FileConfiguration getReward(String configName) {
        return this.getConfig(REWARDS_DIR + "/" + configName);
    }

    public FileConfiguration getSource(String configName) {
        return this.getConfig(SOURCES_DIR + "/" + configName);
    }

    public void saveConfig(String configName) {
        try {
            getConfig(configName).save(getConfigFile(configName));
        } catch (IOException e) {
            plugin.getLogger().severe("Unable to save or load " + configName + " - " + e.getMessage());
        }
    }

    public File getConfigFile(String configName) {
        String configPath = plugin.getDataFolder().getPath();

        if (configName.startsWith(REWARDS_DIR)) {
            configPath = plugin.getDataFolder().getPath() + "/" + REWARDS_DIR;
        } else if (configName.startsWith(SOURCES_DIR)) {
            configPath = plugin.getDataFolder().getPath() + "/" + SOURCES_DIR;
        }

        return new File(configPath + "/" + configName);
    }

}
