package me.adrian.skymining.Utility;

import me.adrian.skymining.SkyMining;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class UpdateHaste {


    public static void UpdateHaste(Player player){
            if (SkyMining.haste.containsKey(player.getUniqueId())){



                ItemStack b = new ItemStack(Material.BLAZE_ROD);
                ItemMeta bm = b.getItemMeta();


                bm.setUnbreakable(true);
                bm.setDisplayName(ChatColor.GOLD + "Haste Item");


                ArrayList<String> lore = new ArrayList<>();

                lore.add("");





                if (SkyMining.playerlanguage.containsKey(player.getUniqueId())){
                    if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("de")){
                        lore.add(ChatColor.GOLD + "Haste übrig:");
                    }
                    else if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("en")){
                        lore.add(ChatColor.GOLD + "Haste left:");
                    }

                }
                else {
                    lore.add(ChatColor.GOLD + "Haste übrig:");
                }

                if (SkyMining.haste.get(player.getUniqueId()).equals(0)) {
                    lore.add(ChatColor.RED + "0");
                }
                else {
                    lore.add(ChatColor.GREEN + SkyMining.haste.get(player.getUniqueId()).toString());
                }

                lore.add("");

                bm.setLore(lore);


                b.setItemMeta(bm);


                for (ItemStack itemStack : player.getInventory()) {
                    if (itemStack != null){

                        if (itemStack.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Haste Item")){
                            int first = player.getInventory().first(itemStack);
                            player.getInventory().setItem(first, b);
                        }
                    }

                }






            }
            else {


                ItemStack b = new ItemStack(Material.BLAZE_ROD);
                ItemMeta bm = b.getItemMeta();


                bm.setUnbreakable(true);
                bm.setDisplayName(ChatColor.GOLD + "Haste Item");


                ArrayList<String> lore = new ArrayList<>();

                lore.add("");





                if (SkyMining.playerlanguage.containsKey(player.getUniqueId())){
                    if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("de")){
                        lore.add(ChatColor.GOLD + "Haste übrig:");
                    }
                    else if (SkyMining.playerlanguage.get(player.getUniqueId()).equals("en")){
                        lore.add(ChatColor.GOLD + "Haste left:");
                    }

                }
                else {
                    lore.add(ChatColor.GOLD + "Haste übrig:");
                }

                lore.add(ChatColor.RED + "0");
                lore.add("");

                bm.setLore(lore);

                b.setItemMeta(bm);

                for (ItemStack itemStack : player.getInventory()) {
                    if (itemStack != null){

                        if (itemStack.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Haste Item")){
                            int first = player.getInventory().first(itemStack);
                            player.getInventory().setItem(first, b);
                        }
                    }

                }
            }


    }

}
