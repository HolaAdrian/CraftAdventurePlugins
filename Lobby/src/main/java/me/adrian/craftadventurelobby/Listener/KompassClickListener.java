package me.adrian.craftadventurelobby.Listener;

import me.adrian.craftadventurelobby.Lobby;
import me.adrian.craftadventurelobby.Utility.Creator;
import me.adrian.craftadventurelobby.Utility.StattMatchmaking;
import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class KompassClickListener implements Listener {


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getCurrentItem() != null){
            if (event.getCurrentItem().getItemMeta() != null) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.UNDERLINE + "Smasher")) {
                    if (event.getWhoClicked() instanceof Player) {
                        Player player = (Player) event.getWhoClicked();
                        if (Lobby.smasherwartung == true) {
                            if (Lobby.playerlanguage.containsKey(player.getUniqueId())) {
                                if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")) {
                                    Creator.CreateTitle(player, ChatColor.RED + "Smasher ist in Wartungsarbeiten!", ChatColor.RED + "Bitte warte bis die Wartungsarbeiten fertig sind!", 20, 60, 20);
                                } else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")) {
                                    Creator.CreateTitle(player, ChatColor.RED + "We are currently working on Smasher", ChatColor.RED + "Because of this you can't join!", 20, 60, 20);
                                }
                            } else {
                                Creator.CreateTitle(player, ChatColor.RED + "Smahser ist in Wartungsarbeiten!", ChatColor.RED + "Bitte warte bis die Wartungsarbeiten fertig sind!", 20, 60, 20);
                            }
                            player.closeInventory();


                            return;
                        }

                        if (Lobby.smasherrunning == false) {
                            if (StattMatchmaking.mp.isEmpty()) {
                                StattMatchmaking.mp.add(player.getUniqueId());
                            } else {
                                if (StattMatchmaking.mp.contains(player.getUniqueId())) {
                                    if (Lobby.playerlanguage.containsKey(player.getUniqueId())) {
                                        if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")) {
                                            player.sendMessage(ChatColor.RED + "Du bist bereits in der Spielersuche!");
                                        }
                                        if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")) {
                                            player.sendMessage(ChatColor.RED + "You are already in que");
                                        }
                                    } else {
                                        player.sendMessage(ChatColor.RED + "Du bist bereits in der Spielersuche!");
                                    }
                                } else {
                                    StattMatchmaking.mp.add(player.getUniqueId());
                                }
                            }

                        } else {
                            if (Lobby.playerlanguage.containsKey(player.getUniqueId())) {
                                if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")) {
                                    Creator.CreateTitle(player, "Smasher läuft bereits!", "Bitte warte bis ein weiterer Server frei ist", 10, 60, 10);
                                }
                                if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")) {
                                    Creator.CreateTitle(player, "Smasher is already running!", "Pleasy wait until a server is free", 10, 60, 10);
                                }
                            } else {
                                Creator.CreateTitle(player, "Smasher läuft bereits!", "Bitte warte bis ein weiterer Server frei ist", 10, 60, 10);
                            }
                        }
                    }
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + ""+  ChatColor.UNDERLINE + "Sky Mining")){
                    Player player = (Player) event.getWhoClicked();
                    if (Lobby.skyminingwartung == true){
                        if (Lobby.playerlanguage.containsKey(player.getUniqueId())) {
                            if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")) {
                                Creator.CreateTitle(player, ChatColor.RED + "Sky Mining ist in Wartungsarbeiten!", ChatColor.RED + "Bitte warte bis die Wartungsarbeiten fertig sind!", 20, 60, 20);
                            } else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")) {
                                Creator.CreateTitle(player, ChatColor.RED + "We are currently working on Sky Mining", ChatColor.RED + "Because of this you can't join!", 20, 60, 20);
                            }
                        } else {
                            Creator.CreateTitle(player, ChatColor.RED + "Sky Mining ist in Wartungsarbeiten!", ChatColor.RED + "Bitte warte bis die Wartungsarbeiten fertig sind!", 20, 60, 20);
                        }
                        return;
                    }
                    player.closeInventory();
                    Lobby.sendServer(player, "skyminer");

                }




            }
            }
        }




    }

