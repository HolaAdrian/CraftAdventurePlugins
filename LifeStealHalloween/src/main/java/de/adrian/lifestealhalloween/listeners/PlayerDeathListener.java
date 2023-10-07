package de.adrian.lifestealhalloween.listeners;

import de.adrian.lifestealhalloween.utils.Datas;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import javax.xml.crypto.Data;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        if (event.getPlayer().getKiller() == null || !(event.getPlayer().getKiller() instanceof Player)){
            if (Datas.playerhearts.containsKey(player.getUniqueId())){
                Double oldhearts = Datas.playerhearts.get(player.getUniqueId());
                Double newhearts = oldhearts - 2.0;
                Datas.playerhearts.put(player.getUniqueId(), newhearts);
            }
            else {
                Datas.playerhearts.put(player.getUniqueId(), 8.0);
            }

        }
        else {
            Player killer = event.getPlayer().getKiller();
            if (Datas.playerhearts.containsKey(player.getUniqueId())){
                Double oldhearts = Datas.playerhearts.get(player.getUniqueId());
                Double newhearts = oldhearts - 2.0;
                Datas.playerhearts.put(player.getUniqueId(), newhearts);

            }
            else {
                Datas.playerhearts.put(player.getUniqueId(), 18.0);
            }
            if (Datas.playerhearts.containsKey(killer.getUniqueId())){
                Double oldhearts = Datas.playerhearts.get(killer.getUniqueId());
                Double newhearts = oldhearts + 2.0;
                Datas.playerhearts.put(killer.getUniqueId(), newhearts);
                killer.setMaxHealth(newhearts);
                killer.setHealth(killer.getHealth() + 2.0);
            }
            else {
                Datas.playerhearts.put(killer.getUniqueId(), 22.0);
            }
        }
    }
}
