package me.adrian.smasher.Listener;

import me.adrian.smasher.Smasher;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        FileConfiguration config = Smasher.main.getConfig();
        if (config.equals(null))
            return;


        if (event.getFrom().getY() > event.getTo().getY()){
            if (Smasher.main.getConfig() != null){
                if (event.getPlayer().getLocation().getY()< Smasher.main.getConfig().getInt("hight")){
                    if (event.getPlayer().getGameMode().equals(GameMode.SURVIVAL)){
                        event.getPlayer().setHealth(0);
                    }
                    else {
                        double x = config.getDouble("airnow.x");
                        double y = config.getDouble("airnow.y");
                        double z = config.getDouble("airnow.z");
                        float yaw = (float) config.getDouble("airnow.yaw");
                        float pitch = (float) config.getDouble("airnow.pitch");


                        Location airnow = new Location(Bukkit.getWorld("world"), x, y, z, yaw, pitch);
                        event.getPlayer().teleport(airnow);
                    }
                }
            }

        }
    }
}
