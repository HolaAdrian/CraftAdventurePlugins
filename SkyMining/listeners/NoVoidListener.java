package me.adrian.skymining.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class NoVoidListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {


        Location spawn = new Location(Bukkit.getWorld("world"), 0, 100, 0, 180, 0);


        if (event.getFrom().getY() > event.getTo().getY()){
            if (event.getTo().getY() < 70){
                if (event.getPlayer().getGameMode() != GameMode.CREATIVE){
                    event.getPlayer().teleport(spawn);
                }


            }
        }
    }
}
