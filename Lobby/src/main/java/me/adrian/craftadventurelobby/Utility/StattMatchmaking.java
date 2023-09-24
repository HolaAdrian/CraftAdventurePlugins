package me.adrian.craftadventurelobby.Utility;

import me.adrian.craftadventurelobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.UUID;

public class StattMatchmaking {

    public static ArrayList<UUID> mp = new ArrayList<>();

    private static Integer SCHEDU;



    public static void StartMatchmaking(){









                SCHEDU = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Lobby.main, new Runnable() {

                    Integer countdown = 30;

                    @Override
                    public void run() {


                        Integer players = mp.size();
                        if (players < 2) {
                            for (UUID uuid : mp) {
                                if (Bukkit.getPlayer(uuid) != null) {
                                    Player player1 = Bukkit.getPlayer(uuid);
                                    if (player1.getInventory().getItem(8) == null || player1.getInventory().getItem(8).equals(Material.BARRIER)){
                                        player1.getInventory().clear();
                                        player1.getInventory().setItem(8, ItemGetter.stopque());

                                    }
                                    player1.setLevel(60);
                                    player1.sendActionBar(ChatColor.RED + "Countdown: 60");
                                    countdown = 30;
                                }
                            }
                        } else {
                            countdown = countdown -1;

                            for (UUID uuid : mp) {
                                if (Bukkit.getPlayer(uuid) != null) {
                                    Player player1 = Bukkit.getPlayer(uuid);
                                    if (countdown < 1) {
                                        Lobby.smasherrunning = true;


                                    } else {
                                        if (player1.getInventory().getItem(8) == null || player1.getInventory().getItem(8).equals(Material.BARRIER)){
                                                player1.getInventory().clear();
                                                player1.getInventory().setItem(8, ItemGetter.stopque());

                                        }
                                        player1.setLevel(countdown);
                                        player1.sendActionBar(ChatColor.GREEN + "Players: " + mp.size() +  " " + " " + " Countdown: " + countdown);
                                    }
                                }

                            }

                            if (countdown < 1){

                                for (UUID uuid : mp) {
                                    Player player1 = Bukkit.getPlayer(uuid);
                                    Lobby.sendServerQuit(player1, "smasher");
                                    player1.setLevel(0);
                                    mp.remove(player1);

                                }
                                countdown = 30;
                                mp.clear();
                                Bukkit.getScheduler().cancelTask(SCHEDU);
                            }



                        }
                    }
                }, 0, 20);



    }
}
