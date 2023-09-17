package me.adrian.craftadventurelobby.Utility;

import me.adrian.craftadventurelobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class StattMatchmaking {

    public static ArrayList<UUID> mp = new ArrayList<>();

    private static Integer SCHEDU;

    private static Integer countdown = 30;

    public static void StartMatchmaking(){









                SCHEDU = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Lobby.main, new Runnable() {

                    @Override
                    public void run() {

                        Integer players = mp.size();
                        if (players < 2) {
                            for (UUID uuid : mp) {
                                if (Bukkit.getPlayer(uuid) != null) {
                                    Player player1 = Bukkit.getPlayer(uuid);
                                    player1.getInventory().setItem(8, ItemGetter.stopque());
                                    player1.setLevel(60);
                                    countdown = 30;
                                }
                            }
                        } else {
                            countdown = countdown -1;

                            for (UUID uuid : mp) {
                                if (Bukkit.getPlayer(uuid) != null) {
                                    Player player1 = Bukkit.getPlayer(uuid);
                                    player1.getInventory().setItem(8, ItemGetter.stopque());
                                    if (countdown < 1) {
                                        Lobby.smasherrunning = true;


                                    } else {
                                        player1.setLevel(countdown);
                                    }
                                }

                            }

                            if (countdown < 1){

                                for (UUID uuid : mp) {
                                    Player player1 = Bukkit.getPlayer(uuid);
                                    Lobby.sendServer(player1, "smasher");
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
