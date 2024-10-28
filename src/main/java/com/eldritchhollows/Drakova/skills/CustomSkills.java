package com.eldritchhollows.Drakova.skills;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import com.eldritchhollows.Drakova.utils.DrakSkills;
import dev.aurelium.auraskills.api.item.ItemContext;
import dev.aurelium.auraskills.api.registry.NamespacedId;
import dev.aurelium.auraskills.api.skill.CustomSkill;

public class CustomSkills {
    public static final CustomSkill SMITHING = CustomSkill
            .builder(NamespacedId.of(DrakovaPlugin.id, DrakSkills.SMITHING.id()))
            .displayName(DrakSkills.SMITHING.getDisplayName())
            .description(DrakSkills.SMITHING.getDescription())
            .item(ItemContext.builder().material("iron_pickaxe").pos("4,4").build())
            .build();

    public static final CustomSkill WOODWORKING = CustomSkill
            .builder(NamespacedId.of(DrakovaPlugin.id, "woodworking"))
            .displayName("Woodworking")
            .description("Craft things with wood, increases agility stuff")
            .item(ItemContext.builder().material("wooden_shovel").pos("5,5").build())
            .build();
}
