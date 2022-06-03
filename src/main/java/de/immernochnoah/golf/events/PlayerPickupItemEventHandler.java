package de.immernochnoah.golf.events;

import de.immernochnoah.golf.golf_system.Golf;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PlayerPickupItemEventHandler implements Listener {

    @EventHandler
    public void handlePlayerMoveEvent(PlayerPickupItemEvent event) {
        Player p = event.getPlayer();
        Golf golf = new Golf();
        if (!golf.isPlayerCurrentlyPlaying(p)) {
            event.setCancelled(true);
        } else {
            golf.setPlayerMustThrow(p);
        }
    }
}
