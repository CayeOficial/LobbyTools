package com.cayeoficial.listeners;

import com.cayeoficial.helpers.ConfigHelper;
import com.cayeoficial.LobbyTools;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class playerInteract implements Listener {
    private final LobbyTools plugin;
    public playerInteract(LobbyTools plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {
        Player p = event.getPlayer();

        /*
         * Check if anti-interact is enabled
         */
        if(!ConfigHelper.isEnabled("Config.player-interact")) {
            /*
             * If it's enabled then check if the player's world
             * is the same as the protected world
             */
            if(Objects.equals(p.getLocation().getWorld().getName(), ConfigHelper.getString("Config.world"))) {
                /*
                 * Check if player has permission to bypass this restriction
                 */
                if(!p.hasPermission("lobbytools.admin")) {
                    /*
                     * Cancel event and warn player
                     */
                    event.setCancelled(true);
                }
            }
        }

    }
}
