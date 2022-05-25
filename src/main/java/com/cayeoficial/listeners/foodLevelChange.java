package com.cayeoficial.listeners;

import com.cayeoficial.lobbytools;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class foodLevelChange implements Listener {
    private final lobbytools plugin;
    public foodLevelChange(lobbytools plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onHunger(final FoodLevelChangeEvent e) {

        /*
        * Cancel FoodLevelChangeEvent so players don't get hungry!
        */
        if(e.getEntity() != null) {
            e.setCancelled(true);
        }
    }
}
