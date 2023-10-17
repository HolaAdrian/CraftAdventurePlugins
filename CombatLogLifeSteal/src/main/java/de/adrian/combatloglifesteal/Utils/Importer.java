package de.adrian.combatloglifesteal.Utils;

import de.adrian.combatloglifesteal.CombatLogLifeSteal;
import de.adrian.combatloglifesteal.Listener.PlayHitByPlayerListener;
import de.adrian.combatloglifesteal.Listener.PlayerDeathListener;
import de.adrian.combatloglifesteal.Listener.PlayerQuitKillListener;
import org.bukkit.plugin.PluginManager;

public class Importer {


    public static void ImportAll(PluginManager pluginManager, CombatLogLifeSteal main){
        ImportListener(pluginManager, main);
    }
    private static void ImportListener(PluginManager pluginManager, CombatLogLifeSteal main){
        pluginManager.registerEvents(new PlayHitByPlayerListener(), main);
        pluginManager.registerEvents(new PlayerQuitKillListener(), main);
        pluginManager.registerEvents(new PlayerDeathListener(), main);
    }

}
