package de.adrian.lifestealhalloween.listeners;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.adrian.lifestealhalloween.LifeStealHalloween;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class LanguageCLickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getCurrentItem() != null) {
            if (event.getCurrentItem().getItemMeta() != null) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Deutsch")) {
                    if (event.getWhoClicked() instanceof Player) {

                        Player player = (Player) event.getWhoClicked();


                        ByteArrayDataOutput out = ByteStreams.newDataOutput();
                        out.writeUTF("SavePlayerLanguage");
                        out.writeUTF(player.getUniqueId().toString());
                        out.writeUTF("de");

                        player.sendPluginMessage(LifeStealHalloween.main, "bungeecord:language", out.toByteArray());
                        event.setCancelled(true);


                        player.closeInventory();

                        player.sendMessage(ChatColor.GREEN + "Deine Sprache wurde auf Deutsch gestellt.");

                        LifeStealHalloween.playerlanguage.put(player.getUniqueId(), "de");

                        LifeStealHalloween.playerlanguage.put(player.getUniqueId(), "de");


                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "English")) {
                    if (event.getWhoClicked() instanceof Player) {
                        Player player = (Player) event.getWhoClicked();

                        ByteArrayDataOutput out = ByteStreams.newDataOutput();
                        out.writeUTF("SavePlayerLanguage");
                        out.writeUTF(player.getUniqueId().toString());
                        out.writeUTF("en");

                        player.sendPluginMessage(LifeStealHalloween.main, "bungeecord:language", out.toByteArray());
                        event.setCancelled(true);

                        LifeStealHalloween.playerlanguage.put(player.getUniqueId(), "en");
                        LifeStealHalloween.playerlanguage.put(player.getUniqueId(), "en");

                        player.closeInventory();
                        player.sendMessage(net.md_5.bungee.api.ChatColor.GREEN + "Your language is now english");


                    }
                }
            }
        }

    }}
