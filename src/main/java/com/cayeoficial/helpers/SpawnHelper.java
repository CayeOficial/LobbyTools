package com.cayeoficial.helpers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import static com.cayeoficial.helpers.ConfigHelper.isEnabled;


public class SpawnHelper {
    /*
     * [!] This is a temporal way to get
     * the plugin it has to be changed.
     */
    static Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("LobbyTools");

    public static void sendToSpawn(Player player) {
        FileConfiguration config = plugin.getConfig();
        World spawnWorld = Bukkit.getServer().getWorld(config.getString("Spawn.world"));
        double spawnPosY = config.getDouble("Spawn.x");
        double spawnPosX = config.getDouble("Spawn.y");
        double spawnPosZ = config.getDouble("Spawn.z");
        float spawnYaw = (float) config.getDouble("Spawn.yaw");
        float spawnPitch = (float) config.getDouble("Spawn.pitch");
        Location spawn = new Location(spawnWorld, spawnPosX, spawnPosY, spawnPosZ);
        if(isEnabled("Spawn.teleport-player-to-spawn")) {
            spawn.setYaw(spawnYaw);
            player.getLocation().setPitch(spawnPitch);
            player.teleport(spawn);
        }
    }

}
