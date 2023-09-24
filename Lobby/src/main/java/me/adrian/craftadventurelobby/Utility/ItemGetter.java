package me.adrian.craftadventurelobby.Utility;
import com.destroystokyo.paper.profile.PlayerProfile;
import me.adrian.craftadventurelobby.Lobby;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerTextures;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.UUID;

public class ItemGetter {

    public static ItemStack SkyMining(Player player){
        ItemStack kit = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta kitm = kit.getItemMeta();
        kitm.setDisplayName(ChatColor.DARK_PURPLE + ""+  ChatColor.UNDERLINE + "Sky Mining");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        if (Lobby.playerlanguage.containsKey(player.getUniqueId())) {
            if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")) {
                lore.add("In Sky Mining musst du in vielen Inseln verschiedene Rohstoffe abbauen und somit voranschreiten!");
            } else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")) {
                lore.add("In Sky Mining, you must mine various resources on multiple islands to progress!");
            }
        } else {
            lore.add("In Sky Mining musst du in vielen Inseln verschiedene Rohstoffe abbauen und somit voranschreiten!");
        }
        lore.add("");
        kitm.setLore(lore);
        kitm.addEnchant(Enchantment.DIG_SPEED, 1, true);
        kit.setItemMeta(kitm);
        return kit;


    }

    public static ItemStack Smasher(Player player){
        ItemStack kit = new ItemStack(Material.STICK);
        ItemMeta kitm = kit.getItemMeta();
        kitm.setDisplayName(ChatColor.AQUA + ""+  ChatColor.UNDERLINE + "Smasher");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        if (Lobby.playerlanguage.containsKey(player.getUniqueId())) {
            if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")) {
                lore.add("In Smasher musst du mit verschiedenen Kits deine Gegner von einer riesigen Insel werfen!");
            } else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")) {
                lore.add("In Smasher you have to use various kits to throw your opponents off a huge island!");
            }
        } else {
            lore.add("In Smasher musst du mit verschiedenen Kits deine Gegner von einer riesigen Insel werfen!");
        }
        lore.add("");
        kitm.setLore(lore);
        kitm.addEnchant(Enchantment.KNOCKBACK, 1, true);
        kit.setItemMeta(kitm);
        return kit;
    }



    public static ItemStack kit(){
        ItemStack kit = new ItemStack(Material.STICK);
        ItemMeta kitm = kit.getItemMeta();
        kitm.setDisplayName(ChatColor.GOLD + "Kit (Smasher)");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("Änder dein Smasher Kit!");
        lore.add("");
        lore.add("Change your Smasher kit!");
        lore.add("");
        kitm.setLore(lore);
        kitm.addEnchant(Enchantment.KNOCKBACK, 1, true);
        kit.setItemMeta(kitm);
        return kit;



    }

    public static ItemStack kompass(){
        ItemStack comp = new ItemStack(Material.COMPASS);
        ItemMeta compm = comp.getItemMeta();
        compm.setDisplayName(ChatColor.GOLD + "Gamemodeselector/Spielmodusauswahl");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("Ändere deinen Spielmodus!");
        lore.add("");
        lore.add("Change your gamemode!");
        lore.add("");
        compm.setLore(lore);
        comp.setItemMeta(compm);


        return comp;


    }



    public static ItemStack head(){
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta headm = (SkullMeta) head.getItemMeta();
        headm.setOwner("TheJohannCrafter");
        headm.setDisplayName(ChatColor.GOLD + "Language/Sprache");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("Änder deine Sprache!");
        lore.add("");
        lore.add("Change your language!");
        lore.add("");
        headm.setLore(lore);
        head.setItemMeta(headm);






        return head;
    }
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
        ksm.addEnchant(Enchantment.KNOCKBACK, 3, true);

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
