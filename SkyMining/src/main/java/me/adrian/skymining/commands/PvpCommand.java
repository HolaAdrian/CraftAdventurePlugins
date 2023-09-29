package me.adrian.skymining.commands;

import me.adrian.skymining.SkyMining;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
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

public class PvpCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (!(commandSender instanceof Player)){
            commandSender.sendMessage(ChatColor.RED + "You have to be a player to change your pvp mode!");
            return false;
        }


        Player player = ((Player) commandSender).getPlayer();

        if (!(strings.length == 1)){
            player.sendMessage(ChatColor.RED + "Sytax: /pvp <on/off>");

        }
        else {
            if (strings[0].equalsIgnoreCase("on")){
                SkyMining.pvpon.put(player.getUniqueId(), true);
                if (SkyMining.playerlanguage.containsKey(player.getUniqueId())) {
                    if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("de")) {
                        player.sendMessage(ChatColor.GREEN + "Pvp ist jetzt eingeschaltet!");
                    } else if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("en")) {
                        player.sendMessage(ChatColor.GREEN + "Pvp is now enabled!");
                    }
                } else {
                    player.sendMessage(ChatColor.GREEN + "Pvp ist jetzt eingeschaltet!");
                }
            }
            else if (strings[0].equalsIgnoreCase("off")){
                SkyMining.pvpon.put(player.getUniqueId(), false);
                if (SkyMining.playerlanguage.containsKey(player.getUniqueId())) {
                    if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("de")) {
                        player.sendMessage(ChatColor.GREEN + "Pvp ist jetzt ausgeschaltet!");
                    } else if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("en")) {
                        player.sendMessage(ChatColor.GREEN + "Pvp is now disabled!");
                    }
                } else {
                    player.sendMessage(ChatColor.GREEN + "Pvp ist jetzt ausgeschaltet!");
                }
            }
            else {
                player.sendMessage(ChatColor.RED + "Sytax: /pvp <on/off>");
            }




        }



        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        ArrayList<String> vorschläge = new ArrayList<>();
        if (strings.length == 1){
            vorschläge.add("on");
            vorschläge.add("off");
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
