package me.adrian.smasher.Utility;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.adrian.smasher.Listener.ConnectionListener;
import me.adrian.smasher.Listener.PlayerDeathListener;
import me.adrian.smasher.Smasher;
import me.adrian.smasher.commands.LobbyCommand;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;

public class EndRound {

    public static void endRound(Player player){

        for (Player p: Bukkit.getOnlinePlayers()){







            Smasher.sendServer(p, "lobby");

            p.setGameMode(GameMode.SURVIVAL);
        }

        Smasher.lives.clear();
        Smasher.playingPlayers.clear();
        PlayerDeathListener.lastonestanding = "Niemand";
        LobbyCommand.lastonestanding = "Niemand";
        ConnectionListener.lastonestanding = "Niemand";
        Smasher.playersalive = 0;


        return;
    }

}
