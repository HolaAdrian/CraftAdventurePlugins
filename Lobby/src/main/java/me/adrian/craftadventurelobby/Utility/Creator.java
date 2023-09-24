package me.adrian.craftadventurelobby.Utility;

import org.bukkit.entity.Player;

public class Creator {

    public static void SetLobbyItems(Player player){
        player.getInventory().setItem(2, ItemGetter.head());
        player.getInventory().setItem(6, ItemGetter.kit());
        player.getInventory().setItem(4, ItemGetter.kompass());







    }


    public static void CreateTitle(Player player, String title, String subtitle, int FadeIn, int stay, int FadeOut){
        player.sendTitle(title, subtitle, FadeIn, stay, FadeOut);
    }

}
