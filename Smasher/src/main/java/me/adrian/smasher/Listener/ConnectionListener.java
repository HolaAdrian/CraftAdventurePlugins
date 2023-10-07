package me.adrian.smasher.Listener;

import me.adrian.smasher.Smasher;
import me.adrian.smasher.Utility.EndRound;
import me.adrian.smasher.Utility.ItemGetter;
import me.adrian.smasher.Utility.Respawner;
import me.adrian.smasher.Utility.Sender;
import me.adrian.smasher.commands.LobbyCommand;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class ConnectionListener implements Listener {

    public static String lastonestanding = "Niemand";


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {


        event.getPlayer().setMaxHealth(20);
        event.getPlayer().setHealth(20);

        Respawner.SetPlayerKits();







        event.setJoinMessage("");
        Player player = event.getPlayer();

        Smasher.cooldown.put(player.getUniqueId(), 1);
        player.setLevel(0);

        Smasher.lives.put(player.getUniqueId(), 10);
        UUID uniqueId = player.getUniqueId();
        Smasher.playingPlayers.add(uniqueId);








        player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999, 0));

        Respawner.Teleport(player);
        player.setGameMode(GameMode.SURVIVAL);

        Smasher.playersalive = Smasher.playersalive +1;





    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        Player player = event.getPlayer();
        player.setMaxHealth(20);
        player.setHealth(10);

        if (!Smasher.deathPlayers.contains(player.getUniqueId())){
            Smasher.deathPlayers.add(player.getUniqueId());
        }

        if (Smasher.playingPlayers.contains(player.getUniqueId()))
            Smasher.playingPlayers.remove(player.getUniqueId());


        if (player.getGameMode().equals(GameMode.SURVIVAL)){
            Smasher.playersalive = Bukkit.getOnlinePlayers().size() -1;
        }

        if (Smasher.playersalive < 2){
            EndRound.SayLobbyEndRound();

            for (Player p: Bukkit.getOnlinePlayers()){
                p.setGameMode(GameMode.SPECTATOR);
            }

            for (Player p: Bukkit.getOnlinePlayers()){
                if (!Smasher.deathPlayers.contains(p.getUniqueId())){
                    lastonestanding = p.getName();
                }
            }



            for (Player p: Bukkit.getOnlinePlayers()){
                p.playSound(p.getLocation(), Sound.ITEM_GOAT_HORN_SOUND_0, 1.0F, 1.0F);
                if (Smasher.playerlanguage.containsKey(p.getUniqueId())){
                    if (Smasher.playerlanguage.get(p.getUniqueId()).equals("de")){
                        p.sendMessage(ChatColor.GOLD + lastonestanding + " hat diese Runde smasher gewonnen!");
                        Sender.CreateTitle(p, ChatColor.GOLD +lastonestanding, ChatColor.GREEN + "hat gewonnen!", 20, 60, 20);
                    }
                    else if (Smasher.playerlanguage.get(p.getUniqueId()).equals("en")){
                        p.sendMessage(ChatColor.GOLD + lastonestanding + " has won this round of smasher!");
                        Sender.CreateTitle(p, ChatColor.GOLD + lastonestanding, ChatColor.GREEN + "has won!", 20, 60, 20);}
                }
                else{
                    p.sendMessage(ChatColor.GOLD + lastonestanding + " hat diese Runde smasher gewonnen!");
                    Sender.CreateTitle(p, ChatColor.GOLD + lastonestanding, ChatColor.GREEN + "hat gewonnen!", 20, 60, 20);
                }
            }

            Bukkit.getScheduler().scheduleSyncDelayedTask(Smasher.main, new Runnable() {
                @Override
                public void run() {
                    EndRound.endRound(player);
                }
            }, 100);


        }


        event.getPlayer().getInventory().clear();
        event.setQuitMessage("");


    }
}
