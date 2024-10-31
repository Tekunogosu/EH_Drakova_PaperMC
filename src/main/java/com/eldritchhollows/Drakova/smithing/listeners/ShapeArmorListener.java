package com.eldritchhollows.Drakova.smithing.listeners;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import com.eldritchhollows.Drakova.utils.BlockUtils;
import com.eldritchhollows.Drakova.utils.CraftingSession;
import com.eldritchhollows.Drakova.utils.DrakovaSkillsManager;
import com.eldritchhollows.Drakova.utils.EItemModelData;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import dev.aurelium.auraskills.api.AuraSkillsApi;
import dev.aurelium.auraskills.api.user.SkillsUser;
import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import java.util.List;
import java.util.UUID;

public class ShapeArmorListener implements Listener {

    private final AuraSkillsApi auraSkills;
    private final DrakovaPlugin plugin;

    private CraftingSession craftingSession;

    public ShapeArmorListener(DrakovaPlugin plugin, AuraSkillsApi auraSkills) {
        this.plugin = plugin;
        this.auraSkills = auraSkills;
    }

    @EventHandler
    public void shapeArmorOnAnvil(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        Block anvil = event.getClickedBlock();

        if (anvil == null) return;

        if (player.isSneaking()
                && event.getAction().isRightClick()
                && player.getInventory().getItemInMainHand().isEmpty()
                && anvil.hasMetadata(BlockUtils.PlayerCraft)
        ) {
            // cancel default behaviour
            event.setCancelled(true);

            getItemFromBlock(anvil, player);

            return;
        }

        ItemStack hammer = event.getItem();
        if (!event.getAction().isRightClick()
                || hammer == null
                || !hammer.hasCustomModelData()
                || hammer.getCustomModelData() != EItemModelData.SMITHING_HAMMER.getId()) return;

        // Things we know: user right-clicked, hammer is smithing hammer
        if (!List.of(Material.ANVIL, Material.CHIPPED_ANVIL, Material.DAMAGED_ANVIL).contains(anvil.getType()))
            return;

        event.setCancelled(true);

        // TODO: check IF item has PDC of Blank with item in main hand, instead of offhand

        // things we know; right click, smithing hammer, block clicked is anvil
        ItemStack offHand = player.getInventory().getItemInOffHand();
        // TODO: Check for PDC attribute for blank status


        // things we know; right click, smithing hammer, clickde anvil, offhand is blank chestplate

        ItemMeta meta = offHand.getItemMeta();
        if (meta == null) return;

        // add item to the anvil with hologram


        if (anvil.hasMetadata(BlockUtils.PlayerCraft)) {
            // check if the craftingManager is present
            List<MetadataValue> metaData = anvil.getMetadata(BlockUtils.PlayerCraft);

            for (MetadataValue data : metaData) {
                if (data.getOwningPlugin() == plugin) {
                    this.craftingSession = (CraftingSession) data.value();
                    plugin.getLogger().warning("Found metadata, now do something with it.");
                }
            }
        }


        // if the crafting manager is still null, that means there is no item set, so create it
        if (craftingSession == null) {
            if (!offHand.hasCustomModelData() || offHand.getCustomModelData() != EItemModelData.IRON_CHESTPLATE_BLANK.getId())
                return;
            // only set the data if we have the item in our inventory
            addItemToStation(offHand, player, anvil);
            return;
        }


        doCraft(meta, offHand, player, anvil);
        // check the state of the item
        // if its blank, do the stuff to shape it
        // if its shaped, do something else??
        // shift right click with empty hand will pop the item off the anvil


        // if this works, store the item in a hashmap to keep track of the data


    }

    private void getItemFromBlock(Block anvil, Player player) {
        for (MetadataValue data : anvil.getMetadata(BlockUtils.PlayerCraft)) {
            if (data.getOwningPlugin() == plugin) {
                // add the item back to the players inventory
                CraftingSession session = (CraftingSession) data.value();
                if (session == null) return;
//                if (session.getCraftingItem().isEmpty()) {
//                    plugin.getLogger().warning("Session crafting item is empty!!");
//                    return;
//                }

                player.getInventory().addItem(session.getCraftingItem());
                DHAPI.removeHologram(session.getHologram().getId());
                anvil.removeMetadata(BlockUtils.PlayerCraft, plugin);
            }
        }
    }

    private void doCraft(ItemMeta meta, ItemStack craftedItem, Player player, Block anvil) {
        meta.lore(List.of(Component.text("Shaped").color(TextColor.color(40, 100, 40))));

        AttributeModifier attr = new AttributeModifier(
                new NamespacedKey(DrakovaPlugin.id, UUID.randomUUID().toString()),
                5.0f, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST
        );

        Multimap<Attribute, AttributeModifier> map = ArrayListMultimap.create();
        map.put(Attribute.GENERIC_ARMOR, attr);
        meta.setAttributeModifiers(map);
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, new AttributeModifier(
                new NamespacedKey(DrakovaPlugin.id, UUID.randomUUID().toString()),
                2.0f, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST
        ));
        craftedItem.setItemMeta(meta);

        // clone the item from the anvil to the inventory
        player.getInventory().addItem(craftedItem.clone());

        anvil.getWorld().playSound(anvil.getLocation(), Sound.BLOCK_ANVIL_USE, 0.8f, 1.0f);

        SkillsUser user = auraSkills.getUser(player.getUniqueId());
        user.addSkillXp(DrakovaSkillsManager.SMITHING, 50);

        MetadataValue remove = null;
        for (MetadataValue data : anvil.getMetadata(BlockUtils.PlayerCraft)) {
            if (data.getOwningPlugin() == plugin) { // always check to make sure you are removing the data for YOUR plugin
                anvil.removeMetadata(BlockUtils.PlayerCraft, plugin);

            }
        }

    }

    private void addItemToStation(ItemStack offHand, Player player, Block anvil) {


        Hologram h = DHAPI.createHologram(offHand.getDisplayName().replace(" ", "_"), anvil.getLocation().clone().add(0.5, 1.75, 0.5));
        DHAPI.addHologramLine(h, offHand);

        plugin.getLogger().warning("Storing item in anvil: " + offHand.getDisplayName());
        craftingSession = new CraftingSession(player.getUniqueId(), anvil, offHand.clone(), h);

        anvil.setMetadata(BlockUtils.PlayerCraft, new FixedMetadataValue(plugin, craftingSession));
        player.getInventory().getItemInOffHand().setAmount(offHand.getAmount() - 1);
    }
}
