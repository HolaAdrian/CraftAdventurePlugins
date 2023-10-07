package me.adrian.craftadventurelobby.Commands;

import me.adrian.craftadventurelobby.Lobby;
import me.adrian.craftadventurelobby.Utility.Creator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;

public class TempBan implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!commandSender.hasPermission(new Permission("lobby.tempban"))){
            if (!(commandSender instanceof Player)){
                commandSender.sendMessage(ChatColor.RED + "You don't have permission to run this command");
                return false;
            }
            else {
                Player player = (Player) commandSender;
                if (Lobby.playerlanguage.containsKey(player.getUniqueId())){
                    if (Lobby.playerlanguage.get(player.getUniqueId()).equalsIgnoreCase("de")){
                        player.sendMessage(ChatColor.RED + "Du hast nicht genug Rechte für diesen Command!");
                        return false;
                    }
                    if (Lobby.playerlanguage.get(player.getUniqueId()).equalsIgnoreCase("en")){
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











        if (strings.length == 3) {
            if (Bukkit.getOfflinePlayer(strings[0]) == null) {
                commandSender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "Player not found.");
                return false;
            }
            String name = "Console";
            if (commandSender.getName() != null){
                name  = commandSender.getName();
            }
            String webhookstring = "**__Ban:__**\n__Name:__ " + strings[0] + "\n__Reason:__ " + strings[2] + "\n__Duration in Days:__ " + strings[1] + "\n__Admin:__ " + name + "\n__Ban-Id:__ " +Lobby.main.getConfig().getInt("bannumber");
            OfflinePlayer player = Bukkit.getOfflinePlayer(strings[0]);
                if (strings[1].equalsIgnoreCase("always")){
                    if (strings[2].equalsIgnoreCase("cheating")) {
                        player.banPlayer("\n" + ChatColor.DARK_RED + "You are permanently banned from the server!" + "\n" + ChatColor.GRAY + "Reason: " + ChatColor.WHITE + "Cheating" + "\n" + ChatColor.GRAY + "Appeal here: " + ChatColor.AQUA + "http://dc.craftadventure.de\n" + ChatColor.GRAY + "Ban ID: " + ChatColor.WHITE + Lobby.main.getConfig().getInt("bannumber"));
                        Creator.SetPlus1BanConfig();
                        Lobby.SendDiscordBanWebhook(webhookstring);
                        commandSender.sendMessage(ChatColor.GREEN + "Banned!");
                    }
                    else if (strings[2].equalsIgnoreCase("swearing")) {
                        player.banPlayer("\n" + ChatColor.DARK_RED + "You are permanently banned from the server!" + "\n" + ChatColor.GRAY + "Reason: " + ChatColor.WHITE + "Swearing" + "\n" + ChatColor.GRAY + "Appeal here: " + ChatColor.AQUA + "http://dc.craftadventure.de\n" + ChatColor.GRAY + "Ban ID: " + ChatColor.WHITE + Lobby.main.getConfig().getInt("bannumber"));
                        Creator.SetPlus1BanConfig();
                        Lobby.SendDiscordBanWebhook(webhookstring);
                        commandSender.sendMessage(ChatColor.GREEN + "Banned!");
                    }
                    else if (strings[2].equalsIgnoreCase("other")) {
                        player.banPlayer("\n" + ChatColor.DARK_RED + "You are permanently banned from the server!" + "\n" + ChatColor.GRAY + "Reason: " + ChatColor.WHITE + "Swearing" + "\n" + ChatColor.GRAY + "Appeal here: " + ChatColor.AQUA + "http://dc.craftadventure.de\n" + ChatColor.GRAY + "Ban ID: " + ChatColor.WHITE + Lobby.main.getConfig().getInt("bannumber"));
                        Creator.SetPlus1BanConfig();
                        Lobby.SendDiscordBanWebhook(webhookstring);
                        commandSender.sendMessage(ChatColor.GREEN + "Banned!");
                    }
                }
                else {
                    long timeinday = Long.parseLong(strings[1]);
                    long currentTime = System.currentTimeMillis();
                    long banDurationSeconds = timeinday * 24 * 60 * 60;
                    long endTime = currentTime +  (banDurationSeconds * 1000);

                    if (strings[2].equalsIgnoreCase("cheating")) {
                        player.banPlayer("\n" + ChatColor.DARK_RED + "You are temporarily banned from the server!" + "\n" + ChatColor.GRAY + "Reason: " + ChatColor.WHITE + "Cheating" + "\n" + ChatColor.GRAY + "Appeal here: " + ChatColor.AQUA + "http://dc.craftadventure.de\n" + ChatColor.GRAY + "Ban ID: " + ChatColor.WHITE + Lobby.main.getConfig().getInt("bannumber"), new Date(endTime));
                        Creator.SetPlus1BanConfig();
                        Lobby.SendDiscordBanWebhook(webhookstring);
                        commandSender.sendMessage(ChatColor.GREEN + "Banned!");
                    }
                    if (strings[2].equalsIgnoreCase("swearing")){
                        player.banPlayer("\n" + ChatColor.DARK_RED + "You are temporarily banned from the server!" + "\n" + ChatColor.GRAY + "Reason: " + ChatColor.WHITE + "Swearing" + "\n" + ChatColor.GRAY + "Appeal here: " + ChatColor.AQUA + "http://dc.craftadventure.de\n" + ChatColor.GRAY + "Ban ID: " + ChatColor.WHITE + Lobby.main.getConfig().getInt("bannumber"), new Date(endTime));
                        Creator.SetPlus1BanConfig();
                        Lobby.SendDiscordBanWebhook(webhookstring);
                        commandSender.sendMessage(ChatColor.GREEN + "Banned!");
                    }
                    if (strings[2].equalsIgnoreCase("other")){
                        player.banPlayer("\n" + ChatColor.DARK_RED + "You are temporarily banned from the server!" + "\n" + ChatColor.GRAY + "Reason: " + ChatColor.WHITE + "No reason set! (Check Discord for more)" + "\n" + ChatColor.GRAY + "Appeal here: " + ChatColor.AQUA + "http://dc.craftadventure.de\n" + ChatColor.GRAY + "Ban ID: " + ChatColor.WHITE + Lobby.main.getConfig().getInt("bannumber"), new Date(endTime));
                        Creator.SetPlus1BanConfig();
                        Lobby.SendDiscordBanWebhook(webhookstring);
                        commandSender.sendMessage(ChatColor.GREEN + "Banned!");
                    }



                }







        }
        else {
            commandSender.sendMessage(ChatColor.RED + "Syntax: /ban <name> <duration> <reason>");
            return false;
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        ArrayList<String> vorschläge = new ArrayList<>();
        if (strings.length == 1){
            for (Player p: Bukkit.getOnlinePlayers()){
                vorschläge.add(p.getName());
            }
        }
        if (strings.length == 2){
            vorschläge.add("1");
            vorschläge.add("7");
            vorschläge.add("14");
            vorschläge.add("30");
            vorschläge.add("365");
        }
        if (strings.length == 3){
            vorschläge.add("cheating");
            vorschläge.add("swearing");
            vorschläge.add("other");
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
