package com.cayeoficial.listeners;

import com.cayeoficial.lobbytools;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class playerChat implements Listener {
    private final lobbytools plugin;
    public playerChat(lobbytools plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onChat(final AsyncPlayerChatEvent event) {
        FileConfiguration config = plugin.getConfig();
        String chatIsEnabled = "Config.enable-chat";
        String chatIsDisabled = "Messages.chat-is-disabled";
        final Player p = event.getPlayer();
        if(!config.getBoolean(chatIsEnabled)) {
            if(!p.hasPermission("lobbytools.admin")) {
                event.setCancelled(true);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(chatIsDisabled)));
            }
        }
    }
}
