package com.eldritchhollows.Drakova.smithing.listeners;

import com.eldritchhollows.Drakova.smithing.items.armor.IronChestplateBlank;
import com.eldritchhollows.Drakova.utils.DrakovaSkillsManager;
import com.eldritchhollows.Drakova.utils.EItemModelData;
import dev.aurelium.auraskills.api.AuraSkillsApi;
import dev.aurelium.auraskills.api.user.SkillsUser;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

public class SmithingHammerListener implements Listener {
    private final AuraSkillsApi auraSkills;

    public SmithingHammerListener(AuraSkillsApi auraSkills) {
        this.auraSkills = auraSkills;
    }

    @EventHandler
    public void onRightClickAnvil(PlayerInteractEvent event) {

        ItemStack hammer = event.getItem();
        if (hammer == null) return;
        if (event.getAction().isRightClick()
                && hammer.hasCustomModelData() && hammer.getCustomModelData() == EItemModelData.SMITHING_HAMMER.getId()) {

            Block block = event.getClickedBlock();
            Player player = event.getPlayer();

            if (block != null && List.of(Material.ANVIL, Material.DAMAGED_ANVIL, Material.CHIPPED_ANVIL).contains(block.getType())) {

                // check if player has Hot iron in offHand
                ItemStack offHand = player.getInventory().getItemInOffHand();

                if (offHand.isEmpty() || !offHand.hasCustomModelData()
                        || offHand.getCustomModelData() != EItemModelData.HOT_IRON_INGOT.getId()) {
                    // do nothing if we don't have the right item
                    return;
                }

                // only cancel the event IF we have a valid set of stuff, otherwise use the anvil like normal
                event.setCancelled(true);
                // consume 1 ingot
                offHand.setAmount(offHand.getAmount() - 1);

                block.getWorld().playSound(block.getLocation(), Sound.BLOCK_ANVIL_PLACE, -1.8f, 1.0f);
                block.getWorld().spawnParticle(
                        Particle.SMALL_FLAME,
                        block.getLocation().add(-1.3, 1, 0.7),
                        2, 0.2, 0.2, 0.01
                );
                block.getWorld().spawnParticle(
                        Particle.ELECTRIC_SPARK,
                        block.getLocation().add(-1.9, 1.1, 0.6),
                        4, 0.5, 0.3, 0.01
                );

                SkillsUser user = auraSkills.getUser(player.getUniqueId());
                user.addSkillXp(DrakovaSkillsManager.SMITHING, 9);

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

    public void ShapeArmor(IronChestplateBlank armor) {
        // check if armor is armor ??
        // check if armor is blank
        // counter for num of right clicks, takes 2 swings to shape armor
        // give smithing exp
        // give Shaped armor to user
    }


}
