package com.cayeoficial.listeners;

import com.cayeoficial.LobbyTools;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import com.cayeoficial.helpers.ConfigHelper;

public class playerLeft implements Listener {
    private final LobbyTools plugin;
    public playerLeft(LobbyTools plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerLeft(PlayerQuitEvent event) {
        /*
         * Disable Minecraft Left message
         */

        if(ConfigHelper.isEnabled("Config.disable-minecraft-default-messages")) {
            event.setQuitMessage(null);
        }
    }

}
