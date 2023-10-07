package me.adrian.craftadventurelobby.Utility;

import me.adrian.craftadventurelobby.Lobby;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

import static org.bukkit.Sound.ENTITY_ARROW_HIT_PLAYER;

public class StattMatchmaking {

    public static ArrayList<UUID> mp = new ArrayList<>();

    public static Integer SettingCountdown = null;


    public static void StartMatchmaking() {

        Bukkit.getScheduler().scheduleAsyncRepeatingTask(Lobby.main, new Runnable() {
            Integer countdown = 30;

            @Override
            public void run() {

                if (mp.size() < 2) {
                    for (UUID uuid : mp) {
                        if (Bukkit.getPlayer(uuid) != null) {
                            Player player1 = Bukkit.getPlayer(uuid);
                            if (player1.getInventory().getItem(8) == null || player1.getInventory().getItem(8).equals(Material.BARRIER)) {
                                player1.getInventory().clear();
                                player1.getInventory().setItem(8, ItemGetter.stopque());

                            }
                            player1.setLevel(30);
                            player1.sendActionBar(ChatColor.RED + "Countdown: 30");
                            countdown = 30;
                        }
                    }

                } else if (mp.size() > 1) {
                    if (SettingCountdown != null){
                        countdown = SettingCountdown;
                        SettingCountdown = null;
                    }

                    countdown--;
                    if (countdown < 6) {
                        PlaySound.PlaySound(mp);

                    }
                    if (countdown > 0) {

                        for (UUID uuid : mp) {

                            if (Bukkit.getPlayer(uuid) != null) {

                                Player player1 = Bukkit.getPlayer(uuid);
                                player1.setLevel(countdown);
                                if (Lobby.playerlanguage.containsKey(player1.getUniqueId())) {
                                    if (Lobby.playerlanguage.get(player1.getUniqueId()).equals("de")) {
                                        player1.sendActionBar(ChatColor.GREEN + "Spieler: " + mp.size() + " Start: " + countdown);
                                    } else if (Lobby.playerlanguage.get(player1.getUniqueId()).equals("en")) {
                                        player1.sendActionBar(ChatColor.GREEN + "Players: " + mp.size() + " Start: " + countdown);
                                    }
                                } else {
                                    player1.sendActionBar(ChatColor.GREEN + "Spieler: " + mp.size() + " Start: " + countdown);
                                }
                            }

                        }
                    } else if (countdown < 1) {
                        for (UUID uuid : mp) {
                            if (Bukkit.getPlayer(uuid) != null) {
                                Lobby.smasherrunning = true;
                                Player player1 = Bukkit.getPlayer(uuid);
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                                try {
                                    dataOutputStream.writeUTF("Connect");
                                    dataOutputStream.writeUTF("smasher");
                                } catch (IOException ignored) {
                                }
                                player1.sendPluginMessage(Lobby.main, "BungeeCord", byteArrayOutputStream.toByteArray());


                                player1.setLevel(0);
                            }
                        }
                        mp.clear();
                        countdown = 30;
                    }


                }
            }
        }, 0, 20);


    }
}