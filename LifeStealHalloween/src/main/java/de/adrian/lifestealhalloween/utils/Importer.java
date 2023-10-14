package de.adrian.lifestealhalloween.utils;

import de.adrian.lifestealhalloween.LifeStealHalloween;
import de.adrian.lifestealhalloween.commands.ConfigCommand;
import de.adrian.lifestealhalloween.commands.LobbyCommand;
import de.adrian.lifestealhalloween.commands.SetLivesCommand;
import de.adrian.lifestealhalloween.commands.WithdrawCommand;
import de.adrian.lifestealhalloween.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;

public class Importer {


    public static void LoadAll(LifeStealHalloween main, PluginManager pluginManager){
        LoadConfig(main);
        LoadListeners(pluginManager, main);
        LoadPluginMessages(main);
        LoadCommand(main);
        ImportPermission(pluginManager);
        ImportRecipes();
    }

    public static void LoadConfig(LifeStealHalloween main){

        if (!main.getConfig().isSet("created")){
            main.saveDefaultConfig();
        }
        else {
            SafeManager.LoadAll(main.getConfig());
        }


    }

    public static void LoadListeners(PluginManager pluginManager, LifeStealHalloween main){
        pluginManager.registerEvents(new PlayerDeathListener(), main);
        pluginManager.registerEvents(new RespawnListener(), main);
        pluginManager.registerEvents(new ConnectionListener(), main);
        pluginManager.registerEvents(new LanguageCLickListener(), main);
        pluginManager.registerEvents(new BreakPlaceListener(), main);
        pluginManager.registerEvents(new HeartLitstener(), main);
    }

    private static void LoadPluginMessages(LifeStealHalloween main){
        main.getServer().getMessenger().registerOutgoingPluginChannel(main, "bungeecord:language");
        main.getServer().getMessenger().registerIncomingPluginChannel(main, "bungeecord:language",new PluginMessageListener());
        main.getServer().getMessenger().registerOutgoingPluginChannel(main, "BungeeCord");

    }
    private static void LoadCommand(LifeStealHalloween main){
        main.getCommand("setlives").setExecutor(new SetLivesCommand());
        main.getCommand("config").setExecutor(new ConfigCommand());
        main.getCommand("withdraw").setExecutor(new WithdrawCommand());
        main.getCommand("lobby").setExecutor(new LobbyCommand());
    }

    private static void ImportPermission(PluginManager pluginManager){
        pluginManager.addPermission(new Permission("lifesteal.unban"));
        pluginManager.addPermission(new Permission("lifesteal.setlives"));
        pluginManager.addPermission(new Permission("lifesteal.config"));
    }

    private static void ImportRecipes(){
        ItemStack heart = ItemGetter.Heart(1);
        ShapedRecipe heartrecipe = new ShapedRecipe(heart);
        heartrecipe.shape("NGN","DID", "NGN");
        heartrecipe.setIngredient('G', Material.GOLD_BLOCK);
        heartrecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        heartrecipe.setIngredient('I', Material.NETHERITE_INGOT);
        Bukkit.addRecipe(heartrecipe);
    }





}
