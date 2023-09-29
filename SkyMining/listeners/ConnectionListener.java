package me.adrian.skymining.listeners;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.adrian.skymining.SkyMining;

import me.adrian.skymining.Utility.SetScoreboard;
import me.adrian.skymining.Utility.UpdateHaste;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Objective;

public class ConnectionListener implements Listener {

    private static Integer SCHEDU;
    private static Integer times = 0;

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        for (Player p: Bukkit.getOnlinePlayers()) {
            int newe = Bukkit.getOnlinePlayers().size() -1;
            p.getScoreboard().resetScores(ChatColor.BLUE + "Online Spieler: " + Bukkit.getOnlinePlayers().size());
            for (Objective o : p.getScoreboard().getObjectives()) {
                o.getScore(ChatColor.BLUE + "Online Spieler: " + newe).setScore(3);
            }
        }



        for (Player p : Bukkit.getOnlinePlayers()) {
            if (!p.equals(event.getPlayer())){
                if (SkyMining.playerlanguage.containsKey(p.getUniqueId())){
                    String s = SkyMining.playerlanguage.get(p.getUniqueId());
                    if (s.equals("de")){
                        p.sendMessage(ChatColor.GOLD + event.getPlayer().getName() + ChatColor.RED + " spielt nichtmehr Sky Mine auf Craftadventure.de");
                    }
                    else if (s.equals("en")){
                        p.sendMessage(ChatColor.GOLD + event.getPlayer().getName() + ChatColor.RED + " is no longer playing Sky Mine on Craftadventure.de");
                    }
                }
                else {
                    p.sendMessage(ChatColor.GOLD + event.getPlayer().getName() + ChatColor.RED + " spielt nichtmehr Sky Mine auf Craftadventure.de");
                }
            }
        }
        event.setQuitMessage("");

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){


        Player player = event.getPlayer();
        player.getInventory().setHeldItemSlot(0);

        SetScoreboard.setScoreboard(player);







        if (event.getPlayer().getInventory().contains(Material.BLAZE_ROD) != true){
            event.getPlayer().getInventory().addItem( SafeManager.hasteItem());
            SCHEDU = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyMining.main, new Runnable() {
                @Override
                public void run() {
                    times ++;
                    if (times>1){
                        for (ItemStack itemStack: event.getPlayer().getInventory()){
                            if (itemStack != null){
                                if (itemStack.getType().equals(Material.BLAZE_ROD)){
                                    int first = player.getInventory().first(itemStack);
                                    player.getInventory().setItem(first, SafeManager.hasteItem());

                                }
                            }

                        }
                        UpdateHaste.UpdateHaste(player);
                        Bukkit.getScheduler().cancelTask(SCHEDU);
                    }

                }
            }, 0, 10);
        }
        else {

            SCHEDU = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyMining.main, new Runnable() {
                @Override
                public void run() {
                    times ++;
                    if (times>1){
                        for (ItemStack itemStack: event.getPlayer().getInventory()){
                            if (itemStack != null){
                                if (itemStack.getType().equals(Material.BLAZE_ROD)){
                                    int first = player.getInventory().first(itemStack);
                                    player.getInventory().setItem(first, SafeManager.hasteItem());

                                }
                            }

                        }
                        UpdateHaste.UpdateHaste(player);
                        Bukkit.getScheduler().cancelTask(SCHEDU);
                    }

                }
            }, 0, 10);
        }




        event.setJoinMessage("");





        String name = player.getName();


            for (Player p: Bukkit.getOnlinePlayers()){

                if (p != player){
                    if (SkyMining.playerlanguage.containsKey(p.getUniqueId())){
                        String s = SkyMining.playerlanguage.get(p.getUniqueId());
                        if (s.equals("de")){
                            p.sendMessage(ChatColor.GOLD + name + ChatColor.GREEN + " spielt jetzt Sky Mine auf Craftadventure.de");
                        }
                        else if (s.equals("en")){
                            p.sendMessage(ChatColor.GOLD + name + ChatColor.GREEN + " is now playing on Craftadventure.de");
                        }
                    }
                    else {
                        p.sendMessage(ChatColor.GOLD + name + ChatColor.GREEN + " spielt jetzt Sky Mine auf Craftadventure.de");
                    }
                }



            }




    }
}


