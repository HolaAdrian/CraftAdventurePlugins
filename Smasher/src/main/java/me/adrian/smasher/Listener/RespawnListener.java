package me.adrian.smasher.Listener;

import com.destroystokyo.paper.event.player.PlayerPostRespawnEvent;
import me.adrian.smasher.Smasher;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnListener implements Listener {

    @EventHandler
    public void onPlayerPostRespawn(PlayerPostRespawnEvent event) {
        FileConfiguration config = Smasher.main.getConfig();
        if (config == null)
            return;


        Integer integer = Smasher.randomGenerator(1, 5);

        Double x = config.getDouble("location" + integer + ".x");
        Double y = config.getDouble("location" + integer + ".y");
        Double z = config.getDouble("location" + integer + ".z");
        Float yaw = (float) config.getDouble("location" + integer + ".yaw");
        Float pitch = (float) config.getDouble("location" + integer + ".pitch");

        Location location = new Location(Bukkit.getWorld("world"), x, y, z ,yaw, pitch);
        event.getPlayer().teleport(location);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {

        FileConfiguration config = Smasher.main.getConfig();
        if (config == null)
            return;


        Integer integer = Smasher.randomGenerator(1, 5);

        Double x = config.getDouble("location" + integer + ".x");
        Double y = config.getDouble("location" + integer + ".y");
        Double z = config.getDouble("location" + integer + ".z");
        Float yaw = (float) config.getDouble("location" + integer + ".yaw");
        Float pitch = (float) config.getDouble("location" + integer + ".pitch");

        Location location = new Location(Bukkit.getWorld("world"), x, y, z ,yaw, pitch);
        event.getPlayer().teleport(location);


        int newInvulnerabilityDuration = 20;

        event.getPlayer().setNoDamageTicks(newInvulnerabilityDuration);


    }
}
