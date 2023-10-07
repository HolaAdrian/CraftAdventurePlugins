package me.adrian.skymining.commands;

import me.adrian.skymining.SkyMining;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class lobbyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player){

            Player player = ((Player) commandSender).getPlayer();

            SkyMining.sendServer(player, "lobby");



        }
        else {


        }



        return false;
    }
}
