package com.cayeoficial.helpers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class MessageHelper {
    /*
     * [!] This is a temporal way to get
     * the plugin it has to be changed.
     */
    static Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("LobbyTools");
    static FileConfiguration config = plugin.getConfig();

    public static void sendMessage(Player player, String configOption) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(configOption).replaceAll("%player_name%", player.getName())));
    }
}
