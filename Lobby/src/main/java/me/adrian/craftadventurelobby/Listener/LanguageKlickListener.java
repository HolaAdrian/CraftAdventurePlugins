package me.adrian.craftadventurelobby.Listener;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.adrian.craftadventurelobby.Lobby;
import me.adrian.craftadventurelobby.Utility.ItemGetter;
import me.adrian.craftadventurelobby.Utility.Sayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class LanguageKlickListener implements Listener {

    private static Integer SCHEDU;

    private static Integer times = 0;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if (event.getCurrentItem() != null){
            if (event.getCurrentItem().getItemMeta() != null) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Deutsch")) {
                    if (event.getWhoClicked() instanceof Player) {

                        Player player = (Player) event.getWhoClicked();


                        ByteArrayDataOutput out = ByteStreams.newDataOutput();
                        out.writeUTF("SavePlayerLanguage");
                        out.writeUTF(player.getUniqueId().toString());
                        out.writeUTF("de");

                        player.sendPluginMessage(Lobby.main, "bungeecord:language", out.toByteArray());
                        event.setCancelled(true);


                        player.closeInventory();

                        player.sendMessage(ChatColor.GREEN + "Deine Sprache wurde auf Deutsch gestellt.");

                        Lobby.playerlanguage.put(player.getUniqueId(), "de");

                        Lobby.playerlanguage.put(player.getUniqueId(), "de");

                        SCHEDU = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.main, new Runnable() {
                            @Override
                            public void run() {
                                times ++;
                                if (times>1){
                                    player.getInventory().setItem(2, ItemGetter.Compass(player));
                                    Bukkit.getScheduler().cancelTask(SCHEDU);
                                }
                            }
                        }, 0, 10);




                    }
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "English")) {
                    if (event.getWhoClicked() instanceof Player) {
                        Player player = (Player) event.getWhoClicked();

                        ByteArrayDataOutput out = ByteStreams.newDataOutput();
                        out.writeUTF("SavePlayerLanguage");
                        out.writeUTF(player.getUniqueId().toString());
                        out.writeUTF("en");

                        player.sendPluginMessage(Lobby.main, "bungeecord:language", out.toByteArray());
                        event.setCancelled(true);

                        Lobby.playerlanguage.put(player.getUniqueId(), "en");
                        Lobby.playerlanguage.put(player.getUniqueId(), "en");

                        player.closeInventory();
                        player.sendMessage(net.md_5.bungee.api.ChatColor.GREEN + "Your language is now english");


                        SCHEDU = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.main, new Runnable() {
                            @Override
                            public void run() {
                                times ++;
                                if (times>1){
                                    player.getInventory().setItem(2, ItemGetter.Compass(player));
                                    Bukkit.getScheduler().cancelTask(SCHEDU);
                                }
                            }
                        }, 0, 10);

                        for (ItemStack itemStack : player.getInventory()) {
                            if (itemStack.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Serverselector")){
                                int first = player.getInventory().first(itemStack);
                                player.getInventory().setItem(first, ItemGetter.Compass(player));
                            }
                        }




                    }
                }
            }
        }

    }

}
