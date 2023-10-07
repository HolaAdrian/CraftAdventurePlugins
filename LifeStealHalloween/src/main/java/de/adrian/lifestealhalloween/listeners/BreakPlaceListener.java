package de.adrian.lifestealhalloween.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BreakPlaceListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType().equals(Material.PLAYER_HEAD)){
            if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
                event.setCancelled(true);
            }
        }
    }
}
