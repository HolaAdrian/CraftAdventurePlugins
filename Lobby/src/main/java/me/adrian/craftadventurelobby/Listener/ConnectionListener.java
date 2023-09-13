package me.adrian.craftadventurelobby.Listener;

import me.adrian.craftadventurelobby.Lobby;
import me.adrian.craftadventurelobby.Utility.ItemGetter;
import me.adrian.craftadventurelobby.Utility.Sayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Salmon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {

    Integer times = 0;

    private static Integer SCHEDU;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){


        if (!Lobby.playersinsmasher.isEmpty()){
            if (Lobby.playersinsmasher.contains(event.getPlayer().getUniqueId())){
                Lobby.playersinsmasher.remove(event.getPlayer().getUniqueId());
                if (Lobby.playersinsmasher.isEmpty()){
                    Lobby.smasherrunning = false;
                }
            }
        }


        String name = event.getPlayer().getName();

        Player player = event.getPlayer();
        player.getInventory().setHeldItemSlot(2);
        player.getInventory().clear();

        Location location = new Location(Bukkit.getWorld("world"), 735, 23, -1012, -90, 0);

        player.teleport(location);


        event.setJoinMessage("");

        for (Player p: Bukkit.getOnlinePlayers()){
            if (p != player){
                p.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] [" + ChatColor.GOLD + name + ChatColor.GRAY + "]");
            }
        }




        SCHEDU = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.main, new Runnable() {
            @Override
            public void run() {
                times ++;
                if (times>1){
                    Sayer.sayHello(player);
                    player.getInventory().setItem(2, ItemGetter.Compass(player));
                    Bukkit.getScheduler().cancelTask(SCHEDU);
                }
            }
        }, 0, 10);










    }


    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {


        String name = event.getPlayer().getName();

        Player player = event.getPlayer();
        player.getInventory().clear();

        event.setQuitMessage(ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "] [" + ChatColor.GOLD + name + ChatColor.GRAY + "]");



    }



}
