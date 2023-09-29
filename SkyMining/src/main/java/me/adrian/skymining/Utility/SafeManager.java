package me.adrian.skymining.Utility;

import me.adrian.skymining.SkyMining;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Banner;
import org.bukkit.block.TileState;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.block.data.BlockData;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.util.ArrayList;
import java.util.UUID;

public class SafeManager {


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


    public static ItemStack hasteItem(){

        ItemStack b = new ItemStack(Material.BLAZE_ROD);
        ItemMeta bm = b.getItemMeta();


        ItemStack banners = new ItemStack(Material.WHITE_BANNER);
        ItemMeta bannerm = banners.getItemMeta();

        bm.setUnbreakable(true);
        bm.setDisplayName(ChatColor.GOLD + "Haste Item");


        ArrayList<String> lore = new ArrayList<>();

        lore.add("");
        lore.add(ChatColor.GOLD + "Haste übrig:");
        lore.add(ChatColor.RED + "0");
        lore.add("");


        bm.setLore(lore);

        b.setItemMeta(bm);

        return b;
    }







}