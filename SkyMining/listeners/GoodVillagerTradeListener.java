package me.adrian.skymining.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.AbstractVillager;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GoodVillagerTradeListener implements Listener {


    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        return;
        //if (event.getRightClicked() instanceof Villager){
            //AbstractVillager villager1 = (AbstractVillager) event.getRightClicked();
            //Inventory inventory = villager1.getInventory();
            //Inventory inventory1 = Bukkit.createInventory(null, 9);

            //event.getPlayer().openInventory(inventory1);
        //}
    }
}
