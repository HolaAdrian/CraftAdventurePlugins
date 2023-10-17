package de.adrian.combatloglifesteal.Listener;

import de.adrian.combatloglifesteal.CombatLogLifeSteal;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayHitByPlayerListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player){
            Player dammager = (Player) event.getDamager();
            Player dammaged = (Player) event.getEntity();
            int cooldown = CombatLogLifeSteal.main.getConfig().getInt("cooldown");
            CombatLogLifeSteal.cooldown.put(dammaged.getUniqueId(), cooldown);
            CombatLogLifeSteal.cooldown.put(dammager.getUniqueId(), cooldown);
            dammaged.sendActionBar(ChatColor.RED + "Combat: " + String.valueOf(cooldown));
            dammager.sendActionBar(ChatColor.RED + "Combat: " + String.valueOf(cooldown));
        }
    }
}
