package me.adrian.craftadventurelobby.Utility;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.adrian.craftadventurelobby.Lobby;
import org.bukkit.Bukkit;
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


    public static Integer SkyMinePlayer;

    private static Integer SCHEDU;
    private static Integer times = 0;




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

    public static ItemStack Smasher(Player player){



        ItemStack compass = new ItemStack(Material.BLAZE_ROD);
        ItemMeta compassmeta = compass.getItemMeta();

        compassmeta.setDisplayName(ChatColor.GOLD + "Smasher");

        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        if (Lobby.playerlanguage.containsKey(player.getUniqueId())){
            if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")){
                lore.add("Smasher ist ein Modus in dem du andere Spieler von der Insel hauen musst!");
                lore.add("Du kannst dein Kit mit /changekit auswählen.");
            }
            else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")){
                lore.add("Smasher is a mode in which you have to knock other players off your island!");
                lore.add("You can use /changekit to change your kit");
            }
        }
        else{
            lore.add("Smasher ist ein Modus in dem du andere Spieler von der Insel hauen musst!");
            lore.add("Du kannst dein Kit mit /changekit auswählen.");
        }











        if (Lobby.serverplayers.containsKey("event")){
            lore.add(Lobby.serverplayers.get("event").toString());
        }
        lore.add("");

        compassmeta.setLore(lore);

        compass.setItemMeta(compassmeta);



        return compass;

    }


    public static ItemStack SkyMiner(Player player){



        ItemStack compass = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta compassmeta = compass.getItemMeta();

        compassmeta.setDisplayName(ChatColor.GOLD + "Sky Mining");

                ArrayList<String> lore = new ArrayList<>();
                lore.add("");
                if (Lobby.playerlanguage.containsKey(player.getUniqueId())){
                    if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")){
                        lore.add("Sky Miner ist ein Modus in dem du dich von unten nach oben arbeiten musst.");
                        lore.add("Du startest bei Holz und gräbst dich durch die verschiedenen Dimensionen.");
                    }
                    else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")){
                        lore.add("Sky Miner is a mode in which you have to work your way from bottom to top.");
                        lore.add("You start with wood and dig through the various dimensions.");
                    }
                }
                else{
                    lore.add("Sky Miner ist ein Modus in dem du dich von unten nach oben arbeiten musst.");
                    lore.add("Du startest bei Holz und gräbst dich durch die verschiedenen Dimensionen.");
                }











                if (Lobby.serverplayers.containsKey("event")){
                    lore.add(Lobby.serverplayers.get("event").toString());
                }
                lore.add("");

                compassmeta.setLore(lore);

        compass.setItemMeta(compassmeta);



        return compass;

    }


    public static ItemStack ComingSoon(Player player){

        ItemStack compass = new ItemStack(Material.BARRIER);
        ItemMeta compassmeta = compass.getItemMeta();

        compassmeta.setDisplayName(ChatColor.RED + "Coming Soon...");

        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        if (Lobby.playerlanguage.containsKey(player.getUniqueId())){
            if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")){
                lore.add("Mehr Server kommen bald...");
            }
            else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")){
                lore.add("More server will come soon...");
            }
        }
        else{
            lore.add("Mehr Server kommen bald...");
        }

        lore.add("");
        lore.add("");

        compassmeta.setLore(lore);

        compass.setItemMeta(compassmeta);



        return compass;

    }

    public static ItemStack Compass(Player player){

        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassmeta = compass.getItemMeta();

        compassmeta.setDisplayName(ChatColor.GOLD + "Serverselector");

        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        if (Lobby.playerlanguage.containsKey(player.getUniqueId())){
            if (Lobby.playerlanguage.get(player.getUniqueId()).equals("de")){
                lore.add("Wähle deine Server aus (Rechtsklick)");
            }
            else if (Lobby.playerlanguage.get(player.getUniqueId()).equals("en")){
                lore.add("Choose your server (Right-click)");
            }
        }
        else{
            lore.add("Wähle deine Server aus (Rechtsklick)");
        }

        lore.add("");
        lore.add("");

        compassmeta.setLore(lore);

        compass.setItemMeta(compassmeta);



        return compass;

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
