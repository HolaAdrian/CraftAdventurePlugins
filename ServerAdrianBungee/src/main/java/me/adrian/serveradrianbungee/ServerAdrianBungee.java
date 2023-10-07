package me.adrian.serveradrianbungee;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.google.gson.JsonObject;
import me.adrian.serveradrianbungee.Utility.Cooldowner;
import me.adrian.serveradrianbungee.commands.*;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.*;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.scheduler.ScheduledTask;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.JsonConfiguration;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public final class ServerAdrianBungee extends Plugin implements Listener {


    HashMap<UUID, String> playerlanguage = new HashMap<>();
    HashMap<UUID, String> playerkit = new HashMap<>();

    public static HashMap<UUID, Integer> joinmecooldown = new HashMap<>();


    private File file;
    private Configuration configuration;

    public static ServerAdrianBungee main;

    public static ScheduledTask task;

    private static URL url;








    @Override
    public void onEnable() {

        try {
            url= new URL("https://discord.com/api/webhooks/1159113519296434236/xlKxTbnhh4riWW9bC8xz0lz4gRCgk0C4SBY5Zr6w7rQ0CpLEn7vM2AzALnEdnr3jR4Ix");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


        SendDiscordWebhook("Bungee" + " Server/Plugin wurde gestartet!");





        main = this;
        Cooldowner.StartJoinmeeCooldowner();


        file = new File(ProxyServer.getInstance().getPluginsFolder() + "/config.yml");






        try {
            if (!file.exists()){
            file.createNewFile();
        }

            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }







        if (configuration != null){
            if (configuration.contains("kit") && configuration.getSection("kit") != null) {
                for (String languageKey : configuration.getSection("kit").getKeys()) {
                    String kitValue = configuration.getString("kit." + languageKey);
                    UUID uuid = UUID.fromString(languageKey);
                    playerkit.put(uuid, kitValue);
                }
            }
            if (configuration.contains("language") && configuration.getSection("language") != null) {
                for (String languageKey : configuration.getSection("language").getKeys()) {
                   String languageValue = configuration.getString("language." + languageKey);
                    UUID uuid = UUID.fromString(languageKey);
                   playerlanguage.put(uuid, languageValue);
                }
            }


        }


        getProxy().registerChannel("bungeecord:language");
        getProxy().registerChannel("bungeecord:kit");
        getProxy().registerChannel("between:smasherlobby");
        getProxy().registerChannel("bungeecord:lobby");
        getProxy().registerChannel("bungeecord:kitchange");
        getProxy().registerChannel("bungeecord:wartung");
        getProxy().getPluginManager().registerListener(this, this);
        getProxy().getPluginManager().registerCommand(this, new lobbycommand());
        getProxy().getPluginManager().registerCommand(this, new kitcommand());
        getProxy().getPluginManager().registerCommand(this, new creditscommand());
        getProxy().getPluginManager().registerCommand(this, new versioncommand());





    }

    @Override
    public void onDisable(){

        SendDiscordWebhook("Bungee" + " Server/Plugin wurde beendet!");

        if (task != null) {
            task.cancel();
        }
        try {
            if (!file.exists()){
                file.createNewFile();
            }

            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);

            for (UUID uuid : playerlanguage.keySet()) {
                configuration.set("language." + uuid.toString(), playerlanguage.get(uuid));
            }
            for (UUID uuid : playerkit.keySet()) {
                configuration.set("kit." + uuid.toString(), playerkit.get(uuid));
            }
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, file);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    @EventHandler
    public void onServerConnect(ServerConnectEvent event) {

        ProxiedPlayer player = event.getPlayer();
        if (player.getServer() != null){

            if (playerlanguage.containsKey(player.getUniqueId())){
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("SendPlayerLanguage");
                out.writeUTF(player.getUniqueId().toString());
                out.writeUTF(playerlanguage.get(player.getUniqueId()));
                player.getServer().sendData("bungeecord:language", out.toByteArray());
            }
            else {
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("SendPlayerLanguage");
                out.writeUTF(player.getUniqueId().toString());
                out.writeUTF("de");
                player.getServer().sendData("bungeecord:language", out.toByteArray());
            }

        }
    }

    public static void SendDiscordWebhook(String content){

        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("content", "[BungeeCord]: " + content);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.addRequestProperty("Content-Type", "application/json");
            urlConnection.addRequestProperty("User-Agent", "Java-DiscordWebhook");
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");


            OutputStream stream = urlConnection.getOutputStream();
            stream.write(jsonObject.toString().getBytes());
            stream.flush();
            stream.close();

            urlConnection.getInputStream().close();
            urlConnection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    @EventHandler
    public void onServerSwitch(ServerSwitchEvent event) {


        ProxiedPlayer player = event.getPlayer();

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream output = new ObjectOutputStream(out);
            output.writeObject(playerkit);
            player.getServer().sendData("bungeecord:kit", out.toByteArray());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


            if (playerlanguage.containsKey(player.getUniqueId())) {
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("SendPlayerLanguage");
                out.writeUTF(player.getUniqueId().toString());
                out.writeUTF(playerlanguage.get(player.getUniqueId()));
                player.getServer().sendData("bungeecord:language", out.toByteArray());
            } else {
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("SendPlayerLanguage");
                out.writeUTF(player.getUniqueId().toString());
                out.writeUTF("de");
                player.getServer().sendData("bungeecord:language", out.toByteArray());
            }

    }

        @EventHandler(priority = EventPriority.HIGHEST)
        public void onPluginMessageReceived (PluginMessageEvent event){




            if (event.getTag().equals("bungeecord:wartung")){
                ByteArrayDataInput in = ByteStreams.newDataInput(event.getData());
                String server = in.readUTF();
                ServerInfo lobby = getProxy().getServerInfo("lobby");
                for (ProxiedPlayer p: getProxy().getPlayers()){
                    if (p.getServer().getInfo().getName().equalsIgnoreCase(server)){
                        p.connect(lobby);
                    }
                }


            }



            if (event.getTag().equals("bungeecord:lobby")) {
                ByteArrayDataInput in = ByteStreams.newDataInput(event.getData());
                String message = in.readUTF();
                if (message.equals("la")) {
                    for (ProxiedPlayer player : getProxy().getPlayers()) {
                        if (!player.getName().equals("Ligt_Adrian") || player.getName().equals("Naturpro")) {
                            player.disconnect("Server is under maintenance");
                        }
                        if (playerlanguage.containsKey(player.getUniqueId())) {
                            if (playerlanguage.get(player.getUniqueId()).equals("de")) {
                                player.disconnect("Der Server ist jetzt im Wartungsmodus");
                            } else if (playerlanguage.get(player.getUniqueId()).equals("en")) {
                                player.disconnect("The server is now in maintenance");
                            }
                        } else {
                            player.disconnect("Der Server ist jetzt im Wartungsmodus");
                        }
                    }
                }
            }


            if (event.getTag().equals("between:smasherlobby")) {
                ByteArrayDataInput in = ByteStreams.newDataInput(event.getData());
                String message = in.readUTF();
                if (message.equals("resume")) {
                    ServerInfo lobby = getProxy().getServerInfo("lobby");
                    ByteArrayDataOutput out = ByteStreams.newDataOutput();
                    out.writeUTF("resume");
                    lobby.sendData("between:smasherlobby", out.toByteArray());
                }
            }

            if (event.getTag().equals("bungeecord:language")) {
                ByteArrayDataInput in = ByteStreams.newDataInput(event.getData());
                String subChannel = in.readUTF();
                if (subChannel.equals("SavePlayerLanguage")) {
                    UUID PlayerUUID = UUID.fromString(in.readUTF());
                    if (getProxy().getPlayer(PlayerUUID) != null) {
                        ProxiedPlayer player = getProxy().getPlayer(PlayerUUID);
                        String language = in.readUTF();
                        playerlanguage.put(PlayerUUID, language);
                        if (language.equalsIgnoreCase("de")) {


                            ByteArrayDataOutput out = ByteStreams.newDataOutput();
                            out.writeUTF("SendPlayerLanguage");
                            out.writeUTF(player.getUniqueId().toString());
                            out.writeUTF("de");
                            player.getServer().sendData("bungeecord:language", out.toByteArray());

                        } else if (language.equalsIgnoreCase("en")) {
                            ByteArrayDataOutput out = ByteStreams.newDataOutput();
                            out.writeUTF("SendPlayerLanguage");
                            out.writeUTF(player.getUniqueId().toString());
                            out.writeUTF("en");
                            player.getServer().sendData("bungeecord:language", out.toByteArray());

                        }
                    }
                }


            }
            if (event.getTag().equals("bungeecord:kitchange")) {
                ByteArrayDataInput in = ByteStreams.newDataInput(event.getData());
                String subChannel = in.readUTF();
                if (subChannel.equals("sendKit")) {
                    String uuid = in.readUTF();
                    UUID playerUUID = UUID.fromString(uuid);
                    if (getProxy().getPlayer(playerUUID) != null) {
                        ProxiedPlayer player = getProxy().getPlayer(playerUUID);
                        String kit = in.readUTF();
                        playerkit.put(player.getUniqueId(), kit);
                    }

                }
            }
        }
    }
