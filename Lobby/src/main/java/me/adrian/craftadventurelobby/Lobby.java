package me.adrian.craftadventurelobby;

import me.adrian.craftadventurelobby.Utility.Importer;
import me.adrian.craftadventurelobby.Utility.StattMatchmaking;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public final class Lobby extends JavaPlugin {


    public static ArrayList<UUID> playersinsmasher = new ArrayList<>();

    public static boolean smasherrunning = false;

    public static boolean smasherwartung = false;
    public static boolean skyminingwartung = false;







    public static void sendServer(Player player, String server) {
        if (player == null)
            return;
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

    public static Lobby main;



    @Override
    public void onEnable() {



        main = this;


        Importer.ImportListeners(this, Bukkit.getPluginManager());
        Importer.ImportCommands(this);
        Importer.ImportPluginChannels(this);

        StattMatchmaking.StartMatchmaking();



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }




}
