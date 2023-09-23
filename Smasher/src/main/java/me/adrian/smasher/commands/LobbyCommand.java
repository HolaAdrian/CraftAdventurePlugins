package me.adrian.smasher.commands;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.adrian.smasher.Smasher;
import me.adrian.smasher.Utility.EndRound;
import me.adrian.smasher.Utility.Sender;
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

            if (Smasher.playingPlayers.contains(player.getUniqueId()))
                Smasher.playingPlayers.remove(player.getUniqueId());

            if (player.getGameMode().equals(GameMode.SURVIVAL)){
                Smasher.playersalive = Bukkit.getOnlinePlayers().size() -1;
            }

            if (!Smasher.deathPlayers.contains(player.getUniqueId())){
                Smasher.deathPlayers.add(player.getUniqueId());
            }



            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeUTF("Connect");
                dataOutputStream.writeUTF("lobby");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
             player.sendPluginMessage(Smasher.main, "BungeeCord", byteArrayOutputStream.toByteArray());

            if (Smasher.playersalive < 2){

                for (Player p: Bukkit.getOnlinePlayers()){
                    p.setGameMode(GameMode.SPECTATOR);
                }

                EndRound.SayLobbyEndRound();

                for (Player p: Bukkit.getOnlinePlayers()){
                    if (!Smasher.deathPlayers.contains(p.getUniqueId())){
                        lastonestanding = p.getName();
                    }
                }



                for (Player p: Bukkit.getOnlinePlayers()){
                    if (Smasher.playerlanguage.containsKey(p.getUniqueId())){
                        if (Smasher.playerlanguage.get(p.getUniqueId()).equals("de")){
                            p.sendMessage(ChatColor.GOLD + lastonestanding + " hat diese Runde smasher gewonnen!");
                            Sender.CreateTitle(p, ChatColor.GOLD+lastonestanding, ChatColor.GREEN + "hat gewonnen!", 20, 60, 20);
                        }
                        else if (Smasher.playerlanguage.get(p.getUniqueId()).equals("en")){
                            p.sendMessage(ChatColor.GOLD + lastonestanding + " has won this round of smasher!");
                            Sender.CreateTitle(p, ChatColor.GOLD +lastonestanding, ChatColor.GREEN + "has won!", 20, 60, 20);}
                    }
                    else{
                        p.sendMessage(ChatColor.GOLD + lastonestanding + " hat diese Runde smasher gewonnen!");
                        Sender.CreateTitle(p, ChatColor.GOLD+lastonestanding, ChatColor.GREEN + "hat gewonnen!", 20, 60, 20);
                    }
                }

                Bukkit.getScheduler().scheduleSyncDelayedTask(Smasher.main, new Runnable() {
                    @Override
                    public void run() {
                        EndRound.endRound(player);
                    }
                }, 100);


            }






            }

















        return false;


        }




    }

