package me.adrian.smasher.commands;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.adrian.smasher.Listener.ConnectionListener;
import me.adrian.smasher.Smasher;
import me.adrian.smasher.Utility.EndRound;
import me.adrian.smasher.Utility.Respawner;
import me.adrian.smasher.Utility.Sender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

public class LobbyCommand implements CommandExecutor {

    public static String lastonestanding = "Niemand";


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player){

            Player player = ((Player) commandSender).getPlayer();
            Smasher.lives.put(player.getUniqueId(), 0);

            player.setMaxHealth(20);
            player.setHealth(10);

            if (Smasher.lives.containsKey(player.getUniqueId())){

                Integer livesafter = 0;

                if (livesafter.equals(0)){
                    if (!Smasher.deathPlayers.contains(player.getUniqueId())){
                        Smasher.deathPlayers.add(player.getUniqueId());
                    }
                    player.setGameMode(GameMode.SPECTATOR);
                    Smasher.playersalive --;
                }





                if (Smasher.playersalive < 2){
                    EndRound.SayLobbyEndRound();

                    for (Player p: Bukkit.getOnlinePlayers()){
                        p.setGameMode(GameMode.SPECTATOR);
                    }

                    for (Player p: Bukkit.getOnlinePlayers()){
                        if (!Smasher.deathPlayers.contains(p.getUniqueId())){
                            lastonestanding = p.getName();
                        }
                    }







                    Bukkit.getScheduler().scheduleSyncDelayedTask(Smasher.main, new Runnable() {
                        @Override
                        public void run() {
                            EndRound.endRound(player);
                        }
                    }, 100);


                }
                else if (livesafter < 1){
                    for (Player p: Bukkit.getOnlinePlayers()){
                        if (Smasher.playerlanguage.containsKey(p.getUniqueId())){
                            if (Smasher.playerlanguage.get(p.getUniqueId()).equals("de")){
                                p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " ist gestorben und hat keine Leben mehr!");
                            }
                            else if (Smasher.playerlanguage.get(p.getUniqueId()).equals("en")){
                                p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " died and has no more lives!");                                }
                        }
                        else{
                            p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " ist gestorben und hat keine Leben mehr!");                            }
                    }
                }



                if (livesafter > 0){
                    for (Player p: Bukkit.getOnlinePlayers()){
                        if (Smasher.playerlanguage.containsKey(p.getUniqueId())){
                            if (Smasher.playerlanguage.get(p.getUniqueId()).equals("de")){
                                p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " ist gestorben und hat noch " + ChatColor.GOLD + livesafter + ChatColor.GREEN + " Leben!");
                            }
                            else if (Smasher.playerlanguage.get(p.getUniqueId()).equals("en")){
                                p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " died and has " + ChatColor.GOLD + livesafter + ChatColor.GREEN + " lives left!");
                            }
                        }
                        else{
                            p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " ist gestorben und hat noch " + ChatColor.GOLD + livesafter + ChatColor.GREEN + " Leben!");
                        }
                    }
                }





            }

        }


        if (commandSender instanceof Player) {
            Player player = ((Player) commandSender).getPlayer();
            Smasher.sendServer(player, "lobby");
        }

















        return false;


        }




    }

