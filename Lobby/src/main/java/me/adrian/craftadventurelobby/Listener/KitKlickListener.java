package me.adrian.craftadventurelobby.Listener;

import me.adrian.craftadventurelobby.Utility.ItemGetter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class KitKlickListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getItem() != null){
            if (event.getItem().getItemMeta() != null){
                if (event.getItem().getType().equals(Material.STICK)){
                    if (event.getAction().equals(Action.RIGHT_CLICK_AIR)|| event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
                        Player player = event.getPlayer();
                        Inventory inventory = Bukkit.createInventory(null, 9, "Kit");


                        inventory.setItem(0, ItemGetter.KnockbackStick());
                        inventory.setItem(1, ItemGetter.Bow());
                        inventory.setItem(2, ItemGetter.Assasine());

                        player.openInventory(inventory);
                    }
                }
            }
        }
    }


}
