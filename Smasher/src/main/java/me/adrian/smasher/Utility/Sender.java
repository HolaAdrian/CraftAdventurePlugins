package me.adrian.smasher.Utility;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Sender {

    public static void CreateTitle(Player player, String title, String subtitle, int FadeIn, int stay, int FadeOut){
        player.sendTitle(title, subtitle, FadeIn, stay, FadeOut);
    }
}
