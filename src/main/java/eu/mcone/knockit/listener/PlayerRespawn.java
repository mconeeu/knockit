/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.util.Item;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener {

    @EventHandler
    public void on(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        p.setFireTicks(0);

        e.setRespawnLocation(KnockIT.getInstance().getWorld().getLocation("spawn").bukkit());
        Bukkit.getScheduler().scheduleSyncDelayedTask(KnockIT.getInstance(), () -> Item.setItems(p));
    }

}
