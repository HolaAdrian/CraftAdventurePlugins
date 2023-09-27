package me.adrian.craftadventurelobby.Commands;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.adrian.craftadventurelobby.Lobby;
import me.adrian.craftadventurelobby.Utility.Creator;
import me.adrian.craftadventurelobby.Utility.StattMatchmaking;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WartungsarbeitenCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage(ChatColor.RED + "You have to be a player to perform this command!");
            return false;



        }

        Player player = ((Player) commandSender).getPlayer();

        if (!player.hasPermission("lobby.wartungsarbeiten")){
            if (Lobby.playerlanguage.containsKey(player.getUniqueId())) {
                if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")) {
                    player.sendMessage(ChatColor.RED + "Du hast keine Rechte diesen Command auszuführen!");
                } else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")) {
                    player.sendMessage(ChatColor.RED + "You don't have permission to run this command!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Du hast keine Rechte diesen Command auszuführen!");
            }

            return false;
        }

        if (strings.length == 0){

            if (!Lobby.main.getServer().hasWhitelist()){
                Lobby.main.getServer().setWhitelist(true);
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("la");
                Lobby.main.getServer().sendPluginMessage(Lobby.main, "bungeecord:lobby", out.toByteArray());
                if (Lobby.playerlanguage.containsKey(player.getUniqueId())) {
                    if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")) {
                        player.sendMessage(ChatColor.GREEN + "Der Server ist nun im Wartungsmodus");
                    } else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")) {
                        player.sendMessage(ChatColor.GREEN + "The server is now in locked mode!");
                    }
                } else {
                    player.sendMessage(ChatColor.GREEN + "Der Server ist nun im Wartungsmodus");
                }
            }
            else {
                Lobby.main.getServer().setWhitelist(false);
                if (Lobby.playerlanguage.containsKey(player.getUniqueId())) {
                    if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")) {
                        player.sendMessage(ChatColor.GREEN + "Der Server ist nun ncihtmehr im Wartungsmodus");
                    } else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")) {
                        player.sendMessage(ChatColor.GREEN + "The server is now no longer in locked mode!");
                    }
                } else {
                    player.sendMessage(ChatColor.GREEN + "Der Server ist nun nichtmehr im Wartungsmodus");
                }
            }
        }
        else if (strings.length == 1){
            if (strings[0].equalsIgnoreCase("all")){
                if (!Lobby.main.getServer().hasWhitelist()){
                    ByteArrayDataOutput out = ByteStreams.newDataOutput();
                    out.writeUTF("la");
                    Lobby.main.getServer().sendPluginMessage(Lobby.main, "bungeecord:lobby", out.toByteArray());
                    if (Lobby.playerlanguage.containsKey(player.getUniqueId())) {
                        if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")) {
                            player.sendMessage(ChatColor.GREEN + "Der Server ist nun im Wartungsmodus");
                        } else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")) {
                            player.sendMessage(ChatColor.GREEN + "The server is now in locked mode!");
                        }
                    } else {
                        player.sendMessage(ChatColor.GREEN + "Der Server ist nun im Wartungsmodus");
                    }





                }
                else {
                    Lobby.main.getServer().setWhitelist(false);
                    if (Lobby.playerlanguage.containsKey(player.getUniqueId())) {
                        if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")) {
                            player.sendMessage(ChatColor.GREEN + "Der Server ist nun nichtmehr im Wartungsmodus");
                        } else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")) {
                            player.sendMessage(ChatColor.GREEN + "The server is now no longer in locked mode!");
                        }
                    } else {
                        player.sendMessage(ChatColor.GREEN + "Der Server ist nun nichtmehr im Wartungsmodus");
                    }
                }

            }
            if (strings[0].equalsIgnoreCase("Smasher")){
                if (Lobby.smasherwartung == true){
                    Lobby.smasherwartung = false;
                    if (Lobby.playerlanguage.containsKey(player.getUniqueId())) {
                        if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")) {
                            player.sendMessage(ChatColor.GREEN + "Smasher ist nun nichtmehr im Wartungsmodus!");
                        } else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")) {
                            player.sendMessage(ChatColor.GREEN + "Smasher is now no longer in locked mode!");
                        }
                    } else {
                        player.sendMessage(ChatColor.GREEN + "Smasher ist nun nichtmehr im Wartungsmodus!");
                    }
                }
                else {
                    Lobby.smasherwartung = true;
                    for (UUID uuid: StattMatchmaking.mp){
                        if (Bukkit.getPlayer(uuid) != null){
                            Player player1 = Bukkit.getPlayer(uuid);
                            player1.getInventory().clear();
                            player1.getInventory().setHeldItemSlot(0);
                            Creator.SetLobbyItems(player1);
                            player1.setLevel(0);
                        }
                    }
                    StattMatchmaking.mp.clear();
                    if (Lobby.playerlanguage.containsKey(player.getUniqueId())) {
                        if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")) {
                            player.sendMessage(ChatColor.GREEN + "Smasher ist nun im Wartungsmodus!");
                        } else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")) {
                            player.sendMessage(ChatColor.GREEN + "Smasher is now in locked mode!");
                        }
                    } else {
                        player.sendMessage(ChatColor.GREEN + "Smasher ist nun im Wartungsmodus!");
                    }
                }

            }
            if (strings[0].equalsIgnoreCase("SkyMining")){
                if (Lobby.skyminingwartung == true){
                    Lobby.skyminingwartung = false;
                    if (Lobby.playerlanguage.containsKey(player.getUniqueId())) {
                        if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")) {
                            player.sendMessage(ChatColor.GREEN + "Sky Mining ist nun nichtmehr im Wartungsmodus!");
                        } else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")) {
                            player.sendMessage(ChatColor.GREEN + "Sky Mining is now no longer in locked mode!");
                        }
                    } else {
                        player.sendMessage(ChatColor.GREEN + "Sky Mining ist nun nichtmehr im Wartungsmodus!");
                    }
                }
                else {
                    Lobby.skyminingwartung = true;
                    if (Lobby.playerlanguage.containsKey(player.getUniqueId())) {
                        if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")) {
                            player.sendMessage(ChatColor.GREEN + "Sky Mining ist nun im Wartungsmodus!");
                        } else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")) {
                            player.sendMessage(ChatColor.GREEN + "Sky Mining is now in locked mode!");
                        }
                    } else {
                        player.sendMessage(ChatColor.GREEN + "Sky Mining ist nun im Wartungsmodus!");
                    }
                }

            }
        }
        else {
            player.sendMessage(ChatColor.RED + "Syntax: /wartung <Spielmodus (Optional)>");
        }



        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        ArrayList<String> vorschläge = new ArrayList<>();
        if (strings.length == 1){
            vorschläge.add("Smasher");
            vorschläge.add("SkyMining");
            vorschläge.add("All");
        }
        ArrayList<String> startingWith = new ArrayList<>();

        String arg = strings[strings.length -1];

        for (String s1 : vorschläge) {
            if (s1.toLowerCase().startsWith(arg)|| s1.startsWith(arg)){
                startingWith.add(s1);
            }
        }



        return startingWith;
    }
}
