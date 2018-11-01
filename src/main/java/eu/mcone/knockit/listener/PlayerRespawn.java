/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.kit.Kit;
import eu.mcone.knockit.kit.KitManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener {

    @EventHandler
    public void on(PlayerRespawnEvent e) {
        Player p = e.getPlayer();

        p.getInventory().clear();
        p.setExp(1);
        e.setRespawnLocation(KnockIT.getInstance().getWorld().getLocation(KnockIT.getInstance().getWorld().getLocation("spawn")));

        Bukkit.getScheduler().runTask(KnockIT.getInstance(), () ->
                KitManager.setKit(p, Kit.DEFAULT));

        CoreSystem.getInstance().createActionBar()
                .message("§c§l§oDu bist gestorben")
                .send(p);
    }

}
