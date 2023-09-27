package me.adrian.craftadventurelobby.Commands;

import me.adrian.craftadventurelobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player){
            FileConfiguration config = Lobby.main.getConfig();

            if (config != null){
                double x = config.getDouble("spawn.x");
                double y = config.getDouble("spawn.y");
                double z = config.getDouble("spawn.z");
                float yaw = (float) config.getDouble("spawn.yaw");
                float pitch = (float) config.getDouble("spawn.pitch");
                String worldstring = config.getString("spawn.world");
                if ( Bukkit.getWorld(worldstring) != null){
                    World world = Bukkit.getWorld(worldstring);
                    Location spawn = new Location(world, x, y, z, yaw, pitch);
                    Player player = ((Player) commandSender).getPlayer();
                    player.teleport(spawn);

                    if (Lobby.playerlanguage.containsKey(player.getUniqueId())){
                        if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")){
                            player.sendMessage(ChatColor.GREEN + "Du wurdest zum Spawn teleportiert.");
                        }
                        else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")){
                            player.sendMessage(ChatColor.GREEN + "You were teleportet to the spawn.");
                        }
                    }
                    else{
                        player.sendMessage(ChatColor.GREEN + "Du wurdest zum Spawn teleportiert.");
                    }

                }




            }
            else {
                Player player = ((Player) commandSender).getPlayer();
                if (Lobby.playerlanguage.containsKey(player.getUniqueId())){
                    if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")){
                        player.sendMessage(ChatColor.RED + "Es wurde kein Spawn gefunden! Bitte frage ein Teammmitglied nach hilfe.");
                    }
                    else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")){
                        commandSender.sendMessage(ChatColor.RED + "No spawn found please ask an staff for help!");
                    }
                }
                else{
                    player.sendMessage(ChatColor.RED + "Es wurde kein Spawn gefunden! Bitte frage ein Teammmitglied nach hilfe.");
                }

            }




        }
        else {
            commandSender.sendMessage(ChatColor.RED + "You have to be a player to perform this command!");
        }




        return false;
    }
}
