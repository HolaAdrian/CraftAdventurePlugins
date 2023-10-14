package me.adrian.skymining.listeners;


import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;



public class BuildDestroyListener implements Listener {


    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

        if (event.getPlayer().getGameMode() != GameMode.CREATIVE) {
            event.setCancelled(true);
        }
    }}



