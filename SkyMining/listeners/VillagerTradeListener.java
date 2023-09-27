package me.adrian.skymining.listeners;

import io.papermc.paper.event.player.PlayerTradeEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.event.entity.VillagerReplenishTradeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class VillagerTradeListener implements Listener {




    @EventHandler
    public void onPlayerTrade(PlayerTradeEvent event) {
        event.getTrade().setUses(0);
    }



}
