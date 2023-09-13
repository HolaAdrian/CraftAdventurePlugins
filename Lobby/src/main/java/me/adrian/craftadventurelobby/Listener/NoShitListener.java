package me.adrian.craftadventurelobby.Listener;

import io.papermc.paper.event.player.PrePlayerAttackEntityEvent;
import me.adrian.craftadventurelobby.Lobby;
import me.adrian.craftadventurelobby.Utility.ItemGetter;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class NoShitListener implements Listener {


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getCurrentItem() == null){
            return;
        }
        if (event.getCurrentItem().getItemMeta() != null){
            if (event.getWhoClicked() instanceof Player){
                Player player = (Player) event.getWhoClicked();
                if (event.getCurrentItem().getType().equals(Material.NETHERITE_PICKAXE)){
                    event.setCancelled(true);
                    Lobby.sendServer(player, "skyminer");
                }
                else if (event.getCurrentItem().getType().equals(Material.BLAZE_ROD)){

                    if (Lobby.smasherrunning == false){

                        event.setCancelled(true);
                        Lobby.sendServer(player, "smasher");
                        Lobby.playersinsmasher.add(player.getUniqueId());
                        Lobby.smasherrunning = true;
                    }
                    else {

                        player.sendMessage(ChatColor.RED + "Run");
                        event.setCancelled(true);
                    }


                }
            }


        }
    }



    @EventHandler
    public void onInventoryPickupItem(InventoryPickupItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getItem() == null){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onInventoryInteract(InventoryInteractEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerAttemptPickupItem(PlayerAttemptPickupItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player){
            if (event.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK){
                event.setCancelled(true);
            }
        }
    }



    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPrePlayerAttackEntity(PrePlayerAttackEntityEvent event) {
        if (event.getPlayer().getGameMode() != GameMode.CREATIVE){
            event.setCancelled(true);
        }
    }

}
