package me.adrian.smasher.Listener;

import com.destroystokyo.paper.event.player.PlayerPostRespawnEvent;
import me.adrian.smasher.Smasher;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.UUID;

public class RespawnListener implements Listener {

    @EventHandler
    public void onPlayerPostRespawn(PlayerPostRespawnEvent event) {
        FileConfiguration config = Smasher.main.getConfig();
        if (config == null)
            return;


        Integer integer = Smasher.randomGenerator(1, 8);

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


        Integer integer = Smasher.randomGenerator(1, 8);

        Double x = config.getDouble("location" + integer + ".x");
        Double y = config.getDouble("location" + integer + ".y");
        Double z = config.getDouble("location" + integer + ".z");
        Float yaw = (float) config.getDouble("location" + integer + ".yaw");
        Float pitch = (float) config.getDouble("location" + integer + ".pitch");

        Location location = new Location(Bukkit.getWorld("world"), x, y, z ,yaw, pitch);
        event.getPlayer().teleport(location);


        int newInvulnerabilityDuration = 1;
        Smasher.cooldown.put(event.getPlayer().getUniqueId(), 0);
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        if (Smasher.playerlanguage.containsKey(uuid)){
            if (Smasher.playerlanguage.get(uuid).equals("de")){
                player.sendActionBar(ChatColor.GREEN + "Kein Cooldown mehr!");

            }
            else if (Smasher.playerlanguage.get(uuid).equals("en")){
                player.sendActionBar(ChatColor.GREEN + "No more cooldown!");

            }
        }
        else{
            player.sendActionBar(ChatColor.GREEN + "Kein Cooldown mehr!");
        }

        event.getPlayer().setNoDamageTicks(newInvulnerabilityDuration);


    }
}
