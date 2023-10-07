package de.adrian.lifestealhalloween.listeners;

import de.adrian.lifestealhalloween.utils.Datas;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class HeartLitstener implements Listener {


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getItem() != null){
            if (event.getItem().getItemMeta() != null){
                if (event.getItem().getType().equals(Material.PLAYER_HEAD)){
                    if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)|| event.getAction().equals(Action.RIGHT_CLICK_AIR)){
                        event.setCancelled(true);
                        Player player = event.getPlayer();
                        player.setMaxHealth(player.getMaxHealth() + 2.0);
                        player.setHealth(player.getHealth() + 2.0);
                        if (Datas.playerhearts.containsKey(player.getUniqueId())){
                            Datas.playerhearts.put(player.getUniqueId(), Datas.playerhearts.get(player.getUniqueId()) + 2.0);
                        }
                        else {
                            Datas.playerhearts.put(player.getUniqueId(), player.getMaxHealth());
                        }
                        for (ItemStack itemStack : player.getInventory()) {
                            if (itemStack != null){
                                if (itemStack.equals(event.getItem())){
                                    itemStack.setAmount(itemStack.getAmount() -1);
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}
