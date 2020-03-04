/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.util.Vector;

public class FishingRodListener implements Listener {

    @EventHandler
    public void on(PlayerFishEvent e) {
        Player p = e.getPlayer();
        FishHook h = e.getHook();

        if ((e.getState().equals(PlayerFishEvent.State.IN_GROUND)
                || e.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY)
                || e.getState().equals(PlayerFishEvent.State.FAILED_ATTEMPT)
        ) && p.getItemInHand().getItemMeta().getDisplayName().equals("§8§ §d§lEnterhaken")) {
            Block target = e.getPlayer().getWorld().getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1, h.getLocation().getBlockZ());

            if (target.getType().equals(Material.AIR) && !target.getType().equals(Material.STATIONARY_WATER)) {
                Location lc = p.getLocation();
                Location to = e.getHook().getLocation();

                lc.setY(lc.getY() + 0.5D);
                p.teleport(lc);

                double g = -0.08D;
                double t = to.distance(lc);
                double vX = (1.0D + 0.07D * t) * (to.getX() - lc.getX()) / t;
                double vY = (1.0D + 0.03D * t) * (to.getY() - lc.getY()) / t - 0.5D * g * t;
                double vZ = (1.0D + 0.07D * t) * (to.getZ() - lc.getZ()) / t;

                Vector v = p.getVelocity();
                v.setX(vX);
                v.setY(vY);
                v.setZ(vZ);
                p.setVelocity(v);
            }
        }
    }

}
