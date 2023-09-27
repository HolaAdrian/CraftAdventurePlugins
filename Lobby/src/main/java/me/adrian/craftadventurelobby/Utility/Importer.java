package me.adrian.craftadventurelobby.Utility;

import me.adrian.craftadventurelobby.Commands.*;
import me.adrian.craftadventurelobby.Listener.*;
import me.adrian.craftadventurelobby.Lobby;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class Importer {

    public static void ImportPermission(PluginManager pluginManager){
        pluginManager.addPermission(new Permission("lobby.wartungsarbeiten"));

    }

    public static void ImportPluginChannels(Lobby main){
        main.getServer().getMessenger().registerOutgoingPluginChannel(main, "bungeecord:language");
        main.getServer().getMessenger().registerIncomingPluginChannel(main, "bungeecord:language",new PluginMessagelistener());

        main.getServer().getMessenger().registerOutgoingPluginChannel(main, "BungeeCord");
        main.getServer().getMessenger().registerIncomingPluginChannel(main, "between:smasherlobby", new BetweenListener());

        main.getServer().getMessenger().registerOutgoingPluginChannel(main, "bungeecord:kitchange");
        main.getServer().getMessenger().registerIncomingPluginChannel(main,"bungeecord:kitchange",new PluginMessagelistener());

        main.getServer().getMessenger().registerOutgoingPluginChannel(main, "bungeecord:lobby");
    }

    public static void ImportListeners(Plugin plugin, PluginManager pluginManager){
        pluginManager.registerEvents(new BreakPlaceListener(), plugin);
        pluginManager.registerEvents(new NoShitListener(), plugin);
        pluginManager.registerEvents(new LanguageKlickListener(), plugin);
        pluginManager.registerEvents(new ConnectionListener(), plugin);
        pluginManager.registerEvents(new VillagerLobbyClickListener(), plugin);
        pluginManager.registerEvents(new KitCLickListener(), plugin);
        pluginManager.registerEvents(new StopQueListener(), plugin);
        pluginManager.registerEvents(new VillagerSilentListener(), plugin);
        pluginManager.registerEvents(new LanguageClickListener(), plugin);
        pluginManager.registerEvents(new KitKlickListener(), plugin);
        pluginManager.registerEvents(new KompassClickListener(), plugin);
        pluginManager.registerEvents(new KompassKlickListener(), plugin);
    }

    public static void ImportCommands(Lobby main){
        main.getCommand("spawn").setExecutor(new SpawnCommand());
        main.getCommand("setspawn").setExecutor(new SetspawnCommand());
        main.getCommand("smasherresume").setExecutor(new smasherresumeCommand());
        main.getCommand("discord").setExecutor(new DiscordCommand());
        main.getCommand("wartung").setExecutor(new WartungsarbeitenCommand());
    }



}
