package de.adrian.lifestealhalloween.listeners;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import de.adrian.lifestealhalloween.LifeStealHalloween;
import de.adrian.lifestealhalloween.utils.ItemGetter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class PluginMessageListener implements org.bukkit.plugin.messaging.PluginMessageListener {
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
                    LifeStealHalloween.playerlanguage.put(player1.getUniqueId(), in.readUTF());
                }
            }

        }
    }
}
