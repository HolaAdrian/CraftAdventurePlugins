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

public class DiscordCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.RED + "Du musst ein Spieler sein");
            return false;
        }


        Player player = ((Player) commandSender).getPlayer();


        if (Smasher.playerlanguage.containsKey(player.getUniqueId())) {
            if (Smasher.playerlanguage.get(player.getUniqueId()).equals("de")) {
                TextComponent discord = new TextComponent(org.bukkit.ChatColor.GREEN + "Klicke hier um zu unserem Discord zu gelangen");
                discord.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/6e9uBGtaST"));
                discord.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("Join!")));
                player.spigot().sendMessage(discord);
            } else if (Smasher.playerlanguage.get(player.getUniqueId()).equals("en")) {
                TextComponent discord = new TextComponent(org.bukkit.ChatColor.GREEN + "Click here to go to our discord");
                discord.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/6e9uBGtaST"));
                discord.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("Join!")));
                player.spigot().sendMessage(discord);
            }
        } else {
            TextComponent discord = new TextComponent(org.bukkit.ChatColor.GREEN + "Klicke hier um zu unserem Discord zu gelangen");
            discord.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/6e9uBGtaST"));
            discord.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("Join!")));
            player.spigot().sendMessage(discord);
        }


        return false;
    }
}
