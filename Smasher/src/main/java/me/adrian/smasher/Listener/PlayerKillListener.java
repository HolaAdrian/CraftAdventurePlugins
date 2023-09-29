package me.adrian.smasher.Listener;


import me.adrian.smasher.Smasher;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.UUID;

public class PlayerKillListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
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