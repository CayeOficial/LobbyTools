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

    static FileConfiguration config = plugin.getConfig();
    public static void sendToSpawn(Player player) {
        boolean teleportToSpawn = true;
        World spawnWorld = Bukkit.getServer().getWorld(config.getString("Spawn.world"));
        if(spawnWorld == null) {
        Bukkit.getServer().getLogger().warning("⚠ ##### IMPORTANT! ##### ⚠");
        Bukkit.getServer().getLogger().warning("");
        Bukkit.getServer().getLogger().warning("The world specified in Spawn section of the plugin does not exists!");
        Bukkit.getServer().getLogger().warning("This may corrupt data! For safety purposes, the plugin will not teleport");
        Bukkit.getServer().getLogger().warning("the player to te spawn untill you fix this.");
        Bukkit.getServer().getLogger().warning("");
        Bukkit.getServer().getLogger().warning("⚠ ##### IMPORTANT! ##### ⚠");
        teleportToSpawn = false;
        }
        double spawnPosY = config.getDouble("Spawn.x");
        double spawnPosX = config.getDouble("Spawn.y");
        double spawnPosZ = config.getDouble("Spawn.z");
        float spawnYaw = (float) config.getDouble("Spawn.yaw");
        float spawnPitch = (float) config.getDouble("Spawn.pitch");
        Location spawn = new Location(spawnWorld, spawnPosX, spawnPosY, spawnPosZ);
        if(isEnabled("Spawn.teleport-player-to-spawn")) {
            if(teleportToSpawn) {
                spawn.setYaw(spawnYaw);
                player.getLocation().setPitch(spawnPitch);
                player.teleport(spawn);
            }
        }
    }

    public static void setSpawn(Player player) {
        config.set("Spawn.world", player.getLocation().getWorld().getName());
        config.set("Spawn.x", player.getLocation().getX());
        config.set("Spawn.y", player.getLocation().getY());
        config.set("Spawn.z", player.getLocation().getZ());
        config.set("Spawn.yaw", player.getLocation().getYaw());
        config.set("Spawn.pitch", player.getLocation().getPitch());
    }

}
