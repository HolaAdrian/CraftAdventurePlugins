package me.adrian.smasher.Utility;

import me.adrian.smasher.Smasher;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Cooldown {


    public static void StatSchedualar(Smasher main){
        Bukkit.getScheduler().scheduleAsyncRepeatingTask(main, new Runnable() {
            @Override
            public void run() {
                for (UUID uuid : Smasher.cooldown.keySet()) {
                    Integer cooldown = Smasher.cooldown.get(uuid);

                    System.out.println(cooldown);

                    if (cooldown < 2){
                        if (Bukkit.getPlayer(uuid) != null){
                            Player player = Bukkit.getPlayer(uuid);

                            if (Smasher.playerlanguage.containsKey(uuid)){
                                if (Smasher.playerlanguage.get(uuid).equals("de")){
                                    player.sendActionBar(ChatColor.GREEN + "Kein Cooldown mehr!");

                                }
                                else if (Smasher.playerlanguage.get(uuid).equals("en")){
                                    player.sendActionBar(ChatColor.GREEN + "No more cooldown!");

                                }
                            }
                            else{
                                player.sendActionBar(ChatColor.GREEN + "Kein Cooldown mehr!");
                            }
                        }
                        if (Bukkit.getPlayer(uuid) != null){
                            Player player = Bukkit.getPlayer(uuid);
                            cooldown = 0;
                            Smasher.cooldown.put(player.getUniqueId(), cooldown);
                        }

                    }
                    else {
                        cooldown --;
                        if (Bukkit.getPlayer(uuid) != null){
                            Player player = Bukkit.getPlayer(uuid);
                            player.sendActionBar(ChatColor.GREEN + "Cooldown: " + String.valueOf(cooldown));
                            Smasher.cooldown.put(player.getUniqueId(), cooldown);
                        }

                    }

                }





            }
        }, 0, 20);
    }


}
