/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.util;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.gamemode.Gamemode;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjective;

public class SidebarObjective extends CoreSidebarObjective {

    public SidebarObjective() {
        super("KnockIT");
    }

    @Override
    public void onRegister(CorePlayer player) {
        setDisplayName(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.1"));

        setScore(10, "");
        setScore(9, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.2"));
        setScore(8, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.3") + player.getStats(Gamemode.KNOCKIT).getKill());
        setScore(7, "");
        setScore(6, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.4"));
        setScore(5, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.5") + player.getStats(Gamemode.KNOCKIT).getDeath());
        setScore(4, "");
        setScore(3, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.6"));
        setScore(2, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.7")+ player.getCoins());
        setScore(1, "");
        setScore(0, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.8"));
    }

    @Override
    public void onReload(CorePlayer player) {
        setDisplayName(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.1"));

        setScore(8, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.3") + player.getStats(Gamemode.KNOCKIT).getKill());
        setScore(5, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.5") + player.getStats(Gamemode.KNOCKIT).getDeath());
        setScore(2, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.7") + player.getCoins());
    }

}
