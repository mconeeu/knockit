/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.gamesystem.api.game.event.GameMapCountdownChangeEvent;
import eu.mcone.knockit.util.SidebarObjective;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;

public class GameMapCountdownChangeListener implements Listener {

    @EventHandler
    public void on(GameMapCountdownChangeEvent e) {
        SidebarObjective.MAP_CHANGE_SECONDS = e.getSeconds();

        for (CorePlayer corePlayer : CoreSystem.getInstance().getOnlineCorePlayers()) {
            corePlayer.getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
        }
    }
}
