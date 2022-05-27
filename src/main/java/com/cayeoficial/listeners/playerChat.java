package com.cayeoficial.listeners;

import com.cayeoficial.LobbyTools;
import com.cayeoficial.helpers.ConfigHelper;
import com.cayeoficial.helpers.MessageHelper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class playerChat implements Listener {
    private final LobbyTools plugin;
    public playerChat(LobbyTools plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onChat(final AsyncPlayerChatEvent event) {
        /*
        * Get the player
        */
        final Player player = event.getPlayer();
        
        /*
        * Check if the chat is enabled and if
        * the player can bypass it*/
        if(!ConfigHelper.isEnabled("Config.enable-chat")) {
            if(!player.hasPermission("LobbyTools.admin")) {
                event.setCancelled(true);
                MessageHelper.sendMessage(player, "Messages.chat-is-disabled");
            }
        }
    }
}
