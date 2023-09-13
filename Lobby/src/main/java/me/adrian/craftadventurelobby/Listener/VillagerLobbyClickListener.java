package me.adrian.craftadventurelobby.Listener;

import me.adrian.craftadventurelobby.Lobby;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class VillagerLobbyClickListener implements Listener {
    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event) {
        if (event.getRightClicked() instanceof Villager){
            Villager villager = (Villager) event.getRightClicked();
            if (villager.getCustomName().contains("Sky Mining")){
                Player player = event.getPlayer();
                Lobby.sendServer(player, "skyminer");
            }
        }
    }
}
