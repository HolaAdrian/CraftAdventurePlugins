package me.adrian.craftadventurelobby.Listener;

import me.adrian.craftadventurelobby.Utility.Creator;
import me.adrian.craftadventurelobby.Utility.ItemGetter;
import me.adrian.craftadventurelobby.Utility.StattMatchmaking;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.net.MalformedURLException;

public class ConnectionListener implements Listener {

    Integer times = 0;



    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){


        String name = event.getPlayer().getName();

        Player player = event.getPlayer();

        player.getInventory().setHeldItemSlot(1);
        player.getInventory().clear();

        Location location = new Location(Bukkit.getWorld("world"), 735, 23, -1012, -90, 0);

        player.teleport(location);
        player.setLevel(0);
        Creator.SetLobbyItems(player);


        event.setJoinMessage("");

        for (Player p: Bukkit.getOnlinePlayers()){
            if (p != player){
                p.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] [" + ChatColor.GOLD + name + ChatColor.GRAY + "]");
            }
        }










    }


    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (StattMatchmaking.mp.contains(event.getPlayer().getUniqueId())){
            StattMatchmaking.mp.remove(event.getPlayer().getUniqueId());
        }


        String name = event.getPlayer().getName();

        Player player = event.getPlayer();
        player.getInventory().clear();

        event.setQuitMessage(ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "] [" + ChatColor.GOLD + name + ChatColor.GRAY + "]");



    }



}
