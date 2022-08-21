package io.github.andromdaa.general_452_plugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitScheduler;

public class OnChat implements Listener {
    General_452_plugin plugin = General_452_plugin.getPlugin();
    @EventHandler
    public void killOffendingPlayer(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        boolean messageIsInConfig = false;
        for (String s : plugin.getConfig().getStringList("phrases")) {
            if (s.equalsIgnoreCase(event.getMessage())) {
                messageIsInConfig = true;
                break;
            }
        }
        boolean playerIsInConfig = plugin.getConfig().getStringList("player").contains(p.getName());
        if(playerIsInConfig && messageIsInConfig) {
            BukkitScheduler scheduler = plugin.getServer().getScheduler();
            scheduler.scheduleSyncDelayedTask(plugin, () -> p.setHealth(0.0));
        }
    }
}
