package me.adrian.smasher.Listener;

import me.adrian.smasher.Smasher;
import me.adrian.smasher.Utility.EndRound;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.UUID;

public class PlayerDeathListener implements Listener {

    public static String lastonestanding;

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.setDeathMessage("");
        if (event.getEntity() instanceof Player){
            Player player = event.getEntity();
            if (Smasher.playingPlayers.contains(player.getUniqueId())){
                if (Smasher.lives.containsKey(player.getUniqueId())){
                    Integer integer = Smasher.lives.get(player.getUniqueId());
                    Integer livesafter = integer -1;
                    Smasher.lives.put(player.getUniqueId(), livesafter);

                    if (livesafter.equals(0)){
                        player.setGameMode(GameMode.SPECTATOR);
                        Smasher.playersalive --;
                    }




                    if (Smasher.playersalive < 2){

                        for (UUID playingPlayer : Smasher.playingPlayers) {
                            Player player1 = Bukkit.getPlayer(playingPlayer);
                            if (player1 != null){
                                if (player != player1){
                                    lastonestanding = player1.getName();
                                }
                            }
                        }



                        for (Player p: Bukkit.getOnlinePlayers()){
                            if (Smasher.playerlanguage.containsKey(p.getUniqueId())){
                                if (Smasher.playerlanguage.get(p.getUniqueId()).equals("de")){
                                    p.sendMessage(ChatColor.GOLD + lastonestanding + " hat diese Runde smasher gewonnen!");
                                }
                                else if (Smasher.playerlanguage.get(p.getUniqueId()).equals("en")){
                                    p.sendMessage(ChatColor.GOLD + lastonestanding + " has won this round of smasher!");                                }
                            }
                            else{
                                p.sendMessage(ChatColor.GOLD + lastonestanding + " hat diese Runde smasher gewonnen!");                            }
                        }


                        Bukkit.getScheduler().scheduleSyncDelayedTask(Smasher.main, new Runnable() {
                            @Override
                            public void run() {
                                EndRound.endRound(player);
                            }
                        }, 100);


                    }
                    else if (livesafter < 1){
                        for (Player p: Bukkit.getOnlinePlayers()){
                            if (Smasher.playerlanguage.containsKey(p.getUniqueId())){
                                if (Smasher.playerlanguage.get(p.getUniqueId()).equals("de")){
                                    p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " ist gestorben und hat keine Leben mehr!");
                                }
                                else if (Smasher.playerlanguage.get(p.getUniqueId()).equals("en")){
                                    p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " died and has no more lives!");                                }
                            }
                            else{
                                p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " ist gestorben und hat keine Leben mehr!");                            }
                        }
                    }



                    if (livesafter > 0){
                        for (Player p: Bukkit.getOnlinePlayers()){
                            if (Smasher.playerlanguage.containsKey(p.getUniqueId())){
                                if (Smasher.playerlanguage.get(p.getUniqueId()).equals("de")){
                                    p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " ist gestorben und hat noch " + ChatColor.GOLD + livesafter + ChatColor.GREEN + " Leben!");
                                }
                                else if (Smasher.playerlanguage.get(p.getUniqueId()).equals("en")){
                                    p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " died and has " + ChatColor.GOLD + livesafter + ChatColor.GREEN + " lives left!");
                                }
                            }
                            else{
                                p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " ist gestorben und hat noch " + ChatColor.GOLD + livesafter + ChatColor.GREEN + " Leben!");
                            }
                        }
                    }



                }
            }
        }


    }
}
