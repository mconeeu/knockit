/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.bukkit.CoreSystem;
import eu.mcone.coresystem.bukkit.event.StatsChangeEvent;
import eu.mcone.coresystem.bukkit.player.CorePlayer;
import eu.mcone.coresystem.lib.gamemode.Gamemode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;

public class StatsChange implements Listener {

    @EventHandler
    public void on(StatsChangeEvent e) {
        CorePlayer p = e.getPlayer();

        if (e.getStats().equals(CoreSystem.getInstance().getStatsAPI(Gamemode.KNOCKIT))) {
            p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
        }
    }

}
