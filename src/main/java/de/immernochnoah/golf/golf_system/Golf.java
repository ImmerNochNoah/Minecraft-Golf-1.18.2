package de.immernochnoah.golf.golf_system;

import de.immernochnoah.golf.file_system.File_Manager;
import de.immernochnoah.golf.manager.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Golf {

    private static ArrayList<Player> golf_player = new ArrayList<>();
    public static ArrayList<Player> currently_playing = new ArrayList<>();
    public static ArrayList<Player> playerMustThrow = new ArrayList<>();

    public boolean playerMustThrow(Player p) {
        return playerMustThrow.contains(p);
    }

    public Player getCurrentlyPlayingPlayer() {
        return currently_playing.get(0);
    }

    public void setPlayerMustThrow(Player p) {
        if (!playerMustThrow.contains(p)) {
            playerMustThrow.add(p);
        }
    }

    public void removePlayerMustThrow(Player p) {
        playerMustThrow.remove(p);
    }

    public boolean isPlayerCurrentlyPlaying(Player p) {
        return currently_playing.contains(p);
    }

    public void removeCurrentPlayer(Player p) {
        File_Manager fm = new File_Manager();
        if (currently_playing.contains(p)) {
            p.sendMessage(fm.getConfigText("PREFIX", "Prefix") + String.format(fm.getConfigText("MESSAGES", "Du bist Fertig Nachricht"), p.getName()));
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_YES, 1.0f, 1.0f);
            p.teleport(p.getLocation().add(0, 0, -3));
            removePlayerMustThrow(p);
            currently_playing.remove(p);
        }
    }

    public void setCurrentPlayer(Player p) {
        File_Manager fm = new File_Manager();
        if (currently_playing.isEmpty() || currently_playing.contains(p)) {
            if (!currently_playing.contains(p)) {
                currently_playing.add(p);
                p.sendMessage(fm.getConfigText("PREFIX", "Prefix") + String.format(fm.getConfigText("MESSAGES", "Du bist dran Nachricht"), p.getName()));
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                setPlayerMustThrow(p);
            }
        } else {
            p.sendMessage(fm.getConfigText("PREFIX", "Prefix") + String.format(fm.getConfigText("MESSAGES", "Nicht dran Nachricht"), p.getName()));
            p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
            Vector v = p.getLocation().getDirection().multiply(0.5D).setY(0.5D);
            p.setVelocity(v);
        }
    }

    public void addPlayer(Player p) {
        File_Manager fm = new File_Manager();
        if (!golf_player.contains(p)) {
            golf_player.add(p);

            p.sendMessage(fm.getConfigText("PREFIX", "Prefix") + fm.getConfigText("MESSAGES", "Golf Nachricht"));
        }

    }

    public void removePlayer(Player p) {
        golf_player.remove(p);
        currently_playing.remove(p);
    }


}
