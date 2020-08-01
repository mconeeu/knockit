/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.gadgets.event;

import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.gadgets.Gadget;
import eu.mcone.knockit.listener.PlayerHeightListener;
import org.bukkit.Location;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
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

            for (Entity entity : e.getEntity().getNearbyEntities(8, 8, 8)) {
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
                    v.setY(0.6D);
                    v.multiply(1.3D);
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

    @EventHandler(priority = EventPriority.HIGH)
    public void on(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            ItemStack i = e.getItem();
            if ((i == null) || (!i.hasItemMeta()) || (!i.getItemMeta().hasDisplayName())) {
                return;
            }

            if (i.equals(Gadget.GRENADE.getItem())) {
                if (PlayerHeightListener.isOnSpawn(p.getLocation())) {
                    KnockIT.getInstance().getMessenger().send(p, "§4Du kannst am Spawn keine Granate werfen!");
                    e.setCancelled(true);
                } else {
                    e.setCancelled(false);
                    KnockIT.getInstance().getKnockITPlayer(e.getPlayer().getUniqueId()).removeGadget(Gadget.GRENADE);
                }
            }
        }
    }
}
