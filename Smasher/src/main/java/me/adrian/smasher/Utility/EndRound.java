package me.adrian.smasher.Utility;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.adrian.smasher.Listener.ConnectionListener;
import me.adrian.smasher.Listener.PlayerDeathListener;
import me.adrian.smasher.Listener.PlayerMoveListener;
import me.adrian.smasher.Smasher;
import me.adrian.smasher.commands.LobbyCommand;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;

public class EndRound {

    public static void SayLobbyEndRound(){
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("resume");
        Smasher.main.getServer().sendPluginMessage(Smasher.main, "between:smasherlobby", out.toByteArray());
    }

    public static void endRound(Player player){

        for (Player p: Bukkit.getOnlinePlayers()){
            Smasher.sendServer(p, "lobby");

            p.setGameMode(GameMode.SURVIVAL);
            p.setMaxHealth(20);
            p.setHealth(10);
        }

        Smasher.lives.clear();
        Smasher.playingPlayers.clear();
        PlayerMoveListener.lastonestanding = "Niemand";
        LobbyCommand.lastonestanding = "Niemand";
        ConnectionListener.lastonestanding = "Niemand";
        Respawner.lastonestanding = "Niemand";
        Smasher.playersalive = 0;
        Smasher.deathPlayers.clear();

        for (Player p: Bukkit.getOnlinePlayers()){



            if (Smasher.playerlanguage.containsKey(p.getUniqueId())) {
                if (Smasher.playerlanguage.get(p.getUniqueId()).equals("de")) {
                    p.kickPlayer("Die Lobby konnte nicht verbunden werden! Sie ist wahrscheinlich offline oder in Wartungsarbeiten!");
                } else if (Smasher.playerlanguage.get(p.getUniqueId()).equals("en")) {
                    p.kickPlayer("The Lobby couldn't be reached! It most likely is offline or under maintenance!");
                }
            } else {
                p.kickPlayer("Die Lobby konnte nicht verbunden werden! Sie ist wahrscheinlich offline oder in Wartungsarbeiten!");
            }




        }

        }

}
