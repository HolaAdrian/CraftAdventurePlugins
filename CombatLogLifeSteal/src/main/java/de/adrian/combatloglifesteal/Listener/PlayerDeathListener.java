package de.adrian.combatloglifesteal.Listener;

import de.adrian.combatloglifesteal.CombatLogLifeSteal;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        if (CombatLogLifeSteal.cooldown.containsKey(player.getUniqueId())){
            CombatLogLifeSteal.cooldown.remove(player.getUniqueId());
        }
    }
}
