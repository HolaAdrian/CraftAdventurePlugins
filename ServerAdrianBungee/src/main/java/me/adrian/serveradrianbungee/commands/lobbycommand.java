package me.adrian.serveradrianbungee.commands;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.io.ByteArrayOutputStream;

public class lobbycommand extends Command{

    public lobbycommand() {
        super("language", null, "sprache");

    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (commandSender instanceof ProxiedPlayer){
            ProxiedPlayer player = (ProxiedPlayer) commandSender;

            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("ShowInventory");
            out.writeUTF(player.getUniqueId().toString());
            player.getServer().sendData("bungeecord:language", out.toByteArray());


        }

    }
}
