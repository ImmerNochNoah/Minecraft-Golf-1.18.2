package de.immernochnoah.golf.events;

import de.immernochnoah.golf.file_system.File_Manager;
import de.immernochnoah.golf.golf_system.Golf;
import de.immernochnoah.golf.manager.ItemManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItemEventHandler implements Listener {

    @EventHandler
    public void handlePlayerDropItemEvent(PlayerDropItemEvent event) {
        Player p = event.getPlayer();
        File_Manager fm = new File_Manager();
        Golf golf = new Golf();
        if (!golf.isPlayerCurrentlyPlaying(p)) {
            event.setCancelled(true);
            p.sendMessage(fm.getConfigText("PREFIX", "Prefix") + String.format(fm.getConfigText("MESSAGES", "Nicht dran Nachricht"), p.getName()));
            p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f ,1.0f);

        } else {
            golf.removePlayerMustThrow(p);
            //5 Sekunden warten bis man wieder laufen kann hinzufügen...
        }
    }
}
