package me.adrian.craftadventurelobby.Listener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import me.adrian.craftadventurelobby.Lobby;
import me.adrian.craftadventurelobby.Utility.StattMatchmaking;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayInputStream;

public class BetweenListener implements PluginMessageListener {
    @Override
    public void onPluginMessageReceived(@NotNull String s, @NotNull Player player, @NotNull byte[] bytes) {
        ByteArrayDataInput in = ByteStreams.newDataInput(bytes);
        String message = in.readUTF();
        if (message.equals("resume")){
            Lobby.smasherrunning = false;
            StattMatchmaking.StartMatchmaking();

        }
        else {
            System.out.println("I got an undhandable Plugin message! Please contact an admin");
        }
    }
}
