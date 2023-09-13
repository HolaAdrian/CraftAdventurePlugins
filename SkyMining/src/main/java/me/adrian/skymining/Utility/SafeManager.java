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

import java.util.ArrayList;
import java.util.UUID;

public class SafeManager {


    public static ItemStack ENGLAND(){

        ItemStack b = new ItemStack(Material.WHITE_BANNER);
        BannerMeta bannerMeta = (BannerMeta) b.getItemMeta();
        bannerMeta.addPattern(new Pattern(DyeColor.RED, PatternType.CROSS));

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

        ItemStack b = new ItemStack(Material.RED_BANNER);
        BannerMeta bannerMeta = (BannerMeta) b.getItemMeta();
        bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
        bannerMeta.addPattern(new Pattern(DyeColor.YELLOW, PatternType.STRIPE_BOTTOM));


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


    public static void SafeAll(FileConfiguration file){

        file.set("new", true);

        for (UUID p: SkyMining.haste.keySet()){
            file.set("haste." + p, SkyMining.haste.get(p));

        }


        SkyMining.main.saveConfig();




    }

    public static void LoadAll(FileConfiguration file){


        if (file.getConfigurationSection("haste") != null){
            for (String p: file.getConfigurationSection("haste").getKeys(false)){
                UUID UUIDp = UUID.fromString(p);
                Integer haste = file.getInt("haste." + p);
                SkyMining.haste.put(UUIDp, haste);
            }



        }






    }



}
