package me.adrian.craftadventurelobby.Utility;

import org.bukkit.entity.Player;

public class Creator {


    public static void CreateTitle(Player player, String title, String subtitle, int FadeIn, int stay, int FadeOut){
        player.sendTitle(title, subtitle, FadeIn, stay, FadeOut);
    }

}
