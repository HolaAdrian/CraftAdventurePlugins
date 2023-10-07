package me.adrian.craftadventurelobby.Listener;

import me.adrian.craftadventurelobby.Utility.Creator;
import me.adrian.craftadventurelobby.Utility.ItemGetter;
import me.adrian.craftadventurelobby.Utility.StattMatchmaking;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class StopQueListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getItem() != null){
            if (event.getItem().getItemMeta() != null){
                if (event.getItem().equals(ItemGetter.stopque())){
                    if (event.getAction().equals(Action.RIGHT_CLICK_AIR)|| event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
                        if (StattMatchmaking.mp.contains(player.getUniqueId())){
                            StattMatchmaking.mp.remove(player.getUniqueId());
                            player.getInventory().clear();
                            player.sendActionBar(ChatColor.GOLD + "Left!");
                            player.setLevel(0);
                            Creator.SetLobbyItems(player);
                        }
                    }
                }

            }
        }
    }
}
