/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.bukkit.util.LocationFactory;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.util.Item;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener {

    @EventHandler
    public void on(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        p.setFireTicks(0);

        Location respawnLocation = LocationFactory.getConfigLocation(KnockIT.config, "Location-Spawn");
        if (respawnLocation != null) {
            e.setRespawnLocation(respawnLocation);
        } else {
            p.sendMessage(KnockIT.config.getConfigValue("System-Prefix") + "§4Du konntest nicht zum Spawn teleportiert werden, da der Spawn nicht eingespeichert ist!");
        }

        Bukkit.getScheduler().scheduleSyncDelayedTask(KnockIT.getInstance(), () -> Item.setItems(p));
    }

}
