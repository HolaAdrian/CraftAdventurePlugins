package me.adrian.craftadventurelobby.Commands;

import me.adrian.craftadventurelobby.Lobby;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;

public class SetspawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player){
            Player player = ((Player) commandSender).getPlayer();
            if (player.hasPermission(new Permission("lobby.setspawn"))){
                Location spawn = player.getLocation();
                double x = spawn.getX();
                double y = spawn.getY();
                double z = spawn.getZ();
                String world = spawn.getWorld().getName();
                float yaw = spawn.getYaw();
                float pitch = spawn.getPitch();
                safe(x, y, z, yaw, pitch, world, Lobby.main.getConfig(), player, Lobby.main);




            }
            else {
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

            }

        }
        else {
            commandSender.sendMessage(ChatColor.RED + "You have to be a player to perform this command!");
        }
        return false;
    }

    private static void safe(double x, double y, double z, float yaw, float pitch, String world, FileConfiguration config, Player player, Lobby main){
        if (config != null){
            config.set("spawn.x" , x);
            config.set("spawn.y" , y);
            config.set("spawn.z" , z);
            config.set("spawn.yaw", yaw);
            config.set("spawn.pitch", pitch);
            config.set("spawn.world", world);
            config.set("bannumber", config.getInt("bannumber"));
            main.saveConfig();

            if (Lobby.playerlanguage.containsKey(player.getUniqueId())){
                if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")){
                    player.sendMessage(ChatColor.GREEN + "Der Spawn wurde gesetzt!");
                }
                else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")){
                    player.sendMessage(ChatColor.GREEN + "The spawn was set!");
                }
            }
            else{
                player.sendMessage(ChatColor.GREEN + "Der Spawn wurde gesetzt!");
            }



        }
        else {
            if (Lobby.playerlanguage.containsKey(player.getUniqueId())){
                if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")){
                    player.sendMessage(ChatColor.RED + "Es wurde keine config gefunden!");
                }
                else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")){
                    player.sendMessage(ChatColor.RED + "No config was found!");
                }
            }
            else{
                player.sendMessage(ChatColor.RED + "Es wurde keine config gefunden!");
            }

        }

    }



}
