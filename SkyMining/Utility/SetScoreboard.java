package me.adrian.skymining.Utility;

import me.adrian.skymining.SkyMining;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class SetScoreboard {
        static Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        public static Objective objective = scoreboard.registerNewObjective("name", "name");


        public static void setScoreboard(Player player){
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            objective.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Craftadventure.de");
            objective.getScore(ChatColor.BLACK + "").setScore(6);
            objective.getScore(ChatColor.LIGHT_PURPLE + "Gamemode: Sky Mining").setScore(5);

            objective.getScore(ChatColor.LIGHT_PURPLE + "").setScore(4);
            objective.getScore(ChatColor.WHITE + "").setScore(2);
            objective.getScore(ChatColor.AQUA + "discord.craftadventure.de").setScore(1);

            player.setScoreboard(scoreboard);







            int old = Bukkit.getOnlinePlayers().size() -1;
            player.getScoreboard().resetScores(ChatColor.BLUE + "Online Spieler: " + old);
            for (Objective o: player.getScoreboard().getObjectives()){
                o.getScore(ChatColor.BLUE + "Online Spieler: " + Bukkit.getOnlinePlayers().size()).setScore(3);
            }


    }

}
