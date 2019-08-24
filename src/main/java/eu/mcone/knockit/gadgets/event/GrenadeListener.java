/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.gadgets.event;

import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.gadgets.Gadgets;
import org.bukkit.Location;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class GrenadeListener implements Listener {

    @EventHandler
    public void on(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Egg) {
            Location location = e.getEntity().getLocation();
            int bX = location.getBlockX();
            int bY = location.getBlockY();
            int bZ = location.getBlockZ();

            e.getEntity().getWorld().createExplosion(location.getX(), location.getY(), location.getZ(), 4, false, false);

            for (Entity entity : e.getEntity().getNearbyEntities(10, 10, 10)) {
                if (entity instanceof Player) {
                    Player p = (Player) entity;

                    int aX = p.getLocation().getBlockX();
                    int aY = p.getLocation().getBlockY();
                    int aZ = p.getLocation().getBlockZ();

                    int x = aX - bX;
                    int y = aY - bY;
                    int z = aZ - bZ;

                    Vector v = new Vector(x, y, z);
                    v.normalize();
                    v.setY(1.0D);
                    v.multiply(2.0D);
                    p.setVelocity(v);
                }
            }
        }
    }

    @EventHandler
    public void on(CreatureSpawnEvent e) {
        if (e.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.EGG)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void on(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        Location spawnHigh = KnockIT.getInstance().getCurrentWorld().getLocation("spawnHigh");
        if (e.getItem() != null) {
            if (e.getItem().equals(Gadgets.GRENADE.getItem())) {
                if (spawnHigh != null) {
                    if (player.getLocation().getY() > spawnHigh.getY()) {
                        KnockIT.getInstance().getMessager().send(player, "§cDu kannst am Spawn keine Granate werfen!");
                        e.setCancelled(true);
                    }
                } else {
                    if (player.getLocation().getY() > 80) {
                        KnockIT.getInstance().getMessager().send(player, "§cDu kannst am Spawn keine Granate werfen!");
                        e.setCancelled(true);
                    } else {
                        e.setCancelled(false);
                    }
                }
            }
        }
    }
}
