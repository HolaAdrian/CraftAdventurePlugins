package de.adrian.combatloglifesteal.Listener;

import de.adrian.combatloglifesteal.CombatLogLifeSteal;
import de.adrian.combatloglifesteal.Utils.Creator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.util.ArrayList;

public class PlayerQuitKillListener implements Listener {


        public static ItemStack Heart(){
            ItemStack b = new ItemStack(Material.PLAYER_HEAD, 1);
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



    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (CombatLogLifeSteal.cooldown.containsKey(player.getUniqueId())){
            if (CombatLogLifeSteal.cooldown.get(player.getUniqueId()) > 0){
                player.setHealth(0);
                Bukkit.broadcastMessage(ChatColor.RED + player.getName() + " Combat logged!");
                player.getWorld().dropItem(player.getLocation(), Heart());
            }
        }
    }
}
