package me.adrian.skymining.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class NoShitListener implements Listener {


    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Villager){
            if (event.getDamager() instanceof Player){
                Player dammager = (Player) event.getDamager();

                if (!dammager.getGameMode().equals(GameMode.CREATIVE)){
                    event.setCancelled(true);
                }

            }
        }
    }



    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        event.setCancelled(true);
        event.setCurrentItem(new ItemStack(org.bukkit.Material.AIR));
    }

    @EventHandler
    public void onPrepareItemCraft(PrepareItemCraftEvent event) {
        if (event.getRecipe() == null){
            return;
        }
        if (event.getRecipe().getResult() != null){
            event.getRecipe().getResult().setType(Material.AIR);
            event.getInventory().setResult(new ItemStack(Material.AIR));
        }

    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {


        if (event.getItemDrop().getItemStack().getType().equals(Material.BLAZE_ROD)){
                event.setCancelled(true);
            }



    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event != null){
            if (event.getClickedBlock()!= null){
                if (event.getClickedBlock().getType().equals(Material.MANGROVE_TRAPDOOR)){
                    if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
                        event.setCancelled(true);
                    }

                }
            }
        }



    }

    @EventHandler
    public void onInventoryMoveItem(InventoryDragEvent event) {
        if (event.getCursor() != null){
            if (event.getCursor().getType() != null){
                if (event.getCursor().getType().equals(Material.BLAZE_ROD)){
                    event.setCancelled(true);
                }
            }
        }

    }
}
