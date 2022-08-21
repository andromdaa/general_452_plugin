package io.github.andromdaa.general_452_plugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class General_452_plugin extends JavaPlugin implements Listener {

    @EventHandler
    public void killFlo(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        boolean messageIsInConfig = false;
        for (String s : getConfig().getStringList("phrases")) {
            if (s.equalsIgnoreCase(event.getMessage())) {
                messageIsInConfig = true;
                break;
            }
        }
        boolean playerIsInConfig = getConfig().getStringList("player").contains(p.getName());
        if(playerIsInConfig && messageIsInConfig) {
            BukkitScheduler scheduler = getServer().getScheduler();
            scheduler.scheduleSyncDelayedTask(this, () -> p.setHealth(0.0));
        }
    }


    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
