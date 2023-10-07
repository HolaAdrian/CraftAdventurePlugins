package de.adrian.lifestealhalloween.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import static de.adrian.lifestealhalloween.LifeStealHalloween.main;

public class LobbyCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player){

            Player player = ((Player) commandSender).getPlayer();

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeUTF("Connect");
                dataOutputStream.writeUTF("lobby");
            } catch (IOException e) {
                e.printStackTrace();
            }
            player.sendPluginMessage(main, "BungeeCord", byteArrayOutputStream.toByteArray());
            player.sendMessage(ChatColor.GREEN + "Connecting to server...");



        }
        return false;
    }
}
