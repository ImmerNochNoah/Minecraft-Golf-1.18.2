package de.immernochnoah.golf.commands;

import de.immernochnoah.golf.golf_system.Golf;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Next_Cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        Golf golf = new Golf();
        golf.removeCurrentPlayer(p);
        return false;
    }
}
