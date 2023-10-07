package me.adrian.skymining.listeners;

import com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;


public class BuildDestroyListener implements Listener {

    static ArrayList<Material> DestroyableBlocks = new ArrayList<Material>();


    public static void AddBlocks(){


        DestroyableBlocks.add(Material.OAK_LOG);
        DestroyableBlocks.add(Material.BIRCH_LOG);
        DestroyableBlocks.add(Material.STONE);
        DestroyableBlocks.add(Material.COAL_ORE);
        DestroyableBlocks.add(Material.IRON_ORE);
        DestroyableBlocks.add(Material.GOLD_ORE);
        DestroyableBlocks.add(Material.DIAMOND_ORE);
    }








    @EventHandler
    public void onPlayerPickupExperience(PlayerPickupExperienceEvent event) {
        event.setCancelled(true);
    }










    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();
        if (!player.getGameMode().equals(GameMode.CREATIVE)){
            if (!DestroyableBlocks.contains(event.getBlock().getType())){
                event.setCancelled(true);
            }
        }
    }



    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

        if (event.getPlayer().getGameMode() != GameMode.CREATIVE) {
            event.setCancelled(true);
        }
    }}



