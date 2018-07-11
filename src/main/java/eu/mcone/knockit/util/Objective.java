/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.util;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreObjective;
import eu.mcone.knockit.KnockIT;
import org.bukkit.scoreboard.DisplaySlot;

public class Objective extends CoreObjective {

    public Objective() {
        super(DisplaySlot.SIDEBAR, "Main", "KnockIT");
    }

    @Override
    public void onRegister(CorePlayer player) {
        setDisplayName(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.1"));

        setScore(10, "");
        setScore(9, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.2"));
        setScore(8, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.3") + KnockIT.getInstance().getStatsAPI().getKills(player.getUuid()));
        setScore(7, "");
        setScore(6, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.4"));
        setScore(5, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.5") + KnockIT.getInstance().getStatsAPI().getDeaths(player.getUuid()));
        setScore(4, "");
        setScore(3, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.6"));
        setScore(2, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.7")+ player.getCoins());
        setScore(1, "");
        setScore(0, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.8"));
    }

    @Override
    public void onReload(CorePlayer player) {
        setDisplayName(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.1"));

        setScore(8, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.3") + KnockIT.getInstance().getStatsAPI().getKills(player.getUuid()));
        setScore(5, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.5") + KnockIT.getInstance().getStatsAPI().getDeaths(player.getUuid()));
        setScore(2, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.7") + player.getCoins());
    }

}
