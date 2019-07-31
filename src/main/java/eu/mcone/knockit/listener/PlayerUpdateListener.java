/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.event.MoneyChangeEvent;
import eu.mcone.coresystem.api.bukkit.event.StatsChangeEvent;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;

public class PlayerUpdateListener implements Listener {

    @EventHandler
    public void onMoneyChange(MoneyChangeEvent e) {
        e.getPlayer().getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
    }

    @EventHandler
    public void onStatsChange(StatsChangeEvent e) {
        CorePlayer p = e.getPlayer();
        p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
    }
}
