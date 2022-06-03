package de.immernochnoah.golf.events;

import de.immernochnoah.golf.file_system.File_Manager;
import de.immernochnoah.golf.golf_system.Golf;
import de.immernochnoah.golf.manager.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.InputStream;

public class PlayerJoinEventHandler implements Listener {

    @EventHandler
    public void handlePlayerJoinEvent(PlayerJoinEvent event) {
        Player p  = event.getPlayer();
        File_Manager fm = new File_Manager();
        Golf golf = new Golf();
        golf.addPlayer(p);
        p.getInventory().clear();
        p.getInventory().setItem(0,new ItemManager(Material.SNOWBALL).setDisplayName("§6Golfball §8| §7" + p.getName()).build());
        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            onlinePlayers.sendMessage(fm.getConfigText("PREFIX", "Prefix") + String.format(fm.getConfigText("MESSAGES", "Join Nachricht"), p.getName()));
        }
        event.setJoinMessage(null);
    }
}
