package me.adrian.craftadventurelobby.Listener;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.adrian.craftadventurelobby.Lobby;
import me.adrian.craftadventurelobby.Utility.ItemGetter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class KitCLickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getCurrentItem() != null){
            if (event.getCurrentItem().getItemMeta() != null) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Knockback Stick")) {
                    if (event.getWhoClicked() instanceof Player) {

                        Player player = (Player) event.getWhoClicked();


                        ByteArrayDataOutput out = ByteStreams.newDataOutput();
                        out.writeUTF("sendKit");
                        out.writeUTF(player.getUniqueId().toString());
                        out.writeUTF("kit:knockering");

                        player.sendPluginMessage(Lobby.main, "bungeecord:kitchange", out.toByteArray());
                        event.setCancelled(true);


                        player.closeInventory();

                        player.sendMessage(ChatColor.GREEN + "Kit changed!");





                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Spammer-Bow")) {
                    if (event.getWhoClicked() instanceof Player) {

                        Player player = (Player) event.getWhoClicked();


                        ByteArrayDataOutput out = ByteStreams.newDataOutput();
                        out.writeUTF("sendKit");
                        out.writeUTF(player.getUniqueId().toString());
                        out.writeUTF("kit:spammer");

                        player.sendPluginMessage(Lobby.main, "bungeecord:kitchange", out.toByteArray());
                        event.setCancelled(true);


                        player.closeInventory();

                        player.sendMessage(ChatColor.GREEN + "Kit changed!");





                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Assasine Sword")){

                    Player player = (Player) event.getWhoClicked();


                    ByteArrayDataOutput out = ByteStreams.newDataOutput();
                    out.writeUTF("sendKit");
                    out.writeUTF(player.getUniqueId().toString());
                    out.writeUTF("kit:assasine");

                    player.sendPluginMessage(Lobby.main, "bungeecord:kitchange", out.toByteArray());
                    event.setCancelled(true);


                    player.closeInventory();

                    player.sendMessage(ChatColor.GREEN + "Kit changed!");

                }

            }
        }
    }
}
