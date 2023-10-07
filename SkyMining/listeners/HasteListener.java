package me.adrian.skymining.listeners;

import me.adrian.skymining.SkyMining;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class HasteListener implements Listener {




    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getItem() != null){

            if (event.getAction() == Action.RIGHT_CLICK_AIR|| event.getAction() == Action.RIGHT_CLICK_BLOCK){
                if (event.getItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Haste Item")){
                    if (!SkyMining.haste.containsKey(event.getPlayer().getUniqueId())){
                        if (SkyMining.playerlanguage.containsKey(event.getPlayer().getUniqueId())){
                            if (SkyMining.playerlanguage.get(event.getPlayer().getUniqueId()).equals("de")){
                                event.getPlayer().sendMessage(ChatColor.RED + "Du hast kein Haste mehr übrig!");
                            }
                            else if (SkyMining.playerlanguage.get(event.getPlayer().getUniqueId()).equals("en")){
                                event.getPlayer().sendMessage(ChatColor.RED + "You don't have any more haste!");
                            }

                        }
                        else {
                            event.getPlayer().sendMessage(ChatColor.RED + "Du hast kein Haste mehr übrig!");
                        }
                    }
                    else {
                        if (SkyMining.haste.get(event.getPlayer().getUniqueId()) == 0){

                            if (SkyMining.playerlanguage.containsKey(event.getPlayer().getUniqueId())){
                                if (SkyMining.playerlanguage.get(event.getPlayer().getUniqueId()).equals("de")){
                                    event.getPlayer().sendMessage(ChatColor.RED + "Du hast kein Haste mehr übrig!");
                                }
                                else if (SkyMining.playerlanguage.get(event.getPlayer().getUniqueId()).equals("en")){
                                    event.getPlayer().sendMessage(ChatColor.RED + "You don't have any more haste!");
                                }

                            }
                            else {
                                event.getPlayer().sendMessage(ChatColor.RED + "Du hast kein Haste mehr übrig!");
                            }



                        }
                        else {





                            if (SkyMining.playerlanguage.containsKey(event.getPlayer().getUniqueId())){
                                if (SkyMining.playerlanguage.get(event.getPlayer().getUniqueId()).equals("de")){
                                    event.getPlayer().sendMessage(ChatColor.GREEN + "Du hast jetzt für 2 Minuten Haste 3");
                                }
                                else if (SkyMining.playerlanguage.get(event.getPlayer().getUniqueId()).equals("en")){
                                    event.getPlayer().sendMessage(ChatColor.GREEN + "You now have haste 3 for 2 minutes");
                                }

                            }
                            else {
                                event.getPlayer().sendMessage(ChatColor.GREEN + "Du hast jetzt für 2 Minuten Haste 3");
                            }


                            Integer integer = SkyMining.haste.get(event.getPlayer().getUniqueId());
                            SkyMining.haste.put(event.getPlayer().getUniqueId(), integer -1);



                            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 2400 , 2));



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

                            for (ItemStack itemStack : event.getPlayer().getInventory()) {
                                if (itemStack != null){

                                    if (itemStack.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Haste Item")){
                                        int first = event.getPlayer().getInventory().first(itemStack);
                                        event.getPlayer().getInventory().setItem(first, b);
                                    }
                                }

                            }

                        }
            }





                }
            }
        }




    }
}
