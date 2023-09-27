package me.adrian.smasher.Utility;

import me.adrian.smasher.Smasher;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Respawner {

    public static String lastonestanding = "Niemand";

    public static void SetPlayerKits(){

        for (Player playerkitter: Bukkit.getOnlinePlayers()){
            if (!Smasher.playerkit.containsKey(playerkitter.getUniqueId())){
                playerkitter.getInventory().setItem(0, ItemGetter.KnockbackStick());
                ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta itemMeta = boot.getItemMeta();
                itemMeta.setUnbreakable(true);
                boot.setItemMeta(itemMeta);
                playerkitter.getInventory().setBoots(boot);


                ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta itemMeta1 = chestplate.getItemMeta();
                itemMeta1.setUnbreakable(true);
                chestplate.setItemMeta(itemMeta1);
                playerkitter.getInventory().setChestplate(chestplate);


                ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta itemMeta2 = helm.getItemMeta();
                itemMeta2.setUnbreakable(true);
                helm.setItemMeta(itemMeta2);
                playerkitter.getInventory().setHelmet(helm);
            }
            else {
                String s = Smasher.playerkit.get(playerkitter.getUniqueId());
                if (s.contains("spammer")){
                    playerkitter.getInventory().clear();
                    ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                    ItemMeta itemMeta2 = helm.getItemMeta();
                    itemMeta2.setUnbreakable(true);
                    helm.setItemMeta(itemMeta2);
                    ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                    ItemMeta itemMeta = boot.getItemMeta();
                    itemMeta.setUnbreakable(true);
                    boot.setItemMeta(itemMeta);
                    playerkitter.getInventory().setBoots(boot);

                    ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                    ItemMeta itemMeta1 = chestplate.getItemMeta();
                    itemMeta1.setUnbreakable(true);
                    chestplate.setItemMeta(itemMeta1);
                    playerkitter.getInventory().setChestplate(chestplate);

                    playerkitter.getInventory().setHelmet(helm);
                    playerkitter.getInventory().setItem(0, ItemGetter.Bow());
                    playerkitter.getInventory().setItem(9, new ItemStack(Material.ARROW));
                }
                if (s.contains("assasine")){
                    playerkitter.getInventory().clear();
                    ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                    ItemMeta itemMeta2 = helm.getItemMeta();
                    itemMeta2.setUnbreakable(true);
                    helm.setItemMeta(itemMeta2);
                    ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                    ItemMeta itemMeta = boot.getItemMeta();
                    itemMeta.setUnbreakable(true);
                    boot.setItemMeta(itemMeta);
                    playerkitter.getInventory().setBoots(boot);

                    playerkitter.getInventory().setHelmet(helm);
                    playerkitter.getInventory().setItem(0, ItemGetter.Assasine());
                }
                if (s.contains("axe")){
                    playerkitter.getInventory().clear();
                    playerkitter.getInventory().setItem(0, ItemGetter.axeKit());
                }
                if (s.contains("knockering")){
                    playerkitter.getInventory().clear();
                    playerkitter.getInventory().setItem(0, ItemGetter.KnockbackStick());
                    ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                    ItemMeta itemMeta = boot.getItemMeta();
                    itemMeta.setUnbreakable(true);
                    boot.setItemMeta(itemMeta);
                    playerkitter.getInventory().setBoots(boot);


                    ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
                    ItemMeta itemMeta1 = chestplate.getItemMeta();
                    itemMeta1.setUnbreakable(true);
                    chestplate.setItemMeta(itemMeta1);
                    playerkitter.getInventory().setChestplate(chestplate);


                    ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                    ItemMeta itemMeta2 = helm.getItemMeta();
                    itemMeta2.setUnbreakable(true);
                    helm.setItemMeta(itemMeta2);
                    playerkitter.getInventory().setHelmet(helm);
                }
                if (s.contains("tank")){
                    playerkitter.setMaxHealth(10);
                    playerkitter.setHealth(10);
                    playerkitter.getInventory().setItem(0, ItemGetter.TankStick());
                    ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
                    ItemMeta itemMeta = boot.getItemMeta();
                    itemMeta.setUnbreakable(true);
                    boot.setItemMeta(itemMeta);
                    playerkitter.getInventory().setBoots(boot);


                    ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
                    ItemMeta itemMeta1 = chestplate.getItemMeta();
                    itemMeta1.setUnbreakable(true);
                    chestplate.setItemMeta(itemMeta1);
                    playerkitter.getInventory().setChestplate(chestplate);


                    ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
                    ItemMeta itemMeta2 = helm.getItemMeta();
                    itemMeta2.setUnbreakable(true);
                    helm.setItemMeta(itemMeta2);
                    playerkitter.getInventory().setHelmet(helm);

                    ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
                    ItemMeta itemMeta3 = leggings.getItemMeta();
                    itemMeta3.setUnbreakable(true);
                    leggings.setItemMeta(itemMeta3);
                    playerkitter.getInventory().setLeggings(leggings);
                }
            }
        }

    }

    public static void TeleportAsynch(Player player){
        FileConfiguration config = Smasher.main.getConfig();
        if (config.equals(null))
            return;


        Integer inte = Smasher.randomGenerator(1, 8);
        Double x = config.getDouble("location" + inte + ".x");
        Double y = config.getDouble("location" + inte + ".y");
        Double z = config.getDouble("location" + inte + ".z");
        Float yaw = (float) config.getDouble("location" + inte + ".yaw");
        Float pitch = (float) config.getDouble("location" + inte + ".pitch");

        Location location = new Location(Bukkit.getWorld("world"), x, y, z ,yaw, pitch);
        player.teleportAsync(location);

    }


    public static void Teleport(Player player){

        FileConfiguration config = Smasher.main.getConfig();
        if (config.equals(null))
            return;


        Integer inte = Smasher.randomGenerator(1, 8);
        Double x = config.getDouble("location" + inte + ".x");
        Double y = config.getDouble("location" + inte + ".y");
        Double z = config.getDouble("location" + inte + ".z");
        Float yaw = (float) config.getDouble("location" + inte + ".yaw");
        Float pitch = (float) config.getDouble("location" + inte + ".pitch");

        Location location = new Location(Bukkit.getWorld("world"), x, y, z ,yaw, pitch);
        player.teleport(location);


    }

    public static void RemoveLife(Player player){
        if (Smasher.lives.containsKey(player.getUniqueId())){
            Integer integer = Smasher.lives.get(player.getUniqueId());
            Integer livesafter = integer -1;
            Smasher.lives.put(player.getUniqueId(), livesafter);

            if (livesafter.equals(0)){
                if (!Smasher.deathPlayers.contains(player.getUniqueId())){
                    Smasher.deathPlayers.add(player.getUniqueId());
                }
                player.setGameMode(GameMode.SPECTATOR);
                Smasher.playersalive --;
            }





            if (Smasher.playersalive < 2){
                EndRound.SayLobbyEndRound();

                for (Player p: Bukkit.getOnlinePlayers()){
                    p.setGameMode(GameMode.SPECTATOR);
                }

                for (Player p: Bukkit.getOnlinePlayers()){
                    if (!Smasher.deathPlayers.contains(p.getUniqueId())){
                        lastonestanding = p.getName();
                    }
                }



                for (Player p: Bukkit.getOnlinePlayers()){
                    if (Smasher.playerlanguage.containsKey(p.getUniqueId())){
                        if (Smasher.playerlanguage.get(p.getUniqueId()).equals("de")){
                            p.sendMessage(ChatColor.GOLD + lastonestanding + " hat diese Runde smasher gewonnen!");
                            Sender.CreateTitle(p, ChatColor.GOLD+lastonestanding,ChatColor.GREEN +  "hat gewonnen!", 20, 60, 20);
                        }
                        else if (Smasher.playerlanguage.get(p.getUniqueId()).equals("en")){
                            p.sendMessage(ChatColor.GOLD + lastonestanding + " has won this round of smasher!");
                            Sender.CreateTitle(p, ChatColor.GOLD+lastonestanding, ChatColor.GREEN + "has won!", 20, 60, 20);}
                    }
                    else{
                        p.sendMessage(ChatColor.GOLD + lastonestanding + " hat diese Runde smasher gewonnen!");
                        Sender.CreateTitle(p, ChatColor.GOLD+lastonestanding, ChatColor.GREEN + "hat gewonnen!", 20, 60, 20);
                    }
                }


                Bukkit.getScheduler().scheduleSyncDelayedTask(Smasher.main, new Runnable() {
                    @Override
                    public void run() {
                        EndRound.endRound(player);
                    }
                }, 100);


            }
            else if (livesafter < 1){
                for (Player p: Bukkit.getOnlinePlayers()){
                    if (Smasher.playerlanguage.containsKey(p.getUniqueId())){
                        if (Smasher.playerlanguage.get(p.getUniqueId()).equals("de")){
                            p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " ist gestorben und hat keine Leben mehr!");
                        }
                        else if (Smasher.playerlanguage.get(p.getUniqueId()).equals("en")){
                            p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " died and has no more lives!");                                }
                    }
                    else{
                        p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " ist gestorben und hat keine Leben mehr!");                            }
                }
            }



            if (livesafter > 0){
                for (Player p: Bukkit.getOnlinePlayers()){
                    if (Smasher.playerlanguage.containsKey(p.getUniqueId())){
                        if (Smasher.playerlanguage.get(p.getUniqueId()).equals("de")){
                            p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " ist gestorben und hat noch " + ChatColor.GOLD + livesafter + ChatColor.GREEN + " Leben!");
                        }
                        else if (Smasher.playerlanguage.get(p.getUniqueId()).equals("en")){
                            p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " died and has " + ChatColor.GOLD + livesafter + ChatColor.GREEN + " lives left!");
                        }
                    }
                    else{
                        p.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " ist gestorben und hat noch " + ChatColor.GOLD + livesafter + ChatColor.GREEN + " Leben!");
                    }
                }
            }





        }

    }


}
