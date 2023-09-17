package me.adrian.serveradrianbungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class versioncommand extends Command {

    public versioncommand() {
        super("version", null, "");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        String message = "The Server is currently in Beta!";
        commandSender.sendMessage(message);
    }
}
