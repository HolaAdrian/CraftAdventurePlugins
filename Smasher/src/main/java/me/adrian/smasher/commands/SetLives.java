package me.adrian.smasher.commands;

import me.adrian.smasher.Smasher;
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


public class SetLives implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        CommandSender player = commandSender;
        if (!(strings.length == 3)){
            player.sendMessage(ChatColor.RED + "Syntax: /lives <set/add> <player> <amount>");
            return false;
        }

        if (strings[0].equalsIgnoreCase("set")|| strings[0].equalsIgnoreCase("add")){
            if (Bukkit.getPlayer(strings[1]) != null){
                Integer amount = Integer.valueOf(strings[2]);
                if (strings[0].contains("set")){
                    Smasher.lives.put(Bukkit.getPlayer(strings[1]).getUniqueId(), amount);
                    player.sendMessage(ChatColor.GREEN + Bukkit.getPlayer(strings[1]).getName() + " hat jetzt " + amount + ". Leben!");
                }
                if (strings[0].contains("add")){
                    Integer i = Smasher.lives.get(Bukkit.getPlayer(strings[1]).getUniqueId());
                    Integer ii = i + amount;
                    Smasher.lives.put(Bukkit.getPlayer(strings[1]).getUniqueId(), ii);
                    player.sendMessage(ChatColor.GREEN + Bukkit.getPlayer(strings[1]).getName() + " hat jetzt " + ii + ". Leben!");
                }
            }
            else {
                player.sendMessage(ChatColor.RED + "Error: " + ChatColor.DARK_RED + "Player not found!");
            }
        }
        else {
            player.sendMessage(ChatColor.RED + "Syntax: /lives <set/add> <player> <amount>");
        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        ArrayList<String> vorschläge = new ArrayList<>();
        if (strings.length == 1){
            vorschläge.add("set");
            vorschläge.add("add");
        }
        if (strings.length == 2){
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                String name = onlinePlayer.getName();
                vorschläge.add(name);
            }
        }
        if (strings.length == 3){
            vorschläge.add("1");
            vorschläge.add("3");
            vorschläge.add("5");
            vorschläge.add("10");
            vorschläge.add("100");
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
