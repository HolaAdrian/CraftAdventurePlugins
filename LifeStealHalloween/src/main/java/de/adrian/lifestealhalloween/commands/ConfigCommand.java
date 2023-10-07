package de.adrian.lifestealhalloween.commands;

import de.adrian.lifestealhalloween.LifeStealHalloween;
import de.adrian.lifestealhalloween.utils.SafeManager;
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

public class ConfigCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!commandSender.hasPermission(new Permission("lifesteal.config"))){
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
        if (strings.length == 1){
            if (strings[0].equalsIgnoreCase("save")){
                SafeManager.SafeAll(LifeStealHalloween.main.getConfig());
                if (!(commandSender instanceof Player)){
                    commandSender.sendMessage(ChatColor.GREEN + "The config was saved!");
                    return false;
                }
                else {
                    Player player = (Player) commandSender;
                    if (LifeStealHalloween.playerlanguage.containsKey(player.getUniqueId())){
                        if (LifeStealHalloween.playerlanguage.get(player.getUniqueId()).equalsIgnoreCase("de")){
                            player.sendMessage(ChatColor.GREEN + "Die Config wurde gespeichert!");
                            return false;
                        }
                        if (LifeStealHalloween.playerlanguage.get(player.getUniqueId()).equalsIgnoreCase("en")){
                            player.sendMessage(ChatColor.GREEN + "The config was saved!");
                            return false;
                        }
                    }
                    else {
                        player.sendMessage(ChatColor.GREEN + "Die Config wurde gespeichert!");
                        return false;
                    }
                }
            }
            if (strings[0].equalsIgnoreCase("load")){
                SafeManager.LoadAll(LifeStealHalloween.main.getConfig());
                if (!(commandSender instanceof Player)){
                    commandSender.sendMessage(ChatColor.GREEN + "The config was loaded!");
                    return false;
                }
                else {
                    Player player = (Player) commandSender;
                    if (LifeStealHalloween.playerlanguage.containsKey(player.getUniqueId())){
                        if (LifeStealHalloween.playerlanguage.get(player.getUniqueId()).equalsIgnoreCase("de")){
                            player.sendMessage(ChatColor.GREEN + "Die Config wurde geladen!");
                            return false;
                        }
                        if (LifeStealHalloween.playerlanguage.get(player.getUniqueId()).equalsIgnoreCase("en")){
                            player.sendMessage(ChatColor.GREEN + "The config was loaded!");
                            return false;
                        }
                    }
                    else {
                        player.sendMessage(ChatColor.GREEN + "Die Config wurde geladen!");
                        return false;
                    }
                }
            }
        }
        else {
            commandSender.sendMessage(ChatColor.RED + "Syntax: /config <save/load>");
        }


        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        ArrayList<String> vorschläge = new ArrayList<>();
        if (strings.length == 1){
            vorschläge.add("load");
            vorschläge.add("save");
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
