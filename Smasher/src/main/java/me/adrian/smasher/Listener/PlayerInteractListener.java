package me.adrian.smasher.Listener;

import com.destroystokyo.paper.event.block.BlockDestroyEvent;
import io.papermc.paper.event.block.BlockBreakBlockEvent;
import me.adrian.smasher.Smasher;
import me.adrian.smasher.Utility.Cooldown;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() != null){
            if (event.getClickedBlock().getType().equals(Material.LIGHT_WEIGHTED_PRESSURE_PLATE)){
                if (event.getAction().equals(Action.PHYSICAL)){
                    Player player = event.getPlayer();
                    if (Smasher.cooldown.get(player.getUniqueId()) != 0){
                        return;
                    }
                    Vector knockbackVector = new Vector(0, 2.35, 0);
                    player.setVelocity(knockbackVector);
                    Smasher.cooldown.put(player.getUniqueId(), 25);
                    player.sendActionBar(ChatColor.GREEN + "Cooldown: 25");
                }
            }

        }
        }




    }

