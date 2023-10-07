package me.adrian.craftadventurelobby.Commands;

import me.adrian.craftadventurelobby.Lobby;
import me.adrian.craftadventurelobby.Utility.StattMatchmaking;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage(ChatColor.RED + "You have to be a player to run this command!");
            return false;
        }
        Player player = ((Player) commandSender).getPlayer();
        if (!player.hasPermission(new Permission("lobby.startsmasher"))){
            if (Lobby.playerlanguage.containsKey(player.getUniqueId())){
                if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")){
                    player.sendMessage(ChatColor.RED + "Du hast keine Berechtigung diesen Command auszuführen!");
                }
                else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")){
                    player.sendMessage(ChatColor.RED + "You don't have permission to run this command!");
                }
            }
            else{
                player.sendMessage(ChatColor.RED + "Du hast keine Berechtigung diesen Command auszuführen!");
            }
            return false;
        }

        if (!StattMatchmaking.mp.contains(player.getUniqueId())|| StattMatchmaking.mp.size() < 2){
            if (Lobby.playerlanguage.containsKey(player.getUniqueId())){
                if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")){
                    player.sendMessage(ChatColor.RED + "Du bist nicht in Smasher oder bist alleine in der Que!");
                }
                else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")){
                    player.sendMessage(ChatColor.RED + "You either aren't in smasher or you are in que alone!");
                }
            }
            else{
                player.sendMessage(ChatColor.RED + "Du bist nicht in Smasher oder bist alleine in der Que!");
            }
            return false;
        }
        for (UUID uuid : StattMatchmaking.mp) {
            if (Bukkit.getPlayer(uuid) != null){
                Player p = Bukkit.getPlayer(uuid);
                if (Lobby.playerlanguage.containsKey(p.getUniqueId())){
                    if (Lobby.playerlanguage.get(p.getUniqueId()).equals("de")){
                        p.sendMessage(ChatColor.GREEN + "Der Countdown wurde auf 5 Sekunden gestellt!");
                    }
                    else if (Lobby.playerlanguage.get(p.getUniqueId()).equals("en")){
                        p.sendMessage(ChatColor.GREEN + "The countdown was set to 5 seconds!");
                    }
                }
                else{
                    p.sendMessage(ChatColor.GREEN + "Der Countdown wurde auf 5 Sekunden gestellt!");
                }
            }
        }
        StattMatchmaking.SettingCountdown = 6;



        return false;
    }
}
