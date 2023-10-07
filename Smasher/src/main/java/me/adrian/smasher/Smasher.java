package me.adrian.smasher;

import me.adrian.smasher.Utility.Cooldown;
import me.adrian.smasher.Utility.Importer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
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

    private static URL url;


    @Override
    public void onEnable() {

        try {
            url= new URL("https://discord.com/api/webhooks/1159113519296434236/xlKxTbnhh4riWW9bC8xz0lz4gRCgk0C4SBY5Zr6w7rQ0CpLEn7vM2AzALnEdnr3jR4Ix");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        SendDiscordWebhook("Smasher" + getConfig().getString("server") + " Server/Plugin wurde gestartet!");

        if (!getConfig().isSet("server")){
            saveDefaultConfig();
        }


        SendDiscordWebhook("Smasher" + getConfig().getString("server") + " Server/Plugin wurde gestartet!");



        main = this;

        Importer.ImportCommands(this);
        Importer.ImportPluginChannels(this);
        Importer.ImportListeners(Bukkit.getPluginManager(), this);

        Cooldown.StatSchedualar(this);

    }

    @Override
    public void onDisable() {
        SendDiscordWebhook("Smasher" + getConfig().getString("server") + " Server/Plugin wurde beendet!");
    }

    public static void SendDiscordWebhook(String content){

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("content","[Smasher]: " + content);
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
