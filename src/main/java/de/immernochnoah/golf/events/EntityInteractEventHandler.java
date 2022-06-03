package de.immernochnoah.golf.events;

import de.immernochnoah.golf.file_system.File_Manager;
import de.immernochnoah.golf.golf_system.Golf;
import de.immernochnoah.golf.manager.ItemManager;
import org.bukkit.*;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityAirChangeEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class EntityInteractEventHandler implements Listener {

    @EventHandler
    public void handleEntityInteractEvent(EntityInteractEvent event) {
        if (event.getBlock().getType() == Material.LIGHT_WEIGHTED_PRESSURE_PLATE) {
            event.getEntity().remove();
            File_Manager fm = new File_Manager();
            Golf golf = new Golf();
            Player p = golf.getCurrentlyPlayingPlayer();
            for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                onlinePlayers.sendMessage(fm.getConfigText("PREFIX", "Prefix") + String.format(fm.getConfigText("MESSAGES", "Global Treffer Nachricht"), p.getName()));
            }
            Firework firework = event.getBlock().getWorld().spawn(event.getBlock().getLocation().add(0,2,0),Firework.class);
            FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
            data.addEffect(FireworkEffect.builder().withColor(Color.BLUE).withColor(Color.BLUE).withColor(Color.BLUE).with(FireworkEffect.Type.BURST).withFlicker().build());
            data.setPower(1);
            firework.setFireworkMeta(data);
            p.sendMessage(fm.getConfigText("PREFIX", "Prefix") + fm.getConfigText("MESSAGES", "Treffer Nachricht"));
            p.getInventory().setItem(0,new ItemManager(Material.SNOWBALL).setDisplayName("§6Golfball §8| §7" + p.getName()).build());
            golf.removeCurrentPlayer(p);
        }
    }
}
