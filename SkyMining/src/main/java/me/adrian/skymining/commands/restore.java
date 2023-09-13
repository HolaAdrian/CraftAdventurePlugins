package me.adrian.skymining.commands;

import me.adrian.skymining.SkyMining;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class restore implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player){
            Player player = ((Player) commandSender).getPlayer();

            if (player.hasPermission("skyminer.restoregamerules")){
                player.performCommand("time set day");
                player.performCommand("weather clear");
                player.performCommand("gamerule keepInventory true");
                player.performCommand("gamerule doDaylightCycle false");
                player.performCommand("gamerule doWeatherCycle false");
                player.performCommand("gamerule fallDamage false");
                player.performCommand("gamerule commandBlockOutput false");
                player.performCommand("gamerule announceAdvancements false");


                    player.sendMessage(ChatColor.GREEN + "Die Grundeinstellungen wurden wiederherrgesttellt");



            }

            else {


                    player.sendMessage(ChatColor.RED + "Du hst keine Berechtigungen für diesen Command!");



            }

        }
        else {

            commandSender.sendMessage(ChatColor.RED + "You have to be a player!");
        }





        return false;
    }
}
