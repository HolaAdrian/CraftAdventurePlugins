package me.adrian.craftadventurelobby.Utility;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class Creator {
    public static PlayerProfile getProfile(String url) {
        PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID());
        PlayerTextures textures = profile.getTextures();
        URL urlObject;
        try {
            urlObject = new URL(url);
        } catch (MalformedURLException exception) {
            throw new RuntimeException("Invalid URL", exception);
        }
        textures.setSkin(urlObject);
        profile.setTextures(textures);
        return profile;
    }


    public static void SetLobbyItems(Player player){
        player.getInventory().setItem(2, ItemGetter.head());
        player.getInventory().setItem(6, ItemGetter.kit());
        player.getInventory().setItem(4, ItemGetter.kompass());







    }


    public static void CreateTitle(Player player, String title, String subtitle, int FadeIn, int stay, int FadeOut){
        player.sendTitle(title, subtitle, FadeIn, stay, FadeOut);
    }

}
