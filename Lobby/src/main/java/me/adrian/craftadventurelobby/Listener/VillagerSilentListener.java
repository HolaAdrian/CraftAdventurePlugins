package me.adrian.craftadventurelobby.Listener;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class VillagerSilentListener implements Listener {


    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (event.getEntity().getType().equals(EntityType.VILLAGER)){
            Villager villager = (Villager) event.getEntity();
            villager.setSilent(true);
        }
    }
}
