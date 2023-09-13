package me.adrian.craftadventurelobby.Utility;

import me.adrian.craftadventurelobby.Commands.SetspawnCommand;
import me.adrian.craftadventurelobby.Commands.SpawnCommand;
import me.adrian.craftadventurelobby.Listener.*;
import me.adrian.craftadventurelobby.Lobby;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class Importer {

    public static void ImportPluginChannels(Lobby main){
        main.getServer().getMessenger().registerOutgoingPluginChannel(main, "bungeecord:language");
        main.getServer().getMessenger().registerIncomingPluginChannel(main, "bungeecord:language",new PluginMessagelistener());

        main.getServer().getMessenger().registerOutgoingPluginChannel(main, "BungeeCord");

        main.getServer().getMessenger().registerOutgoingPluginChannel(main, "bungeecord:kit");
        main.getServer().getMessenger().registerIncomingPluginChannel(main, "bungeecord:kit",new PluginMessagelistener());
    }

    public static void ImportListeners(Plugin plugin, PluginManager pluginManager){
        pluginManager.registerEvents(new BreakPlaceListener(), plugin);
        pluginManager.registerEvents(new NoShitListener(), plugin);
        pluginManager.registerEvents(new LanguageKlickListener(), plugin);
        pluginManager.registerEvents(new CompassClickListener(), plugin);
        pluginManager.registerEvents(new ConnectionListener(), plugin);
        pluginManager.registerEvents(new VillagerLobbyClickListener(), plugin);
        pluginManager.registerEvents(new KitCLickListener(), plugin);
    }

    public static void ImportCommands(Lobby main){
        main.getCommand("spawn").setExecutor(new SpawnCommand());
        main.getCommand("setspawn").setExecutor(new SetspawnCommand());
    }



}
