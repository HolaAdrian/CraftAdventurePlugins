package me.adrian.skymining.listeners;

import me.adrian.skymining.SkyMining;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ParkourListener implements Listener {
    Location spawn = new Location(Bukkit.getWorld("world"), 0.5, 102, -0.5, 0, 0);

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {




        if (event.getAction().equals(Action.PHYSICAL)){
            if (event.getClickedBlock().getType().equals(Material.HEAVY_WEIGHTED_PRESSURE_PLATE)){
                    if (SkyMining.haste.containsKey(event.getPlayer().getUniqueId())){
                        for (ItemStack itemStack : event.getPlayer().getInventory()) {
                            if (itemStack != null){
                                if (itemStack.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Haste Item")){

                                    Integer integer = SkyMining.haste.get(event.getPlayer().getUniqueId());
                                    SkyMining.haste.put(event.getPlayer().getUniqueId(), integer +1);


                                    ItemStack b = new ItemStack(Material.BLAZE_ROD);
                                    ItemMeta bm = b.getItemMeta();


                                    bm.setUnbreakable(true);
                                    bm.setDisplayName(ChatColor.GOLD + "Haste Item");


                                    ArrayList<String> lore = new ArrayList<>();

                                    lore.add("");
                                    if (SkyMining.playerlanguage.containsKey(event.getPlayer().getUniqueId())){
                                        if (SkyMining.playerlanguage.get(event.getPlayer().getUniqueId()).equals("de")){
                                            lore.add(ChatColor.GOLD + "Haste übrig:");
                                        }
                                        else if (SkyMining.playerlanguage.get(event.getPlayer().getUniqueId()).equals("en")){
                                            lore.add(ChatColor.GOLD + "Haste left:");
                                        }

                                    }
                                    else {
                                        lore.add(ChatColor.GOLD + "Haste übrig:");
                                    }
                                    String string = SkyMining.haste.get(event.getPlayer().getUniqueId()).toString();
                                    if (SkyMining.haste.get(event.getPlayer().getUniqueId()) == 0){
                                        lore.add(ChatColor.RED + string);
                                    }
                                    else {
                                        lore.add(ChatColor.GREEN + string);
                                    }
                                    lore.add("");


                                    bm.setLore(lore);

                                    b.setItemMeta(bm);



                                    int first = event.getPlayer().getInventory().first(itemStack);
                                    event.getPlayer().getInventory().setItem(first, b);
                                }
                            }

                        }

                        event.getPlayer().teleport(spawn);



                    }
                    else {


                        for (ItemStack itemStack : event.getPlayer().getInventory()) {
                            if (itemStack != null){
                                if (itemStack.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Haste Item")){
                                    SkyMining.haste.put(event.getPlayer().getUniqueId(), 1);
                                    ItemStack b = new ItemStack(Material.BLAZE_ROD);
                                    ItemMeta bm = b.getItemMeta();


                                    bm.setUnbreakable(true);
                                    bm.setDisplayName(ChatColor.GOLD + "Haste Item");


                                    ArrayList<String> lore = new ArrayList<>();

                                    lore.add("");
                                    lore.add(ChatColor.GOLD + "Haste übrig:");
                                    lore.add(ChatColor.GREEN + "1");
                                    lore.add("");


                                    bm.setLore(lore);

                                    b.setItemMeta(bm);


                                    int first = event.getPlayer().getInventory().first(itemStack);
                                    event.getPlayer().getInventory().setItem(first, b);

                                }
                            }






                        }



                    }
                }
            }

        }


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.setCancelled(true);
        Player player = event.getPlayer();
        if (SkyMining.lastisland.containsKey(player.getUniqueId())){
            Location location = SkyMining.lastisland.get(player.getUniqueId());
            player.teleport(location);
        }
        else {
            player.teleport(spawn);
        }
    }
}
