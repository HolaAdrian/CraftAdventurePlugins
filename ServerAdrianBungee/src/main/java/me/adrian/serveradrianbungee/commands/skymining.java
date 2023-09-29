package me.adrian.serveradrianbungee.commands;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.adrian.serveradrianbungee.ServerAdrianBungee;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class skymining extends Command {

    public skymining() {
        super("skymining", null, "");

    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (commandSender instanceof ProxiedPlayer){
            ProxiedPlayer player = (ProxiedPlayer) commandSender;
            ServerInfo skyminer = ServerAdrianBungee.main.getProxy().getServerInfo("skyminer");
            player.connect(skyminer);


        }
    }
}
