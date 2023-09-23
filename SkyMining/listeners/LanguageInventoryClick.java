package me.adrian.skymining.listeners;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.adrian.skymining.SkyMining;
import me.adrian.skymining.Utility.SetScoreboard;
import me.adrian.skymining.Utility.UpdateHaste;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class LanguageInventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if (event.getCurrentItem() == null){
            return;
        }
        if (event.getCurrentItem().getItemMeta() != null) {
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Deutsch")) {
                if (event.getWhoClicked() instanceof Player) {

                    Player player = (Player) event.getWhoClicked();


                    ByteArrayDataOutput out = ByteStreams.newDataOutput();
                    out.writeUTF("SavePlayerLanguage");
                    out.writeUTF(player.getUniqueId().toString());
                    out.writeUTF("de");

                    player.sendPluginMessage(SkyMining.main, "bungeecord:language", out.toByteArray());
                    event.setCancelled(true);


                    player.closeInventory();

                    player.sendMessage(net.md_5.bungee.api.ChatColor.GREEN + "Deine Sprache wurde auf Deutsch gestellt.");

                    SkyMining.playerlanguage.put(player.getUniqueId(), "de");

                    SkyMining.playerlanguage.put(player.getUniqueId(), "de");
                    UpdateHaste.UpdateHaste(player);




                }
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "English")) {
                if (event.getWhoClicked() instanceof Player) {
                    Player player = (Player) event.getWhoClicked();

                    ByteArrayDataOutput out = ByteStreams.newDataOutput();
                    out.writeUTF("SavePlayerLanguage");
                    out.writeUTF(player.getUniqueId().toString());
                    out.writeUTF("en");

                    player.sendPluginMessage(SkyMining.main, "bungeecord:language", out.toByteArray());
                    event.setCancelled(true);

                    SkyMining.playerlanguage.put(player.getUniqueId(), "en");

                    player.closeInventory();
                    player.sendMessage(net.md_5.bungee.api.ChatColor.GREEN + "Your language is now english");
                    UpdateHaste.UpdateHaste(player);
                    UpdateHaste.UpdateHaste(player);




                }
            }
        }
    }
}