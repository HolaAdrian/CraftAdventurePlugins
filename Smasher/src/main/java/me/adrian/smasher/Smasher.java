package me.adrian.smasher;

import me.adrian.smasher.Utility.Cooldown;
import me.adrian.smasher.Utility.Importer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public final class Smasher extends JavaPlugin {

    public static HashMap<UUID, String> playerkit = new HashMap<>();


    public static void sendServer(Player player, String server) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeUTF("Connect");
            dataOutputStream.writeUTF(server);
        } catch (IOException ignored) {
        }
        player.sendPluginMessage(main, "BungeeCord", byteArrayOutputStream.toByteArray());
    }

    public static Integer randomGenerator(Integer minnimum, Integer maximum){

        Random random = new Random();

        int randomNumber = random.nextInt(maximum - minnimum + 1) + minnimum;

        return randomNumber;
    }


    public static Integer playersalive = 0;

    public static ArrayList<UUID> deathPlayers = new ArrayList<>();

    public static ArrayList<UUID> playingPlayers = new ArrayList<>();


    public static Smasher main;

    public static HashMap<UUID, String> playerlanguage = new HashMap<>();

    public static HashMap<UUID, Integer> lives = new HashMap<>();

    public static HashMap<UUID, Integer> cooldown = new HashMap<>();


    @Override
    public void onEnable() {

        if (!getConfig().isSet("new")){
            saveDefaultConfig();
        }




        main = this;

        Importer.ImportCommands(this);
        Importer.ImportPluginChannels(this);
        Importer.ImportListeners(Bukkit.getPluginManager(), this);

        Cooldown.StatSchedualar(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
