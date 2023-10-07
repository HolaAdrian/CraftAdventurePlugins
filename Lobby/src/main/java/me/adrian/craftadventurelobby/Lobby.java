package me.adrian.craftadventurelobby;

import me.adrian.craftadventurelobby.Utility.Importer;
import me.adrian.craftadventurelobby.Utility.StattMatchmaking;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
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

    private static URL url;

    private static URL banurl;



    @Override
    public void onEnable() {
        try {
            url= new URL("https://discord.com/api/webhooks/1159113519296434236/xlKxTbnhh4riWW9bC8xz0lz4gRCgk0C4SBY5Zr6w7rQ0CpLEn7vM2AzALnEdnr3jR4Ix");
            banurl= new URL("https://discord.com/api/webhooks/1159879391774515221/8qIVrEjdGKN5vt0_8I6Mu61wwgZzf5pd382XefatWwh94eoQOYSyy_A6mMmvfWizRGtM");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }




        main = this;

        SendDiscordWebhook("Lobby Server/Plugin wurde gestartet!");

        Importer.ImportListeners(this, Bukkit.getPluginManager());
        Importer.ImportCommands(this);
        Importer.ImportPluginChannels(this);
        Importer.ImportPermission(Bukkit.getPluginManager());

        StattMatchmaking.StartMatchmaking();



    }

    @Override
    public void onDisable() {
        SendDiscordWebhook("Lobby Server/Plugin wurde beendet!");
    }

    public static void SendDiscordWebhook(String content){

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("content","[Lobby]: " + content);
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

    public static void SendDiscordBanWebhook(String content){

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("content", content);
            HttpsURLConnection urlConnection = (HttpsURLConnection) banurl.openConnection();
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
