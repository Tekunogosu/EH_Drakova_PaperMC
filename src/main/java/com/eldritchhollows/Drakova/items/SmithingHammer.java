package com.eldritchhollows.Drakova.items;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import com.eldritchhollows.Drakova.skills.CustomSkills;
import com.eldritchhollows.Drakova.utils.ItemModelDataEnum;
import dev.aurelium.auraskills.api.AuraSkillsApi;
import dev.aurelium.auraskills.api.user.SkillsUser;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;

public class SmithingHammer implements Listener {

    private final DrakovaPlugin plugin;
    private final AuraSkillsApi auraSkills;

    public SmithingHammer(DrakovaPlugin plugin) {
        this.plugin = plugin;
        this.auraSkills = AuraSkillsApi.get();
    }

    public SmithingHammer register() {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        return this;
    }

    @EventHandler
    public void onRightClickAnvil(PlayerInteractEvent event) {
        // check if we are targeting the anvil
        // check if the anvil has a hot ingot
        // after 2 clicks, put hammered iron in inventory
        // give smithing exp

        // only trigger for our main hand (this prevents triggering the offhand too
//        if (event.getHand() != EquipmentSlot.HAND) return;


        Block block = event.getClickedBlock();
        Player player = event.getPlayer();
        ItemStack hammer = event.getItem();
        if (hammer == null) return;
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK
                && hammer.getCustomModelData() == ItemModelDataEnum.SMITHING_HAMMER.getId()) {


            if (block != null && (block.getType() == Material.ANVIL
                    || block.getType() == Material.DAMAGED_ANVIL
                    || block.getType() == Material.CHIPPED_ANVIL)) {

                // check if player has Hot iron in offHand
                ItemStack offHand = player.getInventory().getItemInOffHand();

                if (offHand.isEmpty() || !offHand.hasCustomModelData() || offHand.getCustomModelData() != ItemModelDataEnum.HOT_IRON_INGOT.getId()) {
                    // do nothing if we don't have the right item
                    return;
                }

                // only cancel the event IF we have a valid set of stuff, otherwise use the anvil like normal
                event.setCancelled(true);
                // consume 1 ingot
                offHand.setAmount(offHand.getAmount() - 1);

                block.getWorld().playSound(block.getLocation(), Sound.BLOCK_ANVIL_PLACE, 0.8f, 1.0f);
                block.getWorld().spawnParticle(
                        Particle.SMALL_FLAME,
                        block.getLocation().add(0.3, 1, 0.7),
                        3, 0.2, 0.2, 0.01
                );
                block.getWorld().spawnParticle(
                        Particle.ELECTRIC_SPARK,
                        block.getLocation().add(0.9, 1.1, 0.6),
                        5, 0.5, 0.3, 0.01
                );

                SkillsUser user = auraSkills.getUser(player.getUniqueId());
                user.addSkillXp(CustomSkills.SMITHING, 10);

                // add new item to player inventory (hammered ingot)
                HashMap<Integer, ItemStack> overflow = player.getInventory().addItem(new ItemStack(Material.IRON_BARS));

                // if inventory is full, drop newly created items on at the players feet
                if (!overflow.isEmpty()) {
                    for (ItemStack item : overflow.values()) {
                        player.getWorld().dropItem(player.getLocation(), item);
                    }
                }


            }
        }
    }

    public static ItemStack create() {
        ItemStack stack = new ItemStack(Material.MACE);
        ItemMeta meta = stack.getItemMeta();
        if (meta != null) {
            meta.displayName(Component.text(ItemModelDataEnum.SMITHING_HAMMER.getDisplayName()));
            meta.lore(List.of(
                    Component.text("- With Hot Iron Ingot in offhand"),
                    Component.text("- right click anvil with hammer in main hand")
            ));
            meta.setCustomModelData(ItemModelDataEnum.SMITHING_HAMMER.getId());
            meta.setRarity(ItemRarity.UNCOMMON);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

            stack.setItemMeta(meta);
            // TODO: Stats for hammer that affect performance of smithing
        }

        return stack;
    }


}
