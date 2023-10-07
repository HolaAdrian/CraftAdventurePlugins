package de.adrian.lifestealhalloween.listeners;

import de.adrian.lifestealhalloween.LifeStealHalloween;
import de.adrian.lifestealhalloween.utils.Datas;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;


public class ConnectionListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!Datas.playerhearts.containsKey(player.getUniqueId())){
            Datas.playerhearts.put(player.getUniqueId(), player.getMaxHealth());
        }
        else {
            Double v = Datas.playerhearts.get(player.getUniqueId());
            player.setMaxHealth(v);
        }

        event.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + ChatColor.GOLD + player.getName());
        if (LifeStealHalloween.playerlanguage.containsKey(player.getUniqueId())){
            if (LifeStealHalloween.playerlanguage.get(player.getUniqueId()).equalsIgnoreCase("de")){
                player.sendMessage(ChatColor.GOLD + "Viel Spaß beim Halloween Event!");
            }
            if (LifeStealHalloween.playerlanguage.get(player.getUniqueId()).equalsIgnoreCase("en")){
                player.sendMessage(ChatColor.GOLD + "Have Fun with the halloween event!");
            }
        }
        else {
            player.sendMessage(ChatColor.GOLD + "Viel Spaß beim Halloween Event!");
        }
    }


    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        Player player = event.getPlayer();
        if (!Datas.playerhearts.containsKey(player.getUniqueId())){
            Datas.playerhearts.put(player.getUniqueId(), player.getMaxHealth());
        }

        event.setQuitMessage(ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "] " + ChatColor.GOLD + player.getName());
    }
}
