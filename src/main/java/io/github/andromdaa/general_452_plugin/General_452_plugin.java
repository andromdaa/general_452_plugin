package io.github.andromdaa.general_452_plugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class General_452_plugin extends JavaPlugin {
    private static General_452_plugin plugin;

    public static General_452_plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new OnChat(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
