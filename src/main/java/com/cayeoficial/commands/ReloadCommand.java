package com.cayeoficial.commands;

import com.cayeoficial.helpers.ConfigHelper;
import com.cayeoficial.helpers.MessageHelper;
import com.cayeoficial.LobbyTools;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {
    private final LobbyTools plugin;
    public ReloadCommand(LobbyTools plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ConfigHelper.getString("Messages.reload-message"));
            plugin.reloadConfig();
        } else {
            Player p = (Player) sender;
            if(p.hasPermission("lobbytools.admin")) {
                plugin.reloadConfig();
                MessageHelper.sendMessage(p, "Messages.reload-message");
            } else {
                MessageHelper.sendMessage(p, "Messages.no-permission-error");
            }

        }
        return true;
    }

}




