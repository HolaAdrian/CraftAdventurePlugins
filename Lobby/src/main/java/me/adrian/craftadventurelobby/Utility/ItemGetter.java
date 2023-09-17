package me.adrian.craftadventurelobby.Utility;
import me.adrian.craftadventurelobby.Lobby;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.nio.Buffer;
import java.util.ArrayList;

public class ItemGetter {




    public static ItemStack stopque(){

        ItemStack que = new ItemStack(Material.BARRIER);
        ItemMeta quem = que.getItemMeta();
        quem.setDisplayName(ChatColor.RED + "Leave Que");
        que.setItemMeta(quem);


        return que;


    }
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

    public static ItemStack Bow(){

        ItemStack bw = new ItemStack(Material.BOW);
        ItemMeta bwm = bw.getItemMeta();

        bwm.setDisplayName(ChatColor.GOLD + "Spammer-Bow");
        bwm.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
        bwm.addEnchant(Enchantment.ARROW_INFINITE, 1, true);


        bw.setItemMeta(bwm);

        return bw;

    }

    public static ItemStack KnockbackStick(){

        ItemStack ks = new ItemStack(Material.STICK);
        ItemMeta ksm = ks.getItemMeta();


        ksm.setDisplayName(ChatColor.DARK_PURPLE + "Knockback Stick");
        ksm.addEnchant(Enchantment.KNOCKBACK, 2, true);

        ks.setItemMeta(ksm);

        return ks;

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




}
