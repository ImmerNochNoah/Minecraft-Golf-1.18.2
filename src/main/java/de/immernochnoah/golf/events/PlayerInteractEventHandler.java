package de.immernochnoah.golf.events;

import de.immernochnoah.golf.file_system.File_Manager;
import de.immernochnoah.golf.golf_system.Golf;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractEventHandler implements Listener {

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if (event.getPlayer().getLocation().getBlock().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
            Golf golf = new Golf();
            golf.setCurrentPlayer(p);
        }
        event.setCancelled(true);
    }
}
