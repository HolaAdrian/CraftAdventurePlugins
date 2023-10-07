package de.adrian.lifestealhalloween.listeners;

import de.adrian.lifestealhalloween.LifeStealHalloween;
import de.adrian.lifestealhalloween.utils.Datas;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import javax.xml.crypto.Data;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class RespawnListener implements Listener {


    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if (Datas.playerhearts.containsKey(player.getUniqueId())){
            Double hearts = Datas.playerhearts.get(player.getUniqueId());
            if (hearts < 1.0){
                long currentTime = System.currentTimeMillis();
                int banDurationSeconds = 86400;
                long endTime = currentTime + (banDurationSeconds * 1000);
                player.banPlayer( ChatColor.RED + "Du hast 0 Herzen und wurdest deshalb für einen Tag gebannt!", new Date(endTime));
                if (LifeStealHalloween.playerlanguage.containsKey(player.getUniqueId())){
                    if (LifeStealHalloween.playerlanguage.get(player.getUniqueId()).equalsIgnoreCase("de")){
                        player.kickPlayer(ChatColor.DARK_RED + "Du hast 0 Herzen und wurdest deshalb für einen Tag gebannt!");
                    }
                    if (LifeStealHalloween.playerlanguage.get(player.getUniqueId()).equalsIgnoreCase("en")){
                        player.kickPlayer(ChatColor.DARK_RED + "You have 0 hearts and got banned for a day!");
                    }
                }
                else {
                    player.kickPlayer(ChatColor.DARK_RED + "Du hast 0 Herzen und wurdest deshalb für einen Tag gebannt!");
                }
                Datas.playerhearts.put(player.getUniqueId(), 6.0);
                return;
            }
            player.setMaxHealth(hearts);
            player.setHealth(hearts);


        }
    }
}
