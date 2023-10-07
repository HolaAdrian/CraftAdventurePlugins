package me.adrian.serveradrianbungee.Utility;

import me.adrian.serveradrianbungee.ServerAdrianBungee;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Cooldowner {

    public static void StartJoinmeeCooldowner(){

        ServerAdrianBungee.task = ServerAdrianBungee.main.getProxy().getScheduler().schedule(ServerAdrianBungee.main, new Runnable() {
            @Override
            public void run() {
                for (UUID uuid : ServerAdrianBungee.joinmecooldown.keySet()) {
                    Integer i = ServerAdrianBungee.joinmecooldown.get(uuid);
                    if (i > 0){
                        Integer newi = i - 1;
                        ServerAdrianBungee.joinmecooldown.put(uuid, newi);
                    }
                }
            }
        }, 0, 1, TimeUnit.SECONDS);


    }

}
