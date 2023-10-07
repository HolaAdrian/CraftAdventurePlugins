package de.adrian.lifestealhalloween.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.util.ArrayList;

public class ItemGetter {

    public static ItemStack Heart(Integer amount){
        ItemStack b = new ItemStack(Material.PLAYER_HEAD, amount);
        SkullMeta bannerMeta = (SkullMeta) b.getItemMeta();
        PlayerProfile profile = Creator.getProfile("http://textures.minecraft.net/texture/76fdd4b13d54f6c91dd5fa765ec93dd9458b19f8aa34eeb5c80f455b119f278");
        bannerMeta.setOwnerProfile(profile);

        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("1 LIFE/HEART/HERZ");
        lore.add("");
        bannerMeta.setLore(lore);
        bannerMeta.setDisplayName(ChatColor.DARK_RED + "LIFE");
        b.setItemMeta(bannerMeta);
        return b;
    }

    public static ItemStack German(){

        ItemStack b = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta bannerMeta = (SkullMeta) b.getItemMeta();
        PlayerProfile profile = Creator.getProfile("http://textures.minecraft.net/texture/5c27bd8752b9e30051cdfb147515273c82d5a553f06bb6a23920e801f0ac843a");
        bannerMeta.setOwnerProfile(profile);


        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("Klicke um Deutsch als deine Sprache auszuwählen!");
        lore.add("");
        bannerMeta.setLore(lore);
        bannerMeta.setDisplayName(ChatColor.WHITE + "Deutsch");


        b.setItemMeta(bannerMeta);



        return b;

    }

    public static ItemStack ENGLAND(){

        ItemStack b = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta bannerMeta = (SkullMeta) b.getItemMeta();
        PlayerProfile profile = Creator.getProfile("http://textures.minecraft.net/texture/408a5f662ba616821c7523e7297ef870be83a16fd962c131fd9d5c1998cbe936");
        bannerMeta.setOwnerProfile(profile);

        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("Klick to select english as your language");
        lore.add("");
        bannerMeta.setLore(lore);
        bannerMeta.setDisplayName(ChatColor.WHITE + "English");



        b.setItemMeta(bannerMeta);



        return b;

    }
}
