package me.adrian.serveradrianbungee;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.adrian.serveradrianbungee.commands.kitcommand;
import me.adrian.serveradrianbungee.commands.lobbycommand;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.*;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;

public final class ServerAdrianBungee extends Plugin implements Listener {


    HashMap<UUID, String> playerlanguage = new HashMap<>();
    HashMap<UUID, String> playerkit = new HashMap<>();


    public static ServerAdrianBungee Main;

    private File file;
    private Configuration configuration;





    @Override
    public void onEnable() {


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
                    String languageValue = configuration.getString("kit." + languageKey);
                    UUID uuid = UUID.fromString(languageKey);
                    playerkit.put(uuid, languageValue);
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
        getProxy().getPluginManager().registerListener(this, this);
        getProxy().getPluginManager().registerCommand(this, new lobbycommand());
        getProxy().getPluginManager().registerCommand(this, new kitcommand());






    }

    @Override
    public void onDisable(){
        try {
            if (!file.exists()){
                file.createNewFile();
            }

            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);

            for (UUID uuid : playerlanguage.keySet()) {
                configuration.set("language." + uuid.toString(), playerlanguage.get(uuid));
            }
            for (UUID uuid : playerkit.keySet()) {
                configuration.set("kit." + uuid.toString(), playerlanguage.get(uuid));
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

    @EventHandler
    public void onServerSwitch(ServerSwitchEvent event) {

        ProxiedPlayer player = event.getPlayer();
        if (playerkit.containsKey(player.getUniqueId())){
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("SetPlayerKit");
            out.writeUTF(player.getUniqueId().toString());
            out.writeUTF(playerkit.get(player.getUniqueId()));
            player.getServer().sendData("bungeecord:kit", out.toByteArray());
        }
        else {
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("SetPlayerKit");
            out.writeUTF(player.getUniqueId().toString());
            out.writeUTF("knocker");
            player.getServer().sendData("bungeecord:kit", out.toByteArray());
        }




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

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPluginMessageReceived(PluginMessageEvent event) {

        if (event.getTag().equals("bungeecord:language")){
            ByteArrayDataInput in = ByteStreams.newDataInput(event.getData());
            String subChannel = in.readUTF();
            if (subChannel.equals("SavePlayerLanguage")) {
                UUID PlayerUUID = UUID.fromString(in.readUTF());
                if (getProxy().getPlayer(PlayerUUID) != null){
                    ProxiedPlayer player = getProxy().getPlayer(PlayerUUID);
                    String language = in.readUTF();
                    playerlanguage.put(PlayerUUID, language);
                    if (language.equalsIgnoreCase("de")){


                        ByteArrayDataOutput out = ByteStreams.newDataOutput();
                        out.writeUTF("SendPlayerLanguage");
                        out.writeUTF(player.getUniqueId().toString());
                        out.writeUTF("de");
                        player.getServer().sendData("bungeecord:language", out.toByteArray());

                    }
                    else if (language.equalsIgnoreCase("en")){
                        ByteArrayDataOutput out = ByteStreams.newDataOutput();
                        out.writeUTF("SendPlayerLanguage");
                        out.writeUTF(player.getUniqueId().toString());
                        out.writeUTF("en");
                        player.getServer().sendData("bungeecord:language", out.toByteArray());

                    }
                }
        }



        }
        if (event.getTag().equals("bungeecord:kit")){
            ByteArrayDataInput in = ByteStreams.newDataInput(event.getData());
            String subChannel = in.readUTF();
            if (subChannel.equals("sendKit")){
                String uuid = in.readUTF();
                UUID playerUUID = UUID.fromString(uuid);
                if (getProxy().getPlayer(playerUUID) != null){
                    ProxiedPlayer player = getProxy().getPlayer(playerUUID);
                    String kit = in.readUTF();
                    playerkit.put(player.getUniqueId(), kit);

                }

            }
        }
    }
}
