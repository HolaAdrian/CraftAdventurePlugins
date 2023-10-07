package de.adrian.lifestealhalloween;

import de.adrian.lifestealhalloween.utils.Importer;
import de.adrian.lifestealhalloween.utils.SafeManager;
import it.unimi.dsi.fastutil.Hash;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.UUID;

public final class LifeStealHalloween extends JavaPlugin {

    private static URL url;

    public static LifeStealHalloween main;

    public static HashMap<UUID,String> playerlanguage = new HashMap<>();

    @Override
    public void onEnable() {
        main = this;

        try {
            url= new URL("https://discord.com/api/webhooks/1159113519296434236/xlKxTbnhh4riWW9bC8xz0lz4gRCgk0C4SBY5Zr6w7rQ0CpLEn7vM2AzALnEdnr3jR4Ix");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        SendDiscordWebhook("LifeSteal Halloween Server/Plugin wurde gestartet!");

        Importer.LoadAll(this, Bukkit.getPluginManager());


    }

    @Override
    public void onDisable() {
        SendDiscordWebhook("LifeSteal Halloween Server/Plugin wurde beendet!");
        SafeManager.SafeAll(getConfig());
    }

    public static void SendDiscordWebhook(String content){

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("content","[LifeSteal]: " + content);
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
