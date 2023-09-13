package me.adrian.craftadventurelobby.Listener;

import me.adrian.craftadventurelobby.Utility.ItemGetter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class CompassClickListener implements Listener {

    public static ArrayList<Inventory> inventories = new ArrayList<>();




    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        if (event.getItem() != null){
            ItemStack item = event.getItem();

            if (item.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Serverselector")){
                if (event.getAction() == Action.RIGHT_CLICK_AIR|| event.getAction() == Action.RIGHT_CLICK_BLOCK){
                    Player player = event.getPlayer();

                    Inventory inventory = Bukkit.createInventory(null, 27, ChatColor.GOLD + "Server Selector:");


                    ItemStack coming = ItemGetter.ComingSoon(event.getPlayer());




                    ItemStack smasher = ItemGetter.Smasher(event.getPlayer());
                    inventory.setItem(10, smasher);

                    ItemStack miner = ItemGetter.SkyMiner(event.getPlayer());
                    inventory.setItem(13, miner);


                    inventory.setItem(16, coming);


                    inventories.add(inventory);





                    player.openInventory(inventory);




                }



            }
        }
    }

}
