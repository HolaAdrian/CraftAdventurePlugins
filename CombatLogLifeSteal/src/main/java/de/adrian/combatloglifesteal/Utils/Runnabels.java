package de.adrian.combatloglifesteal.Utils;

import de.adrian.combatloglifesteal.CombatLogLifeSteal;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Runnabels {


    public static void StartRunnable(){

        Bukkit.getScheduler().scheduleAsyncRepeatingTask(CombatLogLifeSteal.main, new Runnable() {


            @Override
            public void run() {
                if (CombatLogLifeSteal.cooldown != null){
                    for (UUID uuid : CombatLogLifeSteal.cooldown.keySet()) {
                        Integer cooldown = CombatLogLifeSteal.cooldown.get(uuid);
                        Integer i = cooldown -1;
                        if (i > 0){
                            CombatLogLifeSteal.cooldown.put(uuid, i);
                            if (Bukkit.getPlayer(uuid) != null){
                                Player player = Bukkit.getPlayer(uuid);
                                player.sendActionBar(ChatColor.RED + "Combat: " + i);
                            }
                        }
                        else {
                            CombatLogLifeSteal.cooldown.remove(uuid);
                            if (Bukkit.getPlayer(uuid) != null){
                                Player player = Bukkit.getPlayer(uuid);
                                player.sendActionBar(ChatColor.RED + "Combat: " + 0);
                            }
                        }


                    }
                }
            }
        }, 0, 20);




    }

}
