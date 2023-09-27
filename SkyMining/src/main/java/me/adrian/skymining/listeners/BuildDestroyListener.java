package me.adrian.skymining.listeners;

import com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import java.util.*;

public class BuildDestroyListener implements Listener {

    @EventHandler
    public void onPlayerPickupExperience(PlayerPickupExperienceEvent event) {
        event.setCancelled(true);
    }

    ArrayList<Material> DestroyableBlocks = new ArrayList<Material>();








    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {


        DestroyableBlocks.add(Material.OAK_LOG);
        DestroyableBlocks.add(Material.BIRCH_LOG);
        DestroyableBlocks.add(Material.STONE);
        DestroyableBlocks.add(Material.COAL_ORE);
        DestroyableBlocks.add(Material.IRON_ORE);
        DestroyableBlocks.add(Material.GOLD_ORE);
        DestroyableBlocks.add(Material.DIAMOND_ORE);

        Player player = event.getPlayer();
        if (!player.getGameMode().equals(GameMode.CREATIVE)){
            for (Material destroyableBlock : DestroyableBlocks) {
                if (!DestroyableBlocks.contains(event.getBlock().getType())){
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

        if (event.getPlayer().getGameMode() != GameMode.CREATIVE){
            event.setCancelled(true);
        }
    }
}
