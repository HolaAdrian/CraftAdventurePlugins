package me.adrian.skymining;

import me.adrian.skymining.commands.lobbyCommand;
import me.adrian.skymining.commands.restore;
import me.adrian.skymining.commands.trashCommand;
import me.adrian.skymining.commands.villagerrestore;
import me.adrian.skymining.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
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
    }






    @Override
    public void onEnable() {

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

        if (getConfig().isSet("new")){
            SafeManager.LoadAll(getConfig());
        }
        else {
            saveDefaultConfig();
        }


        PluginManager pluginManager = Bukkit.getPluginManager();
        enableListeners(pluginManager, this);

        getCommand("restoregamerules").setExecutor(new restore());
        getCommand("restorevillager").setExecutor(new villagerrestore());
        getCommand("lobby").setExecutor(new lobbyCommand());
        getCommand("trash").setExecutor(new trashCommand());





    }

    @Override
    public void onDisable() {



        SafeManager.SafeAll(getConfig());
    }
}
