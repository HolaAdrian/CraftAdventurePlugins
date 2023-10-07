package me.adrian.smasher.Listener;


import org.bukkit.entity.EntityType;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowOnGroundListener implements Listener {


    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        if (event.getEntityType()!= null){
            if (event.getEntityType().equals(EntityType.ARROW)){
                Projectile entity = event.getEntity();
                entity.remove();
            }
        }
    }
}
