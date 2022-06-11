package com.cayeoficial;

import com.cayeoficial.commands.ReloadCommand;
import com.cayeoficial.commands.SetSpawnCommand;
import com.cayeoficial.helpers.UpdateHelper;
import com.cayeoficial.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;


public final class LobbyTools extends JavaPlugin implements Listener {

    private Plugin plugin;
    @Override
    public void onEnable() {
        plugin = this;
        getLogger().info("§aInitializing [Lobby-Tools]");
        getLogger().info("§aInitializing Lobby-Tools modules...");
        new UpdateHelper(this, 98023).getVersion(version -> {
            if(this.getDescription().getVersion().equals(version)) {
                getLogger().info("§2Great!§a You're using the lastest version of LobbyTools, thanks for downloading!");
            } else {
                getLogger().info("§bThere's a new version of LobbyTools available");
                getLogger().info("§bGet it at: https://www.spigotmc.org/resources/98023/");
            }
        });
        try {
        createConfig();
        registerEvents();
        commands();
        } catch(Exception exception) {
        getLogger().info("§c[ERROR] Failed to initialize plugin's modules.");
        getLogger().info("§cHere's the error StackTrace, please include it when contacting the owner of the plugin.");
        exception.printStackTrace();
        }

    }

    @Override
    public void onDisable() {
        getLogger().info("§cDisabling Lobby-Tools");
    }
    public void registerEvents() {
        final PluginManager pluginManager = this.getServer().getPluginManager();
        Arrays.asList(
                new blockPlace(this),
                new blockBreak(this),
                new entityDamage(this),
                new entityDamageByEntity(this),
                new foodLevelChange(this),
                new playerJoin(this),
                new playerLeft(this),
                new playerChat(this),
                new playerInteract(this)
        ).forEach(event -> pluginManager.registerEvents(event, this));
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
        if(checkForIncompatibilities()) {
        Arrays.asList(
                "##### WARNING #####",
                "",
                "[!] DeluxeHub is installed on your server, you",
                "can't actually use both without issues.",
                "",
                "Please remove DeluxeHub from your plugin list",
                "",
                "##### WARNING #####"
        ).forEach(string -> getLogger().warning(string));
            }
        }, 0L);
    }
    public void commands() {
        Objects.requireNonNull(this.getCommand("setspawn")).setExecutor(new SetSpawnCommand(this));
        Objects.requireNonNull(this.getCommand("ltreload")).setExecutor(new ReloadCommand(this));
    }
    public void createConfig() {
        File config = new File(this.getDataFolder(), "config.yml");

        if (!config.exists()) {
            this.getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }
    }

    public Plugin getPlugin() {
        return plugin;
    }

    private boolean checkForIncompatibilities() {
        return Bukkit.getPluginManager().isPluginEnabled("DeluxeHub");
    }

 }
