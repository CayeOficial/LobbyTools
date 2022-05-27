package com.cayeoficial;

import com.cayeoficial.commands.ReloadCommand;
import com.cayeoficial.commands.SetSpawnCommand;
import com.cayeoficial.listeners.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;


public final class lobbytools extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("§aInitializing [Lobby-Tools]");
        getLogger().info("§aInitializing Lobby-Tools modules...");
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
 }
