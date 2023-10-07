package me.adrian.smasher.commands;

import me.adrian.smasher.Smasher;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage(ChatColor.GOLD + "Why would you need help if you aren't a player?");
            return false;
        }
        Player player = (Player) commandSender;

        if (Smasher.playerlanguage.containsKey(player.getUniqueId())) {
            if (Smasher.playerlanguage.get(player.getUniqueId()).equals("de")) {
                TextComponent title = new TextComponent( ChatColor.GOLD + "" + ChatColor.BOLD+ "" + ChatColor.UNDERLINE +"Smasher:\n");
                TextComponent text = new TextComponent( ChatColor.GREEN + "In Smasher musst du mit verschiedenen Kits deine Gegner von einer schwebenden Plattform schlagen, um dir den Sieg zu sichern!");
                title.addExtra(text);
                player.spigot().sendMessage(title);
            } else if (Smasher.playerlanguage.get(player.getUniqueId()).equals("en")) {
                TextComponent title = new TextComponent( ChatColor.GOLD + "" + ChatColor.BOLD+"" + ChatColor.UNDERLINE + "Smasher:\n");
                TextComponent text = new TextComponent( ChatColor.GREEN + "In Smasher, you must use various kits to knock your opponents off a floating platform in order to secure victory!");
                title.addExtra(text);
                player.spigot().sendMessage(title);
            }
        } else {
            TextComponent title = new TextComponent( ChatColor.GOLD + "" + ChatColor.BOLD+ "" + ChatColor.UNDERLINE + "Smasher:\n");
            TextComponent text = new TextComponent( ChatColor.GREEN + "In Smasher musst du mit verschiedenen Kits deine Gegner von einer schwebenden Plattform schlagen, um dir den Sieg zu sichern!");
            title.addExtra(text);
            player.spigot().sendMessage(title);
        }



        return false;
    }
}
