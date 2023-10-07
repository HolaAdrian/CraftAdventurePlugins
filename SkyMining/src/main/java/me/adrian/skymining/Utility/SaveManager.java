package me.adrian.skymining.Utility;

import me.adrian.skymining.SkyMining;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.UUID;

public class SaveManager {

    public static void SaveAll(FileConfiguration config){



        for (UUID p: SkyMining.haste.keySet()){
            config.set("haste." + p, SkyMining.haste.get(p));

        }

        config.set("new", true);

        for (UUID p: SkyMining.pvpon.keySet()){
            config.set("pvp." + p, SkyMining.pvpon.get(p));
        }

        SkyMining.main.saveConfig();

    }

    public static void LoadAll(FileConfiguration config){
        if (config.getConfigurationSection("haste") != null){
            for (String p: config.getConfigurationSection("haste").getKeys(false)){
                UUID UUIDp = UUID.fromString(p);
                Integer haste = config.getInt("haste." + p);
                SkyMining.haste.put(UUIDp, haste);
            }



        }
        if (config.getConfigurationSection("pvp") != null){
            for (String p: config.getConfigurationSection("pvp").getKeys(false)){
                UUID UUIDp = UUID.fromString(p);
                Boolean pvp = config.getBoolean("pvp." + p);
                SkyMining.pvpon.put(UUIDp, pvp);
            }



        }

    }



}
