package me.adrian.smasher.Utility;

import me.adrian.smasher.Listener.*;
import me.adrian.smasher.Smasher;
import me.adrian.smasher.commands.DiscordCommand;
import me.adrian.smasher.commands.HelpCommand;
import me.adrian.smasher.commands.LobbyCommand;
import me.adrian.smasher.commands.SetLives;
import org.bukkit.plugin.PluginManager;

public class Importer {

    public static void ImportCommands(Smasher main){
        main.getCommand("lobby").setExecutor(new LobbyCommand());
        main.getCommand("discord").setExecutor(new DiscordCommand());
        main.getCommand("lives").setExecutor(new SetLives());
        main.getCommand("help").setExecutor(new HelpCommand());
    }


    public static void ImportListeners(PluginManager pluginManager, Smasher plugin){

        pluginManager.registerEvents(new ArrowOnGroundListener(), plugin);
        pluginManager.registerEvents(new NoShitListener(), plugin);
        pluginManager.registerEvents(new ConnectionListener(), plugin);
        pluginManager.registerEvents(new RespawnListener(), plugin);
        pluginManager.registerEvents(new PlayerMoveListener(), plugin);
        pluginManager.registerEvents(new PlayerDeathListener(), plugin);
        pluginManager.registerEvents(new BreakPlaceListener(), plugin);
        pluginManager.registerEvents(new PlayerInteractListener(), plugin);



    }


    public static void ImportPluginChannels(Smasher main){

        main.getServer().getMessenger().registerOutgoingPluginChannel(main, "bungeecord:language");
        main.getServer().getMessenger().registerIncomingPluginChannel(main, "bungeecord:language",new PluginMessageListener());

        main.getServer().getMessenger().registerOutgoingPluginChannel(main, "bungeecord:kit");
        main.getServer().getMessenger().registerIncomingPluginChannel(main, "bungeecord:kit",new PluginMessageListener());

        main.getServer().getMessenger().registerIncomingPluginChannel(main, "bungeecord:kitchange",new PluginMessageListener());

        main.getServer().getMessenger().registerOutgoingPluginChannel(Smasher.main, "between:smasherlobby");

        main.getServer().getMessenger().registerOutgoingPluginChannel(main, "BungeeCord");
    }




}
