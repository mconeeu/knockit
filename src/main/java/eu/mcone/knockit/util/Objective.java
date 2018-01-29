package eu.mcone.knockit.util;

import eu.mcone.bukkitcoresystem.api.CoinsAPI;
import eu.mcone.bukkitcoresystem.player.CorePlayer;
import eu.mcone.knockit.KnockIT;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Team;

import static eu.mcone.bukkitcoresystem.CoreSystem.statsKnockit;
import static eu.mcone.bukkitcoresystem.CoreSystem.statsSkypvp;

public class Objective extends eu.mcone.bukkitcoresystem.scoreboard.Objective {

    public Objective(CorePlayer p) {
        super(p, DisplaySlot.SIDEBAR, "Main", "KnockIT");
    }

    @Override
    public void register() {
        objective.setDisplayName(KnockIT.config.getConfigValue("ScoreBoard-1"));

        if (scoreboard.getTeam("kills") != null) scoreboard.getTeam("kills").unregister();
        if (scoreboard.getTeam("deaths") != null) scoreboard.getTeam("deaths").unregister();
        if (scoreboard.getTeam("coins") != null) scoreboard.getTeam("coins").unregister();

        Team kills = scoreboard.registerNewTeam("kills");
        kills.addEntry("§1");
        kills.setPrefix(KnockIT.config.getConfigValue("ScoreBoard-3") + statsKnockit.getKills(player.getUuid()));

        Team deaths = scoreboard.registerNewTeam("deaths");
        deaths.addEntry("§3");
        deaths.setPrefix(KnockIT.config.getConfigValue("ScoreBoard-5") + statsKnockit.getDeaths(player.getUuid()));

        Team coins = scoreboard.registerNewTeam("coins");
        coins.addEntry("§5");
        coins.setPrefix(KnockIT.config.getConfigValue("ScoreBoard-7")+ CoinsAPI.getCoins(player.getUuid()));

        objective.getScore("§0").setScore(10);
        objective.getScore(KnockIT.config.getConfigValue("ScoreBoard-2")).setScore(9);
        objective.getScore("§1").setScore(8);
        objective.getScore("§2§r").setScore(7);
        objective.getScore(KnockIT.config.getConfigValue("ScoreBoard-4")).setScore(6);
        objective.getScore("§3").setScore(5);
        objective.getScore("§4").setScore(4);
        objective.getScore(KnockIT.config.getConfigValue("ScoreBoard-6")).setScore(3);
        objective.getScore("§5").setScore(2);
        objective.getScore("§6").setScore(1);
        objective.getScore(KnockIT.config.getConfigValue("ScoreBoard-8")).setScore(0);

        player.bukkit().setScoreboard(scoreboard);
    }

    @Override
    public void reload() {
        objective.setDisplayName(KnockIT.config.getLiveConfigValue("ScoreBoard-1"));

        scoreboard.getTeam("kills").setPrefix(KnockIT.config.getConfigValue("ScoreBoard-3") + statsSkypvp.getKills(player.getUuid()));
        scoreboard.getTeam("deaths").setPrefix(KnockIT.config.getConfigValue("ScoreBoard-5") + statsSkypvp.getDeaths(player.getUuid()));
        scoreboard.getTeam("coins").setPrefix(KnockIT.config.getConfigValue("ScoreBoard-7") + CoinsAPI.getCoins(player.getUuid()));

        player.bukkit().setScoreboard(scoreboard);
    }

}
