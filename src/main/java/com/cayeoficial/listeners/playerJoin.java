package com.cayeoficial.listeners;

import com.cayeoficial.helpers.ConfigHelper;
import com.cayeoficial.helpers.MessageHelper;
import com.cayeoficial.helpers.SpawnHelper;
import com.cayeoficial.lobbytools;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerJoin implements Listener {
    private final lobbytools plugin;
    public playerJoin(lobbytools plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        /*
        * Get the player of the event
        */
        Player p = event.getPlayer();

        /*
        * Teleport player to spawn if enabled
        */
        SpawnHelper.sendToSpawn(p);

        /*
        * Send custom join message if enabled
        */
        if(ConfigHelper.isEnabled("OnJoin.enable-message-on-join")) {
            MessageHelper.sendMessage(p,"OnJoin.join-message");
        }

        /*
        * Launch firework if enabled
        * Needs to be a delayed task in order to the player can see it
        */
        if(ConfigHelper.isEnabled("OnJoin.launch-firework-on-join")) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () ->  p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK), 5L);
        }

        /*
        * Send title/subtitle on join if enabled
        */
        if(ConfigHelper.isEnabled("OnJoin.send-title-on-join")) {
            p.getPlayer().sendTitle(ChatColor.translateAlternateColorCodes('&', ConfigHelper.getStringWithPlaceholder(p, "OnJoin.title-message")), ChatColor.translateAlternateColorCodes('&', ConfigHelper.getStringWithPlaceholder(p, "OnJoin.subtitle-message")));
        }

        /*
        * Disable Minecraft Join message
        */
        if(ConfigHelper.isEnabled("Config.disable-minecraft-default-messages")) {
            event.setJoinMessage(null);
        }

    }

}
