package me.adrian.skymining.listeners;

import io.papermc.paper.event.player.PrePlayerAttackEntityEvent;
import me.adrian.skymining.SkyMining;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class YesNoPvpListener implements Listener {

    @EventHandler
    public void onPrePlayerAttackEntity(PrePlayerAttackEntityEvent event) {

        if (event.getAttacked() instanceof Player){
            Player player = event.getPlayer();
            Entity attacked = event.getAttacked();
            if (SkyMining.pvpon.containsKey(player.getUniqueId())){
                if (SkyMining.pvpon.get(player.getUniqueId()) == false){

                    event.setCancelled(true);
                    if (SkyMining.playerlanguage.containsKey(player.getUniqueId())){
                        if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("de")) {
                            player.sendMessage(ChatColor.RED + "Du hast PVP aus und kannst deshalb auch keine anderen Spieler angreifen!");
                        }if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("en")) {
                            player.sendMessage(ChatColor.RED + "You have pvp disabled, because of that you can't attack any player!");
                        }
                    }
                    else {
                        player.sendMessage(ChatColor.RED + "Du hast PVP aus und kannst deshalb auch keine anderen Spieler angreifen!");
                    }
                }
                else {
                    if (SkyMining.pvpon.containsKey(attacked.getUniqueId())){
                        if (SkyMining.pvpon.get(attacked.getUniqueId()) == false){
                            event.setCancelled(true);
                            if (SkyMining.playerlanguage.containsKey(player.getUniqueId())){
                                if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("de")) {
                                    player.sendMessage(ChatColor.RED + "Der Spieler hat PVP aus!");
                                }if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("en")) {
                                    player.sendMessage(ChatColor.RED + "The player has pvp disabled!");
                                }
                            }
                            else {
                                player.sendMessage(ChatColor.RED + "Der Spieler hat PVP aus!");
                            }
                        }
                    }
                }




            }
            else {
                event.setCancelled(true);
                if (SkyMining.playerlanguage.containsKey(player.getUniqueId())) {
                    if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("de")) {
                        player.sendMessage(ChatColor.RED + "Wir konnten dich nicht in unserer Datenbase finden! Versuch /pvp zu nutzen oder kontaktiere einen Admin");
                    } else if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("en")) {
                        player.sendMessage(ChatColor.RED + "We couldn't find you in our database! Try using /pvp or contact an admin");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Wir konnten dich nicht in unserer Datenbase finden! Versuch /pvp zu nutzen oder kontaktiere einen Admin");
                }
            }
        }
    }
}
