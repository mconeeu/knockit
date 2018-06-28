/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.util;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreObjective;
import eu.mcone.coresystem.api.core.gamemode.Gamemode;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Team;

public class Objective extends CoreObjective {

    public Objective() {
        super(DisplaySlot.SIDEBAR, "Main", "KnockIT");
    }

    @Override
    public void register() {
        objective.setDisplayName(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.1"));

        if (scoreboard.getTeam("kills") != null) scoreboard.getTeam("kills").unregister();
        if (scoreboard.getTeam("deaths") != null) scoreboard.getTeam("deaths").unregister();
        if (scoreboard.getTeam("coins") != null) scoreboard.getTeam("coins").unregister();

        Team kills = scoreboard.registerNewTeam("kills");
        kills.addEntry("§1");
        kills.setPrefix(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.3") + KnockIT.getInstance().getStatsAPI().getKills(player.getUuid()));

        Team deaths = scoreboard.registerNewTeam("deaths");
        deaths.addEntry("§3");
        deaths.setPrefix(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.5") + KnockIT.getInstance().getStatsAPI().getDeaths(player.getUuid()));

        Team coins = scoreboard.registerNewTeam("coins");
        coins.addEntry("§5");
        coins.setPrefix(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.7")+ CoreSystem.getInstance().getCoinsAPI().getCoins(player.getUuid()));

        objective.getScore("§0").setScore(10);
        objective.getScore(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.2")).setScore(9);
        objective.getScore("§1").setScore(8);
        objective.getScore("§2§r").setScore(7);
        objective.getScore(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.4")).setScore(6);
        objective.getScore("§3").setScore(5);
        objective.getScore("§4").setScore(4);
        objective.getScore(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.6")).setScore(3);
        objective.getScore("§5").setScore(2);
        objective.getScore("§6").setScore(1);
        objective.getScore(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.8")).setScore(0);

        player.bukkit().setScoreboard(scoreboard);
    }

    @Override
    public void reload() {
        objective.setDisplayName(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.1"));

        scoreboard.getTeam("kills").setPrefix(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.3") + KnockIT.getInstance().getStatsAPI().getKills(player.getUuid()));
        scoreboard.getTeam("deaths").setPrefix(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.5") + KnockIT.getInstance().getStatsAPI().getDeaths(player.getUuid()));
        scoreboard.getTeam("coins").setPrefix(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.7") + CoreSystem.getInstance().getCoinsAPI().getCoins(player.getUuid()));

        player.bukkit().setScoreboard(scoreboard);
    }

}
