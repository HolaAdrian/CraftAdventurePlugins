package me.adrian.smasher.Listener;

import me.adrian.smasher.Smasher;
import me.adrian.smasher.Utility.EndRound;
import me.adrian.smasher.Utility.Respawner;
import me.adrian.smasher.Utility.Sender;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    public static String lastonestanding = "Niemand";


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (event.getFrom().getY() > event.getTo().getY()){
            if (Smasher.main.getConfig() != null){
                if (event.getPlayer().getLocation().getY()< Smasher.main.getConfig().getInt("hight")){
                    if (event.getPlayer().getGameMode().equals(GameMode.SURVIVAL)){
                        Player player = event.getPlayer();
                        Respawner.Teleport(player);
                        Respawner.RemoveLife(player);

                    }

                }
            }

        }

    }
}




