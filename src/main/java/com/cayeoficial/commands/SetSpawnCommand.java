package com.cayeoficial.commands;

import com.cayeoficial.LobbyTools;
import com.cayeoficial.helpers.ConfigHelper;
import com.cayeoficial.helpers.MessageHelper;
import com.cayeoficial.helpers.SpawnHelper;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawnCommand implements CommandExecutor {
    private final LobbyTools plugin;
    public SetSpawnCommand(LobbyTools plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        
        /*
        * Check if the command is executed via console
        */
        if(!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ConfigHelper.getString("Messages.cannot-execute-by-console"));
            return false;
        } else {
            /*
            * Set the spawn if it's a player and have permissions
            */
            Player player = (Player) sender;
            if(player.hasPermission("LobbyTools.admin")) {
                SpawnHelper.setSpawn(player);
                plugin.saveConfig();
                MessageHelper.sendMessage(player, "Spawn.spawn-set-message");
            } else {
                MessageHelper.sendMessage(player, "Messages.no-permission-error");
            }

        }
        return true;
    }

}
