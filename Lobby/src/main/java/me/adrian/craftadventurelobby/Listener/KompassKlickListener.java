package me.adrian.craftadventurelobby.Listener;

import me.adrian.craftadventurelobby.Utility.ItemGetter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KompassKlickListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getItem() != null){
            if (event.getItem().getItemMeta() != null){
                if (event.getItem().getType().equals(Material.COMPASS)){
                    if (event.getAction().equals(Action.RIGHT_CLICK_AIR)|| event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
                        Player player = event.getPlayer();
                        Inventory inventory = Bukkit.createInventory(null, 27, "Spielmodus/Gamemode");
                        inventory.setItem(13, ItemGetter.Smasher(player));
                        inventory.setItem(11, ItemGetter.SkyMining(player));

                        ItemStack coming = new ItemStack(Material.BARRIER);
                        ItemMeta itemMeta = coming.getItemMeta();
                        itemMeta.setDisplayName(ChatColor.RED + "Coming Soon...");
                        coming.setItemMeta(itemMeta);
                        inventory.setItem(15, coming);


                        player.openInventory(inventory);
                    }
                }
            }
        }
    }
}
