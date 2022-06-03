package de.immernochnoah.golf.events;

import de.immernochnoah.golf.file_system.File_Manager;
import de.immernochnoah.golf.golf_system.Golf;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitEventHandler implements Listener {

    @EventHandler
    public void handlePlayerJoinEvent(PlayerQuitEvent event) {
        Player p  = event.getPlayer();
        File_Manager fm = new File_Manager();
        Golf golf = new Golf();
        golf.removePlayer(p);
        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            onlinePlayers.sendMessage(fm.getConfigText("PREFIX", "Prefix") + String.format(fm.getConfigText("MESSAGES", "Leave Nachricht"), p.getName()));
        }
        event.setQuitMessage(null);
    }
}
