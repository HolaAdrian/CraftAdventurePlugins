package me.adrian.smasher.Utility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemGetter {

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
        ksm.addEnchant(Enchantment.KNOCKBACK, 3, true);

        ks.setItemMeta(ksm);

        return ks;

    }


}
