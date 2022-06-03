package de.immernochnoah.golf.manager;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class StatsManager {

    public HashMap<Player, Integer> player_points = new HashMap<>();

    public void addPoints(Player p, int i) {
        if (!player_points.containsKey(p)) {
            player_points.put(p, i);
            return;
        }
        int pp = getPoints(p) + i;
        player_points.replace(p, pp);
    }

    public int getPoints(Player p) {
        if (!player_points.containsKey(p)) {
            return 0;
        }
        return player_points.get(p);
    }
}
