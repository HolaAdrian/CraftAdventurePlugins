package me.adrian.skymining.listeners;

import io.papermc.paper.event.player.PlayerInventorySlotChangeEvent;
import me.adrian.skymining.Utility.SafeManager;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerChangedMainHandEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Type;

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
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getCurrentItem() != null){
            if (event.getCurrentItem().getType().equals(Material.BLAZE_ROD)){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInventoryMoveItem(InventoryDragEvent event) {
        if (event.getCursor().getType() != null){
            if (event.getCursor().getType().equals(Material.BLAZE_ROD)){
                event.setCancelled(true);
            }
        }
    }
}
