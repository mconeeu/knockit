/*
 * Copyright (c) 2017 - 2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.knockit.listener;

import eu.mcone.coresystem.api.bukkit.event.NpcInteractEvent;
import eu.mcone.knockit.inventory.MainKitInventory;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NpcInteract implements Listener {

    @EventHandler
    public void on(NpcInteractEvent e) {
        if (e.getAction().equals(NpcInteractEvent.Action.RIGHT_CLICK)) {
            if (e.getNpc().getData().getName().equals("Kit")) {
                new MainKitInventory(e.getPlayer());
            }
        }
    }

}
