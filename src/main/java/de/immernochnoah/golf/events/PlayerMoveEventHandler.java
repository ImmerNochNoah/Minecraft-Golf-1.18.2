package de.immernochnoah.golf.events;

import de.immernochnoah.golf.golf_system.Golf;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class PlayerMoveEventHandler implements Listener {

    @EventHandler
    public void handlePlayerMoveEvent(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        Golf golf = new Golf();
        if (golf.playerMustThrow(p)) {
            Location loc = event.getFrom().getBlock().getLocation();
            loc.subtract(event.getFrom().getBlock().getX() > 0 ? 0.5 : -0.5, 0.0, event.getFrom().getBlock().getY()  > 0 ? 0.5 : -0.5);
            event.getPlayer().teleport(loc.setDirection(event.getTo().getDirection()));
        }
    }
}
