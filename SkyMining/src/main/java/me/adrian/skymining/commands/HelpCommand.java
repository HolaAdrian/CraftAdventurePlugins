package me.adrian.skymining.commands;

import me.adrian.skymining.SkyMining;
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

        if (SkyMining.playerlanguage.containsKey(player.getUniqueId())) {
            if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("de")) {
                TextComponent title = new TextComponent( ChatColor.GOLD + "" + ChatColor.BOLD+ "" + ChatColor.UNDERLINE +"Sky Mining:\n");
                TextComponent text = new TextComponent( ChatColor.GREEN + "In Sky Mining musst du dich auf schwebenden Inseln hocharbeiten, indem du Blöcke abbaust, und deine Tools und Rüstung verbesserst.");
                title.addExtra(text);
                player.spigot().sendMessage(title);
            } else if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("en")) {
                TextComponent title = new TextComponent( ChatColor.GOLD + "" + ChatColor.BOLD+"" + ChatColor.UNDERLINE + "Sky Mining:\n");
                TextComponent text = new TextComponent( ChatColor.GREEN + "In Sky Mining, you'll need to progress through floating islands by mining blocks and upgrading your tools and armor.");
                title.addExtra(text);
                player.spigot().sendMessage(title);
            }
        } else {
            TextComponent title = new TextComponent( ChatColor.GOLD + "" + ChatColor.BOLD+ "" + ChatColor.UNDERLINE + "Sky Mining:\n");
            TextComponent text = new TextComponent( ChatColor.GREEN + "In Sky Mining musst du dich auf schwebenden Inseln hocharbeiten, indem du Blöcke abbaust, und deine Tools und Rüstung verbesserst.");
            title.addExtra(text);
            player.spigot().sendMessage(title);
        }



        return false;
    }
}
