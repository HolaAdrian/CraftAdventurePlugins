package me.adrian.craftadventurelobby.Utility;

import me.adrian.craftadventurelobby.Lobby;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Sayer {




    public static void sayHello(Player player){
        if (Lobby.playerlanguage.containsKey(player.getUniqueId())){
            if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")){
                player.sendMessage(ChatColor.GREEN + "Willkommen auf Craftadventure.de");
            }
            else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")){
                player.sendMessage(ChatColor.GREEN + "Welcome to Craftadventure.de!");
            }
        }
        else{
            player.sendMessage(ChatColor.GREEN + "Willkommen auf Craftadventure.de");
        }


    }
}
