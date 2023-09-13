package me.adrian.smasher.Listener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import me.adrian.smasher.Smasher;
import me.adrian.smasher.Utility.ItemGetter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class PluginMessageListener implements org.bukkit.plugin.messaging.PluginMessageListener {
    @Override
    public void onPluginMessageReceived(@NotNull String s, @NotNull Player player, @NotNull byte[] bytes) {

        if (s.equals("bungeecord:kit")){
            ByteArrayDataInput in = ByteStreams.newDataInput(bytes);
            String subchannel = in.readUTF();
            if (subchannel.equals("SetPlayerKit")){
                UUID PLayerUUID = UUID.fromString(in.readUTF());
                if (Bukkit.getPlayer(PLayerUUID) != null){
                    Player playerkitter = Bukkit.getPlayer(PLayerUUID);
                    String kit = in.readUTF();
                    String lowerCase = kit.toLowerCase();


                    if (kit.startsWith("knockering")|| kit.endsWith("knockering")){
                        playerkitter.getInventory().setItem(1, ItemGetter.KnockbackStick());
                        playerkitter.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                        playerkitter.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                        playerkitter.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
                    }

                    if (lowerCase.contains("spammer")){
                        playerkitter.getInventory().setItem(1, ItemGetter.Bow());
                        playerkitter.getInventory().setItem(9, new ItemStack(Material.ARROW));
                    }
                    else {
                        playerkitter.getInventory().setItem(1, ItemGetter.KnockbackStick());
                        playerkitter.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                        playerkitter.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                        playerkitter.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
                    }



                }
                else {
                    System.out.println("nuller");
                    System.out.println(player);
                }

            }
        }

        if (s.equals("bungeecord:language")){
            ByteArrayDataInput in = ByteStreams.newDataInput(bytes);
            String subchannel = in.readUTF();

            if (subchannel.equals("ShowInventory")){
                UUID PLayerUUID = UUID.fromString(in.readUTF());

                if (Bukkit.getPlayer(PLayerUUID) != null){
                    Player player1 = Bukkit.getPlayer(PLayerUUID);

                    if (Smasher.playerlanguage.containsKey(player.getUniqueId())){
                        if (Smasher.playerlanguage.get(player.getUniqueId()).equals("de")){
                            player.sendMessage(ChatColor.GREEN + "Du darfst deine Sprache nicht ändern während du in einer Runde bist!");
                        }
                        else if (Smasher.playerlanguage.get(player.getUniqueId()).equals("en")){
                            player.sendMessage(ChatColor.GREEN + "You can't change your language while being ingame");
                        }
                    }
                    else{
                        player.sendMessage(ChatColor.GREEN + "Du darfst deine Sprache nicht ändern während du in einer Runde bist!");
                    }


                }

            }
            else if (subchannel.equals("SendPlayerLanguage")){
                UUID PLayerUUID = UUID.fromString(in.readUTF());
                if (Bukkit.getPlayer(PLayerUUID) != null){
                    Player player1 = Bukkit.getPlayer(PLayerUUID);
                    Smasher.playerlanguage.put(player1.getUniqueId(), in.readUTF());
                }
            }
        }
    }
}
