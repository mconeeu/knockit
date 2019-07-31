/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.knockit.KnockIT;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        Entity ent = e.getEntity();

        if (ent instanceof Player) {
            Player p = (Player) ent;

            if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
                e.setCancelled(true);
            } else if (e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
                p.setHealth(1.0D);
                return;
            }

            Location spawnHigh = KnockIT.getInstance().getCurrentWorld().getLocation("spawnHigh");
            if (spawnHigh != null) {
                if (p.getLocation().getY() > spawnHigh.getY()) {
                    e.setCancelled(true);
                    ent.setFireTicks(0);
                }
            } else {
                if (p.getLocation().getY() > 80) {
                    e.setCancelled(true);
                    ent.setFireTicks(0);
                }
            }
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        Entity ent = e.getEntity();
        Entity byEnt = e.getDamager();

        if (ent instanceof Player && byEnt instanceof Player) {
            Player p = (Player) ent;

            if (p.getLocation().getY() > KnockIT.getInstance().getCurrentWorld().getLocation("spawnHigh").getY()) {
                e.setCancelled(true);
                KnockIT.getInstance().getMessager().send(byEnt, "§4Du darfst am Spawn nicht kämpfen!");
            }
        }
    }

}
