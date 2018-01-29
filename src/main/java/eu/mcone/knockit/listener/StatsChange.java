/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.bukkitcoresystem.event.StatsChangeEvent;
import eu.mcone.bukkitcoresystem.player.CorePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;

import static eu.mcone.bukkitcoresystem.CoreSystem.statsKnockit;
import static eu.mcone.bukkitcoresystem.CoreSystem.statsSkypvp;

public class StatsChange implements Listener {

    @EventHandler
    public void on(StatsChangeEvent e) {
        CorePlayer p = e.getPlayer();

        if (e.getStats().equals(statsKnockit)) {
            p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
        }
    }

}
