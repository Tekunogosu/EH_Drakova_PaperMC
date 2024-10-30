package com.eldritchhollows.Drakova.utils;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import com.eldritchhollows.Drakova.metallurgy.MetallurgySkill;
import com.eldritchhollows.Drakova.smithing.SmithingSkill;
import dev.aurelium.auraskills.api.AuraSkillsApi;
import dev.aurelium.auraskills.api.item.ItemContext;
import dev.aurelium.auraskills.api.registry.NamespacedId;
import dev.aurelium.auraskills.api.skill.CustomSkill;

public class DrakovaSkillsManager {

    private final DrakovaPlugin plugin;

    public static final CustomSkill SMITHING = CustomSkill
            .builder(NamespacedId.of(DrakovaPlugin.id, EDrakovaSkills.SMITHING.id()))
            .displayName(EDrakovaSkills.SMITHING.getDisplayName())
            .description(EDrakovaSkills.SMITHING.getDescription())
            .item(ItemContext.builder().material("anvil").pos("4,4").build())
            .build();

    public static final CustomSkill WOODWORKING = CustomSkill
            .builder(NamespacedId.of(DrakovaPlugin.id, "woodworking"))
            .displayName("Woodworking")
            .description("Craft things with wood, increases agility stuff")
            .item(ItemContext.builder().material("wooden_shovel").pos("5,5").build())
            .build();

    public static final CustomSkill METALLURGY = CustomSkill
            .builder(NamespacedId.of(DrakovaPlugin.id, EDrakovaSkills.METALLURGY.id()))
            .displayName(EDrakovaSkills.METALLURGY.name())
            .description(EDrakovaSkills.METALLURGY.getDescription())
            .item(ItemContext.builder().material("iron_ingot").pos("4,5").build())
            .build();


    public DrakovaSkillsManager(DrakovaPlugin plugin) {
        this.plugin = plugin;
    }

    public void register() {
        AuraSkillsApi auraSkills = AuraSkillsApi.get();

        new SmithingSkill(plugin, auraSkills).register();
        new MetallurgySkill(plugin, auraSkills).register();
    }

}
