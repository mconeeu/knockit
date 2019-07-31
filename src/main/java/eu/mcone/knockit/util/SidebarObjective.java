/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.util;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.gamemode.Gamemode;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjective;

import java.text.DecimalFormat;

public class SidebarObjective extends CoreSidebarObjective {

    public static int MAP_CHANGE_SECONDS = 0;

    public SidebarObjective() {
        super("KnockIT");
    }

    @Override
    public void onRegister(CorePlayer player) {
        setDisplayName(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.1"));

        setScore(14, "");
        setScore(13, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.2"));
        setScore(12, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.3") + player.getStats(Gamemode.KNOCKIT).getKill());
        setScore(11, "");
        setScore(10, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.4"));
        setScore(9, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.5") + player.getStats(Gamemode.KNOCKIT).getDeath());
        setScore(8, "");
        setScore(7, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.6"));
        setScore(6, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.7") + "§a" + player.getFormattedCoins());
        setScore(5, "");

        setScore(4, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.8"));
        setScore(3, calcTime());
        setScore(2, "");
        setScore(1, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.10"));
    }

    @Override
    public void onReload(CorePlayer player) {
        setDisplayName(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.1"));

        setScore(12, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.3") + player.getStats(Gamemode.KNOCKIT).getKill());
        setScore(9, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.5") + player.getStats(Gamemode.KNOCKIT).getDeath());
        setScore(6, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.7") + "§a" + player.getFormattedCoins());
        setScore(3, calcTime());
    }

    private String calcTime() {
        double min = MAP_CHANGE_SECONDS / 60.0;
        String timeString;

        if (min > 1.0) {
            timeString = " " + Math.round(min) + " Minute(n).";
        } else {
            timeString = " " + MAP_CHANGE_SECONDS + " Sekunde(n).";
        }

        return timeString;
    }
}
