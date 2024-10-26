package com.eldritchhollows.eH_Drakova.commands;

import com.eldritchhollows.eH_Drakova.items.BronzeAlloy;
import com.eldritchhollows.eH_Drakova.items.BronzeArmor;
import com.eldritchhollows.eH_Drakova.items.BronzeIngot;
import com.eldritchhollows.eH_Drakova.items.DarkAxe;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class GiveItem implements CommandExecutor {
    private final JavaPlugin plugin;

    public GiveItem(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command must be used as a player");
            return true;
        }

        Player player = (Player) sender;
        if (!player.hasPermission(command.getPermission())) {
            player.sendMessage(Component.text("You don't have perms for this command"));
            return true;
        }
//        player.sendMessage("Command sent "+ args.toString());
        if (args.length < 1) {
            player.sendMessage("§cUsage: /giveitem <bronze_alloy...>");
            return true;
        }

        String itemName = args[0].toLowerCase();
        ItemStack item = null;

        switch (itemName) {
            case "bronze_alloy":
                item = BronzeAlloy.create();
                break;
            case "bronze_ingot":
                item = BronzeIngot.create();
                break;
            case "bronze_helmet":
                item = BronzeArmor.createHelm();
                break;
            case "bronze_chestplate":
                item = BronzeArmor.createChestplate();
                break;
            case "dark_axe":
                item = DarkAxe.create();
                break;
            default:
                player.sendMessage("§cUnknown item. Available items: bronze_alloy, bronze_ingot, bronze_chestplate, bronze_helmet");
                return true;
        }

        int amount = 1;
        if (args.length == 2) {
            try {
                amount = Integer.parseInt(args[1]);
                if (amount < 1) {
                    player.sendMessage("§cThe amount must be at least 1.");
                    return true;
                }
            } catch (NumberFormatException e) {
                player.sendMessage("§cInvalid number. Please specify a valid amount.");
                return true;
            }
        }
        item.setAmount(amount);

        player.getInventory().addItem(item);

        return true;
    }
}
