package me.adrian.smasher.Listener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import me.adrian.smasher.Smasher;
import me.adrian.smasher.Utility.ItemGetter;
import me.adrian.smasher.Utility.Respawner;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class PluginMessageListener implements org.bukkit.plugin.messaging.PluginMessageListener {


    @Override
    public void onPluginMessageReceived(@NotNull String s, @NotNull Player player, @NotNull byte[] bytes) {

        if (s.equals("bungeecord:kit")){
            try {
                ByteArrayInputStream in = new ByteArrayInputStream(bytes);
                ObjectInputStream inputStream = new ObjectInputStream(in);
                Object o = inputStream.readObject();
                if (o instanceof HashMap){
                    Smasher.playerkit = (HashMap<UUID, String>) o;
                    Respawner.SetPlayerKits();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }

        if (s.equals("bungeecord:language")){
            ByteArrayDataInput in = ByteStreams.newDataInput(bytes);
            String subchannel = in.readUTF();

            if (subchannel.equals("ShowInventory")){
                UUID PLayerUUID = UUID.fromString(in.readUTF());

                if (Bukkit.getPlayer(PLayerUUID) != null){
                    Player player1 = Bukkit.getPlayer(PLayerUUID);

                    if (Smasher.playerlanguage.containsKey(player.getUniqueId())){
                        if (Smasher.playerlanguage.get(player.getUniqueId()).equals("de")){
                            player.sendMessage(ChatColor.GREEN + "Du darfst deine Sprache nicht ändern während du in einer Runde bist!");
                        }
                        else if (Smasher.playerlanguage.get(player.getUniqueId()).equals("en")){
                            player.sendMessage(ChatColor.GREEN + "You can't change your language while being ingame");
                        }
                    }
                    else{
                        player.sendMessage(ChatColor.GREEN + "Du darfst deine Sprache nicht ändern während du in einer Runde bist!");
                    }


                }

            }
            else if (subchannel.equals("SendPlayerLanguage")){
                UUID PLayerUUID = UUID.fromString(in.readUTF());
                if (Bukkit.getPlayer(PLayerUUID) != null){
                    Player player1 = Bukkit.getPlayer(PLayerUUID);
                    Smasher.playerlanguage.put(player1.getUniqueId(), in.readUTF());
                }
            }
        }
    }
}
