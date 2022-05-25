package com.cayeoficial.helpers;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class ConfigHelper {
/*
 * [!] This is a temporal way to get
 * the plugin it has to be changed.
 */
    static Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("LobbyTools");

    static FileConfiguration config = plugin.getConfig();
    public static boolean isEnabled(String configOption) {
        return config.getBoolean(configOption);
    }
    public static String getStringWithPlaceholder(Player player, String configOption) {
        return config.getString(configOption).replaceAll("%player_name%", player.getName());
    }
    public static String getString(String configOption) {
        /*
        * DEBUG
        * System.out.println(config.getString(configOption));
        */
        return config.getString(configOption);
    }
}
