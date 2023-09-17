package me.adrian.serveradrianbungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class creditscommand extends Command {


    public creditscommand() {
        super("credits", null, "");

    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {

        String message = "Special Thanks to Plinn for helping!";
        commandSender.sendMessage(message);



    }
}
