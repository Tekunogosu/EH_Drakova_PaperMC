package com.eldritchhollows.Drakova.skills;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import dev.aurelium.auraskills.api.AuraSkillsApi;
import dev.aurelium.auraskills.api.source.LevelerContext;
import dev.aurelium.auraskills.api.source.SourceType;
import dev.aurelium.auraskills.api.user.SkillsUser;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;

public class SmithingLeveler implements Listener {

    private final DrakovaPlugin plugin;
    private final SourceType sourceType;
    private final LevelerContext levelerContext;
    private final AuraSkillsApi auraSkills;

    public SmithingLeveler(DrakovaPlugin plugin, SourceType source) {
        this.plugin = plugin;
        this.sourceType = source;
        this.auraSkills = AuraSkillsApi.get();
        this.levelerContext = new LevelerContext(this.auraSkills, sourceType);
    }

    public void register() {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void onFurnaceSmelt(FurnaceExtractEvent event) {
        Player player = event.getPlayer();

        if (event.getItemType() == Material.IRON_INGOT) {
            SkillsUser user = auraSkills.getUser(player.getUniqueId());
            user.addSkillXp(CustomSkills.SMITHING, 200 * event.getItemAmount());
        }


    }

    @EventHandler
    public void onPlayerExpGain(PlayerExpChangeEvent event) {
        Player player = event.getPlayer();
    }


}
