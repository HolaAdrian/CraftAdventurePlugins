package me.adrian.skymining;

import me.adrian.skymining.Utility.SaveManager;
import me.adrian.skymining.commands.*;
import me.adrian.skymining.listeners.*;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;

public final class SkyMining extends JavaPlugin{

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

    public static SkyMining main;



    public static HashMap<UUID, Integer> haste = new HashMap<>();

    public static HashMap<UUID, Boolean> pvpon = new HashMap<>();

    public static HashMap<UUID, Location> lastisland = new HashMap<>();

    private static URL url;





    private static void enableListeners(PluginManager pluginManager, Plugin plugin){
        pluginManager.registerEvents(new BuildDestroyListener(), plugin);
        pluginManager.registerEvents(new ConnectionListener(), plugin);
        pluginManager.registerEvents(new ParkourListener(), plugin);
        pluginManager.registerEvents(new HasteListener(), plugin);
        pluginManager.registerEvents(new NoShitListener(), plugin);
        pluginManager.registerEvents(new NoVoidListener(), plugin);
        pluginManager.registerEvents(new LanguageInventoryClick(), plugin);
        pluginManager.registerEvents(new VillagerTradeListener(), plugin);
        pluginManager.registerEvents(new NoFoodListener(), plugin);
        pluginManager.registerEvents(new NoSuffocation(), plugin);
        pluginManager.registerEvents(new DeathDropListener(), plugin);
        pluginManager.registerEvents(new YesNoPvpListener(), plugin);
        pluginManager.registerEvents(new SetIslandListener(), plugin);
    }






    @Override
    public void onEnable() {
        try {
            url= new URL("https://discord.com/api/webhooks/1159113519296434236/xlKxTbnhh4riWW9bC8xz0lz4gRCgk0C4SBY5Zr6w7rQ0CpLEn7vM2AzALnEdnr3jR4Ix");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }



        SendDiscordWebhook("Sky Mining Server/Plugin wurde gestartet!");


        if (getConfig().isSet("new")){
            SaveManager.LoadAll(getConfig());
        }
        else {
            saveDefaultConfig();
        }

        getServer().getMessenger().registerOutgoingPluginChannel(this, "bungeecord:language");
        getServer().getMessenger().registerIncomingPluginChannel(this, "bungeecord:language", new PluginMessageLIstener());
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        World world = Bukkit.getWorld("world");

        int chunkX = 8;
        int chunkZ = -6;

        Chunk chunk = world.getChunkAt(chunkX, chunkZ);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                if (!chunk.isLoaded()) {
                    chunk.load();
                }
            }
        }, 0, 20);

        main = this;




        PluginManager pluginManager = Bukkit.getPluginManager();
        enableListeners(pluginManager, this);

        getCommand("restoregamerules").setExecutor(new restore());
        getCommand("restorevillager").setExecutor(new villagerrestore());
        getCommand("lobby").setExecutor(new lobbyCommand());
        getCommand("trash").setExecutor(new trashCommand());
        getCommand("discord").setExecutor(new DiscordCommand());
        getCommand("pvp").setExecutor(new PvpCommand());
        getCommand("haste").setExecutor(new HasteCommand());
        getCommand("help").setExecutor(new HelpCommand());




    }

    @Override
    public void onDisable() {


        SendDiscordWebhook("Sky Mining Server/Plugin wurde beendet!");
        SaveManager.SaveAll(getConfig());
    }

    public static void SendDiscordWebhook(String content){

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("content","[Sky Mining]: " + content);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.addRequestProperty("Content-Type", "application/json");
            urlConnection.addRequestProperty("User-Agent", "Java-DiscordWebhook");
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");


            OutputStream stream = urlConnection.getOutputStream();
            stream.write(jsonObject.toJSONString().getBytes());
            stream.flush();
            stream.close();

            urlConnection.getInputStream().close();
            urlConnection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
