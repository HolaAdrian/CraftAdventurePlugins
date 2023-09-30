package me.adrian.smasher.Listener;

import me.adrian.smasher.Smasher;
import me.adrian.smasher.Utility.EndRound;
import me.adrian.smasher.Utility.Respawner;
import me.adrian.smasher.Utility.Sender;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.UUID;

public class PlayerDeathListener implements Listener {



    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.setDeathMessage("");
        Player player = event.getPlayer();
        Respawner.TeleportAsynch(player);
        Respawner.RemoveLife(player);
        player.setHealth(player.getMaxHealth());

        if (event.getPlayer().getKiller() != null){
            if (event.getPlayer().getKiller() instanceof Player){
                Player Death = event.getPlayer();
                Player Killer = Death.getKiller();
                Killer.setHealth(Killer.getMaxHealth());
                Smasher.cooldown.put(Killer.getUniqueId(), 0);
                UUID uuid = Killer.getUniqueId();
                if (Smasher.playerlanguage.containsKey(uuid)){
                    if (Smasher.playerlanguage.get(uuid).equals("de")){
                        Killer.sendActionBar(ChatColor.GREEN + "Kein Cooldown mehr!");
                    }
                    else if (Smasher.playerlanguage.get(uuid).equals("en")){
                        Killer.sendActionBar(ChatColor.GREEN + "No more cooldown!");
                    }
                }
                else{
                    Killer.sendActionBar(ChatColor.GREEN + "Kein Cooldown mehr!");
                }


            }

        }
    }


}




