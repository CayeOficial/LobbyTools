package com.cayeoficial.listeners;

import com.cayeoficial.helpers.ConfigHelper;
import com.cayeoficial.lobbytools;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Objects;

public class entityDamage implements Listener {
    private final lobbytools plugin;

    public entityDamage(lobbytools plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        /*
         * Check if damage is enabled
         */
        if (!ConfigHelper.isEnabled("Config.enable-damage")) {

            /*
             * If it's enabled then check if the player's world
             * is the same as the protected world
             */
            if (Objects.equals(event.getEntity().getLocation().getWorld().getName(), ConfigHelper.getString("Config.world"))) {
                event.setCancelled(true);
            }
        }
    }
}
