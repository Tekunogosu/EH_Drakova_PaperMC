package com.eldritchhollows.Drakova.smithing.items;

import com.eldritchhollows.Drakova.utils.EItemModelData;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class SmithingHammer {
    public static ItemStack create() {
        ItemStack stack = new ItemStack(Material.MACE);
        ItemMeta meta = stack.getItemMeta();
        if (meta != null) {
            meta.displayName(Component.text(EItemModelData.SMITHING_HAMMER.getDisplayName()));
            meta.lore(List.of(
                    Component.text("- With Hot Iron Ingot in offhand"),
                    Component.text("- right click anvil with hammer in main hand")
            ));
            meta.setCustomModelData(EItemModelData.SMITHING_HAMMER.getId());
            meta.setRarity(ItemRarity.UNCOMMON);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
            meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
            meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);

            stack.setItemMeta(meta);
            // TODO: Stats for hammer that affect performance of smithing
        }

        return stack;
    }


}
