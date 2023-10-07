package me.adrian.craftadventurelobby.Utility;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class PlaySound {


    public static void PlaySound(ArrayList<UUID> array){

        for (UUID uuid : array) {
            if (Bukkit.getPlayer(uuid) != null){
                Player player = Bukkit.getPlayer(uuid);
                player.playSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, 1.0F, 1.0F);
            }
        }



    }

}
