package com.cayeoficial;

import com.cayeoficial.commands.ReloadCommand;
import com.cayeoficial.commands.SetSpawnCommand;
import com.cayeoficial.listeners.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;


public final class lobbytools extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("§aInitializing [Lobby-Tools]");
        getLogger().info("§aInitializing Lobby-Tools modules...");
        try {
        createConfig();
        events();
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
    public void events() {
        final PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new blockPlace(this), this);
        pluginManager.registerEvents(new blockBreak(this), this);
        pluginManager.registerEvents(new entityDamage(this), this);
        pluginManager.registerEvents(new entityDamageByEntity(this), this);
        pluginManager.registerEvents(new foodLevelChange(this), this);
        pluginManager.registerEvents(new playerJoin(this), this);
        pluginManager.registerEvents(new playerLeft(this), this);
        pluginManager.registerEvents(new playerChat(this), this);
        pluginManager.registerEvents(new playerInteract(this), this);

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
