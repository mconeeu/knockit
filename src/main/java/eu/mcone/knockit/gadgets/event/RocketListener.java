/*
 * Copyright (c) 2017 - 2019 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.gadgets.event;

import eu.mcone.coresystem.api.bukkit.facades.Sound;
import eu.mcone.knockit.KnockIT;
import eu.mcone.knockit.gadgets.Gadget;
import eu.mcone.knockit.listener.PlayerHeightListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class RocketListener implements Listener {

    @EventHandler
    public void on(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            ItemStack i = e.getItem();
            if ((i == null) || (!i.hasItemMeta()) || (!i.getItemMeta().hasDisplayName())) {
                return;
            }

            if (e.getItem().equals(Gadget.ROCKET.getItem())) {
                if (PlayerHeightListener.isOnSpawn(p.getLocation())) {
                    KnockIT.getInstance().getMessenger().send(p, "§4Du kannst am Spawn keine Rakete starten!");
                    e.setCancelled(true);
                } else {
                    e.setCancelled(false);

                    if (e.getItem().equals(Gadget.ROCKET.getItem())) {
                        Vector v = new Vector(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
                        v.normalize();
                        v.setY(2.5D);
                        v.multiply(2.0D);
                        p.setVelocity(v);

                        p.getInventory().remove(p.getItemInHand());


                        Sound.play(p, org.bukkit.Sound.FIREWORK_LAUNCH);
                        KnockIT.getInstance().getMessenger().send(p, "§2Du wurdest in die Luft geschleudert!");
                    }
                }
            }
        }
    }
}




