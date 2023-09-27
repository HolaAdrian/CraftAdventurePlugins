package me.adrian.craftadventurelobby.Listener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import me.adrian.craftadventurelobby.Lobby;
import me.adrian.craftadventurelobby.Utility.ItemGetter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;

import java.io.EOFException;
import java.util.UUID;

public class PluginMessagelistener implements PluginMessageListener {

    @Override
    public void onPluginMessageReceived(@NotNull String s, @NotNull Player player, @NotNull byte[] bytes) {
        if (s.equals("bungeecord:language")){
            ByteArrayDataInput in = ByteStreams.newDataInput(bytes);
            String subchannel = in.readUTF();

            if (subchannel.equals("ShowInventory")){
                UUID PLayerUUID = UUID.fromString(in.readUTF());

                if (Bukkit.getPlayer(PLayerUUID) != null){
                    Player player1 = Bukkit.getPlayer(PLayerUUID);


                    Inventory inventory = Bukkit.createInventory(null, 9, "Sprache/Language");


                    inventory.setItem(0, ItemGetter.German());
                    inventory.setItem(1, ItemGetter.ENGLAND());

                    player1.openInventory(inventory);


                }

            }
            else if (subchannel.equals("SendPlayerLanguage")){
                UUID PLayerUUID = UUID.fromString(in.readUTF());
                if (Bukkit.getPlayer(PLayerUUID) != null){
                    Player player1 = Bukkit.getPlayer(PLayerUUID);
                    Lobby.playerlanguage.put(player1.getUniqueId(), in.readUTF());
                }
            }

        }
        if (s.equals("bungeecord:kitchange")){
            ByteArrayDataInput in = ByteStreams.newDataInput(bytes);
            String subchannel = in.readUTF();
            if (subchannel.equals("ShowInventory")){
                UUID PLayerUUID = UUID.fromString(in.readUTF());
                if (Bukkit.getPlayer(PLayerUUID) != null){
                    Player player1 = Bukkit.getPlayer(PLayerUUID);


                    Inventory inventory = Bukkit.createInventory(null, 9, "Kit");


                    inventory.setItem(0, ItemGetter.KnockbackStick());
                    inventory.setItem(1, ItemGetter.Bow());
                    inventory.setItem(2, ItemGetter.Assasine());
                    inventory.setItem(3, ItemGetter.axeKit());
                    inventory.setItem(4, ItemGetter.TankStick(player1));

                    player1.openInventory(inventory);

                }
            }
        }

    }



    }

