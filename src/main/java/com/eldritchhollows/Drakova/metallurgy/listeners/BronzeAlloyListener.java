package com.eldritchhollows.Drakova.metallurgy.listeners;

import com.eldritchhollows.Drakova.metallurgy.items.BronzeAlloy;
import com.eldritchhollows.Drakova.utils.EItemModelData;
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
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BronzeAlloyListener implements Listener {
    private final JavaPlugin plugin;

    private final Map<UUID, Integer> playerIronCount = new HashMap<>();
    private final Map<UUID, Integer> playerCassiteriteCount = new HashMap<>();

    public BronzeAlloyListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void register() {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        // only trigger for the main hand, so we don't trigger twice each time
        if (event.getHand() != EquipmentSlot.HAND)
            return;

        // check if the player is right-clicking on a cauldron
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {

            Block block = event.getClickedBlock();
            Player player = event.getPlayer();

            if (block != null && block.getType() == Material.LAVA_CAULDRON) {
                // level 3 indicates full of lava
                UUID playerID = player.getUniqueId();
                ItemStack handItem = player.getInventory().getItemInMainHand();

                if (handItem.getType() == Material.RAW_IRON) {
                    incrementPlayerIron(playerID);
                    consumeOneItem(player);
                    player.sendMessage(Component.text("Added 1 iron (" + playerIronCount.get(playerID) + "/3)"));
                    checkForBronzeCreation(player, block);
                } else if (isRawCassiterite(handItem)) {
                    incrementCassiterite(playerID);
                    consumeOneItem(player);
                    player.sendMessage(
                            Component.text("Added 1 cassiterite (" + playerCassiteriteCount.get(playerID) + "/1)"));
                    checkForBronzeCreation(player, block);
                }

            }
        }
    }

    // Check for the actual tin item since it uses the iron nugget material, we
    // don't want to allow an actual iron nugget.
    private boolean isRawCassiterite(ItemStack item) {
        if (item.getType() != Material.IRON_NUGGET)
            return false;

        return item.hasItemMeta() && item.getItemMeta().hasCustomModelData()
                && item.getItemMeta().getCustomModelData() == EItemModelData.CASSITERITE_ORE.getId();
    }

    private void incrementPlayerIron(UUID playerId) {
        int count = playerIronCount.getOrDefault(playerId, 0);
        playerIronCount.put(playerId, count + 1);
    }

    private void incrementCassiterite(UUID playerId) {
        int count = playerCassiteriteCount.getOrDefault(playerId, 0);
        playerCassiteriteCount.put(playerId, count + 1);
    }

    private void consumeOneItem(Player player) {
        ItemStack handItem = player.getInventory().getItemInMainHand();
        handItem.setAmount(handItem.getAmount() - 1);
    }

    private void checkForBronzeCreation(Player player, Block cauldron) {
        UUID playerId = player.getUniqueId();
        if (playerIronCount.getOrDefault(playerId, 0) >= 3 && playerCassiteriteCount.getOrDefault(playerId, 0) >= 1) {
            // create the bronze alloy and drop it at the players feat
//            player.getWorld().dropItemNaturally(player.getLocation(), BronzeAlloy.create());
            player.getWorld().dropItem(player.getLocation(), BronzeAlloy.create());

            // play effects
            cauldron.getWorld().playSound(cauldron.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH, 1.0f, 1.0f);
            cauldron.getWorld().spawnParticle(
                    Particle.SMALL_FLAME,
                    cauldron.getLocation().add(0.5, 1, 0.5),
                    10, 0.2, 0.2, 0.01);
            cauldron.getWorld().spawnParticle(
                    Particle.WHITE_SMOKE,
                    cauldron.getLocation().add(0.3, 0.8, 0.4),
                    5, 0.3, 0.4, 0.01);

            player.sendMessage(Component.text("You have created Bronze Alloy!"));

            // reset counter for this player
            int currentIron = playerIronCount.getOrDefault(playerId, 0);
            int currentTin = playerCassiteriteCount.getOrDefault(playerId, 0);

            // subtract the amount required for the recipe
            // since we know for sure that this amount is already in the hashmap, we don't
            // need to check again that its
            // above the threshhold
            playerIronCount.put(playerId, currentIron - 3);
            playerCassiteriteCount.put(playerId, currentTin - 1);

        }
    }

}
