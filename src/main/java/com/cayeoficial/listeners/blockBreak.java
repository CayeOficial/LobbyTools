package com.cayeoficial.listeners;

import com.cayeoficial.helpers.ConfigHelper;
import com.cayeoficial.helpers.MessageHelper;
import com.cayeoficial.LobbyTools;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Objects;

public class blockBreak implements Listener {
    private final LobbyTools plugin;
    public blockBreak(LobbyTools plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onBlockBreak(final BlockBreakEvent event) {
        Player p = event.getPlayer();

        /*
         * Check if anti-block break is enabled
         */
        if(!ConfigHelper.isEnabled("Config.block-break")) {
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
                    MessageHelper.sendMessage(p, "Messages.cannot-break-blocks");
                }
            }
        }

    }
}
