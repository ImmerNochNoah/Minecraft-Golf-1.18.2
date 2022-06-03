package de.immernochnoah.golf;

import de.immernochnoah.golf.commands.Next_Cmd;
import de.immernochnoah.golf.events.*;
import de.immernochnoah.golf.file_system.Config_File;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Config_File cf = new Config_File();
        cf.createConfig();

        for(World worlds : Bukkit.getWorlds()){
            worlds.setGameRuleValue("doDaylightCycle", "false");
            worlds.setGameRuleValue("doMobSpawning", "false");
            worlds.setThundering(false);
            worlds.setStorm(false);
            worlds.setTime(6000);
        }

        getCommand("next").setExecutor(new Next_Cmd());

        Bukkit.getPluginManager().registerEvents(new PlayerPickupItemEventHandler(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinEventHandler(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitEventHandler(), this);
        Bukkit.getPluginManager().registerEvents(new EntityInteractEventHandler(), this);
        Bukkit.getPluginManager().registerEvents(new ProtectionEventHandler(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractEventHandler(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDropItemEventHandler(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMoveEventHandler(), this);

    }

    @Override
    public void onDisable() {

    }
}
