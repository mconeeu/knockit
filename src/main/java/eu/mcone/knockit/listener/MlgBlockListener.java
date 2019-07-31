/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.knockit.KnockIT;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class MlgBlockListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player player = e.getPlayer();

        if (player.getLocation().getY() > 80) {
            KnockIT.getInstance().getMessager().send(player, "§cDu kannst am Spawn keine Blöcke setzten!");
            e.setCancelled(true);
        } else {
            if (!KnockIT.getInstance().getBuildSystem().hasBuildModeEnabled(player) && e.getBlock().getType().equals(Material.QUARTZ_BLOCK)) {
                Block block = e.getBlockPlaced();

                Bukkit.getScheduler().runTaskLater(
                        KnockIT.getInstance(),
                        () -> block.setType(Material.AIR),
                        60
                );
            }
        }
    }
}
