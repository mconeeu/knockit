/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.gadgets.event;

import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.gadgets.Gadgets;
import eu.mcone.knockit.profile.KnockITPlayer;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class RocketListener implements Listener {

    @EventHandler
    public void on(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Location spawnHigh = KnockIT.getInstance().getCurrentWorld().getLocation("spawnHigh");
        if (e.getItem() != null) {
            if (e.getItem().equals(Gadgets.ROCKET.getItem())) {
                if (spawnHigh != null) {
                    if (player.getLocation().getY() > spawnHigh.getY()) {
                        KnockIT.getInstance().getMessager().send(player, "§cDu kannst am Spawn keine Rakete starten!");
                        e.setCancelled(true);
                    }
                } else {
                    if (player.getLocation().getY() > 80) {
                        KnockIT.getInstance().getMessager().send(player, "§cDu kannst am Spawn keine Rakete starten!");
                        e.setCancelled(true);
                    } else {
                        e.setCancelled(false);
                        KnockITPlayer knockITPlayer = KnockIT.getInstance().getKnockITPlayer(e.getPlayer().getUniqueId());
                        if (e.getItem().equals(Gadgets.ROCKET.getItem())) {
                            Vector v = new Vector(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
                            v.normalize();
                            v.setY(2.5D);
                            v.multiply(2.0D);
                            player.setVelocity(v);

                            knockITPlayer.removeGadget(Gadgets.ROCKET);
                            player.playSound(player.getLocation(), Sound.FIREWORK_LAUNCH, 1, 1);
                            KnockIT.getInstance().getMessager().send(player, "§2Du wurdest in die Luft geschleudert!");
                        }
                    }
                }
            }
        }
    }
}




