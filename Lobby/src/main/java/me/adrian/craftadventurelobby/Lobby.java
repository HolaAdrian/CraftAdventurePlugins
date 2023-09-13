package me.adrian.craftadventurelobby;

import me.adrian.craftadventurelobby.Utility.Importer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public final class Lobby extends JavaPlugin {


    public static ArrayList<UUID> playersinsmasher = new ArrayList<>();

    public static boolean smasherrunning = false;





    public static void sendServer(Player player, String server) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeUTF("Connect");
            dataOutputStream.writeUTF(server);
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.sendPluginMessage(main, "BungeeCord", byteArrayOutputStream.toByteArray());
        player.sendMessage(ChatColor.GREEN + "Connecting to server...");
    }

    public static HashMap<UUID, String> playerlanguage = new HashMap<>();

    public static HashMap<String, Integer> serverplayers = new HashMap<>();

    public static Lobby main;

    @Override
    public void onEnable() {
        main = this;
        Importer.ImportListeners(this, Bukkit.getPluginManager());
        Importer.ImportCommands(this);
        Importer.ImportPluginChannels(this);



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
