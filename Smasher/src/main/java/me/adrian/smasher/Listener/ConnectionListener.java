package me.adrian.smasher.Listener;

import me.adrian.smasher.Smasher;
import me.adrian.smasher.Utility.EndRound;
import me.adrian.smasher.Utility.ItemGetter;
import me.adrian.smasher.commands.LobbyCommand;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

public class ConnectionListener implements Listener {

    public static String lastonestanding = "Niemand";


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {



        event.setJoinMessage("");
        Player player = event.getPlayer();

        UUID uuid = player.getUniqueId();
        Smasher.cooldown.put(player.getUniqueId(), 1);
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

        Smasher.lives.put(player.getUniqueId(), 10);
        UUID uniqueId = player.getUniqueId();
        Smasher.playingPlayers.add(uniqueId);





        FileConfiguration config = Smasher.main.getConfig();
        if (config == null)
            return;



        player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999, 0));

        Integer integer = Smasher.randomGenerator(1, 5);

        Double x = config.getDouble("location" + integer + ".x");
        Double y = config.getDouble("location" + integer + ".y");
        Double z = config.getDouble("location" + integer + ".z");
        Float yaw = (float) config.getDouble("location" + integer + ".yaw");
        Float pitch = (float) config.getDouble("location" + integer + ".pitch");

        Location location = new Location(Bukkit.getWorld("world"), x, y, z ,yaw, pitch);
        player.teleport(location);

        Smasher.playersalive = Smasher.playersalive +1;





    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (Smasher.playingPlayers.contains(player.getUniqueId()))
            Smasher.playingPlayers.remove(player.getUniqueId());


        if (player.getGameMode().equals(GameMode.SURVIVAL)){
            Smasher.playersalive = Bukkit.getOnlinePlayers().size() -1;
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
                    p.sendMessage(ChatColor.GOLD + lastonestanding + " hat diese Runde smasher gewonnen!");
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
