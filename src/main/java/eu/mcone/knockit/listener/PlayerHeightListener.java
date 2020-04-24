/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.knockit.KnockIT;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerHeightListener implements Listener {

    public static final double DEFAULT_DEATH_HEIGHT = 10;
    public static final double DEFAULT_SPAWN_HEIGHT = 80;

    @EventHandler
    public void on(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        Location deathLocation = KnockIT.getInstance().getMapManager().getMapRotationHandler().getCurrentMap().getWorld().getLocation("deathHeight");
        double deathHeight = deathLocation != null ? deathLocation.getY() : DEFAULT_DEATH_HEIGHT;

        if (deathHeight > e.getPlayer().getLocation().getY() && p.getHealth() != 0) {
            p.setHealth(0);
            p.spigot().respawn();
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        Entity target = e.getEntity();
        Entity damager = e.getDamager();

        if (target instanceof Player && (damager instanceof Player || damager instanceof Projectile)) {
            Player t = (Player) target;

            if (PlayerHeightListener.isOnSpawn(damager.getLocation()) || PlayerHeightListener.isOnSpawn(t.getLocation())) {
                e.setCancelled(true);
                KnockIT.getInstance().getMessenger().send(damager instanceof Player ? (Player) damager : (Player) ((Projectile) damager).getShooter(), "§4Du darfst am Spawn nicht kämpfen!");
            }
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        Entity ent = e.getEntity();

        if (ent instanceof Player) {
            Player p = (Player) ent;

            if (PlayerHeightListener.isOnSpawn(p.getLocation())) {
                e.setCancelled(true);

                if (e.getCause().equals(EntityDamageEvent.DamageCause.FIRE) || e.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK)) {
                    ent.setFireTicks(0);
                }
            }
        }
    }

    public static boolean isOnSpawn(Location location) {
        Location spawnHeight = KnockIT.getInstance().getMapManager().getMapRotationHandler().getCurrentMap().getWorld().getLocation("spawnHeight");
        double height = spawnHeight != null ? spawnHeight.getY() : DEFAULT_SPAWN_HEIGHT;

        return location.getY() >= height;
    }

}
