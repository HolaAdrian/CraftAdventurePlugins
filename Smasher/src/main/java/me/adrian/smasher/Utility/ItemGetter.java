package me.adrian.smasher.Utility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemGetter {


    public static ItemStack Assasine(){

        ItemStack ks = new ItemStack(Material.STONE_SWORD);
        ItemMeta ksm = ks.getItemMeta();


        ksm.setDisplayName(ChatColor.RED + "Assasine Sword");
        ksm.setUnbreakable(true);

        ks.setItemMeta(ksm);

        return ks;

    }
    public static ItemStack axeKit(){
        ItemStack bw = new ItemStack(Material.WOODEN_AXE);
        ItemMeta bwm = bw.getItemMeta();

        bwm.setDisplayName(ChatColor.DARK_BLUE + "Axe Kit");
        bwm.setUnbreakable(true);


        bw.setItemMeta(bwm);

        return bw;

    }
    public static ItemStack Bow(){

        ItemStack bw = new ItemStack(Material.BOW);
        ItemMeta bwm = bw.getItemMeta();

        bwm.setDisplayName(ChatColor.GOLD + "Spammer-Bow");
        bwm.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
        bwm.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bwm.setUnbreakable(true);


        bw.setItemMeta(bwm);

        return bw;

    }

    public static ItemStack KnockbackStick(){

        ItemStack ks = new ItemStack(Material.STICK);
        ItemMeta ksm = ks.getItemMeta();
        ksm.setUnbreakable(true);


        ksm.setDisplayName(ChatColor.DARK_PURPLE + "Knockback Stick");
        ksm.addEnchant(Enchantment.KNOCKBACK, 2, true);

        ks.setItemMeta(ksm);

        return ks;

    }
    public static ItemStack TankStick(){

        ItemStack ks = new ItemStack(Material.STICK);
        ItemMeta ksm = ks.getItemMeta();
        ksm.setUnbreakable(true);


        ksm.setDisplayName(ChatColor.DARK_PURPLE + "Tank Stick");
        ksm.addEnchant(Enchantment.KNOCKBACK, 4, true);

        ks.setItemMeta(ksm);

        return ks;

    }


}
