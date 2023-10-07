package de.adrian.lifestealhalloween.utils;

import de.adrian.lifestealhalloween.LifeStealHalloween;
import org.bukkit.configuration.file.FileConfiguration;

import java.time.LocalDateTime;
import java.util.UUID;

public class SafeManager {

    public static void SafeAll(FileConfiguration config){
        for (UUID p: Datas.playerhearts.keySet()){
            config.set("hearts." + p, Datas.playerhearts.get(p));

        }
        config.set("created", true);

        LifeStealHalloween.main.saveConfig();


    }

    public static void LoadAll(FileConfiguration config){

        if (config.getConfigurationSection("hearts") != null){
            for (String p: config.getConfigurationSection("hearts").getKeys(false)){
                UUID UUIDp = UUID.fromString(p);
                Double hearts = config.getDouble("hearts." + p);
                Datas.playerhearts.put(UUIDp, hearts);
            }



        }


    }



}
