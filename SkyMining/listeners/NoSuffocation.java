package me.adrian.skymining.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class NoSuffocation implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player){
            if (event.getCause().equals(EntityDamageEvent.DamageCause.SUFFOCATION)){
                event.setCancelled(true);
            }
        }
    }
}
