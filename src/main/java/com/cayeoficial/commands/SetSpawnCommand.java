package com.cayeoficial.commands;

import com.cayeoficial.helpers.ConfigHelper;
import com.cayeoficial.helpers.MessageHelper;
import com.cayeoficial.lobbytools;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawnCommand implements CommandExecutor {
    private final lobbytools plugin;
    public SetSpawnCommand(lobbytools plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        FileConfiguration config = plugin.getConfig();

        if(!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ConfigHelper.getString("Messages.cannot-execute-by-console"));
            return false;
        } else {
            Player p = (Player) sender;
            if(p.hasPermission("lobbytools.admin")) {
                config.set("Spawn.world", p.getLocation().getWorld().getName());
                config.set("Spawn.x", p.getLocation().getX());
                config.set("Spawn.y", p.getLocation().getY());
                config.set("Spawn.z", p.getLocation().getZ());
                config.set("Spawn.yaw", p.getLocation().getYaw());
                config.set("Spawn.pitch", p.getLocation().getPitch());
                plugin.saveConfig();
                MessageHelper.sendMessage(p, "Spawn.spawn-set-message");
            } else {
                MessageHelper.sendMessage(p, "Messages.no-permission-error");
            }

        }
        return true;
    }

}
