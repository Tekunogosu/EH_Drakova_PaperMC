package com.eldritchhollows.Drakova.smithing.items.armor;

import com.eldritchhollows.Drakova.utils.EItemModelData;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class IronChestplateBlank {
    public static ItemStack create() {
        ItemStack stack = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta meta = stack.getItemMeta();
        if (meta != null) {
            meta.setCustomModelData(EItemModelData.IRON_CHESTPLATE_BLANK.getId());
            meta.displayName(Component.text(EItemModelData.IRON_CHESTPLATE_BLANK.getDisplayName()));
            meta.lore(List.of(
                    Component.text("Blank").color(TextColor.color(75, 111, 160)),
                    Component.text("With this in your offhand, right-click anvil with smithing hammer.")
            ));
            meta.setRarity(ItemRarity.RARE);
            stack.setItemMeta(meta);
            stack.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(Attribute.GENERIC_ARMOR.getKey(), 0.5, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlotGroup.CHEST));
        }

        return stack;
    }
}
