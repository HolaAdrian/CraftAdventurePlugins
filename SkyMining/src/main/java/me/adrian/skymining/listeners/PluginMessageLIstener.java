package me.adrian.skymining.listeners;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import me.adrian.skymining.SkyMining;
import me.adrian.skymining.Utility.SafeManager;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class PluginMessageLIstener implements PluginMessageListener {
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
                    inventory.setItem(0, SafeManager.German());
                    inventory.setItem(1, SafeManager.ENGLAND());

                    player1.openInventory(inventory);


                }

            }
            else if (subchannel.equals("SendPlayerLanguage")){
                UUID PLayerUUID = UUID.fromString(in.readUTF());
                if (Bukkit.getPlayer(PLayerUUID) != null){
                    Player player1 = Bukkit.getPlayer(PLayerUUID);
                    SkyMining.playerlanguage.put(player1.getUniqueId(), in.readUTF());
                    System.out.println(SkyMining.playerlanguage.get(player1.getUniqueId()));
                }
            }
        }
        if (s.equals("bungeecord:joinme")){
            ByteArrayDataInput in = ByteStreams.newDataInput(bytes);
            UUID playeruuid = UUID.fromString(in.readUTF());
            String playercooldown = in.readUTF();

            if (Bukkit.getPlayer(playeruuid) != null){
                Player player1 = Bukkit.getPlayer(playeruuid);
                if (SkyMining.playerlanguage.containsKey(player.getUniqueId())) {
                    if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("de")) {
                        player1.sendMessage(ChatColor.RED + "Du kannst dein Joinme erst wieder in " + playercooldown + " Sekunden machen!");
                    } else if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("en")) {
                        player1.sendMessage(ChatColor.RED + "You can use /joinme again in " + playercooldown + " seconds!");
                    }
                } else {
                    player1.sendMessage(ChatColor.RED + "Du kannst dein Joinme erst wieder in " + playercooldown + " Sekunden machen!");
                }

            }


        }

    }
}
