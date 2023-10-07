package de.adrian.lifestealhalloween.commands;

import de.adrian.lifestealhalloween.LifeStealHalloween;
import de.adrian.lifestealhalloween.utils.Datas;
import de.adrian.lifestealhalloween.utils.ItemGetter;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class WithdrawCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage(ChatColor.RED + "You have to be a player to run this command!");
            return false;
        }

        Player player = (Player) commandSender;
        Double maxhearts;
        if (Datas.playerhearts.containsKey(player.getUniqueId())){
            maxhearts  = Datas.playerhearts.get(player.getUniqueId());
        }
        else {
            maxhearts = player.getMaxHealth();
        }
        if (maxhearts != null){
            if (!(strings.length == 1)){
                player.sendMessage(ChatColor.RED + "Syntax: /withdraw <amount (full)>");
                return false;
            }
            else {
                if (Double.valueOf(strings[0]) != null){
                    Double amount = Double.valueOf(strings[0]) * 2;
                    if (!(amount > maxhearts) && !amount.equals(maxhearts)){
                        Integer itemamount = Integer.valueOf(strings[0]);
                        ItemStack heart = ItemGetter.Heart(itemamount);
                        player.getInventory().addItem(heart);
                        player.setMaxHealth(maxhearts - amount);
                        Datas.playerhearts.put(player.getUniqueId(), maxhearts - amount);
                    }
                    else {
                        if (LifeStealHalloween.playerlanguage.containsKey(player.getUniqueId())){
                            if (LifeStealHalloween.playerlanguage.get(player.getUniqueId()).equalsIgnoreCase("de")){
                                player.sendMessage(ChatColor.RED + "Du kannst nicht mehr leben nehmen als du hast!");
                            }
                            if (LifeStealHalloween.playerlanguage.get(player.getUniqueId()).equalsIgnoreCase("en")){
                                player.sendMessage(ChatColor.RED + "You can't withdraw more hearts then you have!");
                            }
                        }
                        else {
                            player.sendMessage(ChatColor.RED + "Du kannst nicht mehr leben nehmen als du hast!");
                        }

                        return false;
                    }
                }
                else {
                    if (LifeStealHalloween.playerlanguage.containsKey(player.getUniqueId())){
                        if (LifeStealHalloween.playerlanguage.get(player.getUniqueId()).equalsIgnoreCase("de")){
                            player.sendMessage(ChatColor.GOLD +strings[0] + ChatColor.RED + " ist keine Zahl");
                        }
                        if (LifeStealHalloween.playerlanguage.get(player.getUniqueId()).equalsIgnoreCase("en")){
                            player.sendMessage(ChatColor.GOLD +strings[0] + ChatColor.RED + " is not an number");
                        }
                    }
                    else {
                        player.sendMessage(ChatColor.GOLD +strings[0] + ChatColor.RED + " ist keine Zahl");
                    }

                    return false;
                }
                }



            }






        return false;
    }
}
