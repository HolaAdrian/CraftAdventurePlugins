package de.adrian.lifestealhalloween.commands;

import de.adrian.lifestealhalloween.LifeStealHalloween;
import de.adrian.lifestealhalloween.utils.Datas;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SetLivesCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!commandSender.hasPermission(new Permission("lifesteal.setlives"))){
            if (!(commandSender instanceof Player)){
                commandSender.sendMessage(ChatColor.RED + "You don't have permission to run this command");
                return false;
            }
            else {
                Player player = (Player) commandSender;
                if (LifeStealHalloween.playerlanguage.containsKey(player.getUniqueId())){
                    if (LifeStealHalloween.playerlanguage.get(player.getUniqueId()).equalsIgnoreCase("de")){
                        player.sendMessage(ChatColor.RED + "Du hast nicht genug Rechte für diesen Command!");
                        return false;
                    }
                    if (LifeStealHalloween.playerlanguage.get(player.getUniqueId()).equalsIgnoreCase("en")){
                        player.sendMessage(ChatColor.RED + "You don't have permission to run this command");
                        return false;
                    }
                }
                else {
                    player.sendMessage(ChatColor.RED + "Du hast nicht genug Rechte für diesen Command!");
                    return false;
                }
            }
        }


        if (strings.length == 2){
            if (Bukkit.getPlayer(strings[0]) != null){
                Player livesplayer = Bukkit.getPlayer(strings[0]);
                Double lives = Double.valueOf((strings[1]));
                if (lives != null){
                    Datas.playerhearts.put(livesplayer.getUniqueId(), lives);
                    livesplayer.setMaxHealth(lives);
                    livesplayer.setHealth(lives);
                    commandSender.sendMessage(ChatColor.GREEN + "Success!");
                }
                else {
                    commandSender.sendMessage(ChatColor.RED + strings[1] + " is not an nunber");
                }
            }
            else {
                commandSender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "Player not found.");
            }


        }
        else {
            commandSender.sendMessage(ChatColor.RED + "Syntax: /setlives <player> <hearts (1 = 0.5)>");
        }







        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        ArrayList<String> vorschläge = new ArrayList<>();
        if (strings.length == 1){
            for (Player p:  Bukkit.getOnlinePlayers()){
                String name = p.getName();
                vorschläge.add(name);
            }
        }
        if (strings.length == 2){
            vorschläge.add("2");
            vorschläge.add("10");
            vorschläge.add("20");
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
