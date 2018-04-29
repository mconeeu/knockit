/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.knockit.KnockIT;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void on(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(KnockIT.config.getConfigValue("System-Prefix") + "§7 " + p.getDisplayName() + " §7hat das Spiel verlassen");
    }

}
