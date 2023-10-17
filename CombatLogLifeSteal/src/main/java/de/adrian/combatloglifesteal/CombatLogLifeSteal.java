package de.adrian.combatloglifesteal;

import de.adrian.combatloglifesteal.Utils.Importer;
import de.adrian.combatloglifesteal.Utils.Runnabels;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class CombatLogLifeSteal extends JavaPlugin {

    public static HashMap<UUID, Integer> cooldown = new HashMap<>();

    public static CombatLogLifeSteal main;

    @Override
    public void onEnable() {
        main = this;
        if (!getConfig().isSet("created")){
            saveDefaultConfig();
        }
        Importer.ImportAll(Bukkit.getPluginManager(), this);

        Runnabels.StartRunnable();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
