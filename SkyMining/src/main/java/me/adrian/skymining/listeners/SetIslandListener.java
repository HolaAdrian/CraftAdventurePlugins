package me.adrian.skymining.listeners;

import me.adrian.skymining.SkyMining;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Collection;

public class SetIslandListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        //Spawn
        Location mittenull = new Location(Bukkit.getWorld("world"), 0.5, 102, -0.5, 0, 0);
        for (Player spawnnear : mittenull.getNearbyPlayers(11)) {
            SkyMining.lastisland.put(spawnnear.getUniqueId(), new Location(Bukkit.getWorld("world"), 0.5, 102, -0.5, 0, 0));
        }

        //Oak
        Location mitteeinz = new Location(Bukkit.getWorld("world"), 0.5, 94, 37.5);
        Collection<Player> nearbyPlayers = mitteeinz.getNearbyPlayers(6);
        for (Player nearbyPlayer : nearbyPlayers) {
            SkyMining.lastisland.put(nearbyPlayer.getUniqueId(), new Location(Bukkit.getWorld("world"), 0.5, 95, 41.5, 180, 0));
        }

        //Birch
        Location mitteezwei = new Location(Bukkit.getWorld("world"), -26.5, 102, 50.5);
        Collection<Player> nearbyPlayers1 = mitteezwei.getNearbyPlayers(6);
        for (Player player : nearbyPlayers1) {
            SkyMining.lastisland.put(player.getUniqueId(), new Location(Bukkit.getWorld("world"), -26.5, 98, 55.5, 180, 0));
        }
        //Stone
        Location mittedrei = new Location(Bukkit.getWorld("world"), 1.5, 107, 70.5);
        Collection<Player> nearbyPlayers2 = mittedrei.getNearbyPlayers(6);
        for (Player player : nearbyPlayers2) {
            SkyMining.lastisland.put(player.getUniqueId(), new Location(Bukkit.getWorld("world"), 1.5, 103, 65.5, 0, 0));
        }
        //Coal
        Location mittevier = new Location(Bukkit.getWorld("world"), 26.5, 114, 35.5);
        Collection<Player> nearbyPlayers3 = mittevier.getNearbyPlayers(6);
        for (Player player : nearbyPlayers3) {
            SkyMining.lastisland.put(player.getUniqueId(), new Location(Bukkit.getWorld("world"), 21.5, 110, 35.5, -90, 0));
        }
        //Iron
        Location mittefünf = new Location(Bukkit.getWorld("world"), 37.5, 120, 5.5);
        Collection<Player> nearbyPlayers4 = mittefünf.getNearbyPlayers(6);
        for (Player player : nearbyPlayers4) {
            SkyMining.lastisland.put(player.getUniqueId(), new Location(Bukkit.getWorld("world"), 42.5, 116, 5.5, 90, 0));
        }

        Location mittesechs = new Location(Bukkit.getWorld("world"), 69.5, 127, -15.5);
        Collection<Player> nearbyPlayers5 = mittesechs.getNearbyPlayers(6);
        for (Player player : nearbyPlayers5) {
            SkyMining.lastisland.put(player.getUniqueId(), new Location(Bukkit.getWorld("world"), 74.5, 123, -15.5, 90, 0));
        }

        //Dia
        Location mittesieben = new Location(Bukkit.getWorld("world"), 75.5, 133, 22.5);
        Collection<Player> nearbyPlayers6 = mittesieben.getNearbyPlayers(6);
        for (Player player : nearbyPlayers6) {
            SkyMining.lastisland.put(player.getUniqueId(), new Location(Bukkit.getWorld("world"), 75.5,  129, 27.5, 180, 0));
        }

    }
}
